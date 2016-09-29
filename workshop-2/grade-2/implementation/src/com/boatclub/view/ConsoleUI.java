package com.boatclub.view;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ConsoleUI {

    private Scanner input = new Scanner(System.in);

    void showText (String text) {
        System.out.println(text);
    }

    void showRow (String format, Object ...args) {
        System.out.format(format, args);
    }

    int getUserIntInput (String title) {
        printInputTitle(title);
        while (!input.hasNextInt()) {
            input.next();
            printInputTitle("Wrong format, try again");
        }

        return input.nextInt();
    }

    float getUserFloatInput (String title) {
        printInputTitle(title);
        while (!input.hasNextFloat()) {
            input.next();
            printInputTitle("Wrong format, try again");
        }

        return input.nextFloat();
    }

    String getUserPatternInput (String title, Pattern pattern) {
        printInputTitle(title);
        while (!input.hasNext(pattern)) {
            input.next();
            printInputTitle("Wrong format, try again");
        }

        return input.next();
    }

    String getUserInput (String title) {
        printInputTitle(title);
        return input.next();
    }

    <T> T getUserChoice (T[] availableOptions) {
        int choice = 0;

        // Ask for users choice until they respond with an index that exists in available options
        while (!isValidChoice(choice, availableOptions.length)) {
            printInputTitle("Choice");

            if (input.hasNextInt()) {
                choice = input.nextInt();
            } else {
                input.next();
            }
        }
        System.out.println();

        return availableOptions[choiceToIndex(choice)];
    }

    <T> void displayOptions (T[] availableOptions, HashMap<T, String> optionTitles) {
        System.out.println();
        for (int i = 0 ; i < availableOptions.length; i++) {
            T option = availableOptions[i];

            if (optionTitles.containsKey(option)) {
                String title = indexToChoice(i) + ". " + optionTitles.get(option);
                System.out.println(title);
            }
        }
        System.out.println();
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

    private void printInputTitle (String title) {
        System.out.print(title + ": ");
    }

    private int choiceToIndex (int choice) {
        return choice - 1;
    }

    private int indexToChoice (int index) {
        return index + 1;
    }

    private boolean isValidChoice (int choice, int numberOfChoices) {
        return choice > 0 && choice <= numberOfChoices;
    }
}
