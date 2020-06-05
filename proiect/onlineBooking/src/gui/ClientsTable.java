package gui;

import client.Person;
import database.Data;
import event.Event;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClientsTable {
    JFrame jFrame;
    JPanel tablePanel;
    JPanel events;
    JTextField text;
    JButton newEvent;
    JButton bookEvent;
    JButton deleteClient;
    JButton changeName;

    private Object[][] getClients(Data data) {
            ArrayList<Person> clients = data.getPeople();
            int n_events = clients.size();

            Object[][] objects = new Object[n_events][3];
            int i = 0;
            for (Person person:clients) {
                objects[i][0] = person.getId();
                objects[i][1] = person.getName();
                objects[i][2] = person.getCNP();
                i+=1;
            }

            return objects;
        }


        public ClientsTable(Data data)  {
            jFrame = new JFrame("Clients");
            jFrame.getContentPane().setLayout(new FlowLayout());

            tablePanel = new JPanel();
            text = new JTextField(10);
            tablePanel.setLayout(new GridLayout(1, 1));
            jFrame.setMinimumSize(new Dimension(500, 300));
            jFrame.setSize(new Dimension(800, 600));

            Object[][] objects = this.getClients(data);

            String[] columns_name = {"id", "Client name", "CNP"};
            JTable clientsTable = new JTable(objects, columns_name);

            clientsTable.getColumn(columns_name[0]).setMinWidth(3);
            clientsTable.getColumn(columns_name[1]).setMinWidth(200);
            clientsTable.getColumn(columns_name[2]).setMinWidth(80);
            JPanel jPanel = new JPanel();
            String name = "";
            clientsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent event) {
                    int row = clientsTable.getSelectedRow();
                    int column = clientsTable.getSelectedColumn();
                    System.out.println(String.valueOf(row) + ", " + String.valueOf(column) + "\n");
                    if (clientsTable.getSelectedRow() > -1) {

                        String Name = clientsTable.getValueAt(row,1).toString();
                        String cnp = clientsTable.getValueAt(row, 2).toString();
                        String attendingEvenets = data.showEventsForClient(Name, cnp);
                        text.setText(attendingEvenets);
//                        newEvent = new JButton("Buy ticket for a new event.");
//                        jPanel.add(newEvent);

                    }
                }
            });
            System.out.println(name);
            JButton b=new JButton("Add client");
            b.setBounds(300,100,140, 40);
            b.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    new AddClient(data);
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

            deleteClient = new JButton("Delete Client");
            deleteClient.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    int row = clientsTable.getSelectedRow();
                    int column = clientsTable.getSelectedColumn();
                    System.out.println(String.valueOf(row) + ", " + String.valueOf(column) + "\n");
                    if (clientsTable.getSelectedRow() > -1) {

                        String id = clientsTable.getValueAt(row, 0).toString();
                        data.deleteClient(id);
//                        text.setText(attendingEvenets);
//                        newEvent = new JButton("Buy ticket for a new event.");
//                        jPanel.add(newEvent);
                    }
                }
            });

            changeName = new JButton("Modify name");
            changeName.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    int row = clientsTable.getSelectedRow();
                    int column = clientsTable.getSelectedColumn();
                    System.out.println(String.valueOf(row) + ", " + String.valueOf(column) + "\n");
                    if (clientsTable.getSelectedRow() > -1) {

                        String id = clientsTable.getValueAt(row, 0).toString();
                        data.updateNameClient(id, "schimbat");
                    }
                }
            });
            jFrame.add(changeName);
            jFrame.add(deleteClient);
            jFrame.add(bookEvent);
            jFrame.add(b);
            jFrame.add(jPanel);
            tablePanel.add(text, BorderLayout.PAGE_END);
            tablePanel.add(clientsTable);
            jFrame.add(tablePanel);
            jFrame.setVisible(true);
        }



}
