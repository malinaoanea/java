package gui;

import database.Data;

import javax.swing.*;
import java.awt.*;

public class Root extends JFrame {
    public Root(Data db) {
        super("Job Platform Manager");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();
//        tabbedPane.addTab("Companies", new CompaniesPanel(db));

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
            System.err.println("Unable to use Metal cross-platform L&F, falling back to default");
            e.printStackTrace();
        }

        new Root(db);
    }
}
