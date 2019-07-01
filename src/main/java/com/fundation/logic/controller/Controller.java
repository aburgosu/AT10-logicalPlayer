package com.fundation.logic.controller;

import com.fundation.logic.model.Criteria;
import com.fundation.logic.model.ISearch;
import com.fundation.logic.model.SearchVideo;
import com.fundation.logic.view.SearchVideoFrame;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    ISearch search;
    Criteria criteria;
    SearchVideoFrame searchFrame;

    public Controller(SearchVideoFrame searchFrame) {
        criteria = new Criteria();
        this.searchFrame = searchFrame;
        searchFrame.setVisible(true);
    }

    public Criteria setCriteria(String path, String fileName, String extension, Boolean fileHidden, Boolean fileReadOnly) {
        criteria.setPath(path);
        criteria.setFileName(fileName);
        criteria.setExtension(extension);
        criteria.setFileHidden(fileHidden);
        criteria.setFileReadOnly(fileReadOnly);
        return criteria;
    }

    public List makeSearch(Criteria criteria) {
        search = new SearchVideo(criteria);
        List<File> foundFiles = search.search();
        return foundFiles;
    }
}
