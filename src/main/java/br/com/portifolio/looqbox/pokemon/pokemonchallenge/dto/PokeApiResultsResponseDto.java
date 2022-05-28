package br.com.portifolio.looqbox.pokemon.pokemonchallenge.dto;

public class PokeApiResultsResponseDto {
    private String name;
    private String url;

    PokeApiResultsResponseDto() {
    }

    public String getName() {
        return name;
    }
    void setName(final String name) {
        this.name = name;
    }
    public String getUrl() {
        return url;
    }
    void setUrl(final String url) {
        this.url = url;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        PokeApiResultsResponseDto dto = new PokeApiResultsResponseDto();

        public Builder name(final String name) {
            dto.setName(name);
            return this;
        }

        public  Builder url(final String url) {
            dto.setUrl(url);
            return this;
        }

        public PokeApiResultsResponseDto build() {
            return this.dto;
        }
    }
}
