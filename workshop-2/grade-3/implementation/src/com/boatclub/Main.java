package com.boatclub;

import com.boatclub.controller.Router;
import com.boatclub.model.BoatClub;
import com.boatclub.view.View;

public class Main {

    public static void main(String[] args) {
        try {
            View view = new View();
            BoatClub boatClub = new BoatClub();
            Router router = new Router(boatClub, view);

            router.start();

        } catch (Exception error) {
            System.out.println("Application quit because: " + error.getMessage());
        }
    }
}
