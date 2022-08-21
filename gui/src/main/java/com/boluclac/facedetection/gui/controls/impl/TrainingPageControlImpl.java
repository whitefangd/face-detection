package com.boluclac.facedetection.gui.controls.impl;

import com.boluclac.facedetection.ConfigurationCore;
import com.boluclac.facedetection.common.beans.MessageSourceCommon;
import com.boluclac.facedetection.gui.common.annotations.ControlComponent;
import com.boluclac.facedetection.gui.controls.BaseControl;
import com.boluclac.facedetection.gui.controls.TrainingPageControl;
import com.boluclac.facedetection.gui.controls.TrainingPageCreatePopup;
import com.boluclac.facedetection.gui.events.TrainingPageCreateEvent;
import com.boluclac.facedetection.gui.events.TrainingPageEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * <h1>Training page - control Implement</h1>
 * Design Training page control
 *
 * @author boluclac
 * @version 0.0.0
 */
@ControlComponent
public class TrainingPageControlImpl extends JPanel implements BaseControl, TrainingPageControl, TrainingPageCreateEvent {

    /** Message Source Common */
    @Autowired
    private MessageSourceCommon messageSourceCommon;

    /** Events list */
    private final List<TrainingPageEvent> events = new ArrayList<>();

    /** Frame content */
    private final Window contentFrame;

    /**
     * Constructor.
     * Initialize bean
     *
     * @param frameContentParam Frame content
     */
    public TrainingPageControlImpl(Window frameContentParam) {
        super();
        this.contentFrame = frameContentParam;
    }

    /**
     * <h2>get instance object</h2>
     * This is training page instance, it is cast {@link JPanel}
     *
     * @return instance object
     */
    @Override
    public JPanel getInstance() {
        return this;
    }

    /**
     * <h2>Construct</h2>
     * Construct no parameter.<br>
     * After processed, function {@link #afterCreateInit()} will be called automatically
     */
    @PostConstruct
    @Override
    public void init() {
        SwingUtilities.invokeLater(this::initCreatePopup);
    }

    /**
     * <h2>Construct</h2>
     * Construct no parameter.<br>
     * After processed, function {@link #afterCreateInit()} will be called automatically
     */
    public void initCreatePopup() {
        TrainingPageCreatePopup trainingPageCreatePopup = ConfigurationCore.getBean(TrainingPageCreatePopup.class, this, contentFrame);
        assert trainingPageCreatePopup != null;
        trainingPageCreatePopup.addEventListener(this);
        JDialog dialog = trainingPageCreatePopup.getInstance();
        dialog.setVisible(true);
    }

    /**
     * <h2>Construct</h2>
     * Construct no parameter.<br>
     * After processed, function {@link #afterCreateInit()} will be called automatically
     */
    public void initCreateTraining() {
        graphicDesignInit();
        afterLocaleSet(messageSourceCommon.getLocale());
        afterCreateInit();
    }

    /**
     * <h2>Initialize Graphic Design </h2>
     * Initialize graphic user interface<br>
     * Flow process init frame:
     * <ol>
     *     <li>{@literal graphicDesignInit}: Initialize Graphic Design</li>
     *     <li>{@link #afterLocaleSet}: Locale change</li>
     *     <li>{@link #afterCreateInit}: Process after create</li>
     * </ol>
     *
     * @apiNote This is abstract  function, required implement when extend
     */
    @Override
    public void graphicDesignInit() {
        /* ************************************************** */
        /* Self setting
        /* ************************************************** */
        this.setBackground(Color.GRAY);
        this.setLayout(new BorderLayout());
        /* ************************************************** */
        /* Control options
        /* ************************************************** */
        JPanel optionPanel = new JPanel();
        optionPanel.setLayout(new BorderLayout());
        /* ************************************************** */
        /* Control options scroll panel
        /* ************************************************** */
        JScrollPane leftScrollPanel = new JScrollPane();
        leftScrollPanel.setLayout(new ScrollPaneLayout());
        leftScrollPanel.setViewportView(optionPanel);
        leftScrollPanel.setMinimumSize(new Dimension(300, 0));
        leftScrollPanel.setPreferredSize(new Dimension(300, 0));
        /* ************************************************** */
        /* Content panel
        /* ************************************************** */
        JPanel rightContentPanel = new JPanel();
        rightContentPanel.setLayout(new BorderLayout());
        rightContentPanel.setBackground(Color.GRAY);
        /* ************************************************** */
        /* Split panel
        /* ************************************************** */
        JSplitPane mainPanel = new JSplitPane();
        this.add(mainPanel, BorderLayout.CENTER);
        mainPanel.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        mainPanel.setLeftComponent(leftScrollPanel);
        mainPanel.setRightComponent(rightContentPanel);

    }

    /**
     * <h2>Locale change</h2>
     * After local is set<br>
     * Flow process init frame:
     * <ol>
     *     <li>{@link #graphicDesignInit}: Initialize Graphic Design</li>
     *     <li>{@literal afterLocaleSet}: Locale change</li>
     *     <li>{@link #afterCreateInit}: Process after create</li>
     * </ol>
     *
     * @param locale Locale language
     * @apiNote This is abstract  function, required implement when extend
     */
    @Override
    public void afterLocaleSet(Locale locale) {

    }

    /**
     * <h2>Initialize After</h2>
     * Initialize after create base data<br>
     * Flow process init frame:
     * <ol>
     *     <li>{@link #graphicDesignInit}: Initialize Graphic Design</li>
     *     <li>{@link #afterLocaleSet}: Locale change</li>
     *     <li>{@literal afterCreateInit}: Process after create</li>
     * </ol>
     *
     * @apiNote This is abstract  function, required implement when extend
     */
    @Override
    public void afterCreateInit() {

    }

    /**
     * <h2>Get Frame content control</h2>
     * get Frame is {@link JFrame}, it contain this control
     */
    @Override
    public Window getFrameContainer() {
        return contentFrame;
    }

    /**
     * <h2>EventL cancel create new project</h2>
     * Cancel process create training project
     */
    @Override
    public void cancelProjectCreation() {
        for (TrainingPageEvent event : events) {
            event.actionDisposed(this);
        }
    }

    /**
     * <h2>Event create training project</h2>
     * Accept create new training project
     *
     * @param projectName   Project name
     * @param projectFolder Project folder
     */
    @Override
    public void createTrainingProject(String projectName, File projectFolder) {
        initCreateTraining();
        this.revalidate();
        this.repaint();
    }


    /**
     * <h2>Add Event: Training page</h2>
     * Event is triggered when Training page has process
     *
     * @param event Training page event
     */
    @Override
    public void addEventListener(TrainingPageEvent event) {
        events.add(event);
    }

    /**
     * <h2>Remove Event: Training page</h2>
     * Event is triggered when Training page has process
     *
     * @param event Training page event
     */
    @Override
    public void removeEventListener(TrainingPageEvent event) {
        events.remove(event);
    }

    /**
     * <h2>Clear Event: Training page</h2>
     * Event is triggered when Training page has process
     */
    @Override
    public void clearEventListener() {
        events.clear();
    }
}
