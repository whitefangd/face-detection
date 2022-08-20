package com.boluclac.facedetection.gui.controls.face;

import com.boluclac.facedetection.gui.events.face.TrainingPageEvent;

import javax.swing.*;

/**
 * <h1>Training page - page</h1>
 * Design Training page page
 *
 * @author boluclac
 * @version 0.0.0
 */
public interface TrainingPageControl {
    /**
     * <h2>get instance object</h2>
     * This is training page instance, it is cast {@link JPanel}
     *
     * @return instance object
     */
    JPanel getInstance();

    /**
     * <h2>Add Event: Training page</h2>
     * Event is triggered when Training page has process
     *
     * @param event Training page event
     */
    void addEventListener(TrainingPageEvent event);

    /**
     * <h2>Remove Event: Training page</h2>
     * Event is triggered when Training page has process
     *
     * @param event Training page event
     */
    void removeEventListener(TrainingPageEvent event);

    /**
     * <h2>Clear Event: Training page</h2>
     * Event is triggered when Training page has process
     */
    void clearEventListener();
}
