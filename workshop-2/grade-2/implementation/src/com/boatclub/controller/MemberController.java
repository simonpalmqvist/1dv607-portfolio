package com.boatclub.controller;

import com.boatclub.model.Member;
import com.boatclub.view.ConsoleMember;

public class MemberController {

    private ConsoleMember view = new ConsoleMember();
    private Member model;

    public void show (Member member) {
        model = member;

        view.display(model.getName(), model.getPno(), model.getId());
    }

    public void updateMember () {
        String newName = view.displayUpdateName(model.getName());
        String newPno = view.displayUpdatePno(model.getPno());

        model.setName(newName);
        model.setPno(newPno);
    }
}
