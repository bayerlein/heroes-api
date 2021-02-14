package br.com.blackhare.heroes.api.repository;

import br.com.blackhare.heroes.api.entity.Hero;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HeroRepository {

    @Autowired
    private DynamoDBMapper mapper;

    public Hero insert(Hero newHero) {
        this.mapper.save(newHero);
        return newHero;
    }

    public Hero findById(int id) {
        return this.mapper.load(Hero.class, id);
    }
}
