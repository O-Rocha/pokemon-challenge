package br.com.portifolio.looqbox.pokemon.pokemonchallenge.services;

import br.com.portifolio.looqbox.pokemon.pokemonchallenge.dto.PokeApiResponseDto;

/**
 * Classe de interfaçe com a api PokeApi.
 */
public interface PokeApiService {
    
    /**
     * Método que busca nomes de pokemons de forma paginada.
     * @param limit quantidade de pokemons por pagina
     * @param offset quantidade de pokemons a serem pulados para a busca
     * @return lista com informações de pokemons e proxima página
     */
    PokeApiResponseDto listPokemonNamesByRange(int limit, int offset);

    /**
     * listPokemonNamesByRange
     * @param uri url retornada pela propria PokeApi
     * @return lista com informações de pokemons e proxima página
     */
    PokeApiResponseDto listPokemonNamesByRange(String uri);
}
