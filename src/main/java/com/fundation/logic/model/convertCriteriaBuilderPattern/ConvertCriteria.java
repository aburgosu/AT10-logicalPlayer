/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.model.convertCriteriaBuilderPattern;

/**
 * Implements ConvertCriteria class which is used to set the convert criteria.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class ConvertCriteria {
    private final String sourcePath;
    private final String destinationPath;
    private final String newName;
    private final String metadataFormat;
    private final String newFormat;
    private final String convertType;
    private String audioCodec;
    private String audioBitrate;
    private String audioChannel;
    private String videoCodec;
    private String videoBitrate;
    private String fps;
    private boolean keyFrame;
    private String keyFrameEvery;
    private String keyFrameFormat;
    private boolean thumbnail;
    private String thumbnailAt;
    private String thumbnailFormat;
    private String colorFormat;
    private String dpi;

    public static class ConvertCriteriaBuilder {
        private final String sourcePath;
        private final String destinationPath;
        private final String newName;
        private final String metadataFormat;
        private final String newFormat;
        private final String convertType;
        private String audioCodec;
        private String audioBitrate;
        private String audioChannel;
        private String videoCodec;
        private String videoBitrate;
        private String fps;
        private boolean keyFrame;
        private String keyFrameEvery;
        private String keyFrameFormat;
        private boolean thumbnail;
        private String thumbnailAt;
        private String thumbnailFormat;
        private String colorFormat;
        private String dpi;

        /**
         * Allows to construct a ConvertCriteria instance with all minimum required fields.
         * @param sourcePath - File to be converted source path.
         * @param destinationPath - File to be converted destination path.
         * @param newName - Converted file desired new name.
         * @param metadataFormat - Desired metadata format.
         * @param newFormat - Desired format to convert the file.
         * @param convertType - Type of convert.
         */
        public ConvertCriteriaBuilder(String sourcePath, String destinationPath, String newName, String metadataFormat,
                                      String newFormat, String convertType) {
            this.sourcePath = sourcePath;
            this.destinationPath = destinationPath;
            this.newName = newName;
            this.metadataFormat = metadataFormat;
            this.newFormat = newFormat;
            this.convertType = convertType;
        }

        /**
         * Allows to set desired audio codec.
         * @param audioCodec - Desired audio codec.
         * @return ConvertCriteriaBuilder itself with corresponding set attribute.
         */
        public ConvertCriteriaBuilder setAudioCodec(String audioCodec) {
            this.audioCodec = audioCodec;
            return this;
        }

        /**
         * Allows to set desired audio bitrate.
         * @param audioBitrate - Desired audio bitrate.
         * @return ConvertCriteriaBuilder itself with corresponding set attribute.
         */
        public ConvertCriteriaBuilder setAudioBitrate(String audioBitrate) {
            this.audioBitrate = audioBitrate;
            return this;
        }

        /**
         * Allows to set desired audio channel.
         * @param audioChannel - Desired audio channel.
         * @return ConvertCriteriaBuilder itself with corresponding set attribute.
         */
        public ConvertCriteriaBuilder setAudioChannel(String audioChannel) {
            this.audioChannel = audioChannel;
            return this;
        }

        /**
         * Allows to set desired video codec.
         * @param videoCodec - Desired video codec.
         * @return ConvertCriteriaBuilder itself with corresponding set attribute.
         */
        public ConvertCriteriaBuilder setVideoCodec(String videoCodec) {
            this.videoCodec = videoCodec;
            return this;
        }

        /**
         * Allows to set desired video bitrate.
         * @param videoBitrate - Desired video bitrate.
         * @return ConvertCriteriaBuilder itself with corresponding set attribute.
         */
        public ConvertCriteriaBuilder setVideoBitrate(String videoBitrate) {
            this.videoBitrate = videoBitrate;
            return this;
        }

        /**
         * Allows to set desired frames per second.
         * @param fps - Desired frames per second.
         * @return ConvertCriteriaBuilder itself with corresponding set attribute.
         */
        public ConvertCriteriaBuilder setFps(String fps) {
            this.fps = fps;
            return this;
        }

        /**
         * Allows to set if key frame is requested.
         * @param keyFrame - Key frame requested?
         * @return ConvertCriteriaBuilder itself with corresponding set attribute.
         */
        public ConvertCriteriaBuilder setKeyframe(boolean keyFrame) {
            this.keyFrame = keyFrame;
            return this;
        }

        /**
         * Allows to set key frame frequency.
         * @param keyFrameEvery - Desired key frame frequency.
         * @return ConvertCriteriaBuilder itself with corresponding set attribute.
         */
        public ConvertCriteriaBuilder setKeyFrameEvery(String keyFrameEvery) {
            this.keyFrameEvery = keyFrameEvery;
            return this;
        }

        /**
         * Allows to set desired key frame format.
         * @param keyFrameFormat - Desired key frame format.
         * @return ConvertCriteriaBuilder itself with corresponding set attribute.
         */
        public ConvertCriteriaBuilder setKeyFrameFormat(String keyFrameFormat) {
            this.keyFrameFormat = keyFrameFormat;
            return this;
        }

        /**
         * Allows to set if thumbnail is requested.
         * @param thumbnail - Thumbnail requested?
         * @return ConvertCriteriaBuilder itself with corresponding set attribute.
         */
        public ConvertCriteriaBuilder setThumbnail(boolean thumbnail) {
            this.thumbnail = thumbnail;
            return this;
        }

        /**
         * Allows to set time of thumbnail.
         * @param thumbnailAt - Desired time of thumbnail.
         * @return ConvertCriteriaBuilder itself with corresponding set attribute.
         */
        public ConvertCriteriaBuilder setThumbnailAt(String thumbnailAt) {
            this.thumbnailAt = thumbnailAt;
            return this;
        }

        /**
         * Allows to set desired thumbnail format.
         * @param thumbnailFormat - Desired thumbnail format.
         * @return ConvertCriteriaBuilder itself with corresponding set attribute.
         */
        public ConvertCriteriaBuilder setThumbnailFormat(String thumbnailFormat) {
            this.thumbnailFormat = thumbnailFormat;
            return this;
        }

        /**
         * Allows to set desired color format.
         * @param colorFormat - Desired color format.
         * @return ConvertCriteriaBuilder itself with corresponding set attribute.
         */
        public ConvertCriteriaBuilder setColorFormat(String colorFormat) {
            this.colorFormat = colorFormat;
            return this;
        }

        /**
         * Allows to set desired dpi.
         * @param dpi - Desired dpi.
         * @return ConvertCriteriaBuilder itself with corresponding set attribute.
         */
        public ConvertCriteriaBuilder setDpi(String dpi) {
            this.dpi = dpi;
            return this;
        }

        /**
         * Builds an instance of convertCriteria according on minimum required attributes and optional attributes.
         * @return ConvertCriteria instance.
         */
        public ConvertCriteria build() {
            return new ConvertCriteria(this);
        }
    }

    /**
     * Constructs a ConvertCriteria instance according on parameters given to ConvertCriteriaBuilder.
     * @param builder - Builder in charge of build the ConvertCriteria build.
     */
    private ConvertCriteria(ConvertCriteriaBuilder builder) {
        this.sourcePath = builder.sourcePath;
        this.destinationPath = builder.destinationPath;
        this.newName = builder.newName;
        this.metadataFormat = builder.metadataFormat;
        this.newFormat = builder.newFormat;
        this.convertType = builder.convertType;
        this.audioCodec = builder.audioCodec;
        this.audioBitrate = builder.audioBitrate;
        this.audioChannel = builder.audioChannel;
        this.videoCodec = builder.videoCodec;
        this.videoBitrate = builder.videoBitrate;
        this.fps = builder.fps;
        this.keyFrame = builder.keyFrame;
        this.keyFrameEvery = builder.keyFrameEvery;
        this.keyFrameFormat = builder.keyFrameFormat;
        this.thumbnail = builder.thumbnail;
        this.thumbnailAt = builder.thumbnailAt;
        this.thumbnailFormat = builder.thumbnailFormat;
        this.colorFormat = builder.colorFormat;
        this.dpi = builder.dpi;
    }

    /**
     * Allows to get source path.
     * @return Source path.
     */
    public String getSourcePath() {
        return sourcePath;
    }

    /**
     * Allows to get destination path.
     * @return Destination path.
     */
    public String getDestinationPath() {
        return destinationPath;
    }

    /**
     * Allows to get new name.
     * @return New name.
     */
    public String getNewName() {
        return newName;
    }

    /**
     * Allows to get metadata format.
     * @return Metadata format.
     */
    public String getMetadataFormat() {
        return metadataFormat;
    }

    /**
     * Allows to get new format.
     * @return New format.
     */
    public String getNewFormat() {
        return newFormat;
    }

    /**
     * Allows to get convert type.
     * @return Convert type.
     */
    public String getConvertType() {
        return convertType;
    }

    /**
     * Allows to get audio codec.
     * @return Audio codec.
     */
    public String getAudioCodec() {
        return audioCodec;
    }

    /**
     * Allows to get audio bitrate.
     * @return Audio bitrate.
     */
    public String getAudioBitrate() {
        return audioBitrate;
    }

    /**
     * Allows audio channel.
     * @return Audio channel.
     */
    public String getAudioChannel() {
        return audioChannel;
    }

    /**
     * Allows to get video codec.
     * @return Video codec.
     */
    public String getVideoCodec() {
        return videoCodec;
    }

    /**
     * Allows to get video bitrate.
     * @return Video bitrate.
     */
    public String getVideoBitrate() {
        return videoBitrate;
    }

    /**
     * Allows to get frames per second.
     * @return Frames per second.
     */
    public String getFps() {
        return fps;
    }

    /**
     * Allows to get to know if key frame is requested.
     * @return Is key frame requested?
     */
    public boolean isKeyFrame() {
        return keyFrame;
    }

    /**
     * Allows to get key frame frequency.
     * @return Key frame frequency.
     */
    public String getKeyFrameEvery() {
        return keyFrameEvery;
    }

    /**
     * Allows to get key frame format.
     * @return Key frame format.
     */
    public String getKeyFrameFormat() {
        return keyFrameFormat;
    }

    /**
     * Allows to get to know if thumbnail is required.
     * @return Is thumbnail requested?
     */
    public boolean isThumbnail() {
        return thumbnail;
    }

    /**
     * Allows to get time of thumbnail.
     * @return Time of thumbnail.
     */
    public String getThumbnailAt() {
        return thumbnailAt;
    }

    /**
     * Allows to get thumbnail format.
     * @return Thumbnail format.
     */
    public String getThumbnailFormat() {
        return thumbnailFormat;
    }

    /**
     * Allows to get color format.
     * @return Color format.
     */
    public String getColorFormat() {
        return colorFormat;
    }

    /**
     * Allows to get dpi.
     * @return dpi.
     */
    public String getDpi() {
        return dpi;
    }
}
