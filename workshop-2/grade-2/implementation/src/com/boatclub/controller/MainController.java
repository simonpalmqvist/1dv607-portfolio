package com.boatclub.controller;

import com.boatclub.model.BoatClub;
import com.boatclub.view.ConsoleMain;

public class MainController {

    private ConsoleMain ui = new ConsoleMain();
    private BoatClub club = new BoatClub();
    private MemberController memberController = new MemberController();

    void createMember () {
        String name = ui.getInputName();
        String pno = ui.getInputPno();
        club.createMember(name, pno);
        ui.displayAddedUser();
    }

    void showMember () {
        try {
            int id = ui.getInputMemberId();
            memberController.showMember(club.findMember(id));
        } catch (Exception error) {
            System.out.println("Could not find user");
        }
    }

    void deleteMember () {
        int id = ui.getInputMemberId();
        club.deleteMember(id);
        System.out.println("Deleted member");
    }
}
