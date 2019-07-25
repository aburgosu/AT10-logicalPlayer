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
import com.fundation.logic.common.MetadataCommonExtractor;
import com.fundation.logic.common.MetadataVideoExtractor;
import com.fundation.logic.model.CustomizedFile;
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
     * Initializes a search instance which requires a searchCriteria as parameter.
     */
    public VideoSearch(Video videoCriteria) {
        this.videoCriteria = videoCriteria;
    }

    /**
     * Main search method.
     *
     * @return List of found items if searchCriteria's path is not null.
     */
    public List search() {
        if (videoCriteria.getPath() == null) {
            return null;
        }
        return searchInPath(videoCriteria.getPath());
    }

    /**
     * @param path
     * @return Complete list of found items according on searchCriteria's path.
     */
    public List searchInPath(String path) {
        List<CustomizedFile> searchResult = new ArrayList<>();
        File file = new File(path);
        String criteriaFileName = videoCriteria.getFileName();
        String criteriaExtension = videoCriteria.getExtension();
        String criteriVideoCodec = videoCriteria.getVideoCodec();
        String criteriAudioVideoCodec = videoCriteria.getAudioCodec();
        String criteriaFrameRate = videoCriteria.getFrameRate();
        String criteriaHeight = Integer.toString(videoCriteria.getHeight());
        File[] allSubFiles = file.listFiles();
        for (File fileExtractor : allSubFiles) {
            try {
                if (fileExtractor.isDirectory()) {
                    searchResult.addAll(searchInPath(fileExtractor.getAbsolutePath()));
                } else {
                    String fileName = FileInfo.getFileDenomination(fileExtractor, "name");
                    String fileExtension = FileInfo.getFileDenomination(fileExtractor, "extension");
                    String frameRate = "All";
                    String exiftool = "thirdParty/exiftool.exe "; //Tool used for extract metadata
                    String pathd = exiftool + "\"" + fileExtractor + "\"";
                    MetadataVideoExtractor metadataVideoExtractor = new MetadataVideoExtractor();
                    metadataVideoExtractor.run(pathd);
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
                    Date creationDate = FileInfo.getFileDate(fileExtractor, "creation");
                    Date accessDate = FileInfo.getFileDate(fileExtractor, "access");
                    Date modificationDate = FileInfo.getFileDate(fileExtractor, "modification");
                    Float fileSize = FileInfo.getFileSize(fileExtractor);
                    if (evaluateString(frameRate, criteriaFrameRate)
                            && evaluateString(fileName, criteriaFileName)
                            && evaluateString(fileExtension, criteriaExtension)
                            && evaluateString(fileVideoCodec, criteriVideoCodec)
                            && evaluateString(videoAudioCodec, criteriAudioVideoCodec)
                            && evaluateString(fileHeight, criteriaHeight)) {
                        List<String> metadata = MetadataCommonExtractor.getSearchListMetadata();
                        CustomizedFile matchingFile = new CustomizedFile(fileExtractor.getAbsolutePath(), fileName,
                                fileExtension, false, false, fileSize, creationDate,
                                accessDate, modificationDate, "MimeType", "video", metadata);
                        searchResult.add(matchingFile);
                    }
                }
            } catch (Exception excp) {
                excp.getMessage();
            }
        }
        return searchResult;
    }

    /**
     * Evaluates specific string field according on searchCriteria.
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