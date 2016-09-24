package com.boatclub;

import com.boatclub.controller.Router;

public class Main {

    public static void main(String[] args) {
        Router mainController = new Router();

        try {
            mainController.start();
        } catch (Exception error) {
            System.out.println("Application crashed with error: " + error.getMessage());
        }
    }
}
