package com.miguelpazo.game.controllers;

import com.miguelpazo.game.dto.ResHorse;
import com.miguelpazo.game.emuns.TrackEnum;
import com.miguelpazo.game.services.interfaces.IHorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
@RestController
@RequestMapping("/horses")
public class HorseController {

    @Autowired
    private IHorseService horseService;

    /**
     * TODO: Comment endpoint
     *
     * @param track
     * @return
     */
    @GetMapping("")
    public ResponseEntity<?> infoCertificate(@RequestParam String track) {
        List<ResHorse> lstHorse = horseService.fetchByTrack(TrackEnum.get(track));
        return new ResponseEntity<>(lstHorse, HttpStatus.OK);
    }
}
