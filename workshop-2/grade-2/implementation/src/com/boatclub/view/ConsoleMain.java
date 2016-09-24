package com.boatclub.view;

public class ConsoleMain extends ConsoleUI {

    public void displayAddedUser () {
        System.out.println("New member added");
    }

    public int getInputMemberId () {
        System.out.print("Members ID: ");
        return input.nextInt();
    }

    public String getInputName () {
        System.out.print("New members name: ");
        return input.next();
    }

    public String getInputPno () {
        System.out.print("New members Personal Number: ");
        return input.next();
    }
}
