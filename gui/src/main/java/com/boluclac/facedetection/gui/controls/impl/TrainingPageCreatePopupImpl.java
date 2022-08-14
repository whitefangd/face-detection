package com.boluclac.facedetection.gui.controls.impl;

import com.boluclac.facedetection.common.beans.MessageSourceCommon;
import com.boluclac.facedetection.gui.controls.face.BaseControl;
import com.boluclac.facedetection.gui.controls.face.TrainingPageCreatePopup;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.JDialog;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Locale;

/**
 * <h1>Training page create - popup implement</h1>
 * Design popup new training page.
 * Create location and training name
 *
 * @author boluclac
 * @version 0.0.0
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TrainingPageCreatePopupImpl extends JDialog implements BaseControl, TrainingPageCreatePopup {

    /** Message Source Common */
    private final MessageSourceCommon messageSourceCommon;

    /**
     * Constructor.
     * Initialize bean
     *
     * @param messageSourceCommon Message source common
     */
    public TrainingPageCreatePopupImpl(MessageSourceCommon messageSourceCommon) {
        this.messageSourceCommon = messageSourceCommon;
    }

    /**
     * <h2>get instance object</h2>
     * This is training popup new training page instance, it is cast {@link JDialog}
     *
     * @return instance object
     */
    @Override
    public JDialog getInstance() {
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
        this.setPreferredSize(new Dimension(500, 300));
        this.setResizable(false);
        this.setType(Type.UTILITY);
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
