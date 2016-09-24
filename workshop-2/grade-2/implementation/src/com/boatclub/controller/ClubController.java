package com.boatclub.controller;

import com.boatclub.model.BoatClub;
import com.boatclub.model.Member;
import com.boatclub.view.ConsoleMain;

public class ClubController {

    private ConsoleMain view = new ConsoleMain();
    private BoatClub model = new BoatClub();

    void showCreateMember() {
        String name = view.getInputName();
        String pno = view.getInputPno();
        model.createMember(name, pno);
        view.displayAddedUser();
    }

    Member showChooseMember () throws Exception {
        int id = view.getInputMemberId();
        return model.findMember(id);
    }

    void showDeleteMember() {
        int id = view.getInputMemberId();
        model.deleteMember(id);
        System.out.println("Deleted member");
    }
}
