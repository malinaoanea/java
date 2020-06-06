package gui;

import database.Data;
import location.Location;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.BatchUpdateException;
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
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
            }
        });
        panou.add(eticheta);
        panou.add(text);
        panou.add(buttonOK);
        tickets = text;
        return panou;
    }

    public void adauga(Component comp, int x, int y, int w, int h,GridBagConstraints gbcons, JFrame frame, GridBagLayout gridBag ) { gbcons.gridx = x;
        gbcons.gridy = y;
        gbcons.gridwidth = w;
        gbcons.gridheight = h; gridBag.setConstraints(comp, gbcons); frame.add(comp);
    }

    public BookingFrame(Data data) {
        frame = new JFrame("Book event for client");
        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints gbcons = new GridBagConstraints();



        gbcons.weightx = 1.0;
        gbcons.weighty = 1.0;

        gbcons.insets = new Insets(5, 5, 5, 5);
        frame.setLayout(gridBag);
        JLabel lblLogin = new JLabel("Booking event", JLabel.CENTER);
        lblLogin.setFont(new Font(" Arial ", Font.BOLD, 24));
        gbcons.fill = GridBagConstraints.BOTH;
        adauga(lblLogin, 0, 0, 4, 2, gbcons, frame, gridBag);

        JLabel lblNume = new JLabel("Nume client:");
        gbcons.fill = GridBagConstraints.NONE;
        gbcons.anchor = GridBagConstraints.EAST;
        adauga(lblNume, 0, 2, 1, 1, gbcons, frame, gridBag);

        JLabel lblCnp = new JLabel("CNP:");
        adauga(lblCnp, 0, 3, 1, 1, gbcons, frame, gridBag);

        JTextField txtUtilizator = new JTextField("", 30);
        gbcons.fill = GridBagConstraints.HORIZONTAL;
        gbcons.anchor = GridBagConstraints.CENTER;
        adauga(txtUtilizator, 1, 2, 2, 1, gbcons, frame, gridBag);

        JTextField txtCNP = new JTextField("", 30);
        adauga(txtCNP, 1, 3, 2, 1, gbcons, frame, gridBag);

        //
        JLabel lblEvent = new JLabel("Event name:");
        gbcons.fill = GridBagConstraints.NONE;
        gbcons.anchor = GridBagConstraints.EAST;
        adauga(lblEvent, 0, 2, 1, 2, gbcons, frame, gridBag);

        JLabel lblLocation = new JLabel("Location:");
        adauga(lblLocation, 0, 3, 1, 2, gbcons, frame, gridBag);

        JTextField txtEvent = new JTextField("", 30);
        gbcons.fill = GridBagConstraints.HORIZONTAL;
        gbcons.anchor = GridBagConstraints.CENTER;
        adauga(txtEvent, 2, 2, 3, 2, gbcons, frame, gridBag);

        JTextField txtLocation = new JTextField("", 30);
        adauga(txtLocation, 1, 3, 2, 2, gbcons, frame, gridBag);
        //

        JButton btnSalvare = new JButton(" Book ");
        gbcons.fill = GridBagConstraints.HORIZONTAL;
        adauga(btnSalvare, 1, 4, 2, 1, gbcons, frame, gridBag);

        btnSalvare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
//                data.addClient(txtUtilizator.getText(), txtCNP.getText());
//                System.out.println(txtUtilizator.getText() + txtCNP.getText());
                System.out.println(txtUtilizator.getText() + " " + txtCNP.getText()  + txtLocation.getText());
                data.clientBuys(txtUtilizator.getText(), txtCNP.getText(), txtEvent.getText(), txtLocation.getText());
//                frame.dispose();
            }
        });



        JButton btnIesire = new JButton(" Exit ");
        adauga(btnIesire, 2, 4, 1, 1, gbcons, frame, gridBag);

        btnIesire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
            }
        });

        frame.setSize(new Dimension(300, 300));
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
//        data.addClient(txtUtilizator.getText(), txtCNP.getText());
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
