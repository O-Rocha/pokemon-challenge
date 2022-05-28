package br.com.portifolio.looqbox.pokemon.pokemonchallenge.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {
    
    @Value("${poke.api.pagination.url}")
    private String PokeApiUrlTemplate;

    public String getPokeApiUrlTemplate() {
        return PokeApiUrlTemplate;
    }
}
