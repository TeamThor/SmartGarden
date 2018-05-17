package com.company;

import com.company.menu.MainMenu;

public class Main {

    public static void main(String[] args) {
        Application app = new Application();
        MainMenu menu = new MainMenu(app);
        menu.displayMenu();
    }
}

