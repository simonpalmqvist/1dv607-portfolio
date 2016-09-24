package com.boatclub.view;

import com.boatclub.controller.Router;

public class ConsoleMenu extends ConsoleUI {

    public void displayWelcomeMessage () {
        System.out.println("Welcome to the Boat Club");
    }

    public void displayExitMessage () {
        System.out.println("Bye Bye");
    }

    public Router.Action getUserRequest (Router.Action[] availableActions) {
        boolean acceptedInputValue = false;
        int choice = 0;

        displayMenu(availableActions);

        while (!acceptedInputValue) {
            System.out.print("Action: ");
            if (input.hasNextInt()) {
                choice = input.nextInt();
                acceptedInputValue = choice >= 0 && choice < availableActions.length;
            } else {
                input.next();
            }
        }
        System.out.println();

        return availableActions[choice];
    }

    private void displayMenu(Router.Action[] availableActions) {
        System.out.println();
        for (int i = 0 ; i < availableActions.length; i++) {
            displayMenuOption(i, availableActions[i]);
        }
        System.out.println();
    }

    private void displayMenuOption (int position , Router.Action action) {
        String title = position + ". ";

        switch (action) {
            case CreateMember:
                title += "Create a member";
                break;
            case ShowMember:
                title += "Show a member";
                break;
            case DeleteMember:
                title += "Delete a member";
                break;
            case UpdateMember:
                title += "Change member";
                break;
            case BackToStart:
                title += "Back";
                break;
            case Exit:
                title += "Quit application";
                break;
            default:
                title = "";
        }

        if (!title.isEmpty()) {
            System.out.println(title);
        }
    }
}
