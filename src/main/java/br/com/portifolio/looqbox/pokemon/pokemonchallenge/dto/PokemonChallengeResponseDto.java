package br.com.portifolio.looqbox.pokemon.pokemonchallenge.dto;

import java.util.List;

public class PokemonChallengeResponseDto {
    private List<String> results;

    public List<String> getResults() {
        return results;
    }

    void setResults(List<String> results) {
        this.results = results;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        PokemonChallengeResponseDto dto = new PokemonChallengeResponseDto();

        public Builder results(List<String> results) {
            dto.setResults(results);
            return this;
        }

        public PokemonChallengeResponseDto build() {
            return this.dto;
        }
    }
}
