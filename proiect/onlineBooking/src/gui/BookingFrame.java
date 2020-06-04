package gui;

import database.Data;
import location.Location;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class BookingFrame {
    JFrame frame;
    ButtonGroup group;
    JButton buttonOK;
    JTextField tickets;

    public ButtonGroup getGroup(){
        return group;
    }

    public JTextField getTickets() {
        return tickets;
    }

    public JButton getButtonOK(){
        return  buttonOK;
    }

    public JPanel choosingTickts( String location) {
        JPanel panou = new JPanel(); panou.setLayout(new FlowLayout());
        JLabel eticheta = new JLabel("Insert number of ticktes:");
        buttonOK = new JButton("OK");
        JTextField text = new JTextField(2);
        panou.add(eticheta);
        panou.add(text);
        panou.add(buttonOK);
        tickets = text;
        return panou;
    }


    public BookingFrame(Data data, String eventName) {
        // when pressing close, it will not stop the app
        frame = new JFrame("Book event");

        frame.setSize(new Dimension(300, 300));

        JPanel topPanel = (JPanel) frame.getContentPane();
        topPanel.setLayout(new FlowLayout());
//        topPanel.add(radio)

        // creates the radio buttons for choosing from the available locations.
        JPanel radioPanel = new JPanel(new FlowLayout());
        radioPanel.setPreferredSize(new Dimension(150, 200));
        TitledBorder border = BorderFactory.createTitledBorder("Available locations:");

        radioPanel.setBorder(border);
        topPanel.add(radioPanel);
        topPanel.setPreferredSize(new Dimension(200, 400));


        Location[] locations = data.showLocationForEvent(eventName);
        JRadioButton[] radioButtons = new JRadioButton[locations.length];
        int i = 0;
        group = new ButtonGroup();
//
        for (Location location:locations) {
            if (location != null) {
                radioButtons[i] = new JRadioButton(location.getName());
                radioPanel.add(radioButtons[i]);
                group.add(radioButtons[i]);
                i+=1;
            }
            else break;;
        }


        frame.add(radioPanel);

        frame.add(this.choosingTickts( this.getSelectedButtonText(group) ));
        frame.setVisible(true);

    }

    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration buttons = buttonGroup.getElements();
             buttons.hasMoreElements();) {
            AbstractButton button = (AbstractButton) buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }


}
