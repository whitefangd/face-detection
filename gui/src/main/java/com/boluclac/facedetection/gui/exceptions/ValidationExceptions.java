package com.boluclac.facedetection.gui.exceptions;

import com.boluclac.facedetection.ConfigurationCore;
import com.boluclac.facedetection.common.beans.MessageSourceCommon;
import com.boluclac.facedetection.utils.StringUtils;

import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>Validation errors</h1>
 * Exception contain list validation errors
 */
public class ValidationExceptions extends RuntimeException {
    /** Error lists */
    private final List<List<String>> errors = new ArrayList<>();

    /**
     * Constructor with throwable
     */
    public ValidationExceptions() {
        super();
    }

    /**
     * Constructor with throwable
     *
     * @param exception throwable
     */
    public ValidationExceptions(Exception exception) {
        super(exception);
        List<String> error = new ArrayList<>();
        error.add(exception.getMessage());
        errors.add(error);
    }

    /**
     * Add new error in list
     *
     * @param message    Message key
     * @param parameters parameter keys
     */
    public void addError(String message, String... parameters) {
        List<String> error = new ArrayList<>();
        error.add(message);
        if (parameters != null && parameters.length > 0) {
            error.addAll(Arrays.asList(parameters));
        }
        errors.add(error);
    }

    /**
     * Get list message text error.
     *
     * @return list message text error.
     */
    public List<String> getMessageErrors() {
        MessageSourceCommon messageSourceCommon = ConfigurationCore.getBean(MessageSourceCommon.class);
        assert messageSourceCommon != null;
        List<String> messageErrors = new ArrayList<>();
        for (List<String> error : errors) {
            String message = StringUtils.STRING_EMPTY;
            if (error.size() == 1) {
                message = messageSourceCommon.getMessage(error.get(0));
            } else if (error.size() > 1) {
                List<String> params = error.subList(1, error.size());
                String[] values = new String[params.size()];
                for (int indexParam = 0; indexParam < params.size(); indexParam++) {
                    values[indexParam] = messageSourceCommon.getMessage(params.get(indexParam));
                }
                message = messageSourceCommon.getMessage(error.get(0), values);
            }
            if (StringUtils.isNotNullAndEMpty(message)) {
                messageErrors.add(message);
            }
        }
        return messageErrors;
    }
}
