package gui;

import database.Data;

import javax.swing.*;
import java.awt.*;

public class Root extends JFrame {
    public Root(Data db) {
        super("Easy booking");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        setContentPane(tabbedPane);

        setMinimumSize(new Dimension(400, 300));
        setSize(new Dimension(800, 600));

        setVisible(true);
    }

    public static void main(String[] args) {
        Data db = new Data();

        // Use the Metal look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Default look and feel.");
            e.printStackTrace();
        }

        new Root(db);
    }
}
