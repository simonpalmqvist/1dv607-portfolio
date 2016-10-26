package com.boatclub.controller;

import com.boatclub.exception.BoatNotFoundException;
import com.boatclub.exception.MemberNotFoundException;
import com.boatclub.exception.WrongCredentialsException;
import com.boatclub.model.Boat;
import com.boatclub.model.BoatClub;
import com.boatclub.model.Member;
import com.boatclub.view.View;

import java.util.ArrayList;
import java.util.Collections;

public class Router {

    private View view;
    private BoatClub model;
    private ArrayList<UserAction> availableActions;

    public Router (BoatClub model, View view) {
        this.model = model;
        this.view = view;

        updateAvailableActions();
    }

    public void start () throws Exception {
        boolean quit = false;

        view.displayWelcomeMessage();

        // Run until user wants to quit application
        while (!quit) {
            UserAction[] actions = availableActions.toArray(new UserAction[availableActions.size()]);

            view.displayMenu(actions);
            UserAction choice = view.getUserRequest(actions);

            if (availableActions.contains(choice)) {
                quit = tryHandleAction(choice);

                // Store member data after each action
                model.saveMemberData();
            }
        }

        view.displayExitMessage();
    }

    private boolean tryHandleAction (UserAction choice) {
        try {
            return handleAction(choice);
        } catch (MemberNotFoundException e) {
            view.displayMemberNotFound();
        } catch (BoatNotFoundException e) {
            view.displayBoatNotFound();
        } catch (WrongCredentialsException e) {
            view.displayWrongCredentials();
        }

        return false;
    }

    private boolean handleAction (UserAction choice) throws MemberNotFoundException,
                                                            BoatNotFoundException,
                                                            WrongCredentialsException {
        boolean quitApplication = false;

        switch (choice) {
            case Login:
                showLogin();
                updateAvailableActions();
                break;
            case Logout:
                showLogout();
                updateAvailableActions();
                break;
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
        }

        return quitApplication;
    }

    private void showLogin () throws WrongCredentialsException {
        String name = view.getInputUsername();
        String pass = view.getInputPassword();

        model.authenticate(name, pass);
        updateAvailableActions();
    }

    private void showLogout () {
        model.unAuthenticate();
        updateAvailableActions();
    }

    private void showListOfMembersCompact () {
        Member[] members = filterMembers();

        view.displayMemberListHeader();

        for (Member member : members) {
            view.displayMemberListRow(member.getId(), member.getName(), member.getPno(), member.getNumberOfBoats());
        }
    }

    private void showListOfMembersVerbose () {
        Member[] members = filterMembers();

        for (Member member : members) {

            view.displayMember(member.getName(), member.getPno(), member.getId());

            showListOfMembersBoats(member.getBoats());
        }
    }

    private Member[] filterMembers () {
        MemberFilterAction choice = view.getMemberFilter();

        Member[] members = {};

        switch (choice) {
            case None:
                members = model.getAllMembers();
                break;
        }

        return members;
    }

    private void showListOfMembersBoats (Boat[] boats) {
        for (Boat boat : boats) {
            view.displayBoat(boat.getType(), boat.getLength());
        }
    }

    private void showAddMember () {
        String name = view.getInputMemberName();
        String pno = view.getInputMemberPno();

        model.addMember(name, pno);

        view.displayAddedMember();
    }

    private void showMember () throws MemberNotFoundException {
        Member member = getMember();

        view.displayMember(member.getName(), member.getPno(), member.getId());
    }

    private void updateMember () throws MemberNotFoundException {
        Member member = getMember();

        String newName = view.displayUpdateName(member.getName());
        String newPno = view.displayUpdatePno(member.getPno());

        member.setName(newName);
        member.setPno(newPno);
    }

    private void showDeleteMember () throws MemberNotFoundException {
        int id = view.getInputMemberId();

        model.deleteMember(id);

        view.displayMemberDeleted();
    }

    private void showAddBoat () throws MemberNotFoundException {
        Member member = getMember();
        Boat.Type type = view.getInputBoatType();
        float length = view.getInputBoatLength();

        member.addBoat(type, length);

        view.displayAddedBoat();
    }

    private void showUpdateBoat () throws MemberNotFoundException, BoatNotFoundException {
        Member member = getMember();
        Boat boat = getBoat(member);

        Boat.Type boatType = view.displayUpdateType(boat.getType());
        float length = view.displayUpdateLength(boat.getLength());

        boat.setType(boatType);
        boat.setLength(length);
    }

    private void showDeleteBoat () throws MemberNotFoundException, BoatNotFoundException {
        Member member = getMember();

        int index = view.getInputBoatIndex();

        member.deleteBoat(index);

        view.displayBoatDeleted();
    }

    private Member getMember () throws MemberNotFoundException {
        int id = view.getInputMemberId();
        return model.getMember(id);
    }

    private Boat getBoat (Member member) throws BoatNotFoundException {
        int index = view.getInputBoatIndex();
        return member.getBoat(index);
    }

    private void updateAvailableActions() {
        availableActions = new ArrayList<>();

        availableActions.add(UserAction.ListMembers);
        availableActions.add(UserAction.ListMembersVerbose);
        availableActions.add(UserAction.ViewMember);

        if (model.getIsAuthenticated()) {
            availableActions.add(UserAction.AddMember);
            availableActions.add(UserAction.UpdateMember);
            availableActions.add(UserAction.DeleteMember);
            availableActions.add(UserAction.AddBoat);
            availableActions.add(UserAction.UpdateBoat);
            availableActions.add(UserAction.DeleteBoat);
            availableActions.add(UserAction.Logout);
        } else {
            availableActions.add(UserAction.Login);
        }

        availableActions.add(UserAction.Exit);
    }
}