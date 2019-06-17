package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;

public class App {
    private JPanel panel1;
    private JTextField textField1;
    private JLabel celsiusLabel;
    private JLabel fahrenheitLabel;
    private JButton button1;
    private JComboBox comboBox1;
    private String selected = "Fahrenheit";
    private DecimalFormat df = new DecimalFormat("###.##");


    public App() {

        populateComboBox1();

        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {

                if (comboBox1.getItemCount() > 0) {
                    if (event.getStateChange() == ItemEvent.SELECTED) {
                        StringBuilder temp = new StringBuilder();
                        temp.append(event.getItem());
                        temp.delete(0, 3);
                        selected = temp.toString();
                        System.out.println(selected);

                        switch (selected) {
                            case "Fahrenheit":
                                celsiusLabel.setText("Celsius");
                                fahrenheitLabel.setText("Fahrenheit");
                                break;
                            case "Celsius":
                                celsiusLabel.setText("Fahrenheit");
                                fahrenheitLabel.setText("Celsius");
                                break;
                        }
                    }
                }

            }
        });


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField1.getText().length()>0) {
                    Double inputValue = Double.parseDouble(textField1.getText());
                    if (selected.equals("Fahrenheit")) {
                        //(0°C × 9/5) + 32 = 32°F
                        Double convertedValue = (inputValue * 9 / 5) + 32;
                        fahrenheitLabel.setText(df.format(convertedValue) + " Fahrenheit");
                    } else if (selected.equals("Celsius")) {
                        //(32°F − 32) × 5/9 = 0°C
                        Double convertedValue = (inputValue - 32) * 5 / 9;
                        fahrenheitLabel.setText(df.format(convertedValue) + " Celsius");
                    }
                }
            }
        });
    }


    public JPanel getPanel1() {
        return panel1;
    }

    private void populateComboBox1() {
        if (comboBox1.getItemCount() > 0) {
            comboBox1.removeAllItems();
        }
        comboBox1.addItem("to Fahrenheit");
        comboBox1.addItem("to Celsius");

    }


}
