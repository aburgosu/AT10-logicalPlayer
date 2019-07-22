/**
 * Copyright (c) 2019 Jalasoft.
 * <p>
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.model;

import com.fundation.logic.common.FileInfo;
import com.fundation.logic.common.MetadataAudioExtractor;
import com.fundation.logic.common.MetadataCommonExtractor;
import com.fundation.logic.common.MetadataImageExtractor;
import com.fundation.logic.model.criteria.Audio;

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
        String criteriaDuration = Integer.toString(audioCriteria.getDuration());
        String criteriaChannel = Integer.toString(audioCriteria.getChannel());
        String criteriaMimeType = "audio";
        String criteriaSampleRate = Integer.toString(audioCriteria.getSampleRate());
        File[] allSubFiles = file.listFiles();
        for (File fileExtractor : allSubFiles) {
            try {
                if (fileExtractor.isDirectory()) {
                    searchResult.addAll(searchInPath(fileExtractor.getAbsolutePath()));
                } else {
                    String fileName = FileInfo.getFileDenomination(fileExtractor, "name");
                    String fileExtension = FileInfo.getFileDenomination(fileExtractor, "extension");
                    MetadataImageExtractor metadataImageExtractor = new MetadataImageExtractor();
                    String exiftool = "thirdParty/exiftool.exe "; //Tool used for extract metadata
                    String pathd = exiftool + "\"" + fileExtractor + "\"";
                    MetadataAudioExtractor metadataAudioExtractor = new MetadataAudioExtractor();
                    metadataAudioExtractor.run(pathd);
                    metadataImageExtractor.run(pathd);
                    String channel = "All";
                    if (criteriaChannel != "All") {
                        channel = MetadataAudioExtractor.getAudioChannel();
                    }
                    String audioCodec = "All";
                    if (criteriAudioCodec != "All") {
                        audioCodec = MetadataAudioExtractor.searchAudioCodec();
                    }
                    String mimeType = MetadataAudioExtractor.searchMimeType();

                    String sampleRate = "All";
                    if (criteriaSampleRate != "All") {
                        sampleRate = MetadataAudioExtractor.getSearchSampleRate();
                    }
                    Date creationDate = FileInfo.getFileDate(fileExtractor, "creation");
                    Date accessDate = FileInfo.getFileDate(fileExtractor, "access");
                    Date modificationDate = FileInfo.getFileDate(fileExtractor, "modification");
                    Float fileSize = FileInfo.getFileSize(fileExtractor);

                    if (evaluateString(fileName, criteriaFileName)
                            && evaluateString(fileExtension, criteriaExtension)
                            && evaluateString(channel, criteriaChannel)
                            && evaluateString(audioCodec, criteriAudioCodec)
                            && evaluateString(mimeType, criteriaMimeType)
                            && evaluateString(sampleRate, criteriaSampleRate)) {
                        List<String> metadata = MetadataCommonExtractor.getSearchListMetadata();
                        CustomizedFile matchingFile = new CustomizedFile(fileExtractor.getAbsolutePath(), fileName,
                                fileExtension, false, false,
                                fileSize, creationDate, accessDate,
                                modificationDate, "MimeType", "video", metadata);
                        searchResult.add(matchingFile);
                    }
                }
            } catch (Exception e) {
                System.out.println("The file  :" + FileInfo.getFileDenomination(fileExtractor, "name") + " -  No was added ");
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
}
