package com.boluclac.facedetection.configurations;

import ch.qos.logback.classic.util.ContextInitializer;
import com.boluclac.facedetection.common.constants.ConfigConstant;
import org.springframework.beans.factory.annotation.Value;
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

    /** Log file */
    @Value("${" + ConfigConstant.CONFIG_LOG_FILE + "}")
    private String logFile;

    /**
     * Log config
     */
    @Bean
    public void logConfig() {
        System.setProperty(ContextInitializer.CONFIG_FILE_PROPERTY, logFile);
    }
}
