package com.boluclac.facedetection.gui.events;

import com.boluclac.facedetection.gui.controls.TrainingPageCreatePopup;

import java.io.File;

/**
 * <h1>Event Interface: Training page create - popup</h1>
 * Training page create - popup event is use for {@link TrainingPageCreatePopup}
 *
 * @author boluclac
 * @version 0.0.0
 */
public interface TrainingPageCreateEvent extends Event {
    /**
     * <h2>Event cancel create new project</h2>
     * Cancel process create training project
     */
    void cancelProjectCreation();

    /**
     * <h2>Event create training project</h2>
     * Accept create new training project
     * @param projectName Project name
     * @param projectFolder Project folder
     */
    void createTrainingProject(String projectName, File projectFolder);
}
