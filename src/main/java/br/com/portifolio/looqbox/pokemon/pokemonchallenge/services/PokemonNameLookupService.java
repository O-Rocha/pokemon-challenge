package br.com.portifolio.looqbox.pokemon.pokemonchallenge.services;

import java.util.List;

/**
 * Interface do service que filtra os nomes baseados em substrings
 */
public interface PokemonNameLookupService {
    
    /**
     * busca os nomes dos pokemons que começam com uma determinada substring
     * @param substring nome do pokemon ou parte inicial do nome
     * @return lista com os nomes de todos os pokemons que encaixam no padrão
     */
    List<String> queryNamesBySubstring(String substring);
}
