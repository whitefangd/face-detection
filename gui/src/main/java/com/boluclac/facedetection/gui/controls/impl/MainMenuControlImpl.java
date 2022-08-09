package com.boluclac.facedetection.gui.controls.impl;

import com.boluclac.facedetection.gui.controls.face.MainMenuControl;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
public class MainMenuControlImpl extends BaseControl<JMenuBar> implements MainMenuControl {

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

    /**
     * <h2>get instance object</h2>
     * This is main menu instance, it is cast {@link JMenuBar}
     *
     * @return instance object
     */
    @Override
    public JMenuBar getInstance() {
        assert instance != null;
        return instance;
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
    protected void graphicDesignInit() {
        instance = new JMenuBar();
        /* ************************************************** */
        /* Home menu
        /* ************************************************** */
        fileMenu = new JMenu();
        instance.add(fileMenu, 0);
        /* ************************************************** */
        /* Training menu
        /* ************************************************** */
        trainingMenu = new JMenu();
        instance.add(trainingMenu, 1);
        /* ************************************************** */
        /* Help menu
        /* ************************************************** */
        helpMenu = new JMenu();
        instance.add(helpMenu, 2);
        languageMenu = new JMenu();
        helpMenu.add(languageMenu, 0);
        aboutMenu = new JMenuItem();
        helpMenu.add(aboutMenu, 1);
        List<Locale> locales = messageSourceCommon.getLocales();
        for (Locale locale : locales) {
            JMenuItem localeMenu = new JMenuItem();
            localeMenu.setName(locale.getLanguage());
            languageMenu.add(localeMenu);
        }
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
    protected void afterLocaleSet(Locale locale) {
        fileMenu.setText(messageSourceCommon.getMessage("menu.file", locale));
        trainingMenu.setText(messageSourceCommon.getMessage("menu.training", locale));
        helpMenu.setText(messageSourceCommon.getMessage("menu.help", locale));
        languageMenu.setText(messageSourceCommon.getMessage("menu.language", locale));
        aboutMenu.setText(messageSourceCommon.getMessage("menu.about", locale));
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
    protected void afterCreateInit() {
        // Do nothing
    }
}
