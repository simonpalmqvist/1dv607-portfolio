package com.boatclub.controller;

import com.boatclub.model.BoatClub;
import com.boatclub.view.ConsoleUI;
import com.boatclub.view.ConsoleUI.Action;

public class User {

    private ConsoleUI ui;
    private BoatClub club = new BoatClub();

    public User(ConsoleUI ui) {
        this.ui = ui;
    }

    public void start () throws Exception {
        boolean keepApplicationRunning = true;

        ui.displayStartupInformation();

        while (keepApplicationRunning) {
            Action choice = ui.getUserRequest(new Action[]{Action.CreateMember, Action.Exit});

            switch (choice) {
                case CreateMember:
                    showCreateMember();
                    break;
                case Exit:
                    ui.displayExitMessage();
                    keepApplicationRunning = false;
                    break;
                default:
                    throw new Exception("Unvalid option");
            }
        }
    }

    private void showCreateMember () {
        String name = ui.getInputName();
        String pno = ui.getInputPno();
        club.createMember(name, pno);
        ui.displayAddedUser();
    }
}
