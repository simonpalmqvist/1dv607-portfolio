package com.boatclub.view;

public class ConsoleMember extends ConsoleUI {

    public void display (String name, String pno, int id) {
        System.out.println("--------------------------");
        System.out.println("Name: " + name);
        System.out.println("Personal number: " + pno);
        System.out.println("ID: " + id);
        System.out.println("--------------------------");
    }

    public String displayUpdateName (String currentName) {
        String name = currentName;

        if (displayYesAndNoQuestion("Change name (" + currentName + ")?")) {
            System.out.print("Change to: ");
            name = input.next();
        }

        return name;
    }

    public String displayUpdatePno (String currentPno) {
        String pno = currentPno;

        if (displayYesAndNoQuestion("Change personal number (" + currentPno + ")?")) {
            System.out.print("Change to: ");
            pno = input.next();
        }

        return pno;
    }
}
