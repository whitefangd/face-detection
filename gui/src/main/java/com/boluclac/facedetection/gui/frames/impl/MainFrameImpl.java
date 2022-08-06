package com.boluclac.facedetection.gui.frames.impl;

import com.boluclac.facedetection.annotations.FrameComponent;
import com.boluclac.facedetection.common.MessageSourceCommon;
import com.boluclac.facedetection.gui.events.face.ExitFrameEvent;
import com.boluclac.facedetection.gui.frames.face.MainFrame;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class MainFrameImpl extends BaseFrame implements MainFrame {

    /**
     * Message resources Common
     */
    @Autowired
    private MessageSourceCommon messageSourceCommon;
    /**
     * Event list: Exit frame
     */
    private final List<ExitFrameEvent> exitFrameEvents = new ArrayList<>();

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
        JPanel mainPanel = new JPanel();
        this.add(mainPanel);
        mainPanel.setLayout(new BorderLayout());
        JButton button = new JButton();
        mainPanel.add(button, BorderLayout.CENTER);
        button.setText("Change locale");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Locale locale = new Locale("vi", "VN");
                messageSourceCommon.setLocale(locale);
                afterLocaleSet(locale);
            }
        });

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
     * <h2>Set Message resources Common</h2>
     *
     * @param messageSourceCommon Message resources Common
     */
    public void setMessageSourceCommon(MessageSourceCommon messageSourceCommon) {
        this.messageSourceCommon = messageSourceCommon;
    }
}
