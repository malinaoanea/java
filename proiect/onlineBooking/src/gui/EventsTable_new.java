package gui;

import client.Person;
import database.Data;
import event.Event;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class EventsTable_new {
    JFrame jFrame;
    JPanel tablePanel;
    JPanel events;
    JTextField text;
    JButton newEvent;
    JButton bookEvent;
    JButton deleteClient;
    DefaultTableModel model;
    JTable eventsTable;

    private Object[][] getEvents(Data data) {
        ArrayList<Event> events = data.getEvents();
        int n_events = events.size();

        Object[][] objects = new Object[n_events][2];
        int i = 0;
        for (Event event:events) {
            objects[i][0] = event.getId();
            objects[i][1] = event.getName();
            i+=1;
        }

        return objects;
    }


    public EventsTable_new(Data data)  {
        jFrame = new JFrame("Events");
        jFrame.getContentPane().setLayout(new FlowLayout());

        model = new DefaultTableModel();

        tablePanel = new JPanel();
        text = new JTextField(0);
        tablePanel.setLayout(new GridLayout(1, 1));
        jFrame.setMinimumSize(new Dimension(500, 300));
        jFrame.setSize(new Dimension(800, 600));

        Object[][] objects = this.getEvents(data);
        String[] columns_name = {"id", "Event Name"};

//            JTable clientsTable = new JTable(objects, columns_name);
        eventsTable = new JTable();
        eventsTable.setModel(model);

        model.addColumn("id");
        model.addColumn("Event Name");
        eventsTable.setPreferredSize(new Dimension(500, 500));


        eventsTable.getColumn(columns_name[0]).setMinWidth(2);
        eventsTable.getColumn(columns_name[1]).setMinWidth(120);

        for (Object[] objects1:objects)
            model.addRow(objects1);
        JPanel jPanel = new JPanel();
        String name = "";


        System.out.println(name);
        JButton b=new JButton("Add events");
        b.setBounds(300,100,140, 40);
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new AddEvent(data, model);

            }


        });
        bookEvent = new JButton("Book event");
        bookEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
//                    new EventBookingClient(data);
                new BookingFrame(data);

            }
        });

        deleteClient = new JButton("Delete event");
        deleteClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int row = eventsTable.getSelectedRow();
                int column = eventsTable.getSelectedColumn();
                System.out.println(String.valueOf(row) + ", " + String.valueOf(column) + "\n");
                if (eventsTable.getSelectedRow() > -1) {

                    String id = eventsTable.getValueAt(row, 0).toString();
                    data.deleteEvent(id);
                }
                model.removeRow(row);


            }
        });




        jFrame.add(deleteClient);
        jFrame.add(bookEvent);
        jFrame.add(b);
        jFrame.add(jPanel);
        tablePanel.add(text, BorderLayout.PAGE_END);
        tablePanel.add(eventsTable);
        jFrame.add(tablePanel);
        jFrame.setVisible(true);
    }

    private void updateName(Data data) {
        DefaultTableModel model = this.model;

        int selectedRowIndex = eventsTable.getSelectedRow();

        String id = model.getValueAt(selectedRowIndex, 0).toString();
        String fname = model.getValueAt(selectedRowIndex, 1).toString();
        String cnp = model.getValueAt(selectedRowIndex, 2).toString();

        String NewFullName = JOptionPane.showInputDialog(null,"Enter The New  Name",fname);
        String Newcnp = JOptionPane.showInputDialog(null,"Enter The New CNP",cnp);

        data.updateNameClient(id, NewFullName, Newcnp);

        model.setValueAt(NewFullName, selectedRowIndex, 1);
        model.setValueAt(Newcnp, selectedRowIndex, 2);
    }
}




