package com.boluclac.facedetection.gui.controls;

import com.boluclac.facedetection.gui.exceptions.ValidationExceptions;

import javax.swing.*;

/**
 * <h1>Error control interface</h1>
 * Errors control, display errors list
 *
 * @author boluclac
 * @version 0.0.0
 */
public interface ErrorsControl {
    /**
     * <h2>get instance object</h2>
     * This is error control instance, it is cast {@link JPanel}
     *
     * @return instance object
     */
    JPanel getInstance();

    /**
     * <h2>Set Validation errors</h2>
     * Set Validation errors is Exception
     *
     * @param validations Validation errors
     */
    void setErrors(ValidationExceptions validations);

    /**
     * Clear all errors message.
     */
    void clear();
}
