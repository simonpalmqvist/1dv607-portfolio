package com.boatclub.view;

import java.util.Scanner;

abstract class ConsoleUI {

    protected Scanner input = new Scanner(System.in);

    public void waitForContinue () {
        System.out.println();
        System.out.println("Press enter to continue");
        input.hasNextLine();
    }
}
