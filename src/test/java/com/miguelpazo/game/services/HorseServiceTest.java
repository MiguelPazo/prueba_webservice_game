package com.miguelpazo.game.services;

import com.miguelpazo.game.dto.ResHorse;
import com.miguelpazo.game.emuns.TrackEnum;
import com.miguelpazo.game.services.interfaces.IHorseService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
@SpringBootTest
class HorseServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(HorseServiceTest.class);

    @Autowired
    private IHorseService horseService;

    @BeforeAll
    public static void prepare() {
        /**
         * TODO
         */
    }

    @Test
    public void fetchByTrackTest() {
        try {
            List<ResHorse> lstHorses = horseService.fetchByTrack(TrackEnum.SAND);

            for (ResHorse resHorse : lstHorses) {
                logger.info(resHorse.toString());
            }

            assertThat(lstHorses.size())
                    .isGreaterThan(0);
        } catch (Exception ex) {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            logger.error(sw.toString());
        }
    }
}
