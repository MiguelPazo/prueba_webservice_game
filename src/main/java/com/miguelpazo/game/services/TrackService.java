package com.miguelpazo.game.services;

import com.miguelpazo.game.emuns.RaceEnum;
import com.miguelpazo.game.emuns.TrackEnum;
import com.miguelpazo.game.services.interfaces.ITrackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
@Service
public class TrackService implements ITrackService {

    private static final Logger logger = LoggerFactory.getLogger(TrackService.class);

    @Override
    public Integer getScoreByRace(TrackEnum trackEnum, RaceEnum raceEnum) {
        try {
            if (trackEnum.equals(TrackEnum.SAND)) {
                return getScoreSand(raceEnum);
            } else if (trackEnum.equals(TrackEnum.GRASS)) {
                return getScoreGrass(raceEnum);
            }
        } catch (Exception ex) {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            logger.error(sw.toString());
        }

        return null;
    }

    public Integer getScoreSand(RaceEnum raceEnum) {
        if (raceEnum.equals(RaceEnum.ARABIC)) {
            return 1;
        } else if (raceEnum.equals(RaceEnum.MUSTANG)) {
            return 2;
        } else if (raceEnum.equals(RaceEnum.PURE_BLOOD)) {
            return 3;
        }

        return null;
    }

    public Integer getScoreGrass(RaceEnum raceEnum) {
        if (raceEnum.equals(RaceEnum.ARABIC)) {
            return 3;
        } else if (raceEnum.equals(RaceEnum.MUSTANG)) {
            return 2;
        } else if (raceEnum.equals(RaceEnum.PURE_BLOOD)) {
            return 1;
        }

        return null;
    }
}

