package com.boatclub.view;

import java.util.HashMap;
import java.util.Scanner;

public class ConsoleUI {

    private Scanner input = new Scanner(System.in);

    void showText (String text) {
        System.out.println(text);
    }

    int getUserIntInput (String title) {
        System.out.print(title);
        while (!input.hasNextInt()) {
            input.next();
        }

        return input.nextInt();
    }

    float getUserFloatInput (String title) {
        System.out.print(title);
        while (!input.hasNextFloat()) {
            input.next();
        }

        return input.nextFloat();
    }

    String getUserInput (String title) {
        System.out.print(title);
        return input.next();
    }

    <T> T getUserChoice (T[] availableOptions) {
        boolean acceptedInputValue = false;
        int choice = -1;

        // Ask for users choice until they respond with an index that exists in available options
        while (!acceptedInputValue) {
            System.out.print("Choice: ");

            if (input.hasNextInt()) {
                choice = input.nextInt();
                acceptedInputValue = choice >= 0 && choice < availableOptions.length;
            } else {
                input.next();
            }
        }
        System.out.println();

        return availableOptions[choice];
    }

    <T> void displayOptions (T[] availableOptions, HashMap<T, String> optionTitles) {
        System.out.println();
        for (int i = 0 ; i < availableOptions.length; i++) {
            T option = availableOptions[i];

            if (optionTitles.containsKey(option)) {
                String title = i + ". " + optionTitles.get(option);
                System.out.println(title);
            }
        }
        System.out.println();
    }

    String displayUpdateField (String field, String currentValue) {
        String value = currentValue;

        if (displayYesAndNoQuestion("Change " + field +  " (" + value + ")?")) {
            System.out.print("Change to: ");
            value = input.next();
        }
        return value;
    }

    boolean displayYesAndNoQuestion (String question) {
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
}
