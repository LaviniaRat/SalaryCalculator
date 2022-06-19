package com.laviniarat.salarycalculator;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setResizable(false);
        setSize(750, 700);
        setPreferredSize(getSize());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void addComponents() {
        CalculatorSalariuNetPanel calculatorSalariuNet = new CalculatorSalariuNetPanel();
        CalculatorSalariuBrutPanel calculatorSalariuBrut = new CalculatorSalariuBrutPanel();

        GridBagLayout grid = new GridBagLayout();
        final JPanel panel = new JPanel();
        panel.setLayout(grid);
        GridBagConstraints c = new GridBagConstraints();
        c.weighty = 0.2;

        JButton netButton = new JButton("Salariu Net");
//        netButton.setSize(100, 100);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        panel.add(netButton, c);

        JButton brutButton = new JButton("Salariu Brut");
//        brutButton.setSize(100, 100);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        panel.add(brutButton, c);


        this.getContentPane().add(panel);

        Container contentPanel = new Panel();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.LINE_START;
        c.weighty = 0.80;
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 1;
        panel.add(contentPanel, c);

//        calculatorSalariuNet.addComponents(contentPanel);
        calculatorSalariuBrut.addComponents(contentPanel);

        this.pack();
        this.setVisible(true);
    }
}
