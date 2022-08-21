package com.boluclac.facedetection;

import com.boluclac.facedetection.gui.events.MainFrameEvent;
import com.boluclac.facedetection.gui.frames.MainFrame;

/**
 * <h1>Application launcher</h1>
 * Initialize application:
 * <ul>
 *     <li>Initialize Configuration</li>
 *     <li>{@link MainFrame} launcher</li>
 * </ul>
 */
public class App implements MainFrameEvent {

    /** Instance. */
    private static App instance = null;

    /**
     * <h2>Main action</h2>
     * Initialize application:
     * <ul>
     *     <li>Initialize Configuration</li>
     *     <li>{@link MainFrame} launcher</li>
     * </ul>
     *
     * @param argument arguments from environment
     */
    public static void main(String[] argument) {
        /* Initialize Configuration */
        ConfigurationCore.config();
        /* {@link MainFrame} launcher */
        MainFrame mainFrame = ConfigurationCore.getBean(MainFrame.class);
        assert mainFrame != null;
        mainFrame.addEventListener(App.getInstance());
        mainFrame.open();
    }

    /**
     * <h2>Instance: Application launcher</h2>
     * get Application launcher instance. It is only created one time
     *
     * @return Application launcher
     */
    private static App getInstance() {
        if (instance == null) {
            instance = new App();
        }
        return instance;
    }

    /**
     * <h2>Exit action</h2>
     * Exit application
     */
    @Override
    public void exit() {
        System.exit(0);
    }
}
