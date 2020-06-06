package gui;

import database.Data;
import event.Event;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.IllegalCharsetNameException;
import java.util.ArrayList;

import static javax.swing.JOptionPane.*;

public class EventsTable{
    JTable eventsTable;
    DefaultTableModel model;

    private Object[][] getEvent(Data data) {
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

    public EventsTable(Data data)  {
        JFrame jFrame = new JFrame("Events");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1, 1, 0));
        jFrame.setMinimumSize(new Dimension(400, 300));
        jFrame.setSize(new Dimension(800, 600));


        Object[][] objects = this.getEvent(data);
        model = new DefaultTableModel();

        String[] columns_name = {"id", "Event name"};
        JTable eventsTable = new JTable();
        eventsTable.setModel(model);

        model.addColumn("id");
        model.addColumn("Event name");


        for (Object[] objects1:objects)
            model.addRow(objects1);

        eventsTable.getColumn(columns_name[0]).setMinWidth(200);
        eventsTable.getColumn(columns_name[1]).setMinWidth(80);

        eventsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                int row = eventsTable.getSelectedRow();
                int column = eventsTable.getSelectedColumn();
                System.out.println(String.valueOf(row) + ", " + String.valueOf(column) + "\n");
                if (eventsTable.getSelectedRow() > -1) {
                    // print first column value from selected row
//                    System.out.println(eventsTable.getValueAt(row,1));
//                    System.out.println(eventsTable.getValueAt(eventsTable.getSelectedRow(), 1), 0).toString());
                    String eventName = eventsTable.getValueAt(row,1).toString();
                    BookingFrame bookie = new BookingFrame(  data, eventName);
                    bookie.getButtonOK().addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent e)
                        {
                            System.out.println();
//                            System.out.println();
                            String location = bookie.getSelectedButtonText(bookie.getGroup());
                            int n_tickets = Integer.valueOf(bookie.getTickets().getText());
                            data.bookEventLocation(eventName, location, n_tickets);

                        }
                    });
                }
            }
        });



        panel.add(eventsTable);
        jFrame.add(panel);
        jFrame.setVisible(true);
    }


}


