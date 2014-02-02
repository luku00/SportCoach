package com.sport.coach.error;

/**
 *
 * @author luku00
 */
public enum ErrorTypes {

    FILE_ALREADY_IMPORTED;

    /**
     * @param str
     * @return
     */
    public static ErrorTypes fromString(String str) {
        for (ErrorTypes v : ErrorTypes.values()) {
            if (v.name().equals(str)) {
                return v;
            }
        }
        return null;
    }

}
