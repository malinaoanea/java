package gui;

import database.Data;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Root implements ActionListener {
    Data db;
    public Root(Data db) {
        this.db = db;
        JFrame frame = new JFrame("Easy booking");


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();



        JButton showEvents = new JButton("Show events");
        JButton showClients = new JButton("Show clients");

        showEvents.addActionListener(this);
        showClients.addActionListener(this);
        showEvents.setBounds(100, 100, 200, 40);
        showClients.setBounds(100, 200, 200, 40);
        panel.add(showClients);
        panel.add(showEvents);

        frame.add(panel);


        frame.setMinimumSize(new Dimension(400, 300));
        frame.setSize(new Dimension(800, 600));



        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Data db = new Data();
        db.fetchData();

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Default look and feel.");
            e.printStackTrace();
        }

        new Root(db);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand() == "Show events") {
            EventsTable_new eventsTable_new = new EventsTable_new(this.db);
        } else  {
            ClientsTable clientsTable = new ClientsTable(this.db);
        }
    }
}
