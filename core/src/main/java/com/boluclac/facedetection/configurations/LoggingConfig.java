package com.boluclac.facedetection.configurations;

import ch.qos.logback.classic.util.ContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <h1>Logging Configuration</h1>
 * Logging Configuration for face detection
 *
 * @author boluclac
 * @version 0.0.0
 */
@Configuration
public class LoggingConfig {
    /**
     * Log config
     */
    @Bean
    public void logConfig() {
        System.setProperty(ContextInitializer.CONFIG_FILE_PROPERTY, "config/logback.xml");
    }
}
