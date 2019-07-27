/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.model;

import com.fundation.logic.common.FileInfo;
import com.fundation.logic.common.MetadataAudioExtractor;
import com.fundation.logic.model.criteria.Audio;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Implements new Audio search class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class AudioSearch implements ISearch {
    static private Audio audioCriteria;

    /**
     * Initializes a search instance which requires a criteria as parameter.
     */
    public AudioSearch(Audio audioCriteria) {
        this.audioCriteria = audioCriteria;
    }

    /**
     * Main search method.
     *
     * @return List of found items if criteria's path is not null.
     */
    public List search() {
        if (audioCriteria.getPath() == null) {
            return null;
        }
        return searchInPath(audioCriteria.getPath());
    }

    /**
     * @param path
     * @return Complete list of found items according on criteria's path.
     */
    public List searchInPath(String path) {
        List<CustomizedFile> searchResult = new ArrayList<>();
        File file = new File(path);
        String criteriaFileName = audioCriteria.getFileName();
        String criteriaExtension = audioCriteria.getExtension();
        String criteriAudioCodec = audioCriteria.getAudioCodec();
        String criteriaLLDuration = audioCriteria.getDurationfrom();
        String criteriaLUDuration = audioCriteria.getDurationTo();
        String criteriaChannel = audioCriteria.getChannel();
        String criteriaSampleRate = audioCriteria.getSampleRate();
        File[] allSubFiles = file.listFiles();
        Float initDuration = convertDurationToDecimal(criteriaLLDuration);
        Float endDuration = convertDurationToDecimal(criteriaLUDuration);
        for (File fileExtractor : allSubFiles) {
            try {
                if (fileExtractor.isDirectory()) {
                    searchResult.addAll(searchInPath(fileExtractor.getAbsolutePath()));
                } else {
                    String fileName = FileInfo.getFileDenomination(fileExtractor, "name");
                    String fileExtension = FileInfo.getFileDenomination(fileExtractor, "extension");
                    String owner = FileInfo.getFileOwner(fileExtractor, "user");
                    String exiftool = "thirdParty/exiftool.exe "; //Tool used for extract metadata
                    String filePath = exiftool + "\"" + fileExtractor + "\"";
                    MetadataAudioExtractor metadataAudioExtractor = new MetadataAudioExtractor();
                    metadataAudioExtractor.run(filePath);
                    String channel = "All";
                    if (criteriaChannel != "All") {
                        channel = MetadataAudioExtractor.getAudioChannel();
                    }
                    String audioCodec = "All";
                    if (criteriAudioCodec != "All") {
                        audioCodec = MetadataAudioExtractor.searchAudioCodec();
                    }
                    String sampleRate = "All";
                    if (criteriaSampleRate != "All") {
                        sampleRate = MetadataAudioExtractor.getSearchSampleRate();
                    }
                    if (initDuration == 12.0 && endDuration == 12.0) {
                        initDuration = new Float(0.0);
                        endDuration = new Float(12.9);
                    }
                    Float duration = MetadataAudioExtractor.getSearchDuration();
                    Date creationDate = FileInfo.getFileDate(fileExtractor, "creation");
                    Date accessDate = FileInfo.getFileDate(fileExtractor, "access");
                    Date modificationDate = FileInfo.getFileDate(fileExtractor, "modification");
                    Float fileSize = FileInfo.getFileSize(fileExtractor);
                    if (evaluateString(fileName, criteriaFileName)
                            && evaluateString(fileExtension, criteriaExtension)
                            && evaluateString(channel, criteriaChannel)
                            && evaluateString(audioCodec, criteriAudioCodec)
                            && evaluateString(sampleRate, criteriaSampleRate)
                            && evaluateDuration(duration, initDuration, endDuration)) {
                        List<String> metadata = MetadataAudioExtractor.getSearchListMetadata();
                        CustomizedFile matchingFile = new CustomizedFile(fileExtractor.getAbsolutePath(), fileName,
                                fileExtension, false, false,
                                fileSize, creationDate, accessDate,
                                modificationDate, owner, "audio", metadata);
                        searchResult.add(matchingFile);
                    }
                }
            } catch (Exception e) {
            }
        }
        return searchResult;
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

    /**
     * Convert specific duration to decimal.
     *
     * @return decimal duration.
     */
    public Float convertDurationToDecimal(String duration) {
        Float hourToSeconds = new Float(3600);
        Float minuteToSeconds = new Float(60);
        Float hour = Float.parseFloat(duration.substring(0, 2)) * hourToSeconds;
        Float minutes = Float.parseFloat(duration.substring(3, 5)) * minuteToSeconds;
        Float seconds = Float.parseFloat(duration.substring(6, 8));
        Float initDuration = (hour + minutes + seconds) / 3600;
        return initDuration;
    }

    /**
     * Evaluates if the duration size is between set limits.
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
