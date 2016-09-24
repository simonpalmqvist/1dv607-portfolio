package com.boatclub;

import com.boatclub.controller.BoatClubController;

public class Main {

    public static void main(String[] args) {
        BoatClubController boatClub = new BoatClubController();

        try {
            boatClub.handleRequests();
        } catch (Exception error) {
            System.out.println("Application crashed with error: " + error.getMessage());
        }
    }
}
