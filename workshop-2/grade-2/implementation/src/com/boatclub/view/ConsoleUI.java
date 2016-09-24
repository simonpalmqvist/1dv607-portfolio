package com.boatclub.view;

import java.util.Scanner;

abstract class ConsoleUI {

    protected Scanner input = new Scanner(System.in);


    protected void output (String toBeDisplayed) {
        System.out.print(toBeDisplayed);
    }

    protected void outputLine (String toBeDisplayed) {
        System.out.println(toBeDisplayed);
    }

    protected void outputEmptyLine () {
        System.out.println();
    }

    protected boolean displayYesAndNoQuestion (String question) {
        boolean acceptedInputValue = false;
        boolean result = false;

        while (!acceptedInputValue) {
            output(question + " [Y/N]");
            String answer = input.next().toLowerCase();

            if (answer.equals("y") || answer.equals("n")) {
                result = answer.equals("y");
                acceptedInputValue = true;
            }
        }

        return result;
    }

    public Enum getUserRequest (Enum[] availableActions) {
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

    private void displayMenu(Enum[] availableActions) {
        System.out.println();
        for (int i = 0 ; i < availableActions.length; i++) {
            displayMenuOption(i, availableActions[i]);
        }
        System.out.println();
    }

    private void displayMenuOption (int position, Enum action) {
        String title = actionToMenuTitle(action);

        if (!title.isEmpty()) {
            title = position + ". " + title;
            System.out.println(title);
        }
    }

    protected abstract String actionToMenuTitle (Enum action);
}
