package com.boluclac.facedetection.common.beans;

import java.util.Locale;

/**
 * <h1>Message source common interface</h1>
 * Common bean process multi language
 *
 * @author boluclac
 * @version 0.0.0
 */
public interface MessageSourceCommon {
    /**
     * get message by code follow locale
     *
     * @param code   message code is defined in properties
     * @param locale Locale
     * @return Message text
     */
    String getMessage(String code, Locale locale);

    /**
     * Set default locale
     *
     * @param locale Locale
     */
    void setLocale(Locale locale);
}