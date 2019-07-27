package com.fundation.logic.view;

import javax.swing.*;
import java.awt.*;

public class CustomCheckBox extends JCheckBox {
    public CustomCheckBox(String check) {
        super();
        Color checkBox = new Color(119, 136, 153);
        setBackground(checkBox);

        Font fuente = new Font("Calibri", 3, 20);
        setFont(fuente);
    }
}
