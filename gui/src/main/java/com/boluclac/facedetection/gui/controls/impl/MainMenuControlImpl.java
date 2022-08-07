package com.boluclac.facedetection.gui.controls.impl;

import com.boluclac.facedetection.gui.controls.face.MainMenuControl;
import org.springframework.beans.BeanInfoFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MainMenuControlImpl extends BaseControl<JMenuBar> implements MainMenuControl {
    /**
     * Menu training
     */
    private JMenu trainingMenu;
    /**
     * Home training
     */
    private JMenu fileMenu;

}
