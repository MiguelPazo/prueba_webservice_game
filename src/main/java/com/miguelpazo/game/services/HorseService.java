package com.miguelpazo.game.services;

import com.miguelpazo.game.dto.ResHorse;
import com.miguelpazo.game.emuns.RaceEnum;
import com.miguelpazo.game.emuns.TrackEnum;
import com.miguelpazo.game.models.Horse;
import com.miguelpazo.game.respositories.IHorseRepository;
import com.miguelpazo.game.services.interfaces.IHorseService;
import com.miguelpazo.game.services.interfaces.ITrackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
@Service
public class HorseService implements IHorseService {

    private static final Logger logger = LoggerFactory.getLogger(HorseService.class);

    @Autowired
    private IHorseRepository horseRepository;
    @Autowired
    private ITrackService trackService;

    @Override
    public List<ResHorse> fetchByTrack(TrackEnum trackEnum) {
        List<ResHorse> result = new ArrayList<>();

        if (trackEnum == null) {
            return result;
        }

        try {
            List<Horse> lstHorse = horseRepository.fetchAll();

            for (Horse oHorse : lstHorse) {
                ResHorse resHorse = calculateQualification(trackEnum, oHorse);

                if (resHorse != null) {
                    result.add(resHorse);
                }
            }
        } catch (Exception ex) {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            logger.error(sw.toString());
        }

        return result;
    }

    private ResHorse calculateQualification(TrackEnum trackEnum, Horse oHorse) {
        ResHorse resHorse = new ResHorse(oHorse);

        try {
            Integer score = trackService.getScoreByRace(trackEnum, RaceEnum.get(resHorse.getRace()));
            Double qualification = (resHorse.getWeigth() * resHorse.getHeight()) / score;

            resHorse.setQualification(qualification);

            return resHorse;
        } catch (Exception ex) {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            logger.error(sw.toString());
        }

        return null;
    }
}

