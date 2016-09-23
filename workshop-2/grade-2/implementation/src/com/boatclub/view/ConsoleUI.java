package com.boatclub.view;

import com.boatclub.controller.Action;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

abstract class ConsoleUI {

    protected Scanner input = new Scanner(System.in);
    protected Map<Action, String> actionInstructions = new HashMap<>();

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

    public void waitForContinue () {
        System.out.println();
        System.out.println("Press enter to continue");
        input.hasNextLine();
    }

    private void displayActions (Action[] availableActions) {
        System.out.println();
        for (int i = 0 ; i < availableActions.length; i++) {
            System.out.println(i + ". " + actionInstructions.get(availableActions[i]));
        }
        System.out.println();
    }

}
