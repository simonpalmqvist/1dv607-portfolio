package com.boatclub.view;

public class ConsoleMember extends ConsoleUI {

    public enum Action {
        Update,
        Back
    }

    public void display (String name, String pno, int id) {
        outputLine("--------------------------");
        outputLine("Name: " + name);
        outputLine("Personal number: " + pno);
        outputLine("ID: " + id);
        outputLine("--------------------------");
    }

    public String displayUpdateName (String currentName) {
        return displayUpdateField("name", currentName);
    }

    public String displayUpdatePno (String currentPno) {
        return displayUpdateField("personal number", currentPno);
    }

    private String displayUpdateField (String field, String currentValue) {
        String value = currentValue;

        if (displayYesAndNoQuestion("Change " + field +  " (" + value + ")?")) {
            output("Change to: ");
            value = input.next();
        }

        return value;
    }

    @Override
    protected String actionToMenuTitle(Enum action) {
        String title = "";

        if (action == Action.Update) {
            title = "Change member";
        }

        if (action == Action.Back) {
            title = "Back";
        }

        return title;
    }
}
