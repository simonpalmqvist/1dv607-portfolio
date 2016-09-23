package com.boatclub;

import com.boatclub.controller.MainController;
import com.boatclub.view.ConsoleMain;

public class Main {

    public static void main(String[] args) {
        MainController mainController = new MainController();

        try {
            mainController.start();
        } catch (Exception error) {
            System.out.println("Application crashed with error: " + error.getMessage());
        }
    }
}
