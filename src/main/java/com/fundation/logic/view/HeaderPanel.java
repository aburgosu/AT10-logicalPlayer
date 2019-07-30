package com.fundation.logic.view;

import com.fundation.logic.view.customElements.CustomLabel;
import com.fundation.logic.view.customElements.CustomPanelSecond;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class HeaderPanel extends CustomPanelSecond {
    public HeaderPanel(){
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{5, 80, 80, 80, 80, 5};
        gridBagLayout.rowHeights = new int[]{30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(0, 0, 0)));

        JLabel image = new CustomLabel("");
        image.setIcon(new ImageIcon("resources/Images/logo.png"));
        GridBagConstraints gbc_lblimage = new GridBagConstraints();
        gbc_lblimage.gridwidth = 1;
        gbc_lblimage.insets = new Insets(5, 5, 5, 5);
        gbc_lblimage.gridx = 0;
        gbc_lblimage.gridy = 0;
        add(image, gbc_lblimage);

        JLabel lbltitle = new CustomLabel(" LogicalPlayer");
        GridBagConstraints gbc_lbltitle = new GridBagConstraints();
        gbc_lbltitle.gridwidth = 1;
        gbc_lbltitle.insets = new Insets(0, 0, 0, 0);
        gbc_lbltitle.gridx = 3;
        gbc_lbltitle.gridy = 0;
        lbltitle.setFont( new Font("Comic Sans MS",1, 55));
        lbltitle.setForeground(new Color(255,255,255));
        add(lbltitle, gbc_lbltitle);
    }
}
