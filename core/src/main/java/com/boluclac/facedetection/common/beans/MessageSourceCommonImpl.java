package com.boluclac.facedetection.common.beans;

import com.boluclac.facedetection.common.constants.ConfigConstant;
import com.boluclac.facedetection.common.constants.MessageConstant;
import com.boluclac.facedetection.utils.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * <h1>Message source common Implement</h1>
 * Common bean process multi language
 *
 * @author boluclac
 * @version 0.0.0
 */
@Component
public class MessageSourceCommonImpl extends ReloadableResourceBundleMessageSource implements MessageSourceCommon {

    /** Message base name */
    @Value("${" + ConfigConstant.CONFIG_MSG_BASENAME + "}")
    private String baseName;
    /** List locales */
    @Value("#{${" + ConfigConstant.CONFIG_MSG_LOCALES + "}}")
    private List<String> localeNames;
    /** index locale */
    @Value("${" + ConfigConstant.CONFIG_MSG_LOCALE + "}")
    private int locale;

    /** List locale names */
    private List<Locale> locales;

    /**
     * Init load message properties.<br>
     * Default properties is load: <i>classpath:i18n/messages</i><br>
     * Encoding default is use {@link StandardCharsets#UTF_8}
     */
    @PostConstruct
    public void init() {
        this.setBasename(baseName);
        this.setDefaultEncoding(StandardCharsets.UTF_8.name());
        this.setLocale(getLocales().get(locale));
        this.setUseCodeAsDefaultMessage(true);
    }

    /**
     * get message by code follow locale
     *
     * @param code   message code is defined in properties
     * @param locale Locale
     *
     * @return Message text
     */
    @Override
    public String getMessage(String code, Locale locale) {
        return this.getMessage(code, null, locale);
    }

    /**
     * Set default locale
     *
     * @param locale Locale
     */
    @Override
    public void setLocale(Locale locale) {
        super.setDefaultLocale(locale);
    }

    /**
     * get default locale
     *
     * @return locale
     */
    @Override
    public Locale getLocale() {
        return super.getDefaultLocale();
    }

    /**
     * get list locales
     *
     * @return locales
     */
    @Override
    public List<Locale> getLocales() {
        if (locales == null) {
            assert localeNames != null;
            locales = new ArrayList<>();
            for (String localeName : localeNames) {
                assert StringUtils.isNotNullAndEMpty(localeName);
                Locale locale = new Locale(localeName.substring(0, 2), localeName.substring(3, 5));
                locales.add(locale);
            }
        }
        return locales;
    }

    /**
     * get list locales
     *
     * @return locale
     */
    @Override
    public String getLocaleName(String locale) {
        assert localeNames != null;
        return MessageConstant.MESSAGE_LANGUAGE + locale;
    }

    /**
     * get message by code follow default locale
     *
     * @param code message code is defined in properties
     * @return Message text
     */
    @Override
    public String getMessage(String code) {
        return this.getMessage(code, null, getLocale());
    }

    /**
     * get message by code follow default locale
     *
     * @param code       message code is defined in properties
     * @param parameters parameter values
     * @return Message text
     */
    @Override
    public String getMessage(String code, String[] parameters) {
        return this.getMessage(code, parameters, getLocale());
    }
}
