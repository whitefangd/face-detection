package com.boluclac.facedetection.gui.controls.face;

import javax.swing.JMenuBar;

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
}
