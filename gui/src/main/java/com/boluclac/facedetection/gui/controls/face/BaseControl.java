package com.boluclac.facedetection.gui.controls.face;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public interface BaseControl {

    /**
     * <h2>Construct</h2>
     * Construct no parameter.<br>
     * After processed, function {@link #afterCreateInit()} will be called automatically
     */
    void init();

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
    void graphicDesignInit();

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
    void afterLocaleSet(Locale locale);

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
    void afterCreateInit();

    /**
     * <h2>Get Frame content control</h2>
     * get Frame is {@link JFrame}, it contain this control
     */
    Window getFrameContainer();
}
