package com.boluclac.facedetection.gui.controls.impl;

import com.boluclac.facedetection.ConfigurationCore;
import com.boluclac.facedetection.common.beans.MessageSourceCommon;
import com.boluclac.facedetection.gui.common.constants.Constants;
import com.boluclac.facedetection.gui.common.constants.MessageGUIConstant;
import com.boluclac.facedetection.gui.controls.face.BaseControl;
import com.boluclac.facedetection.gui.controls.face.ErrorsControl;
import com.boluclac.facedetection.gui.controls.face.TrainingPageCreatePopup;
import com.boluclac.facedetection.gui.events.ActionCommands;
import com.boluclac.facedetection.gui.events.face.TrainingPageCreateEvent;
import com.boluclac.facedetection.gui.exceptions.ValidationExceptions;
import com.boluclac.facedetection.utils.LogUtils;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
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
public class TrainingPageCreatePopupImpl extends JDialog implements BaseControl, TrainingPageCreatePopup, ActionListener {

    /** Message Source Common */
    @Autowired
    private MessageSourceCommon messageSourceCommon;

    private final List<TrainingPageCreateEvent> events = new ArrayList<>();

    /** project folder */
    private File projectFolder = null;

    /** Frame content */
    private final Window contentFrame;
    /** Error controls */
    private ErrorsControl errorsControl;
    /** Base control parent */
    private final JComponent baseControlParent;
    /** main panel container */
    private final JPanel mainPanel = new JPanel();
    ;
    /** label name. */
    private final JLabel labelName = new JLabel();
    /** text field name */
    private final JTextField txtName = new JTextField();
    /** label folder. */
    private final JLabel labelFolder = new JLabel();
    /** chooser folder. */
    private final JTextField chooserFolder = new JTextField();
    /** chooser folder button. */
    private final JButton chooserFolderBtn = new JButton();
    /** title border */
    private TitledBorder titledBorderChooseProject;
    /** Cancel button */
    private final JButton cancelBtn = new JButton();
    /** OK button */
    private final JButton okBtn = new JButton();

    /**
     * Constructor.
     * Initialize bean
     *
     * @param baseControl       Base control
     * @param frameContentParam Frame content
     */
    public TrainingPageCreatePopupImpl(JComponent baseControl, JFrame frameContentParam) {
        super(frameContentParam);
        this.contentFrame = frameContentParam;
        this.baseControlParent = baseControl;
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
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.pack();
        this.setLocationRelativeTo(contentFrame);
        this.add(mainPanel);
        this.mainPanel.setLayout(new BorderLayout());
        /* ************************************************** */
        /* Error control
        /* ************************************************** */
        errorsControl = ConfigurationCore.getBean(ErrorsControl.class, this);
        assert errorsControl != null;
        this.mainPanel.add(errorsControl.getInstance(), BorderLayout.NORTH);
        /* ************************************************** */
        /* Panel of project information area
        /* ************************************************** */
        final JPanel jPanelChoose = new JPanel();
        jPanelChoose.setLayout(new GridBagLayout());
        titledBorderChooseProject = new TitledBorder(new LineBorder(Color.ORANGE), "");
        CompoundBorder compoundBorder = new CompoundBorder(titledBorderChooseProject, new EmptyBorder(8, 8, 8, 8));
        jPanelChoose.setBorder(compoundBorder);
        jPanelChoose.validate();
        this.mainPanel.add(jPanelChoose, BorderLayout.CENTER);
        /* ************************************************** */
        /* Panel of project action area
        /* ************************************************** */
        final JPanel jPanelAction = new JPanel();
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setAlignment(FlowLayout.RIGHT);
        jPanelAction.setLayout(flowLayout);
        CompoundBorder compoundBorderAction = new CompoundBorder(new EmptyBorder(2, 2, 2, 2), new LineBorder(Color.ORANGE));
        jPanelAction.setBorder(compoundBorderAction);
        this.mainPanel.add(jPanelAction, BorderLayout.SOUTH);
        /* Prepare position information for item in project information area */
        final GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(2, 2, 2, 2);
        /* ************************************************** */
        /* Project training name
        /* ************************************************** */
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0;
        jPanelChoose.add(this.labelName, constraints);
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 2;
        jPanelChoose.add(this.txtName, constraints);
        this.txtName.setColumns(50);
        this.txtName.setBorder(new CompoundBorder(new LineBorder(Color.GRAY),
                BorderFactory.createEmptyBorder(4, 4, 4, 4)));
        /* ************************************************** */
        /* Project training folder
        /* ************************************************** */
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 0;
        jPanelChoose.add(this.labelFolder, constraints);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weightx = 2;
        this.chooserFolder.setColumns(50);
        this.chooserFolder.setBorder(new CompoundBorder(new LineBorder(Color.GRAY),
                BorderFactory.createEmptyBorder(4, 4, 4, 4)));
        this.chooserFolder.setEditable(false);
        jPanelChoose.add(this.chooserFolder, constraints);
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.weightx = 0;
        jPanelChoose.add(this.chooserFolderBtn, constraints);
        /* ************************************************** */
        /* OK action
        /* ************************************************** */
        jPanelAction.add(this.okBtn);
        this.okBtn.setPreferredSize(new Dimension(100, 25));
        /* ************************************************** */
        /* Cancel action
        /* ************************************************** */
        jPanelAction.add(this.cancelBtn);
        this.cancelBtn.setPreferredSize(new Dimension(100, 25));

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
        this.titledBorderChooseProject.setTitle(messageSourceCommon.getMessage(MessageGUIConstant.TRAINNG_PROJECT_CHOSSER_TITLE, locale));
        this.labelName.setText(messageSourceCommon.getMessage(MessageGUIConstant.TRAINNG_PROJECT_NAME, locale));
        this.labelFolder.setText(messageSourceCommon.getMessage(MessageGUIConstant.TRAINNG_PROJECT_FOLDER, locale));
        this.chooserFolderBtn.setText(messageSourceCommon.getMessage(MessageGUIConstant.BUTTON_THREEDOT, locale));
        this.cancelBtn.setText(messageSourceCommon.getMessage(MessageGUIConstant.BUTTON_CANCEL, locale));
        this.okBtn.setText(messageSourceCommon.getMessage(MessageGUIConstant.BUTTON_OK, locale));
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
        this.chooserFolderBtn.setActionCommand(ActionCommands.CHOOSE_FOLDER);
        this.cancelBtn.setActionCommand(ActionCommands.CANCEL);
        this.okBtn.setActionCommand(ActionCommands.OK);
        this.chooserFolderBtn.addActionListener(this);
        this.cancelBtn.addActionListener(this);
        this.okBtn.addActionListener(this);
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
     * Invoked when an action occurs.
     *
     * @param event Event
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        if (ActionCommands.CHOOSE_FOLDER.equals(event.getActionCommand())) {
            chooserFolderOpen();
        } else if (ActionCommands.OK.equals(event.getActionCommand())) {
            createTrainingProject();
        } else if (ActionCommands.CANCEL.equals(event.getActionCommand())) {
            cancelTrainingProject();
        }
    }

    /**
     * create training project
     */
    private void createTrainingProject() {
        this.errorsControl.clear();
        try {
            checkCreateValidate();
            if (projectFolder.isDirectory()) {
                Path path = Paths.get(projectFolder.getPath(), Constants.PROJECT_TRAINING_FILE_NAME);
                File projectFile = path.toFile();
                if (!projectFile.exists()) {
                    assert projectFile.createNewFile();
                } else if (projectFile.isDirectory()) {
                    throw new ValidationExceptions();
                }

            }
            for (TrainingPageCreateEvent event : events) {
                event.createTrainingProject(this.txtName.getText(), this.projectFolder);
            }
            dispose();
        } catch (ValidationExceptions validations) {
            LogUtils.error(validations.getMessage(), validations);
            this.errorsControl.setErrors(validations);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * check create validate
     *
     * @throws ValidationExceptions Validation errors
     */
    private void checkCreateValidate() throws ValidationExceptions {
        ValidationExceptions exceptions = new ValidationExceptions();
        boolean errorFlag = false;
        if (StringUtils.isNullOrEMpty(this.txtName.getText())) {
            exceptions.addError(MessageGUIConstant.ERRORS.ERR_10000001, MessageGUIConstant.TRAINNG_PROJECT_NAME);
            errorFlag = true;
        }
        if (projectFolder == null || StringUtils.isNullOrEMpty(this.chooserFolder.getText())) {
            exceptions.addError(MessageGUIConstant.ERRORS.ERR_10000001, MessageGUIConstant.TRAINNG_PROJECT_FOLDER);
            errorFlag = true;
        }
        if (errorFlag) {
            throw exceptions;
        }
    }

    /**
     * Cancel training project creation
     */
    private void cancelTrainingProject() {
        for (TrainingPageCreateEvent event : events) {
            event.cancelProjectCreation();
        }
        dispose();
    }

    /**
     * Choose folder open dialog
     */
    private void chooserFolderOpen() {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setDialogTitle(messageSourceCommon.getMessage(MessageGUIConstant.TRAINNG_PROJECT_FOLDER));
        jFileChooser.setApproveButtonText(messageSourceCommon.getMessage(MessageGUIConstant.BUTTON_OK));
        jFileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
        jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int resultChoose = jFileChooser.showOpenDialog(this);
        if (resultChoose == JFileChooser.APPROVE_OPTION) {
            projectFolder = jFileChooser.getSelectedFile();
            this.chooserFolder.setText(projectFolder.getName());
        }
    }

    /**
     * <h2>Add Event: Training popup</h2>
     * Event is triggered when Training popup has process
     *
     * @param event Training popup event
     */
    @Override
    public void addEventListener(TrainingPageCreateEvent event) {
        events.add(event);
    }

    /**
     * <h2>Remove Event: Training popup</h2>
     * Event is triggered when Training popup has process
     *
     * @param event Training popup event
     */
    @Override
    public void removeEventListener(TrainingPageCreateEvent event) {
        events.remove(event);
    }

    /**
     * <h2>Clear Event: Training popup</h2>
     * Event is triggered when Training popup has process
     */
    @Override
    public void clearEventListener() {
        events.clear();
    }
}
