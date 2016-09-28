package com.boatclub;

import com.boatclub.controller.Router;

public class Main {

    public static void main(String[] args) {
        Router boatClub = new Router();

        try {
            boatClub.start();
        } catch (Exception error) {
            System.out.println("Application crashed with error: " + error.getMessage());
        }
    }
}
