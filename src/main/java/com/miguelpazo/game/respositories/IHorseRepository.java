package com.miguelpazo.game.respositories;

import com.miguelpazo.game.models.Horse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
public interface IHorseRepository extends MongoRepository<Horse, String> {

    @Query("{'enabled': true, 'deleted': false}")
    List<Horse> fetchAll();
}
