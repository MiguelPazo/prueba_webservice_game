package com.miguelpazo.game.dto;

import com.miguelpazo.game.models.Horse;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
public class ResHorse {

    private String code;
    private String name;
    private String race;
    private Double weigth;
    private Double height;
    private Double qualification;

    public ResHorse() {
    }

    public ResHorse(Horse oHorse) {
        this.code = oHorse.getCode();
        this.name = oHorse.getName();
        this.race = oHorse.getRace();
        this.weigth = oHorse.getWeigth();
        this.height = oHorse.getHeight();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Double getWeigth() {
        return weigth;
    }

    public void setWeigth(Double weigth) {
        this.weigth = weigth;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getQualification() {
        return qualification;
    }

    public void setQualification(Double qualification) {
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return "ResponseHorses{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", race='" + race + '\'' +
                ", weigth=" + weigth +
                ", height=" + height +
                ", qualification=" + qualification +
                '}';
    }
}
