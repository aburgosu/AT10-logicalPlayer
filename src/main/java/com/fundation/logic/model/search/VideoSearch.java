/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.model.search;

import com.fundation.logic.common.FileInfo;
import com.fundation.logic.common.MetadataVideoExtractor;
import com.fundation.logic.model.CustomFile;
import com.fundation.logic.model.searchCriteria.Video;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Implements new Video search class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class VideoSearch implements ISearch {
    static private Video videoCriteria;

    /**
     * Initializes a search instance which requires a criteria as parameter.
     */
    public VideoSearch(Video videoCriteria) {
        this.videoCriteria = videoCriteria;
    }

    /**
     * Main search method.
     *
     * @return List of found items if criteria's path is not null.
     */
    public List search() {
        if (videoCriteria.getPath() == null) {
            return null;
        }
        return searchInPath(videoCriteria.getPath());
    }

    /**
     * @param path
     * @return Complete list of found items according on criteria's path.
     */
    public List searchInPath(String path) {
        List<CustomFile> videoSearchResult = new ArrayList<CustomFile>();
        File file = new File(path);
        String criteriaFileName = videoCriteria.getFileName();
        String criteriaExtension = videoCriteria.getExtension();
        String criteriVideoCodec = videoCriteria.getVideoCodec();
        String criteriAudioVideoCodec = videoCriteria.getAudioCodec();
        String criteriaFrameRate = videoCriteria.getFrameRate();
        String criteriaHeight = videoCriteria.getHeight();
        String criteriaLLDuration = videoCriteria.getDurationfrom();
        String criteriaLUDuration = videoCriteria.getDurationTo();
        String criteriaMimeType = "video";
        Float initDuration = convertDurationToDecimal(criteriaLLDuration);
        Float endDuration = convertDurationToDecimal(criteriaLUDuration);
        File[] allSubFiles = file.listFiles();
        for (File fileExtractor : allSubFiles) {
            try {
                if (fileExtractor.isDirectory()) {
                    videoSearchResult.addAll(searchInPath(fileExtractor.getAbsolutePath()));
                } else {
                    String fileName = FileInfo.getFileDenomination(fileExtractor, "name");
                    String fileExtension = FileInfo.getFileDenomination(fileExtractor, "extension");
                    String frameRate = "All";
                    String exiftool = "thirdParty/exiftool.exe "; //Tool used for extract metadata
                    String owner = FileInfo.getFileOwner(fileExtractor, "user");
                    String filePath = exiftool + "\"" + fileExtractor + "\"";
                    MetadataVideoExtractor metadataVideoExtractor = new MetadataVideoExtractor();
                    metadataVideoExtractor.run(filePath);
                    if (criteriaFrameRate != "All") {
                        frameRate = MetadataVideoExtractor.getSearchFrameRate();
                    }
                    String fileVideoCodec = "All";
                    if (criteriVideoCodec != "All") {
                        fileVideoCodec = MetadataVideoExtractor.getSearchVideoCodec();
                    }
                    String videoAudioCodec = "All";
                    if (criteriAudioVideoCodec != "All") {
                        videoAudioCodec = MetadataVideoExtractor.getSearchAudioCodec();
                    }
                    String fileHeight = "All";
                    if (criteriaHeight != "All") {
                        fileHeight = MetadataVideoExtractor.getSearchHeight();
                    }
                    if (initDuration == 12.0 && endDuration == 12.0){
                        initDuration = Float.MIN_VALUE;
                        endDuration = Float.MAX_VALUE;
                    }
                    Float duration = MetadataVideoExtractor.getSearchDuration();
                    Date creationDate = FileInfo.getFileDate(fileExtractor, "creation");
                    Date accessDate = FileInfo.getFileDate(fileExtractor, "access");
                    Date modificationDate = FileInfo.getFileDate(fileExtractor, "modification");
                    Float fileSize = FileInfo.getFileSize(fileExtractor);
                    String mimeType = MetadataVideoExtractor.getSearchMimeType();
                    if (evaluateString(frameRate, criteriaFrameRate)
                            && evaluateString(fileName, criteriaFileName)
                            && evaluateString(fileExtension, criteriaExtension)
                            && evaluateString(fileVideoCodec, criteriVideoCodec)
                            && evaluateString(videoAudioCodec, criteriAudioVideoCodec)
                            && evaluateString(fileHeight, criteriaHeight)
                            && evaluateDuration(duration, initDuration, endDuration)
                            && evaluateString(mimeType,criteriaMimeType)) {
                        List<String> metadata = MetadataVideoExtractor.getSearchListMetadata();
                        CustomFile matchingFile = new CustomFile(fileExtractor.getAbsolutePath(), fileName,
                                fileExtension, false, false, fileSize, creationDate,
                                accessDate, modificationDate, owner, mimeType, metadata);
                        videoSearchResult.add(matchingFile);
                    }
                }
            } catch (Exception excp) {
                excp.getMessage();
            }
        }
        return videoSearchResult;
    }

    /**
     * Evaluates specific string field according on criteria.
     *
     * @return Answer after evaluation.
     */
    private boolean evaluateString(String fileExtractorCriteria, String criteria) {
        if (criteria == null || fileExtractorCriteria.equalsIgnoreCase(criteria)) {
            return true;
        }
        return false;
    }

    public Float convertDurationToDecimal(String duration){
        Float hourToSeconds = new Float(3600);
        Float minuteToSeconds = new Float(60);
        Float hour = Float.parseFloat(duration.substring(0, 2)) * hourToSeconds;
        Float minutes = Float.parseFloat(duration.substring(3, 5)) * minuteToSeconds;
        Float seconds = Float.parseFloat(duration.substring(6, 8));
        Float initDuration = (hour + minutes + seconds) / 3600;
        return initDuration;
    }

    /**
     * Evaluates if the file size is between set limits.
     *
     * @return Answer after evaluation.
     */
    private boolean evaluateDuration(Float metadataDuration, Float lowerLimit, Float upperLimit) {
        if (lowerLimit == null && upperLimit == null) {
            return true;
        }
        if (lowerLimit != null && upperLimit == null) {
            return metadataDuration >= lowerLimit;
        }
        if (lowerLimit == null && upperLimit != null) {
            return metadataDuration <= upperLimit;
        }
        return (metadataDuration >= lowerLimit && metadataDuration <= upperLimit);
    }
}
