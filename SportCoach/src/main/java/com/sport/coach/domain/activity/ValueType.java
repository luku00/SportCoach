package com.sport.coach.domain.activity;

/**
 *
 * @author luku00
 */
public enum ValueType {

    KM,
    KCAL,
    TIME;

    /**
     * @param str
     * @return
     */
    public static ValueType fromString(String str) {
        for (ValueType v : ValueType.values()) {
            if (v.name().equals(str)) {
                return v;
            }
        }
        return null;
    }
}
