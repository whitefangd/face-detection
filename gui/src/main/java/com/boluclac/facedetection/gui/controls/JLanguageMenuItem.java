package com.boluclac.facedetection.gui.controls;

import javax.swing.JMenuItem;
import java.util.Locale;

/**
 * <h1>Language menu item control</h1>
 * Design Language menu item control
 *
 * @author boluclac
 * @version 0.0.0
 */
public class JLanguageMenuItem extends JMenuItem {

    /** Locale data */
    private Locale localeData;

    /**
     * <h2>Set locale data</h2>
     * Set locale data map to with language
     *
     * @param locale Locale
     */
    public void setLocaleData(Locale locale) {
        this.localeData = locale;
    }

    /**
     * <h2>Set locale data</h2>
     * Get locale data map to with language
     *
     * @return Locale
     */
    public Locale getLocaleData() {
        return this.localeData;
    }
}
