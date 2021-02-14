package br.com.blackhare.heroes.api.controller;

import br.com.blackhare.heroes.api.entity.Hero;
import br.com.blackhare.heroes.api.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/heroes")
public class HeroController {

    @Autowired
    private HeroRepository repository;

    @PostMapping
    public ResponseEntity<Hero> save(@RequestBody Hero newHero) {
        Hero created = this.repository.insert(newHero);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping("/{heroId}")
    public ResponseEntity<Hero> get(@PathVariable int heroId) {
        Hero hero = this.repository.findById(heroId);
        return ResponseEntity.ok(hero);
    }
}
