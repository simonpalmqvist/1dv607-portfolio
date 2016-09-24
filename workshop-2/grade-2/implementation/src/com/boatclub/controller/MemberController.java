package com.boatclub.controller;

import com.boatclub.model.Member;
import com.boatclub.view.ConsoleMember;

public class MemberController {

    private ConsoleMember view = new ConsoleMember();
    private Member model;

    private Enum[] availableActions = new Enum[] { ConsoleMember.Action.Update, ConsoleMember.Action.Back };

    public void handleRequests (Member member) throws Exception {
        boolean goBack = false;
        model = member;

        show();

        while (!goBack) {
            ConsoleMember.Action choice = (ConsoleMember.Action) view.getUserRequest(availableActions);

            switch (choice) {
                case Update:
                    update();
                    break;
                case Back:
                    goBack = true;
                    break;
                default:
                    throw new Exception("This action is not implemented");
            }
        }
    }

    private void show () {
        view.display(model.getName(), model.getPno(), model.getId());
    }

    private void update () {
        String newName = view.displayUpdateName(model.getName());
        String newPno = view.displayUpdatePno(model.getPno());

        model.setName(newName);
        model.setPno(newPno);
    }
}
