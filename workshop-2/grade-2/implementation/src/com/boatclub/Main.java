package com.boatclub;

import com.boatclub.controller.Router;
import com.boatclub.model.BoatClub;
import com.boatclub.view.ConsoleUI;

public class Main {

    public static void main(String[] args) {
        try {
            BoatClub boatClub = new BoatClub();
            ConsoleUI consoleUI = new ConsoleUI();
            Router router = new Router(boatClub, consoleUI);

            router.start();
        } catch (Exception error) {
            System.out.println("Application quit because: " + error.getMessage());
        }
    }
}
