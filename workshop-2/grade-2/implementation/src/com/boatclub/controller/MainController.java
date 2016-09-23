package com.boatclub.controller;

import com.boatclub.model.BoatClub;
import com.boatclub.model.Member;
import com.boatclub.view.ConsoleMain;

public class MainController {

    private ConsoleMain ui = new ConsoleMain();
    private BoatClub club = new BoatClub();
    private MemberController memberController = new MemberController();

    private Action[] availableActions = new Action[]{Action.CreateMember, Action.ShowMember, Action.Exit};

    public void start () throws Exception {
        boolean keepApplicationRunning = true;

        ui.displayStartupInformation();

        while (keepApplicationRunning) {
            Action choice = ui.getUserRequest(availableActions);

            switch (choice) {
                case CreateMember:
                    createMember();
                    break;
                case ShowMember:
                    showMember();
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

    private void createMember () {
        String name = ui.getInputName();
        String pno = ui.getInputPno();
        club.createMember(name, pno);
        ui.displayAddedUser();
    }

    private void showMember () {
        int id = ui.getInputMemberId();
        memberController.showMember(club.findMember(id));
    }
}
