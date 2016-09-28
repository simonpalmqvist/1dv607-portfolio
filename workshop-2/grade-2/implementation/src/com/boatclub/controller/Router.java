package com.boatclub.controller;

import com.boatclub.model.BoatClub;
import com.boatclub.model.Member;
import com.boatclub.view.ConsoleUI;

public class Router {

    private ConsoleUI view = new ConsoleUI();
    private BoatClub model = new BoatClub();

    private UserAction[] availableActions = new UserAction[] {
        UserAction.CreateMember,
        UserAction.ViewMember,
        UserAction.UpdateMember,
        UserAction.DeleteMember,
        UserAction.Exit
    };

    public void start () throws Exception {
        boolean quit = false;

        view.displayWelcomeMessage();

        // Run until user wants to quit application
        while (!quit) {

            view.displayMenu(availableActions);

            UserAction choice = view.getUserRequest(availableActions);

            switch (choice) {
                case CreateMember:
                    showCreateMember();
                    break;
                case ViewMember:
                    showMember();
                    break;
                case UpdateMember:
                    updateMember();
                    break;
                case DeleteMember:
                    showDeleteMember();
                    break;
                case Exit:
                    quit = true;
                    view.displayExitMessage();
                    break;
                default:
                    throw new Exception("This action is not implemented");
            }
        }
    }

    private void showCreateMember() {
        try {
            String name = view.getInputMemberName();
            String pno = view.getInputMemberPno();
            model.addMember(name, pno);
            view.displayAddedMember();
        } catch (Exception e) {
            view.displayMemberNotFound();
        }
    }

    private void showMember () {
        try {
            Member member = getMember();
            view.displayMember(member.getName(), member.getPno(), member.getId());
        } catch (Exception error) {
            view.displayMemberNotFound();
        }
    }

    private void updateMember () {
        try {
            Member member = getMember();
            String newName = view.displayUpdateName(member.getName());
            String newPno = view.displayUpdatePno(member.getPno());

            member.setName(newName);
            member.setPno(newPno);

        } catch (Exception error) {
            view.displayMemberNotFound();
        }
    }

    private void showDeleteMember () {
        try {
            int id = view.getInputMemberId();
            model.deleteMember(id);
            view.displayMemberDeleted();
        } catch (Exception error) {
            view.displayMemberNotFound();
        }
    }

    private Member getMember () throws Exception {
        int id = view.getInputMemberId();
        return model.getMember(id);
    }
}
