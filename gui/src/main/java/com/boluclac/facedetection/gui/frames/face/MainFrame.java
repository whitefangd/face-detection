package com.boluclac.facedetection.gui.frames.face;

import com.boluclac.facedetection.gui.events.face.ExitFrameEvent;

/**
 * <h1>Main Frame Interface</h1>
 * Design main layout, structure frame.
 *
 * @author boluclac
 * @version 0.0.0
 */
public interface MainFrame {
    /**
     * <h2>Open Frame</h2>
     * Open frame.<br>
     * When create object default frame is closed
     */
    void open();

    /**
     * <h2>Add Event: Exit frame</h2>
     * Event is triggered when close frame completed
     *
     * @param event Edit frame event
     */
    void addExitFrameEventListener(ExitFrameEvent event);

    /**
     * <h2>Remove Event: Exit frame</h2>
     * Event is triggered when close frame completed
     *
     * @param event Edit frame event
     */
    void removeExitFrameEventListener(ExitFrameEvent event);

    /**
     * <h2>Clear Event: Exit frame</h2>
     * Event is triggered when close frame completed
     */
    void clearExitFrameEventListener();
}
