package com.boatclub.controller;

import com.boatclub.view.ConsoleMenu;

public class Router {

    private ConsoleMenu ui = new ConsoleMenu();
    private MainController main =  new MainController();
    private Action[] menu;

    public void start () throws Exception {
        boolean keepApplicationRunning = true;

        ui.displayWelcomeMessage();
        setStartMenu();

        while (keepApplicationRunning) {
            Action choice = ui.getUserRequest(menu);

            switch (choice) {
                case CreateMember:
                    main.createMember();
                    break;
                case ShowMember:
                    main.showMember();
                    setMemberMenu();
                    break;
                case DeleteMember:
                    main.deleteMember();
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
        menu = new Action[] { Action.BackToStart };
    }
}
