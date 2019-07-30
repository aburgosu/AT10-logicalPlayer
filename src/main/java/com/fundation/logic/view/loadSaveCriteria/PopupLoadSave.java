/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.view.loadSaveCriteria;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 * Implements PopupLoadSave class which is in charge of delete or load criteria.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class PopupLoadSave extends JPopupMenu {
    private JMenuItem loadItem;
    private JMenuItem deleteItem;

    /**
     * Initializes PopupMenu with options to load or delete selected criteria.
     */
    public PopupLoadSave() {
        loadItem = new JMenuItem("Load");
        add(loadItem);
        deleteItem = new JMenuItem("Delete");
        add(deleteItem);
    }

    /**
     * Allows to get load item from the menu.
     * @return Load item.
     */
    public JMenuItem getLoadItem() {
        return loadItem;
    }

    /**
     * Allows to get delete item from the menu.
     * @return Delete item.
     */
    public JMenuItem getDeleteItem() {
        return deleteItem;
    }
}