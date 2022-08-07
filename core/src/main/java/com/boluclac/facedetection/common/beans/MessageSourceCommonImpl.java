package com.boluclac.facedetection.common.beans;

import com.boluclac.facedetection.common.constants.ConfigConstant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
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

    /**
     * Message base name
     */
    @Value("${" + ConfigConstant.CONFIG_MSG_BASENAME + "}")
    private String baseName;

    /**
     * Init load message properties.<br>
     * Default properties is load: <i>classpath:i18n/messages</i><br>
     * Encoding default is use {@link StandardCharsets#UTF_8}
     */
    @PostConstruct
    public void init() {
        this.setBasename(baseName);
        this.setDefaultEncoding(StandardCharsets.UTF_8.name());
    }

    /**
     * get message by code follow locale
     *
     * @param code   message code is defined in properties
     * @param locale Locale
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
}
