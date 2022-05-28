package br.com.portifolio.looqbox.pokemon.pokemonchallenge.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.portifolio.looqbox.pokemon.pokemonchallenge.dto.PokeApiResponseDto;
import br.com.portifolio.looqbox.pokemon.pokemonchallenge.dto.PokeApiResultsResponseDto;
import br.com.portifolio.looqbox.pokemon.pokemonchallenge.services.PokeApiService;
import br.com.portifolio.looqbox.pokemon.pokemonchallenge.services.PokemonNameLookupService;

@Service
public class PokemonNameLookupServiceImpl implements PokemonNameLookupService {

    private static final int LIMIT = 151;
    private static final int OFFSET = 0;

    private final PokeApiService pokeApiService;

    @Autowired
    public PokemonNameLookupServiceImpl(final PokeApiService pokeApiService) {
        this.pokeApiService = pokeApiService;
    }

    @Override
    public List<String> queryNamesBySubstring(String substring) {
        List<String> validNames = new ArrayList<>();

        PokeApiResponseDto firstSearch = pokeApiService.listPokemonNamesByRange(LIMIT, OFFSET);

        List<PokeApiResultsResponseDto> updatedList = firstSearch.getResults().stream()
                .filter(pokemom -> pokemom.getName().startsWith(substring)).collect(Collectors.toList());
        
        for (PokeApiResultsResponseDto item : updatedList) {
            validNames.add(item.getName());
        }
        // repete as chamadas até o next da resposta ser null
        // retorna a lista
        return validNames;
    }

}
