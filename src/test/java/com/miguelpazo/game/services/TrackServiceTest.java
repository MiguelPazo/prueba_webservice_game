package com.miguelpazo.game.services;

import com.miguelpazo.game.emuns.RaceEnum;
import com.miguelpazo.game.emuns.TrackEnum;
import com.miguelpazo.game.services.interfaces.ITrackService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
@SpringBootTest
class TrackServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(TrackServiceTest.class);

    @Autowired
    private ITrackService trackService;

    @BeforeAll
    public static void prepare() {
        /**
         * TODO
         */
    }

    @Test
    public void getScoreByRaceTest() {
        try {
            Integer result = trackService.getScoreByRace(TrackEnum.SAND, RaceEnum.PURE_BLOOD);

            logger.info(result.toString());

            assertThat(result)
                    .isEqualTo(3);
        } catch (Exception ex) {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            logger.error(sw.toString());
        }
    }
}
