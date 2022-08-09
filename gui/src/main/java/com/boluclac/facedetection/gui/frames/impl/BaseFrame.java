package com.boluclac.facedetection.gui.frames.impl;

import javax.annotation.PostConstruct;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Locale;

/**
 * <h1>Base Frame</h1>
 * Support general unit all frame.
 *
 * @author boluclac
 * @version 0.0.0
 */
public abstract class BaseFrame extends JFrame implements WindowListener {

    /**
     * <h2>Construct</h2>
     * Construct no parameter.<br>
     * After processed, function {@link #afterCreateInit()} will be called automatically
     */
    @PostConstruct
    public void init() {
        graphicDesignInit();
        afterLocaleSet(getLocale());
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
    protected abstract void graphicDesignInit();

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
    protected abstract void afterLocaleSet(Locale locale);

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
    protected abstract void afterCreateInit();

    /**
     * Invoked the first time a window is made visible.
     *
     * @param event Window event
     */
    @Override
    public void windowOpened(WindowEvent event) {
        /* Do nothing */
    }

    /**
     * Invoked when the user attempts to close the window
     * from the window's system menu.
     *
     * @param event Window event
     */
    @Override
    public void windowClosing(WindowEvent event) {
        /* Do nothing */
    }

    /**
     * Invoked when a window has been closed as the result
     * of calling dispose on the window.
     *
     * @param event Window event
     */
    @Override
    public void windowClosed(WindowEvent event) {
        /* Do nothing */
    }

    /**
     * Invoked when a window is changed from a normal to a
     * minimized state. For many platforms, a minimized window
     * is displayed as the icon specified in the window's
     * iconImage property.
     *
     * @param event Window event
     * @see Frame#setIconImage
     */
    @Override
    public void windowIconified(WindowEvent event) {
        /* Do nothing */
    }

    /**
     * Invoked when a window is changed from a minimized
     * to a normal state.
     *
     * @param event Window event
     */
    @Override
    public void windowDeiconified(WindowEvent event) {
        /* Do nothing */
    }

    /**
     * Invoked when the Window is set to be the active Window. Only a Frame or
     * a Dialog can be the active Window. The native windowing system may
     * denote the active Window or its children with special decorations, such
     * as a highlighted title bar. The active Window is always either the
     * focused Window, or the first Frame or Dialog that is an owner of the
     * focused Window.
     *
     * @param event Window event
     */
    @Override
    public void windowActivated(WindowEvent event) {
        /* Do nothing */
    }

    /**
     * Invoked when a Window is no longer the active Window. Only a Frame or a
     * Dialog can be the active Window. The native windowing system may denote
     * the active Window or its children with special decorations, such as a
     * highlighted title bar. The active Window is always either the focused
     * Window, or the first Frame or Dialog that is an owner of the focused
     * Window.
     *
     * @param event Window event
     */
    @Override
    public void windowDeactivated(WindowEvent event) {
        /* Do nothing */
    }
}
