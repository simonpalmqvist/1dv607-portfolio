package com.boatclub.view;

import com.boatclub.controller.Action;

public class ConsoleMenu extends ConsoleUI {

    public void displayWelcomeMessage () {
        System.out.println("Welcome to the Boat Club");
    }

    public void displayExitMessage () {
        System.out.println("Bye Bye");
    }

    public Action getUserRequest (Action[] availableActions) {
        boolean acceptedInputValue = false;
        int choice = 0;

        displayActions(availableActions);

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

    private void displayActions (Action[] availableActions) {
        System.out.println();
        for (int i = 0 ; i < availableActions.length; i++) {
            System.out.println( actionToMenuTitle(i, availableActions[i]) );
        }
        System.out.println();
    }

    private String actionToMenuTitle (int position , Action action) {
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
            case BackToStart:
                title += "Back";
                break;
            case Exit:
                title += "Quit application";
                break;
            default:
                title += "Not found";
        }

        return title;
    }
}
