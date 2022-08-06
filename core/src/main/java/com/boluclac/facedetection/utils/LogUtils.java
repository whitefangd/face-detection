package com.boluclac.facedetection.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <h1>Log utils</h1>
 * Utilities Logging<br>
 *
 * @author boluclac
 * @version 0.0.0
 */
public class LogUtils {
    /**
     * Logger
     */
    private static Logger LOGGER = null;// LoggerFactory.getLogger(LogUtils.class);

    /**
     * Debug logging
     *
     * @param message message
     */
    public static void debug(String message) {
        // if (getLogger().isDebugEnabled()) {
            getLogger().debug(message);
        //}
    }

    private static Logger getLogger() {
        if (LOGGER == null) {
            LOGGER = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        }
        return LOGGER;
    }
}
