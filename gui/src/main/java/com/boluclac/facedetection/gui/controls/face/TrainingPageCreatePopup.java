package com.boluclac.facedetection.gui.controls.face;

import com.boluclac.facedetection.gui.events.face.MainFrameEvent;
import com.boluclac.facedetection.gui.events.face.TrainingPageCreatePopupEvent;

import javax.swing.JDialog;

/**
 * <h1>Training page create - popup</h1>
 * Design popup new training page.
 * Create location and training name
 *
 * @author boluclac
 * @version 0.0.0
 */
public interface TrainingPageCreatePopup {
    /**
     * <h2>get instance object</h2>
     * This is training popup new training page instance, it is cast {@link JDialog}
     *
     * @return instance object
     */
    JDialog getInstance();

    /**
     * <h2>Add Event: Training popup</h2>
     * Event is triggered when Training popup has process
     *
     * @param event Training popup event
     */
    void addEventListener(TrainingPageCreatePopupEvent event);

    /**
     * <h2>Remove Event: Training popup</h2>
     * Event is triggered when Training popup has process
     *
     * @param event Training popup event
     */
    void removeEventListener(TrainingPageCreatePopupEvent event);

    /**
     * <h2>Clear Event: Training popup</h2>
     * Event is triggered when Training popup has process
     */
    void clearEventListener();
}
