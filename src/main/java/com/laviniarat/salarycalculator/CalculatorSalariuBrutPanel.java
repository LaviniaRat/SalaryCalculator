package com.laviniarat.salarycalculator;

import javax.swing.*;
import java.awt.*;

public class CalculatorSalariuBrutPanel extends JPanel {
        private JTextField tFieldSalariu = new JTextField();
        private JTextField tFieldValoareTichet = new JTextField();
        private JTextField tFieldNumarTichete = new JTextField();
        private JCheckBox scutireImpozitCheckBox;
        private JTextField tFiledCalculator = new JTextField();
        private JLabel labelCASValue = new JLabel();
        private JLabel labelCASSValue = new JLabel();
        private JLabel labelImpozitVenitValue = new JLabel();


        public CalculatorSalariuBrutPanel() {
        }

        public void addComponents(Container container) {

            //creating the grid and the panel
            GridLayout grid = new GridLayout(19, 1, 8, 5);
            final JPanel panel = new JPanel();
            panel.setLayout(grid);

            //creating the  header label
            JLabel headerlabel = new JLabel("Calculator Salariu Brut", JLabel.CENTER);
            headerlabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
            panel.add(headerlabel);

            panel.add(new Label());
            container.add(panel, BorderLayout.NORTH);
            Font timesNewRoman = new Font("Times New `Roman", Font.PLAIN, 18);

            final JPanel panelSalariu = buildRow(timesNewRoman, "Salariu Net:", tFieldSalariu);
            panel.add(panelSalariu);

            // creating label 2
            final JPanel panelValoareTichet = buildRow(timesNewRoman, "Valoarea unui tichet de masa:", tFieldValoareTichet);
            panel.add(panelValoareTichet);

            // creating label 3
            final JPanel panelNumarTichete = buildRow(timesNewRoman, "Numar tichete de masa:", tFieldNumarTichete);
            panel.add(panelNumarTichete);

            //creating label 5
            GridLayout gridCalculator = new GridLayout(1, 2);
            final JPanel panelCalculator = new JPanel();
            JLabel labelCalculator = new JLabel("Scutit de impozit:");
            labelCalculator.setFont(timesNewRoman);
            panelCalculator.setLayout(gridCalculator);
            panelCalculator.add(labelCalculator);
            scutireImpozitCheckBox = new JCheckBox();
            panelCalculator.add(scutireImpozitCheckBox);
            panel.add(panelCalculator);

            //creating button
            GridLayout gridButton = new GridLayout(1, 2);
            final JPanel panelbutton = new JPanel();
            JButton button = new JButton("Calculeaza");
            button.setSize(40, 40);
            tFiledCalculator = new JTextField();
            button.addActionListener(e -> computeSalariuBrut());

            panelbutton.setLayout(gridButton);
            panelbutton.add(button);
            panelbutton.add(tFiledCalculator);
            panel.add(panelbutton);

            final JPanel panelCAS = buildRow(timesNewRoman, "Asigurari Sociale (CAS)  25%:", labelCASValue);
            panel.add(panelCAS);

            final JPanel panelCASS = buildRow(timesNewRoman, "Asigurari Sociale de Sanatate (CASS) 10%:", labelCASSValue);
            panel.add(panelCASS);

            final JPanel panelImpozitVenit = buildRow(timesNewRoman, "Impozit pe venit (IV)  10%:", labelImpozitVenitValue);
            panel.add(panelImpozitVenit);

            this.setVisible(true);
        }

        private JPanel buildRow(Font timesNewRoman, String label, JComponent textField) {

            GridLayout grid = new GridLayout(1, 2);
            final JPanel panel = new JPanel();
            panel.setLayout(grid);
            JLabel labelRow = new JLabel(label);
            labelRow.setFont(timesNewRoman);
            panel.add(labelRow);
            panel.add(textField);
            return panel;
        }

        private void computeSalariuBrut() {
            int salariuNet;
            int valoareTichet;
            int numarTichete;
            try {
                addRestriction(tFieldSalariu);
                addRestriction(tFieldValoareTichet);
                addRestriction(tFieldNumarTichete);
            } catch (NumberFormatException e) {
                return;
            }
            salariuNet = Integer.parseInt(tFieldSalariu.getText());
            valoareTichet = Integer.parseInt(tFieldValoareTichet.getText());
            numarTichete = Integer.parseInt(tFieldNumarTichete.getText());
            boolean scutireImpozit = scutireImpozitCheckBox.isSelected();
            CalculatorSalariuBrut calculatorSalariuBrut = new CalculatorSalariuBrut(salariuNet, valoareTichet, numarTichete, scutireImpozit);
            calculatorSalariuBrut.compute();
            populateResults(calculatorSalariuBrut);
        }

        private void addRestriction(JTextField textField) throws NumberFormatException {
            char[] array = textField.getText().toCharArray();
            for (int i = 0; i < array.length; i++) {
                if (array[i] >= '0' && array[i] <= '9') {
                    textField.setEditable(true);
                } else {
                    textField.setText("Introduceti doar cifre intre 0-9");
                    throw new NumberFormatException();
                }
            }

        }

        private void populateResults(CalculatorSalariuBrut calculatorSalariuBrut) {
            double resultSalariuBrut = calculatorSalariuBrut.getSalariuBrut();
            tFiledCalculator.setText(String.valueOf(resultSalariuBrut));
            labelCASValue.setText(String.valueOf(calculatorSalariuBrut.getCAS()));
            labelCASSValue.setText(String.valueOf(calculatorSalariuBrut.getCASS()));
            labelImpozitVenitValue.setText(String.valueOf(calculatorSalariuBrut.getIV()));
        }
    }


