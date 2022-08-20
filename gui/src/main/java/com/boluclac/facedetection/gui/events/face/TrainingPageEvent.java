package com.boluclac.facedetection.gui.events.face;

import com.boluclac.facedetection.gui.controls.face.TrainingPageControl;

import javax.swing.*;

/**
 * <h1>Event Interface: Training page</h1>
 * Training page event is use for {@link TrainingPageControl}
 *
 * @author boluclac
 * @version 0.0.0
 */
public interface TrainingPageEvent extends Event {
    /**
     * <h2>Event dispose item</h2>
     * dispose this item
     *
     * @param component Component dispose
     */
    void actionDisposed(JComponent component);
}
