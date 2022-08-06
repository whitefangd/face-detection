package com.boluclac.facedetection.common;

import java.util.Locale;

public interface MessageSourceCommon {
    String getMessage(String code, Locale locale);

    void setLocale(Locale locale);
}
