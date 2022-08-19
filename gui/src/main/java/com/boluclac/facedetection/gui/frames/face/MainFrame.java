package com.boluclac.facedetection.gui.frames.face;

import com.boluclac.facedetection.gui.events.face.MainFrameEvent;

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
     * <h2>Add Event: main frame</h2>
     * Event is triggered when frame has process
     *
     * @param event Edit frame event
     */
    void addEventListener(MainFrameEvent event);

    /**
     * <h2>Remove Event: main frame</h2>
     * Event is triggered when frame has process
     *
     * @param event Edit frame event
     */
    void removeEventListener(MainFrameEvent event);

    /**
     * <h2>Clear Event: main frame</h2>
     * Event is triggered when frame has process
     */
    void clearEventListener();
}
