package com.boatclub;

import com.boatclub.controller.User;
import com.boatclub.view.ConsoleUI;

public class Main {

    public static void main(String[] args) {
        ConsoleUI ui = new ConsoleUI();
        User user = new User(ui);

        try {
            user.start();
        } catch (Exception error) {
            System.out.println("Application crashed with error: " + error.getMessage());
        }
    }
}
