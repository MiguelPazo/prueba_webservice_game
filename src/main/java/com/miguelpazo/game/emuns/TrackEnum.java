package com.miguelpazo.game.emuns;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
public enum TrackEnum {
    SAND("sand"),
    GRASS("grass");

    private String value;

    TrackEnum(String value) {
        this.value = value;
    }

    private static final Map<String, TrackEnum> lookup = new HashMap<>();

    static {
        for (TrackEnum TrackEnum : TrackEnum.values()) {
            lookup.put(TrackEnum.getValue(), TrackEnum);
        }
    }

    public static TrackEnum get(String value) {
        return lookup.get(value);
    }

    public String getValue() {
        return value;
    }
}
