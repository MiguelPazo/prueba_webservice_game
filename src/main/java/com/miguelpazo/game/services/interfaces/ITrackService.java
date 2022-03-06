package com.miguelpazo.game.services.interfaces;

import com.miguelpazo.game.emuns.RaceEnum;
import com.miguelpazo.game.emuns.TrackEnum;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
public interface ITrackService {

    Integer getScoreByRace(TrackEnum trackEnum, RaceEnum raceEnum);
}
