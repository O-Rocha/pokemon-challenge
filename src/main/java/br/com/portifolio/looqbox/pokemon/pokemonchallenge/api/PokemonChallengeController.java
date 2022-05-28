package br.com.portifolio.looqbox.pokemon.pokemonchallenge.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.portifolio.looqbox.pokemon.pokemonchallenge.dto.PokemonChallengeResponseDto;
import br.com.portifolio.looqbox.pokemon.pokemonchallenge.services.PokemonNameLookupService;

@RestController
@RequestMapping("/pokemons")
public class PokemonChallengeController {

    private final PokemonNameLookupService pokemonNameService;
    
    @Autowired
    public PokemonChallengeController(final PokemonNameLookupService pokeApiService) {
        this.pokemonNameService = pokeApiService;
    }

    @GetMapping()
    public ResponseEntity<PokemonChallengeResponseDto> getPokemonsByName(@RequestParam("name") final String name) {
        List<String> response = pokemonNameService.queryNamesBySubstring(name);
        return response.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(PokemonChallengeResponseDto.builder().results(response).build());

    }
}
