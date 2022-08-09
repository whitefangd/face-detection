package com.boluclac.facedetection.utils;

/**
 * <h1>String utils</h1>
 * Utilities String<br>
 *
 * @author boluclac
 * @version 0.0.0
 */
public class StringUtils {
    /** String empty: "" */
    public static final String STRING_EMPTY = "";

    /**
     * check String value is not null and empty
     *
     * @param value String value
     *
     * @return flag {@link Boolean}
     * <ul>
     *     <li>{@linkplain Boolean#FALSE FALSE}: is NULL or Empty</li>
     *     <Li>{@linkplain Boolean#TRUE TRUE}: is not NUll and Empty</Li>
     * </ul>
     */
    public static boolean isNotNullAndEMpty(String value) {
        return value != null && !STRING_EMPTY.equals(value);
    }
}
