package com.boatclub.controller;

import com.boatclub.model.BoatClub;
import com.boatclub.view.ConsoleBoatClub;

public class BoatClubController {

    private ConsoleBoatClub view = new ConsoleBoatClub();
    private BoatClub model = new BoatClub();
    private MemberController memberController = new MemberController();

    private Enum[] availableActions = new Enum[] {
        ConsoleBoatClub.Action.CreateMember,
        ConsoleBoatClub.Action.ShowMember,
        ConsoleBoatClub.Action.DeleteMember,
        ConsoleBoatClub.Action.Exit
    };

    public void handleRequests () throws Exception {
        boolean quit = false;

        view.displayWelcomeMessage();

        while (!quit) {
            ConsoleBoatClub.Action choice = (ConsoleBoatClub.Action) view.getUserRequest(availableActions);

            switch (choice) {
                case CreateMember:
                    showCreateMember();
                    break;
                case ShowMember:
                    showMember();
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
        String name = view.getInputName();
        String pno = view.getInputPno();
        model.addMember(name, pno);
        view.displayAddedUser();
    }

    private void showMember () {
        try {
            int id = view.getInputMemberId();
            memberController.handleRequests(model.getMember(id));
        } catch (Exception error) {
            view.displayUserNotFound();
        }
    }

    private void showDeleteMember() {
        try {
            int id = view.getInputMemberId();
            model.deleteMember(id);
            view.displayUserDeleted();
        } catch (Exception error) {
            view.displayUserNotFound();
        }
    }
}
