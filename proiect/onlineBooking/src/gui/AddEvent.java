package gui;

import database.Data;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEvent {
    private JFrame frame;
    public void adauga(Component comp, int x, int y, int w, int h, GridBagConstraints gbcons, JFrame frame, GridBagLayout gridBag ) { gbcons.gridx = x;
        gbcons.gridy = y;
        gbcons.gridwidth = w;
        gbcons.gridheight = h; gridBag.setConstraints(comp, gbcons); frame.add(comp);
    }

    public AddEvent(Data data, DefaultTableModel model) {

        frame = new JFrame("Add event");
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

        JLabel lblName = new JLabel("Event name:");
        gbcons.fill = GridBagConstraints.NONE;
        gbcons.anchor = GridBagConstraints.EAST;
        adauga(lblName, 0, 2, 1, 1, gbcons, frame, gridBag);

        JLabel lblLoc = new JLabel("Event location:");
        adauga(lblLoc, 0, 3, 1, 1, gbcons, frame, gridBag);

        JTextField txtNume = new JTextField("", 30);
        gbcons.fill = GridBagConstraints.HORIZONTAL;
        gbcons.anchor = GridBagConstraints.CENTER;
        adauga(txtNume, 1, 2, 2, 1, gbcons, frame, gridBag);

        JTextField txtLoc = new JTextField("", 30);
        adauga(txtLoc, 1, 3, 2, 1, gbcons, frame, gridBag);

        //
        JLabel lblDate = new JLabel("Date:");
        gbcons.fill = GridBagConstraints.NONE;
        gbcons.anchor = GridBagConstraints.EAST;
        adauga(lblDate, 0, 2, 1, 2, gbcons, frame, gridBag);

        JLabel lblType = new JLabel("Type:");
        adauga(lblType, 0, 3, 1, 2, gbcons, frame, gridBag);

        JTextField txtDate = new JTextField("", 30);
        gbcons.fill = GridBagConstraints.HORIZONTAL;
        gbcons.anchor = GridBagConstraints.CENTER;
        adauga(txtDate, 2, 2, 3, 2, gbcons, frame, gridBag);

        JTextField txtType = new JTextField("", 30);
        adauga(txtType, 1, 3, 2, 2, gbcons, frame, gridBag);
        //

        JButton btnSalvare = new JButton(" Book ");
        gbcons.fill = GridBagConstraints.HORIZONTAL;
        adauga(btnSalvare, 1, 4, 2, 1, gbcons, frame, gridBag);

        btnSalvare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
//                data.addClient(txtUtilizator.getText(), txtCNP.getText());
//                System.out.println(txtUtilizator.getText() + txtCNP.getText());
//                System.out.println(txtUtilizator.getText() + " " + txtCNP.getText()  + txtLocation.getText());
//                System.out.println(txtNume.getText() + " " +  txtDate.getText() +" " + txtLoc.getText() +" " + txtType.getText());
                data.addEvent(txtNume.getText(), txtDate.getText(), txtLoc.getText(), txtType.getText());
                model.addRow(new Object[]{data.getNewIdEv(), txtNume.getText()});
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

    }
}
