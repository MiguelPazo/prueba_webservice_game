package com.miguelpazo.game.services.interfaces;

import com.miguelpazo.game.dto.ResHorse;
import com.miguelpazo.game.emuns.TrackEnum;

import java.util.List;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
public interface IHorseService {

    List<ResHorse> fetchByTrack(TrackEnum trackEnum);
}
