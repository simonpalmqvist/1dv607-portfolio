package com.boatclub.view;

public class ConsoleBoatClub extends ConsoleUI {

    public enum Action {
        CreateMember,
        ShowMember,
        DeleteMember,
        Exit
    }

    public void displayWelcomeMessage () {
        outputLine("Welcome to the Boat Club");
    }

    public void displayExitMessage () {
        outputLine("Bye Bye");
    }

    public void displayAddedUser () {
        outputLine("New member added");
    }

    public void displayUserNotFound () {
        outputLine("User not found");
    }

    public void displayUserDeleted() {
        outputLine("Deleted member");
    }

    public int getInputMemberId () {
        output("Members ID: ");
        return input.nextInt();
    }

    public String getInputName () {
        output("New members name: ");
        return input.next();
    }

    public String getInputPno () {
        output("New members Personal Number: ");
        return input.next();
    }

    @Override
    protected String actionToMenuTitle(Enum action) {
        String title = "";

        if (action == Action.CreateMember) {
            title = "Create a member";
        }

        if (action == Action.ShowMember) {
            title = "Show a member";
        }

        if (action == Action.DeleteMember) {
            title = "Delete a member";
        }

        if (action == Action.Exit) {
            title = "Quit application";
        }

        return title;
    }
}
