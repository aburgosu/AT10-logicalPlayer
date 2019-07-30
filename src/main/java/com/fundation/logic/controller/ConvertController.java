/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.controller;

import com.fundation.logic.common.FileInfo;
import com.fundation.logic.model.ServiceConnection;
import com.fundation.logic.model.convertCriteriaBuilderPattern.ConvertCriteria;
import com.fundation.logic.view.MainFrame;

import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Implements the ConvertController class.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class ConvertController {
    private MainFrame mainFrame;
    private String sourcePath;
    private String destPath;
    private String newName;
    private String newFormat;
    private String convertType;
    private String metadata;
    private String audioCodec;
    private String audioBitRate;
    private String audioChannel;
    private String videoCodec;
    private String videoBitRate;
    private String fps;
    private String keyframe;
    private String keyframeTime;
    private String keyframeFormat;
    private String thumbnail;
    private String thumbnailTime;
    private String thumbnailFormat;
    private String formatColor;
    private String dpi;
    private ServiceConnection serviceConnection;

    /**
     * Initializes a SearchController instance with a mainFrame and a searchCriteria
     */
    public ConvertController(MainFrame searchFrame) {
        this.mainFrame = searchFrame;
        this.serviceConnection = new ServiceConnection("http://127.0.0.1/convert");
        listenConvertButtons();
        listenConvertItem();
    }

    /**
     * Convert button listener for every convert panel.
     */
    public void listenConvertButtons() {
        mainFrame.getMainTabs().getSplitPanelConvert().getConverterTab().getConvertAudioPanel().getBtnConvertAudio()
                .addActionListener(e -> {
                    convert("audio");
                });
        mainFrame.getMainTabs().getSplitPanelConvert().getConverterTab().getConvertVideoPanel().getBtnConvertVideo()
                .addActionListener(e -> {
                    convert("video");
                });
        mainFrame.getMainTabs().getSplitPanelConvert().getConverterTab().getConvertPDFPanel().getBtnConvertAudio()
                .addActionListener(e -> {
                    convert("pdfToImage");
                });
        resetCriteria();
    }

    public void convert(String convertType) {
        ConvertCriteria criteria = setConvertCriteria(convertType);
        try {
            JOptionPane.showMessageDialog(mainFrame, "Conversion in proccess...\nplease wait confirmation message");
            serviceConnection.convert(criteria);
            while (true) {
                if (serviceConnection.getStatus() == ServiceConnection.SUCCESS) {
                    JOptionPane.showMessageDialog(mainFrame, "Conversion successful");
                    break;
                }
                if (serviceConnection.getStatus() == ServiceConnection.ERROR) {
                    JOptionPane.showMessageDialog(mainFrame, "Error in conversion, please contact support");
                    break;
                }
                Thread.sleep(5000);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Creates an instance of ConvertCriteria class based on data retrieved from UI convert forms.
     * @return convertCriteria object based on data retrieved from UI convert forms.
     */
    public ConvertCriteria setConvertCriteria(String convertType) {
        getDataFromBasicPanel();
        this.convertType = convertType;
        switch (convertType) {
            case "audio":
                return setConvertAudioCriteria();
            case "video":
                return setConvertVideoCriteria();
            case "pdfToImage":
                return setConvertPDFCriteria();
            default:
                return null;
        }
    }

    /**
     * Allows to get a ConvertCriteria object created based on retrieved data from convert audio panel.
     * @return convertCriteria created based on retrieved data from convert audio panel.
     */
    public ConvertCriteria setConvertAudioCriteria() {
        getDataFromConvertAudioPanel();
        ConvertCriteria convertAudioCriteria = new ConvertCriteria.ConvertCriteriaBuilder(sourcePath,
                destPath, newName, newFormat, convertType).setMetadata(metadata).setAudioCodec(audioCodec)
                .setAudioBitRate(audioBitRate).setAudioChannel(audioChannel).build();
        return convertAudioCriteria;
    }

    /**
     * Allows to get a ConvertCriteria object created based on retrieved data from convert video panel.
     * @return convertCriteria created based on retrieved data from convert video panel.
     */
    public ConvertCriteria setConvertVideoCriteria() {
        getDataFromConvertVideoPanel();
        ConvertCriteria convertVideoCriteria = new ConvertCriteria.ConvertCriteriaBuilder(sourcePath,
                destPath, newName, newFormat, convertType).setMetadata(metadata).setAudioCodec(audioCodec)
                .setAudioBitRate(audioBitRate).setAudioChannel(audioChannel).setVideoCodec(videoCodec)
                .setVideoBitRate(videoBitRate).setKeyframe(keyframe).setKeyframeTime(keyframeTime)
                .setKeyframeFormat(keyframeFormat).setFps(fps).setThumbnail(thumbnail)
                .setThumbnailTime(thumbnailTime).setThumbnailFormat(thumbnailFormat).build();
        return convertVideoCriteria;
    }

    /**
     * Allows to get a ConvertCriteria object created based on retrieved data from convert PDF panel.
     * @return convertCriteria created based on retrieved data from convert PDF panel.
     */
    public ConvertCriteria setConvertPDFCriteria() {
        getDataFromConvertPDFPanel();
        ConvertCriteria convertPDFCriteria = new ConvertCriteria.ConvertCriteriaBuilder(sourcePath,
                destPath, newName, newFormat, convertType).setMetadata(metadata).setFormatColor(formatColor)
                .setDpi(dpi).setThumbnail(thumbnail).setThumbnailFormat(thumbnailFormat).build();
        return convertPDFCriteria;
    }

    /**
     * Allows to get data from basic convert panel.
     */
    public void getDataFromBasicPanel() {
        sourcePath = mainFrame.getMainTabs().getSplitPanelConvert().getBasicConvert()
                .getTextFieldSourcePath().getText();
        destPath = mainFrame.getMainTabs().getSplitPanelConvert().getBasicConvert()
                .getTextFieldDestinationPath().getText() + "\\";
        newName = mainFrame.getMainTabs().getSplitPanelConvert().getBasicConvert().getTextFieldNewName()
                .getText();
        metadata = mainFrame.getMainTabs().getSplitPanelConvert().getBasicConvert()
                .getComboBoxMetadataFormat().getSelectedItem().toString();
        if (metadata == "None") {
            metadata = null;
        }
    }

    /**
     * Allows to get data from convert audio panel.
     */
    public void getDataFromConvertAudioPanel() {
        newFormat = mainFrame.getMainTabs().getSplitPanelConvert().getConverterTab().getConvertAudioPanel()
                .getComboBoxNewFormat().getSelectedItem().toString();
        audioCodec = mainFrame.getMainTabs().getSplitPanelConvert().getConverterTab().getConvertAudioPanel()
                .getComboBoxCodec().getSelectedItem().toString();
        if (audioCodec == "Default") {
            audioCodec = null;
        }
        audioBitRate = mainFrame.getMainTabs().getSplitPanelConvert().getConverterTab()
                .getConvertAudioPanel().getComboBoxBit().getSelectedItem().toString();
        if (audioBitRate == "Default") {
            audioBitRate = null;
        }
        audioChannel = mainFrame.getMainTabs().getSplitPanelConvert().getConverterTab()
                .getConvertAudioPanel().getComboBoxChannel().getSelectedItem().toString();
        if (audioChannel == "Default") {
            audioChannel = null;
        }
    }

    /**
     * Allows to get data from convert video panel.
     */
    public void getDataFromConvertVideoPanel() {
        newFormat = mainFrame.getMainTabs().getSplitPanelConvert().getConverterTab().getConvertVideoPanel()
                .getComboBoxNewFormat().getSelectedItem().toString();
        audioCodec = mainFrame.getMainTabs().getSplitPanelConvert().getConverterTab().getConvertVideoPanel()
                .getComboBoxAudioCodec().getSelectedItem().toString();
        if (audioCodec == "Default") {
            audioCodec = null;
        }
        audioBitRate = mainFrame.getMainTabs().getSplitPanelConvert().getConverterTab()
                .getConvertVideoPanel().getComboBoxAudioBit().getSelectedItem().toString();
        if (audioBitRate == "Default") {
            audioBitRate = null;
        }
        audioChannel = mainFrame.getMainTabs().getSplitPanelConvert().getConverterTab()
                .getConvertVideoPanel().getComboBoxAudioChannel().getSelectedItem().toString();
        if (audioChannel == "Default") {
            audioChannel = null;
        }
        videoCodec = mainFrame.getMainTabs().getSplitPanelConvert().getConverterTab()
                .getConvertVideoPanel().getComboBoxVideoCodec().getSelectedItem().toString();
        if (videoCodec == "Default") {
            videoCodec = null;
        }
        videoBitRate = mainFrame.getMainTabs().getSplitPanelConvert().getConverterTab()
                .getConvertVideoPanel().getComboBoxVideoBit().getSelectedItem().toString();
        if (videoBitRate == "Default") {
            videoBitRate = null;
        }
        fps = mainFrame.getMainTabs().getSplitPanelConvert().getConverterTab()
                .getConvertVideoPanel().getComboBoxVideoRate().getSelectedItem().toString();
        if (fps == "Default") {
            fps = null;
        }
        boolean keyframeAux = mainFrame.getMainTabs().getSplitPanelConvert().getConverterTab()
                .getConvertVideoPanel().getCheckBoxKeyFrame().isSelected();
        if (keyframeAux == true) {
            keyframe = "true";
            keyframeTime = mainFrame.getMainTabs().getSplitPanelConvert().getConverterTab()
                    .getConvertVideoPanel().getMinuteSpinnerKeyFrame().getValue().toString();
            keyframeTime = keyframeTime.substring(17, 19);
            keyframeFormat = mainFrame.getMainTabs().getSplitPanelConvert().getConverterTab()
                    .getConvertVideoPanel().getComboBoxKeyFrameFormat().getSelectedItem().toString();
            if (keyframeFormat == "Default") {
                keyframeFormat = null;
            }
        } else {
            keyframe = "false";
        }
        boolean thumbnailAux = mainFrame.getMainTabs().getSplitPanelConvert().getConverterTab()
                .getConvertVideoPanel().getCheckBoxThumbnail().isSelected();
        if (thumbnailAux == true) {
            thumbnail = "true";
            thumbnailTime = mainFrame.getMainTabs().getSplitPanelConvert().getConverterTab()
                    .getConvertVideoPanel().getMinuteSpinnerThumbnail().getValue().toString();
            thumbnailTime = thumbnailTime.substring(17, 19);
            thumbnailFormat = mainFrame.getMainTabs().getSplitPanelConvert().getConverterTab()
                    .getConvertVideoPanel().getComboBoxThumbnailFormat().getSelectedItem().toString();
            if (thumbnailFormat == "Default") {
                thumbnailFormat = null;
            }
        } else {
            thumbnail = "false";
        }
    }

    /**
     * Allows to get data from convert PDF panel.
     */
    public void getDataFromConvertPDFPanel() {
        newFormat = mainFrame.getMainTabs().getSplitPanelConvert().getConverterTab()
                .getConvertPDFPanel().getComboBoxNewFormat().getSelectedItem().toString();
        formatColor = mainFrame.getMainTabs().getSplitPanelConvert().getConverterTab()
                .getConvertPDFPanel().getComboBoxColorFormat().getSelectedItem().toString();
        dpi = mainFrame.getMainTabs().getSplitPanelConvert().getConverterTab()
                .getConvertPDFPanel().getComboBoxDpi().getSelectedItem().toString();
        boolean thumbnailAux = mainFrame.getMainTabs().getSplitPanelConvert().getConverterTab()
                .getConvertPDFPanel().getCheckBoxThumbnail().isSelected();
        if (thumbnailAux == true) {
            thumbnail = "true";
            thumbnailFormat = mainFrame.getMainTabs().getSplitPanelConvert().getConverterTab()
                    .getConvertPDFPanel().getComboBoxThumbnailFormat().getSelectedItem().toString();
        } else {
            thumbnail = "false";
        }
    }

    /**
     * Resets all criteria attributes to null.
     */
    public void resetCriteria() {
        sourcePath = null;
        destPath = null;
        newName = null;
        newFormat = null;
        convertType = null;
        metadata = null;
        audioCodec = null;
        audioBitRate = null;
        audioChannel = null;
        videoCodec = null;
        videoBitRate = null;
        fps = null;
        keyframe = null;
        keyframeTime = null;
        keyframeFormat = null;
        thumbnail = null;
        thumbnailTime = null;
        thumbnailFormat = null;
        formatColor = null;
        dpi = null;
    }

    /**
     * Listen to convert option on table result popupmenu.
     */
    public void listenConvertItem() {
        try {
            String path = mainFrame.getTableResult().getMenu().getFilePath();
            mainFrame.getTableResult().getMenu().getConvertItem().addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent event) {
                    if (event.getButton() == MouseEvent.BUTTON1) {
                        if (FileInfo.isAudio(path)) {
                            mainFrame.getMainTabs().getSplitPanelConvert().getBasicConvert().getTextFieldSourcePath()
                                    .setText(path);
                            mainFrame.getMainTabs().setSelectedIndex(2);
                            mainFrame.getMainTabs().getSplitPanelConvert().getConverterTab().setSelectedIndex(0);
                            mainFrame.repaint();
                        }
                        if (FileInfo.isVideo(path)) {
                            mainFrame.getMainTabs().getSplitPanelConvert().getBasicConvert().getTextFieldSourcePath()
                                    .setText(path);
                            mainFrame.getMainTabs().setSelectedIndex(2);
                            mainFrame.getMainTabs().getSplitPanelConvert().getConverterTab().setSelectedIndex(1);
                            mainFrame.repaint();
                        }
                    }
                }
            });
        } catch (Exception exception) {
            exception.getMessage();
        }
    }
}
