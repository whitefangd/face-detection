package com.boluclac.facedetection.gui.events;

import com.boluclac.facedetection.gui.frames.MainFrame;

/**
 * <h1>Event Interface: Main frame</h1>
 * Main frame event is use for {@link MainFrame}
 *
 * @author boluclac
 * @version 0.0.0
 */
public interface MainFrameEvent extends Event {
    /**
     * <h2>Exit action</h2>
     * Exit application
     */
    void exit();
}
