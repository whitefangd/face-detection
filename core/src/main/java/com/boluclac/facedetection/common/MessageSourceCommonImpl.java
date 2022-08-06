package com.boluclac.facedetection.common;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

@Component
public class MessageSourceCommonImpl extends ReloadableResourceBundleMessageSource implements MessageSourceCommon {
    @PostConstruct
    public void init() {
        this.setBasename("classpath:i18n/messages");
        this.setDefaultEncoding(StandardCharsets.UTF_8.name());
    }

    /**
     * @param locale
     * @return
     */
    @Override
    public String getMessage(String code, Locale locale) {
        return this.getMessage(code, null, locale);
    }

    /**
     * @param locale
     */
    @Override
    public void setLocale(Locale locale) {
        super.setDefaultLocale(locale);
    }
}
