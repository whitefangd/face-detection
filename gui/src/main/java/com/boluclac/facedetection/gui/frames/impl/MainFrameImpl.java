package com.boluclac.facedetection.gui.frames.impl;

import com.boluclac.facedetection.ConfigurationCore;
import com.boluclac.facedetection.annotations.FrameComponent;
import com.boluclac.facedetection.common.beans.MessageSourceCommon;
import com.boluclac.facedetection.gui.controls.face.MainMenuControl;
import com.boluclac.facedetection.gui.controls.face.TrainingPageControl;
import com.boluclac.facedetection.gui.events.ActionCommands;
import com.boluclac.facedetection.gui.events.face.ExitFrameEvent;
import com.boluclac.facedetection.gui.events.face.MenuActionEvent;
import com.boluclac.facedetection.gui.frames.face.MainFrame;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * <h1>Main Frame Implement</h1>
 * Design base layout, structure frame.
 *
 * @author boluclac
 * @version 0.0.0
 */
@FrameComponent
public class MainFrameImpl extends BaseFrame implements MainFrame, MenuActionEvent {

    /** Message resources Common */
    @Autowired
    private MessageSourceCommon messageSourceCommon;
    /** Event list: Exit frame */
    private final List<ExitFrameEvent> exitFrameEvents = new ArrayList<>();

    /** Main panel */
    private JPanel mainPanel;

    /**
     * Invoked when the user attempts to close the window
     * from the window's system menu.
     *
     * @param event Window event
     */
    @Override
    public void windowClosing(WindowEvent event) {
        for (ExitFrameEvent exitFrameEvent : exitFrameEvents) {
            exitFrameEvent.exit();
        }
    }

    /**
     * <h2>Initialize Graphic Design </h2>
     * Initialize graphic user interface<br>
     *
     * @apiNote Reference more information comment {@link BaseFrame#graphicDesignInit()}
     */
    protected void graphicDesignInit() {
        /* ************************************************** */
        /* Setting window
        /* ************************************************** */
        // Full screen when open frame
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // Only hide Frame when close
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        /* ************************************************** */
        /* Layout root
        /* ************************************************** */
        this.setLayout(new BorderLayout());
        /* ************************************************** */
        /* Panel root
        /* ************************************************** */
        mainPanel = new JPanel();
        this.add(mainPanel, BorderLayout.CENTER);
        mainPanel.setLayout(new BorderLayout());
        /* ************************************************** */
        /* Main menu
        /* ************************************************** */
        MainMenuControl menuBar = ConfigurationCore.getBean(MainMenuControl.class);
        assert menuBar != null;
        this.setJMenuBar(menuBar.getInstance());
        menuBar.addMenuActionEventListener(this);
    }

    /**
     * <h2>Locale change</h2>
     * After local is set<br>
     *
     * @apiNote Reference more information comment {@link BaseFrame#afterLocaleSet(Locale)}
     */
    protected void afterLocaleSet(Locale locale) {
        this.setTitle(messageSourceCommon.getMessage("title", locale));
    }

    /**
     * <h2>Initialize After</h2>
     * Initialize after create base data<br>
     *
     * @apiNote Reference more information comment {@link BaseFrame#afterCreateInit()}
     */
    @Override
    protected void afterCreateInit() {
        this.addWindowListener(this);
    }

    /**
     * <h2>Open Frame</h2>
     * Open frame.<br>
     * When create object default frame is closed
     */
    @Override
    public void open() {
        this.setVisible(true);
    }

    /**
     * <h2>Event: Exit frame</h2>
     * Event is triggered when close frame completed
     * Register event listener
     *
     * @param event Edit frame event
     */
    @Override
    public void addExitFrameEventListener(ExitFrameEvent event) {
        exitFrameEvents.add(event);
    }

    /**
     * <h2>Remove Event: Exit frame</h2>
     * Event is triggered when close frame completed
     * Remove register event listener registered
     *
     * @param event Edit frame event
     */
    @Override
    public void removeExitFrameEventListener(ExitFrameEvent event) {
        exitFrameEvents.remove(event);
    }

    /**
     * <h2>Clear Event: Exit frame</h2>
     * Event is triggered when close frame completed
     * clear event listener registered
     */
    @Override
    public void clearExitFrameEventListener() {
        exitFrameEvents.clear();
    }

    /**
     * <h2>Action menu performed</h2>
     * Invoked when action of menu is occur
     *
     * @param action  {@linkplain ActionCommands Action command} of menu occur
     * @param control {@linkplain MainMenuControl Main menu control} is occurred
     */
    @Override
    public void menuPerformed(String action, MainMenuControl control) {
        if (ActionCommands.CREATE_NEW_TRAINING.equals(action)) {
            createNewTraining();
        }
    }

    /**
     * Create page: Training page
     */
    private void createNewTraining() {
        TrainingPageControl trainingPageControl = ConfigurationCore.getBean(TrainingPageControl.class);
        assert trainingPageControl != null;
        mainPanel.add(trainingPageControl.getInstance(), BorderLayout.CENTER);
        mainPanel.revalidate();
    }
}
