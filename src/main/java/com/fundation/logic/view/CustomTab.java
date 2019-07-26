package com.fundation.logic.view;

import javax.swing.*;
import java.awt.*;

public class CustomTab extends JTabbedPane {
    public CustomTab() {
        super();
        Color buttonColor = new Color(228, 206, 39);
        setBackground(buttonColor);
        Font fuente = new Font("Arial", 3, 25);
        setFont(fuente);
    }
}
