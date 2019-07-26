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

import com.fundation.logic.model.convertCriteriaBuilderPattern.ConvertCriteria;
import com.fundation.logic.view.MainFrame;

/**
 * Implements the ConvertController class.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class ConvertController {
    private MainFrame searchFrame;
    private String sourcePath;
    private String destinationPath;
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
    private boolean keyframe;
    private String keyframeTime;
    private String keyframeFormat;
    private boolean thumbnail;
    private String thumbnailTime;
    private String thumbnailFormat;
    private String formatColor;
    private String dpi;
    /**
     * Initializes a Controller instance with a searchFrame and a searchCriteria
     */
    public ConvertController(MainFrame searchFrame) {
        this.searchFrame = searchFrame;
    }

    public void listenConvertButtons() {
        searchFrame.getSearchTabs().getSplitPanelConvert().getConverterTab().getConvertAudioPanel().getBtnConvertAudio()
            .addActionListener(e -> {
                ConvertCriteria criteria = setConvertCriteria("Audio");
            });
        searchFrame.getSearchTabs().getSplitPanelConvert().getConverterTab().getConvertVideoPanel().getBtnConvertVideo()
            .addActionListener(e -> {
            ConvertCriteria criteria = setConvertCriteria("Video");
            });
        searchFrame.getSearchTabs().getSplitPanelConvert().getConverterTab().getConvertPDFPanel().getBtnConvertAudio()
            .addActionListener(e -> {
                ConvertCriteria criteria = setConvertCriteria("PDF");
            });
    }

    /**
     * Creates an instance of ConvertCriteria class based on data retrieved from UI convert forms.
     * @return
     */
    public ConvertCriteria setConvertCriteria(String convertType) {
        getDataFromBasicPanel();
        this.convertType = convertType;
        switch (convertType) {
            case "Audio":
                return setConvertAudioCriteria();
            case "Video":
                return setConvertVideoCriteria();
            case "PDF":
                return setConvertPDFCriteria();
            default:
                return null;
        }
    }

    public ConvertCriteria setConvertAudioCriteria() {
        getDataFromConvertAudioPanel();
        ConvertCriteria convertAudioCriteria = new ConvertCriteria.ConvertCriteriaBuilder(sourcePath,
                destinationPath, newName, newFormat, convertType).setAudioCodec(audioCodec)
                .setAudioBitRate(audioBitRate).setAudioChannel(audioChannel).build();
        return convertAudioCriteria;
    }

    public ConvertCriteria setConvertVideoCriteria() {
        getDataFromConvertVideoPanel();
        ConvertCriteria convertVideoCriteria = new ConvertCriteria.ConvertCriteriaBuilder(sourcePath,
                destinationPath, newName, newFormat, convertType).setAudioCodec(audioCodec)
                .setAudioBitRate(audioBitRate).setAudioChannel(audioChannel).setVideoCodec(videoCodec)
                .setVideoBitRate(videoBitRate).setKeyframe(keyframe).setKeyframeTime(keyframeTime)
                .setKeyframeFormat(keyframeFormat).setFps(fps).setThumbnail(thumbnail)
                .setThumbnailTime(thumbnailTime).setThumbnailFormat(thumbnailFormat).build();
        return convertVideoCriteria;
    }

    public ConvertCriteria setConvertPDFCriteria() {
        getDataFromConvertPDFPanel();
        ConvertCriteria convertPDFCriteria = new ConvertCriteria.ConvertCriteriaBuilder(sourcePath,
                destinationPath, newName, newFormat, convertType).setFormatColor(formatColor).setDpi(dpi).build();
        return convertPDFCriteria;
    }

    public void getDataFromBasicPanel() {
        sourcePath = searchFrame.getSearchTabs().getSplitPanelConvert().getBasicConvert()
                .getTextFieldSourcePath().getText();
        destinationPath = searchFrame.getSearchTabs().getSplitPanelConvert().getBasicConvert()
                .getTextFieldDestinationPath().getText();
        newName = searchFrame.getSearchTabs().getSplitPanelConvert().getBasicConvert().getTextFieldNewName()
                .getText();
        metadata = searchFrame.getSearchTabs().getSplitPanelConvert().getBasicConvert()
                .getComboBoxMetadataFormat().getSelectedItem().toString();
        if(metadata == "None") {
            metadata = null;
        }
    }

    public void getDataFromConvertAudioPanel() {
        newFormat = searchFrame.getSearchTabs().getSplitPanelConvert().getConverterTab().getConvertAudioPanel()
                .getComboBoxNewFormat().getSelectedItem().toString();
        audioCodec = searchFrame.getSearchTabs().getSplitPanelConvert().getConverterTab().getConvertAudioPanel()
                .getComboBoxCodec().getSelectedItem().toString();
        if(audioCodec == "Default") {
            audioCodec = null;
        }
        audioBitRate = searchFrame.getSearchTabs().getSplitPanelConvert().getConverterTab()
                .getConvertAudioPanel().getComboBoxBit().getSelectedItem().toString();
        if(audioBitRate == "Default") {
            audioBitRate = null;
        }
        audioChannel = searchFrame.getSearchTabs().getSplitPanelConvert().getConverterTab()
                .getConvertAudioPanel().getComboBoxChannel().getSelectedItem().toString();
        if(audioChannel == "Default") {
            audioChannel = null;
        }
    }

    public void getDataFromConvertVideoPanel() {
        newFormat = searchFrame.getSearchTabs().getSplitPanelConvert().getConverterTab().getConvertVideoPanel()
                .getComboBoxNewFormat().getSelectedItem().toString();
        audioCodec = searchFrame.getSearchTabs().getSplitPanelConvert().getConverterTab().getConvertVideoPanel()
                .getComboBoxAudioCodec().getSelectedItem().toString();
        if(audioCodec == "Default") {
            audioCodec = null;
        }
        audioBitRate = searchFrame.getSearchTabs().getSplitPanelConvert().getConverterTab()
                .getConvertVideoPanel().getComboBoxAudioBit().getSelectedItem().toString();
        if(audioBitRate == "Default") {
            audioBitRate = null;
        }
        audioChannel = searchFrame.getSearchTabs().getSplitPanelConvert().getConverterTab()
                .getConvertVideoPanel().getComboBoxAudioChannel().getSelectedItem().toString();
        if(audioChannel == "Default") {
            audioChannel = null;
        }
        videoCodec = searchFrame.getSearchTabs().getSplitPanelConvert().getConverterTab()
                .getConvertVideoPanel().getComboBoxVideoCodec().getSelectedItem().toString();
        if(videoCodec == "Default") {
            videoCodec = null;
        }
        videoBitRate = searchFrame.getSearchTabs().getSplitPanelConvert().getConverterTab()
                .getConvertVideoPanel().getComboBoxVideoBit().getSelectedItem().toString();
        if(videoBitRate == "Default") {
            videoBitRate = null;
        }
        fps = searchFrame.getSearchTabs().getSplitPanelConvert().getConverterTab()
                .getConvertVideoPanel().getComboBoxVideoRate().getSelectedItem().toString();
        if(fps == "Default") {
            fps = null;
        }
        keyframe = searchFrame.getSearchTabs().getSplitPanelConvert().getConverterTab()
                .getConvertVideoPanel().getCheckBoxKeyFrame().isSelected();
        if(keyframe == true) {
            keyframeTime = searchFrame.getSearchTabs().getSplitPanelConvert().getConverterTab()
                    .getConvertVideoPanel().getMinuteSpinnerKeyFrame().getValue().toString();
            keyframeFormat = searchFrame.getSearchTabs().getSplitPanelConvert().getConverterTab()
                    .getConvertVideoPanel().getComboBoxKeyFrameFormat().getValue().toString();
            if(keyframeFormat == "Default") {
                keyframeFormat = null;
            }
        }
        thumbnail = searchFrame.getSearchTabs().getSplitPanelConvert().getConverterTab()
                .getConvertVideoPanel().getCheckBoxThumbnail().isSelected();
        if(thumbnail == true) {
            thumbnailTime = searchFrame.getSearchTabs().getSplitPanelConvert().getConverterTab()
                    .getConvertVideoPanel().getMinuteSpinnerThumbnail().getValue().toString();
            thumbnailFormat = searchFrame.getSearchTabs().getSplitPanelConvert().getConverterTab()
                    .getConvertVideoPanel().getComboBoxThumbnailFormat().getValue().toString();
            if(thumbnailFormat == "Default") {
                thumbnailFormat = null;
            }
        }
    }

    public void getDataFromConvertPDFPanel() {
        newFormat = searchFrame.getSearchTabs().getSplitPanelConvert().getConverterTab()
                .getConvertPDFPanel().getComboBoxNewFormat().getSelectedItem().toString();
        formatColor = searchFrame.getSearchTabs().getSplitPanelConvert().getConverterTab()
                .getConvertPDFPanel().getComboBoxColorFormat().getSelectedItem().toString();
        dpi = searchFrame.getSearchTabs().getSplitPanelConvert().getConverterTab()
                .getConvertPDFPanel().getComboBoxDpi().getSelectedItem().toString();
    }
}
