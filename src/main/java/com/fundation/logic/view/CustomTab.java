package com.fundation.logic.view;

import javax.swing.*;
import java.awt.*;

public class CustomTab extends JTabbedPane {
    public CustomTab() {
        super();
        Color buttonColor = new Color(32, 178, 170);
        setBackground(buttonColor);
        Font fuente = new Font("Arial", 3, 15);
        setFont(fuente);
        setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(0,139,139)));

    }
}
