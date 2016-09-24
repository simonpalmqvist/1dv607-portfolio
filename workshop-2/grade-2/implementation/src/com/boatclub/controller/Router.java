package com.boatclub.controller;

import com.boatclub.view.ConsoleMenu;

public class Router {
    public enum Action {
        CreateMember,
        UpdateMember,
        ShowMember,
        DeleteMember,
        BackToStart,
        Exit
    }

    private ConsoleMenu ui = new ConsoleMenu();
    private ClubController club =  new ClubController();
    private MemberController member =  new MemberController();
    private Action[] menu;

    public void start () throws Exception {
        boolean keepApplicationRunning = true;

        ui.displayWelcomeMessage();
        setStartMenu();

        while (keepApplicationRunning) {
            Action choice = ui.getUserRequest(menu);

            switch (choice) {
                case CreateMember:
                    club.showCreateMember();
                    break;
                case ShowMember:
                    member.show(club.showChooseMember());
                    setMemberMenu();
                    break;
                case UpdateMember:
                    member.updateMember();
                    break;
                case DeleteMember:
                    club.showDeleteMember();
                    break;
                case BackToStart:
                    setStartMenu();
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

    private void setStartMenu () {
        menu = new Action[] { Action.CreateMember, Action.ShowMember, Action.DeleteMember, Action.Exit };
    }

    private void setMemberMenu () {
        menu = new Action[] { Action.UpdateMember, Action.BackToStart };
    }
}
