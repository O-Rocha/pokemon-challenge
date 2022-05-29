package br.com.portifolio.looqbox.pokemon.pokemonchallenge.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.UriSpec;

import br.com.portifolio.looqbox.pokemon.pokemonchallenge.config.ApiConfig;
import br.com.portifolio.looqbox.pokemon.pokemonchallenge.dto.PokeApiResponseDto;
import br.com.portifolio.looqbox.pokemon.pokemonchallenge.services.PokeApiService;

@Service
public class PokeApiServiceImpl implements PokeApiService {

    private final WebClient client;
    private final ApiConfig config;
    private final ObjectMapper mapper;

    @Autowired
    public PokeApiServiceImpl(final WebClient webClient, final ApiConfig config, final ObjectMapper mapper) {
        this.client = webClient;
        this.config = config;
        this.mapper = mapper;
    }

    @Override
    public PokeApiResponseDto listPokemonNamesByRange(final int limit, final int offset) {

        UriSpec<RequestBodySpec> uriSpec = client.method(HttpMethod.GET);
        RequestBodySpec bodySpec = uriSpec.uri(String.format(config.getPokeApiUrlTemplate(), limit, offset));
        return extracted(bodySpec);
    }

    @Override
    public PokeApiResponseDto listPokemonNamesByRange(final String uri) {
        UriSpec<RequestBodySpec> uriSpec = client.method(HttpMethod.GET);
        RequestBodySpec bodySpec = uriSpec.uri(String.format(uri));
        return extracted(bodySpec);
    }

    private PokeApiResponseDto extracted(final RequestBodySpec bodySpec) {
        final RequestHeadersSpec<?> headersSpec = bodySpec.bodyValue("");

        final String response = headersSpec.retrieve()
                .bodyToMono(String.class)
                .block();

        PokeApiResponseDto pokemons = null;

        try {
            pokemons = mapper.readValue(response, PokeApiResponseDto.class);
        } catch (JsonProcessingException e) {
            // normalmente serria feito um log error aqui usando uma api como o Sl4j por
            // exemplo.
            return null;
        }

        return pokemons;
    }

}
