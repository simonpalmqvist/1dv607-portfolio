package com.boatclub.view;

import com.boatclub.controller.Action;

public class ConsoleMain extends ConsoleUI {

    public ConsoleMain() {
        actionInstructions.put(Action.CreateMember, "Create member");
        actionInstructions.put(Action.ShowMember, "Show member");
        actionInstructions.put(Action.DeleteMember, "Delete member");
        actionInstructions.put(Action.Exit, "Quit application");
    }

    public void displayStartupInformation () {
        System.out.println("Welcome to the Boat Club");
    }

    public void displayAddedUser () {
        System.out.println("New member added");
    }

    public void displayExitMessage () {
        System.out.println("ByeBye");
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
