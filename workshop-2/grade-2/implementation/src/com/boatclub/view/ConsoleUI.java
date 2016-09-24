package com.boatclub.view;

import java.util.Objects;
import java.util.Scanner;

abstract class ConsoleUI {

    protected Scanner input = new Scanner(System.in);

    protected boolean displayYesAndNoQuestion (String question) {
        boolean acceptedInputValue = false;
        boolean result = false;

        while (!acceptedInputValue) {
            System.out.print(question + " [Y/N]");
            String answer = input.next().toLowerCase();

            if (answer.equals("y") || answer.equals("n")) {
                result = answer.equals("y");
                acceptedInputValue = true;
            }
        }

        return result;
    }

    public void waitForContinue () {
        System.out.println();
        System.out.println("Press enter to continue");
        input.hasNextLine();
    }
}
