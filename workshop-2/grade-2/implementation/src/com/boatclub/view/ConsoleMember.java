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
        String name = currentName;

        if (displayYesAndNoQuestion("Change name (" + currentName + ")?")) {
            output("Change to: ");
            name = input.next();
        }

        return name;
    }

    public String displayUpdatePno (String currentPno) {
        String pno = currentPno;

        if (displayYesAndNoQuestion("Change personal number (" + currentPno + ")?")) {
            output("Change to: ");
            pno = input.next();
        }

        return pno;
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
