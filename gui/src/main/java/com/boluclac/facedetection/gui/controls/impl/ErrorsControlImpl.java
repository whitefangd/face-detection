package com.boluclac.facedetection.gui.controls.impl;

import com.boluclac.facedetection.common.beans.MessageSourceCommon;
import com.boluclac.facedetection.gui.common.constants.MessageGUIConstant;
import com.boluclac.facedetection.gui.controls.face.BaseControl;
import com.boluclac.facedetection.gui.controls.face.ErrorsControl;
import com.boluclac.facedetection.gui.exceptions.ValidationExceptions;
import com.boluclac.facedetection.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.List;
import java.util.Locale;

/**
 * <h1>Error control implement</h1>
 * Errors control, display errors list
 *
 * @author boluclac
 * @version 0.0.0
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ErrorsControlImpl extends JPanel implements BaseControl, ErrorsControl {

    /** Message Source Common */
    @Autowired
    private MessageSourceCommon messageSourceCommon;

    /** Frame content */
    private final Window contentFrame;

    /** Main container */
    private final JPanel mainPanel = new JPanel();
    /** Title */
    private TitledBorder title;
    /** Border */
    private CompoundBorder border;

    /**
     * Constructor.
     * Initialize bean
     *
     * @param frameContentParam Frame content
     */
    public ErrorsControlImpl(Window frameContentParam) {
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
        this.setLayout(new BorderLayout());
        this.add(this.mainPanel, BorderLayout.CENTER);
        BoxLayout boxLayout = new BoxLayout(this.mainPanel, BoxLayout.Y_AXIS);
        this.mainPanel.setLayout(boxLayout);
        this.title = new TitledBorder(new LineBorder(Color.RED), StringUtils.STRING_EMPTY);
        this.title.setTitleColor(Color.RED);
        border = new CompoundBorder(title, new EmptyBorder(8, 8, 8, 8));
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
    public JFrame getFrameContainer() {
        return null;
    }

    /**
     * <h2>get instance object</h2>
     * This is error control instance, it is cast {@link JPanel}
     *
     * @return instance object
     */
    @Override
    public JPanel getInstance() {
        return this;
    }

    /**
     * <h2>Set Validation errors</h2>
     * Set Validation errors is Exception
     *
     * @param validations Validation errors
     */
    @Override
    public void setErrors(ValidationExceptions validations) {
        List<String> messages = validations.getMessageErrors();
        /* Remove All message then add new message in list message*/
        mainPanel.setBorder(null);
        mainPanel.removeAll();
        if (!messages.isEmpty()) {
            /* Title is only added when have error information */
            this.mainPanel.setBorder(border);
            this.title.setTitle(messageSourceCommon.getMessage(MessageGUIConstant.ERRORS.TITLE));
            for (String message : messages) {
                JLabel label = new JLabel();
                label.setForeground(Color.RED);
                label.setText(message);
                mainPanel.add(label);
            }
        }
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    /**
     * Clear all errors message.
     */
    @Override
    public void clear() {
        mainPanel.setBorder(null);
        mainPanel.removeAll();
        mainPanel.revalidate();
        mainPanel.repaint();
    }
}
