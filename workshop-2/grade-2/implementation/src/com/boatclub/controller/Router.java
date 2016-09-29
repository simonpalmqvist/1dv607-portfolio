package com.boatclub.controller;

import com.boatclub.model.Boat;
import com.boatclub.model.BoatClub;
import com.boatclub.model.Member;
import com.boatclub.view.View;

public class Router {

    private View view;
    private BoatClub model;

    public Router (BoatClub model, View view) {
        this.model = model;
        this.view = view;
    }

    public void start () throws Exception {
        boolean quit = false;
        UserAction[] availableActions = UserAction.values();

        view.displayWelcomeMessage();

        // Run until user wants to quit application
        while (!quit) {
            view.displayMenu(availableActions);
            UserAction choice = view.getUserRequest(availableActions);

            quit = tryHandleAction(choice);

            // Store member data after each action
            model.saveMemberData();
        }

        view.displayExitMessage();
    }

    private boolean tryHandleAction (UserAction choice) {
        try {
            return handleAction(choice);
        } catch (Exception error) {
            view.displayMemberNotFound();
            return false;
        }
    }

    private boolean handleAction (UserAction choice) throws Exception {
        boolean quitApplication = false;

        switch (choice) {
            case ListMembers:
                showListOfMembersCompact();
                break;
            case ListMembersVerbose:
                showListOfMembersVerbose();
                break;
            case AddMember:
                showAddMember();
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
            case AddBoat:
                showAddBoat();
                break;
            case UpdateBoat:
                showUpdateBoat();
                break;
            case DeleteBoat:
                showDeleteBoat();
                break;
            case Exit:
                quitApplication = true;
                break;
            default:
                throw new Exception("This choice can not be performed");
        }

        return quitApplication;
    }

    private void showListOfMembersCompact() {
        view.displayMemberListHeader();

        for (Member member : model.getAllMembers()) {
            view.displayMemberListRow(member.getId(), member.getName(), member.getPno(), member.getNumberOfBoats());
        }
    }

    private void showListOfMembersVerbose () {
        for (Member member : model.getAllMembers()) {

            view.displayMember(member.getName(), member.getPno(), member.getId());

            showListOfMembersBoats(member.getBoats());
        }
    }

    private void showListOfMembersBoats (Boat[] boats) {
        for (Boat boat : boats) {
            view.displayBoat(boat.getType(), boat.getLength());
        }
    }

    private void showAddMember () throws Exception {
        String name = view.getInputMemberName();
        String pno = view.getInputMemberPno();

        model.addMember(name, pno);

        view.displayAddedMember();
    }

    private void showMember () throws Exception {
        Member member = getMember();

        view.displayMember(member.getName(), member.getPno(), member.getId());
    }

    private void updateMember () throws Exception {
        Member member = getMember();

        String newName = view.displayUpdateName(member.getName());
        String newPno = view.displayUpdatePno(member.getPno());

        member.setName(newName);
        member.setPno(newPno);
    }

    private void showDeleteMember () throws Exception {
        int id = view.getInputMemberId();

        model.deleteMember(id);

        view.displayMemberDeleted();
    }

    private void showAddBoat () throws Exception {
        Member member = getMember();
        Boat.Type type = view.getInputBoatType();
        float length = view.getInputBoatLength();

        member.addBoat(type, length);

        view.displayAddedBoat();
    }

    private void showUpdateBoat () throws Exception {
        Member member = getMember();
        Boat boat = getBoat(member);

        Boat.Type boatType = view.displayUpdateType(boat.getType());
        float length = view.displayUpdateLength(boat.getLength());

        boat.setType(boatType);
        boat.setLength(length);
    }

    private void showDeleteBoat () throws Exception {
        Member member = getMember();

        int index = view.getInputBoatIndex();

        member.deleteBoat(index);

        view.displayBoatDeleted();
    }

    private Member getMember () throws Exception {
        int id = view.getInputMemberId();
        return model.getMember(id);
    }

    private Boat getBoat (Member member) throws Exception {
        int index = view.getInputMemberId();
        return member.getBoat(index);
    }
}
