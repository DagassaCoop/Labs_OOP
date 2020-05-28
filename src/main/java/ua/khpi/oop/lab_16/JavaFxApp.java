package ua.khpi.oop.lab_16;

import ua.khpi.oop.lab_16.view.MainWindow;

/**
 * Entry point of application.
 */
public class JavaFxApp {
    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        mainWindow.go(args);
    }
}
