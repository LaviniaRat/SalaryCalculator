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

        GridBagLayout grid = new GridBagLayout();
        final JPanel panel = new JPanel();
        panel.setLayout(grid);
        GridBagConstraints c = new GridBagConstraints();
        c.weighty = 0.2;

        this.getContentPane().add(panel);

        Container contentPanel = new Panel();

        JButton netButton = new JButton("Salariu Net");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        panel.add(netButton, c);


        JButton brutButton = new JButton("Salariu Brut");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        panel.add(brutButton, c);


        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.LINE_START;
        c.weighty = 0.80;
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 1;
        panel.add(contentPanel, c);

        netButton.addActionListener(e -> {
            contentPanel.removeAll();
            getContentPane().repaint();
            CalculatorSalariuNetPanel calculatorSalariuNet = new CalculatorSalariuNetPanel();
            calculatorSalariuNet.addComponents(contentPanel);
            this.setVisible(true);
        });

        brutButton.addActionListener(e -> {
            contentPanel.removeAll();
            getContentPane().repaint();
            CalculatorSalariuBrutPanel calculatorSalariuBrut = new CalculatorSalariuBrutPanel();
            calculatorSalariuBrut.addComponents(contentPanel);
            getContentPane().revalidate();
            this.setVisible(true);
        });


        this.pack();
        this.setVisible(true);


    }
}
