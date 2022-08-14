package com.boluclac.facedetection.gui.controls.impl;

import com.boluclac.facedetection.common.beans.MessageSourceCommon;
import com.boluclac.facedetection.gui.controls.face.BaseControl;
import com.boluclac.facedetection.gui.controls.face.TrainingPageControl;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ScrollPaneLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Locale;

/**
 * <h1>Training page - control Implement</h1>
 * Design Training page control
 *
 * @author boluclac
 * @version 0.0.0
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TrainingPageControlImpl extends JPanel implements BaseControl, TrainingPageControl {

    /** Message Source Common */
    private final MessageSourceCommon messageSourceCommon;

    /**
     * Constructor.
     * Initialize bean
     *
     * @param messageSourceCommon Message source common
     */
    public TrainingPageControlImpl(MessageSourceCommon messageSourceCommon) {
        this.messageSourceCommon = messageSourceCommon;
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
     *
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
}
