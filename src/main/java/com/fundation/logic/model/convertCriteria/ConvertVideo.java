/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.model.convertCriteria;

/**
 * Implements ConvertPdf class which is used to set pdf convert criteria.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class ConvertVideo extends ConvertMultimedia {
    private String videoCodec;
    private String videoBitrate;
    private String fps;
    private boolean keyFrame;
    private String keyFrameEvery;
    private String keyFrameFormat;
    private boolean thumbnail;
    private String thumbnailAt;
    private String thumbnailFormat;

    /**
     * Allows to get desired video codec.
     * @return Desired video codec.
     */
    public String getVideoCodec() {
        return videoCodec;
    }

    /**
     * Allows to set desired video codec.
     * @param videoCodec - Desired video codec.
     */
    public void setVideoCodec(String videoCodec) {
        this.videoCodec = videoCodec;
    }

    /**
     * Allows to get desired video bitrate.
     * @return Desired video bitrate.
     */
    public String getVideoBitrate() {
        return videoBitrate;
    }

    /**
     * Allows to set desired video bitrate.
     * @param videoBitrate - Desired video bitrate.
     */
    public void setVideoBitrate(String videoBitrate) {
        this.videoBitrate = videoBitrate;
    }

    /**
     * Allows to get desired frames per second.
     * @return Desired frames per second.
     */
    public String getFps() {
        return fps;
    }

    /**
     * Allows to set desired frames per second.
     * @param fps - Desired frames per second.
     */
    public void setFps(String fps) {
        this.fps = fps;
    }

    /**
     * Allows to get to know if keyframe is required.
     * @return
     */
    public boolean requiredKeyFrame() {
        return keyFrame;
    }

    /**
     * Allows to set if is required keyframe.
     * @param keyFrame - Is keyframe required?
     */
    public void setKeyFrame(boolean keyFrame) {
        this.keyFrame = keyFrame;
    }

    /**
     * Allows to get desired keyframe frequency.
     * @return Desired keyframe frequency.
     */
    public String getKeyFrameEvery() {
        return keyFrameEvery;
    }

    /**
     * Allows to set keyframe frequency.
     * @param keyFrameEvery - Desired keyframe frequency.
     */
    public void setKeyFrameEvery(String keyFrameEvery) {
        this.keyFrameEvery = keyFrameEvery;
    }

    /**
     * Allows to get desired keyframe format.
     * @return Desired keyframe format.
     */
    public String getKeyFrameFormat() {
        return keyFrameFormat;
    }

    /**
     * Allows to set desired keyframe format.
     * @param keyFrameFormat - Desired keyframe format.
     */
    public void setKeyFrameFormat(String keyFrameFormat) {
        this.keyFrameFormat = keyFrameFormat;
    }

    /**
     * Allows to get to know if thumbnail is required.
     * @return
     */
    public boolean requiredThumbnail() {
        return thumbnail;
    }

    /**
     * Allows to set if thumbnail is required.
     * @param thumbnail - Is thumbnail required?
     */
    public void setThumbnail(boolean thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     * Allows to get thumbnail at desired time.
     * @return Desired time.
     */
    public String getThumbnailAt() {
        return thumbnailAt;
    }

    /**
     * Allows to set thumbnail time.
     * @param thumbnailAt - Time of desired thumbnail.
     */
    public void setThumbnailAt(String thumbnailAt) {
        this.thumbnailAt = thumbnailAt;
    }

    /**
     * Allows to get desired thumbnail format.
     * @return Desired thumbnail format.
     */
    public String getThumbnailFormat() {
        return thumbnailFormat;
    }

    /**
     * Allows to set thumbnail format.
     * @param thumbnailFormat - Desired thumbnail format.
     */
    public void setThumbnailFormat(String thumbnailFormat) {
        this.thumbnailFormat = thumbnailFormat;
    }
}
