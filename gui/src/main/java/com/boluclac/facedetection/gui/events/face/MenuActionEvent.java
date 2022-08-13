package com.boluclac.facedetection.gui.events.face;

import com.boluclac.facedetection.gui.controls.face.MainMenuControl;
import com.boluclac.facedetection.gui.controls.impl.MainMenuControlImpl;

/**
 * <h1>Event Interface: Menu action event</h1>
 * Men u event is use when Main menu has event
 *
 * @author boluclac
 * @version 0.0.0
 */
public interface MenuActionEvent extends Event {
    /**
     * <h2>Action menu performed</h2>
     * Invoked when action of menu is occur
     *
     * @param action  {@linkplain com.boluclac.facedetection.gui.events.ActionCommands Action command} of menu occur
     * @param control {@linkplain MainMenuControl Main menu control} is occurred
     */
    void menuPerformed(String action, MainMenuControl control);
}
