package com.boluclac.facedetection.gui.controls;

import com.boluclac.facedetection.gui.events.MenuActionEvent;

import javax.swing.*;

/**
 * <h1>Main Menu control Interface</h1>
 * Design main menu layout.
 *
 * @author boluclac
 * @version 0.0.0
 */
public interface MainMenuControl {

    /**
     * <h2>get instance object</h2>
     * This is main menu instance, it is cast {@link JMenuBar}
     *
     * @return instance object
     */
    JMenuBar getInstance();

    /**
     * <h2>Add event: {@linkplain MenuActionEvent Menu action event}</h2>
     * Add action menu event listener
     *
     * @param event Menu action event
     */
    void addMenuActionEventListener(MenuActionEvent event);
}
