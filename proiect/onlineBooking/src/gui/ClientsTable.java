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

public class ClientsTable {
    JFrame jFrame;
    JPanel tablePanel;
    JPanel events;
    JTextField text;
    JButton newEvent;
    JButton bookEvent;
    JButton deleteClient;
    JButton changeName;
    DefaultTableModel model;
    JTable clientsTable;

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

            model = new DefaultTableModel();

            tablePanel = new JPanel();
            text = new JTextField(10);
            tablePanel.setLayout(new GridLayout(1, 1));
            jFrame.setMinimumSize(new Dimension(500, 300));
            jFrame.setSize(new Dimension(800, 600));

            Object[][] objects = this.getClients(data);
            String[] columns_name = {"id", "Client Name", "CNP"};

//            JTable clientsTable = new JTable(objects, columns_name);
            clientsTable = new JTable();
            clientsTable.setModel(model);

            model.addColumn("id");
            model.addColumn("Client Name");
            model.addColumn("CNP");
            clientsTable.setPreferredSize(new Dimension(350, 500));

            JScrollPane sjp = new JScrollPane(clientsTable);
            tablePanel.add(sjp);

            clientsTable.getColumn(columns_name[0]).setMinWidth(2);
            clientsTable.getColumn(columns_name[1]).setMinWidth(120);
            clientsTable.getColumn(columns_name[2]).setMinWidth(180);

            for (Object[] objects1:objects)
                model.addRow(objects1);
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
                    new AddClient(data, model);
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
                    model.removeRow(row);


                }
            });

            changeName = new JButton("Modify name");
            changeName.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    int row = clientsTable.getSelectedRow();
                    int column = clientsTable.getSelectedColumn();
                    System.out.println(String.valueOf(row) + ", " + String.valueOf(column) + "\n");
                    String newName = "changed";
//                    if (clientsTable.getSelectedRow() > -1) {
//
////                        String id = clientsTable.getValueAt(row, 0).toString();
////                        UpdateName changeName = new UpdateName();
////                        newName = changeName.getName();
////                        System.out.println(newName);
////                        data.updateNameClient(id, newName);
//
//                    }
//                    model.setValueAt(newName, row, column);
                    updateName(data);
//
                }
            });

//            JScrollPane js = new JScrollPane(clientsTable);
//            tablePanel.setLayout(new BorderLayout());
//            tablePanel.add(js, BorderLayout.CENTER);
//            js.setVisible(true);
            jFrame.add(sjp);
//            jFrame.add(js);

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

        private void updateName(Data data) {
            DefaultTableModel model = this.model;

// get selected row index
            int selectedRowIndex = clientsTable.getSelectedRow();

// get selected row data
            String id = model.getValueAt(selectedRowIndex, 0).toString();
            String fname = model.getValueAt(selectedRowIndex, 1).toString();
            String cnp = model.getValueAt(selectedRowIndex, 2).toString();

            // get the entered data
            String NewFullName = JOptionPane.showInputDialog(null,"Enter The New  Name",fname);
            String Newcnp = JOptionPane.showInputDialog(null,"Enter The New CNP",cnp);

            data.updateNameClient(id, NewFullName, Newcnp);

// set the new data into jtable row
            model.setValueAt(NewFullName, selectedRowIndex, 1);
            model.setValueAt(Newcnp, selectedRowIndex, 2);
        }
}




