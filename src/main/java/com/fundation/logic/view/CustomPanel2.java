package com.fundation.logic.view;

import javax.swing.*;
import java.awt.*;

public class CustomPanel2 extends JPanel {
    public CustomPanel2() {
        super();
        Color panelColor = new Color(32, 178, 170);
        setBackground(panelColor);
        setForeground(Color.orange);
        setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(0, 139, 139)));
    }
}
