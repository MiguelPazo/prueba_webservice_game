package com.miguelpazo.game.respositories;

import com.miguelpazo.game.models.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
public interface ITrackRepository extends MongoRepository<Track, String> {

    @Query("{'enabled': true, 'deleted': false}")
    List<Track> fetchAll();
}
