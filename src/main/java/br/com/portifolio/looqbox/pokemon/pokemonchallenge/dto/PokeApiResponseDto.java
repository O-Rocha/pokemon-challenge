package br.com.portifolio.looqbox.pokemon.pokemonchallenge.dto;

import java.util.List;

public class PokeApiResponseDto {
    private int count;
    private String next;
    private String previous;
    private List<PokeApiResultsResponseDto> results;

    PokeApiResponseDto() {
    }

    //getters e setters normalmente gerados pelo lombok
    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }
    
    public String getPrevious() {
        return previous;
    }

    public List<PokeApiResultsResponseDto> getResults() {
        return results;
    }

    void setCount(final int count) {
        this.count = count;
    }

    void setNext(final String next) {
        this.next = next;
    }
    
    public void setPrevious(final String previous) {
        this.previous = previous;
    }

    public void setResults(final List<PokeApiResultsResponseDto> results) {
        this.results = results;
    }

    //
    //padrão builder geralmente gerado pelo lombok
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        PokeApiResponseDto dto = new PokeApiResponseDto();

        public Builder count(final int count) {
            dto.setCount(count);
            return this;
        }

        public Builder next(final String next) {
            dto.setNext(next);
            return this;
        }
        
        public Builder previous(final String previous) {
            dto.setPrevious(previous);
            return this;
        }

        public Builder results(final List<PokeApiResultsResponseDto> results) {
            dto.setResults(results);
            return this;
        }

        public PokeApiResponseDto build() {
            return this.dto;
        }
    }
}
