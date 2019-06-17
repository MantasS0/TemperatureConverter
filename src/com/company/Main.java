package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        showApplication();
    }

    public static void showApplication() {
        /* Sukuriame frame objekta ir parodome varotojui */
        JFrame frame = new JFrame("App");
        frame.setContentPane(new App().getPanel1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

}
