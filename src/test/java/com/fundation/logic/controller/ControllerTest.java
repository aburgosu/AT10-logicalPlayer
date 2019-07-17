package com.fundation.logic.controller;

import com.fundation.logic.model.criteria.Common;
import com.fundation.logic.model.criteria.Image;
import com.fundation.logic.model.criteria.Video;
import com.fundation.logic.view.SearchVideoFrame;
import org.junit.Test;

import static org.junit.Assert.*;

public class ControllerTest {

    @Test
    public void makeSearch_videoCriteria() {
        SearchVideoFrame search = new SearchVideoFrame();
        Video videoCriteria = new Video();
        videoCriteria.setPath("C:\\Users\\AndresBurgos\\Desktop\\testVideo");
        Controller controller = new Controller(search);
        controller.makeSearch(videoCriteria);
        int actual = search.getTableResult().getRowCount();
        assertNotEquals(0, actual);
    }

    @Test
    public void makeSearch_imageCriteria() {
        SearchVideoFrame search = new SearchVideoFrame();
        Image criteria = new Image();
        criteria.setPath("C:\\Users\\AndresBurgos\\Desktop\\testVideo");
        Controller controller = new Controller(search);
        controller.makeSearch(criteria);
        int actual = search.getTableResult().getRowCount();
        assertNotEquals(0, actual);
    }

    @Test
    public void makeSearch_commonCriteria() {
        SearchVideoFrame search = new SearchVideoFrame();
        Common criteria = new Common();
        criteria.setPath("C:\\Users\\AndresBurgos\\Desktop\\testVideo");
        Controller controller = new Controller(search);
        controller.makeSearch(criteria);
        int actual = search.getTableResult().getRowCount();
        assertNotEquals(0, actual);
    }

    @Test
    public void showSearchResult_commonSearch() {
        SearchVideoFrame search = new SearchVideoFrame();
        search.getSearchTabs().getSplitPanelSearch().getBasicSearchPanel().getTextFieldPath().setText("C:\\Users\\AndresBurgos\\Desktop\\testVideo");
        Controller controller = new Controller(search);
        controller.showSearchResult(Controller.COMMON_SEARCH);
        int actual = search.getTableResult().getRowCount();
        assertNotEquals(0, actual);
    }
    @Test
    public void showSearchResult_videoSearch() {
        SearchVideoFrame search = new SearchVideoFrame();
        search.getSearchTabs().getSplitPanelSearch().getBasicSearchPanel().getTextFieldPath().setText("C:\\Users\\AndresBurgos\\Desktop\\testVideo");
        Controller controller = new Controller(search);
        controller.showSearchResult(Controller.VIDEO_SEARCH);
        int actual = search.getTableResult().getRowCount();
        assertNotEquals(0, actual);
    }
    /**@Test
    public void showSearchResult_audioSearch() {
        SearchVideoFrame search = new SearchVideoFrame();
        search.getSearchTabs().getSplitPanelSearch().getBasicSearchPanel().getTextFieldPath().setText("C:\\Users\\AndresBurgos\\Desktop\\testVideo");
        Controller controller = new Controller(search);
        controller.showSearchResult(Controller.AUDIO_SEARCH);
        int actual = search.getTableResult().getRowCount();
        assertNotEquals(0, actual);
    }*/
    @Test
    public void showSearchResult_imageSearch() {
        SearchVideoFrame search = new SearchVideoFrame();
        search.getSearchTabs().getSplitPanelSearch().getBasicSearchPanel().getTextFieldPath().setText("C:\\Users\\AndresBurgos\\Desktop\\testVideo");
        Controller controller = new Controller(search);
        controller.showSearchResult(Controller.IMAGE_SEARCH);
        int actual = search.getTableResult().getRowCount();
        assertNotEquals(0, actual);
    }

    @Test
    public void getCommonCriteria() {
    }

    @Test
    public void setEvents_createCommonSearch() {
    }
}