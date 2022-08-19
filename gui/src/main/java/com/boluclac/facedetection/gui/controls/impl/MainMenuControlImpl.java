package com.boluclac.facedetection.gui.controls.impl;

import com.boluclac.facedetection.common.beans.MessageSourceCommon;
import com.boluclac.facedetection.gui.common.constants.MessageGUIConstant;
import com.boluclac.facedetection.gui.controls.JLanguageMenuItem;
import com.boluclac.facedetection.gui.controls.face.BaseControl;
import com.boluclac.facedetection.gui.controls.face.MainMenuControl;
import com.boluclac.facedetection.gui.events.ActionCommands;
import com.boluclac.facedetection.gui.events.face.MenuActionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * <h1>Main Menu control Implement</h1>
 * Design main menu layout.
 *
 * @author boluclac
 * @version 0.0.0
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MainMenuControlImpl extends JMenuBar implements BaseControl, MainMenuControl, ActionListener {

    /** Message Source Common */
    @Autowired
    private MessageSourceCommon messageSourceCommon;

    /** Frame content */
    private Window contentFrame;

    /** List menu action listener */
    private final List<MenuActionEvent> menuActionEvents = new ArrayList<>();

    /** Menu training */
    private JMenuItem trainingMenu;
    /** Home training */
    private JMenuItem fileMenu;
    /** Help menu */
    private JMenuItem helpMenu;
    /** Language menu */
    private JMenuItem languageMenu;
    /** About menu */
    private JMenuItem aboutMenu;
    /** Create training menu */
    private JMenuItem createTrainingMenu;

    /**
     * Constructor.
     * Initialize bean
     *
     * @param frameContentParam Frame content
     */
    public MainMenuControlImpl(JFrame frameContentParam) {
        super();
        this.contentFrame = frameContentParam;
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
     * <h2>get instance object</h2>
     * This is main menu instance, it is cast {@link JMenuBar}
     *
     * @return instance object
     */
    @Override
    public JMenuBar getInstance() {
        return this;
    }

    /**
     * <h2>Add event: {@linkplain MenuActionEvent Menu action event}</h2>
     * Add action menu event listener
     *
     * @param event Menu action event
     */
    @Override
    public void addMenuActionEventListener(MenuActionEvent event) {
        menuActionEvents.add(event);
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
        /* Home menu
        /* ************************************************** */
        fileMenu = new JMenu();
        this.add(fileMenu, 0);
        /* ************************************************** */
        /* Training menu
        /* ************************************************** */
        trainingMenu = new JMenu();
        this.add(trainingMenu, 1);
        /* ************************************************** */
        /* Help menu
        /* ************************************************** */
        helpMenu = new JMenu();
        this.add(helpMenu, 2);
        /* ************************************************** */
        /* Language menu
        /* ************************************************** */
        languageMenu = new JMenu();
        helpMenu.add(languageMenu, 0);
        List<Locale> locales = messageSourceCommon.getLocales();
        for (Locale locale : locales) {
            JLanguageMenuItem localeMenu = new JLanguageMenuItem();
            localeMenu.setName(locale.getLanguage());
            localeMenu.setLocaleData(locale);
            languageMenu.add(localeMenu);
            localeMenu.setActionCommand(ActionCommands.CHANGE_LANGUAGE);
            localeMenu.addActionListener(this);
        }
        /* ************************************************** */
        /* About menu
        /* ************************************************** */
        aboutMenu = new JMenuItem();
        helpMenu.add(aboutMenu, 1);
        /* ************************************************** */
        /* Create training menu
        /* ************************************************** */
        createTrainingMenu = new JMenuItem();
        fileMenu.add(createTrainingMenu, 0);
        createTrainingMenu.setActionCommand(ActionCommands.CREATE_NEW_TRAINING);
        createTrainingMenu.addActionListener(this);
        KeyStroke keyCreate = KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK);
        createTrainingMenu.setAccelerator(keyCreate);
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
        fileMenu.setText(messageSourceCommon.getMessage(MessageGUIConstant.MENU_FILE, locale));
        trainingMenu.setText(messageSourceCommon.getMessage(MessageGUIConstant.MENU_TRAINING, locale));
        helpMenu.setText(messageSourceCommon.getMessage(MessageGUIConstant.MENU_HELP, locale));
        languageMenu.setText(messageSourceCommon.getMessage(MessageGUIConstant.MENU_LANGUAGE, locale));
        aboutMenu.setText(messageSourceCommon.getMessage(MessageGUIConstant.MENU_ABOUT, locale));
        if (languageMenu instanceof JMenu) {
            JMenu languageMenuTemp = (JMenu) languageMenu;
            for (int indexMenu = 0; indexMenu < languageMenuTemp.getItemCount(); indexMenu++) {
                JMenuItem menuItem = languageMenuTemp.getItem(indexMenu);
                String menuName = messageSourceCommon.getLocaleName(menuItem.getName());
                menuItem.setText(messageSourceCommon.getMessage(menuName, locale));
            }
        }
        createTrainingMenu.setText(messageSourceCommon.getMessage(MessageGUIConstant.MENU_FILE_NEW_TRAINING, locale));
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
        // DO nothing
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
     * Invoked when an action occurs menu item
     *
     * @param event Event
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        String actionCommand = event.getActionCommand();
        if (ActionCommands.CHANGE_LANGUAGE.equals(actionCommand)) {
            changeLanguage(event);
        } else {
            for (MenuActionEvent menuActionEvent : menuActionEvents) {
                menuActionEvent.menuPerformed(actionCommand, this);
            }
        }
    }

    /**
     * Change language
     *
     * @param event Event action
     */
    private void changeLanguage(ActionEvent event) {
        Object object = event.getSource();
        if (object instanceof JLanguageMenuItem) {
            JLanguageMenuItem menuItem = (JLanguageMenuItem) object;
            messageSourceCommon.setLocale(menuItem.getLocaleData());
            afterLocaleSet(menuItem.getLocaleData());
        }
    }
}
