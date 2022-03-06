package com.miguelpazo.game.data;

import com.miguelpazo.game.common.Utils;
import com.miguelpazo.game.models.Horse;
import com.miguelpazo.game.models.Track;
import com.miguelpazo.game.respositories.IHorseRepository;
import com.miguelpazo.game.respositories.ITrackRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
@SpringBootTest
class GenerateDataTests {

    private static final Logger logger = LoggerFactory.getLogger(GenerateDataTests.class);

    @Autowired
    private IHorseRepository horseRepository;
    @Autowired
    private ITrackRepository trackRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private Utils utils;

    @Test
    public void generateTest() {
        try {
            mongoTemplate.remove(new Query(), "horses");
            mongoTemplate.remove(new Query(), "tracks");

            ArrayList<Horse> lstHorse = new ArrayList<Horse>(Arrays.asList(
                    new Horse(utils.generateToken(), "Rocinante", "Arabic", 550.0, 1.6),
                    new Horse(utils.generateToken(), "Bucéfalo", "Pure blood", 800.0, 1.8),
                    new Horse(utils.generateToken(), "Galán", "Mustang", 900.0, 1.8),
                    new Horse(utils.generateToken(), "Silver", "Pure blood", 800.0, 1.4),
                    new Horse(utils.generateToken(), "Rantanplan", "Mustang", 400.0, 1.5)
            ));

            ArrayList<Track> lstTrack = new ArrayList<Track>(Arrays.asList(
                    new Track(utils.generateToken(), "Sand"),
                    new Track(utils.generateToken(), "Grass")
            ));

            for (Horse oHorse : lstHorse) {
                horseRepository.save(oHorse);
            }

            for (Track oTrack : lstTrack) {
                trackRepository.save(oTrack);
            }
        } catch (Exception ex) {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            logger.error(sw.toString());
        }
    }
}
