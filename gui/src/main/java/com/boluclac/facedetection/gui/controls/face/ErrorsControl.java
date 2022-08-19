package com.boluclac.facedetection.gui.controls.face;

import com.boluclac.facedetection.gui.exceptions.ValidationExceptions;

import javax.swing.*;

public interface ErrorsControl {
    /**
     * <h2>get instance object</h2>
     * This is error control instance, it is cast {@link JPanel}
     *
     * @return instance object
     */
    JPanel getInstance();

    void setErrors(ValidationExceptions validations);

    void clear();
}
