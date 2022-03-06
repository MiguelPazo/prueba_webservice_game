package com.miguelpazo.game.emuns;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
public enum RaceEnum {
    ARABIC("Arabic"),
    PURE_BLOOD("Pure blood"),
    MUSTANG("Mustang");

    private final String value;

    RaceEnum(String value) {
        this.value = value;
    }

    private static final Map<String, RaceEnum> lookup = new HashMap<>();

    static {
        for (RaceEnum raceEnum : RaceEnum.values()) {
            lookup.put(raceEnum.getValue(), raceEnum);
        }
    }

    public static RaceEnum get(String value) {
        return lookup.get(value);
    }

    public String getValue() {
        return value;
    }
}
