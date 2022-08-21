package com.boluclac.facedetection.gui.facades;

import java.io.File;

/**
 * <h1>Facade Interface: Training facade detection</h1>
 * Logic processing, it is called from user interface (Frame or control)
 *
 * @author boluclac
 * @version 0.0.0
 */
public interface TrainingFaceDetectionFacade {

    /**
     * <h2>Create training face detection project</h2>
     *
     * @param projectName   Project name
     * @param projectFolder training project folder
     * @param projectFile   training file launcher project
     */
    void createTrainingProject(String projectName, File projectFolder, File projectFile);
}
