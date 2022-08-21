package com.boluclac.facedetection.gui.facades.impl;

import com.boluclac.facedetection.gui.common.annotations.Facade;
import com.boluclac.facedetection.gui.common.constants.Constants;
import com.boluclac.facedetection.gui.exceptions.ValidationExceptions;
import com.boluclac.facedetection.gui.facades.TrainingFaceDetectionFacade;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.events.Characters;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;

/**
 * <h1>Facade Interface: Training facade detection</h1>
 * Logic processing, it is called from user interface (Frame or control)
 *
 * @author boluclac
 * @version 0.0.0
 */
@Facade
public class TrainingFaceDetectionFacadeImpl implements TrainingFaceDetectionFacade {
    /**
     * <h2>Create training face detection project</h2>
     *
     * @param projectName   Project name
     * @param projectFolder training project folder
     * @param projectFile   training file launcher project
     */
    @Override
    public void createTrainingProject(String projectName, File projectFolder, File projectFile) {
        try {
            if (projectFolder.isDirectory() && projectFile.isFile()) {
                DocumentBuilderFactory xmlFacttory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = xmlFacttory.newDocumentBuilder();
                Document document = builder.newDocument();
                document.setXmlVersion("1.0");
                Element rootEle = document.createElement(Constants.TRAINING_PJ_XML.ROOT);
                document.appendChild(rootEle);
                Element projectNameEle = document.createElement(Constants.TRAINING_PJ_XML.PROJECT_NAME);
                rootEle.appendChild(projectNameEle);
                projectNameEle.setTextContent(projectName);
                try (FileWriter writer = new FileWriter(projectFile)) {
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
                    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                    transformer.setOutputProperty(OutputKeys.ENCODING, StandardCharsets.UTF_8.name());

                    DOMSource domSource = new DOMSource(document);
                    StreamResult streamResult = new StreamResult(writer);
                    transformer.transform(domSource, streamResult);
                }
            }
        } catch (ParserConfigurationException | IOException | TransformerException exception) {
            throw new ValidationExceptions(exception);
        }
    }
}
