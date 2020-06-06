package gui;

import database.Data;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddClient {
    public void adauga(Component comp, int x, int y, int w, int h,GridBagConstraints gbcons, JFrame frame, GridBagLayout gridBag ) { gbcons.gridx = x;
        gbcons.gridy = y;
        gbcons.gridwidth = w;
        gbcons.gridheight = h; gridBag.setConstraints(comp, gbcons); frame.add(comp);
    }

    public AddClient(Data data, DefaultTableModel model) {
        JFrame addClient = new JFrame("Add client");
        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints gbcons = new GridBagConstraints();

        gbcons.weightx = 1.0;
        gbcons.weighty = 1.0;

        gbcons.insets = new Insets(5, 5, 5, 5);
        addClient.setLayout(gridBag);
        JLabel lblLogin = new JLabel("Adding client", JLabel.CENTER);
        lblLogin.setFont(new Font(" Arial ", Font.BOLD, 24));
        gbcons.fill = GridBagConstraints.BOTH;
        adauga(lblLogin, 0, 0, 4, 2, gbcons, addClient, gridBag);

        JLabel lblNume = new JLabel("Nume client:");
        gbcons.fill = GridBagConstraints.NONE;
        gbcons.anchor = GridBagConstraints.EAST;
        adauga(lblNume, 0, 2, 1, 1, gbcons, addClient, gridBag);

        JLabel lblCnp = new JLabel("CNP:");
        adauga(lblCnp, 0, 3, 1, 1, gbcons, addClient, gridBag);

        JTextField txtUtilizator = new JTextField("", 30);
        gbcons.fill = GridBagConstraints.HORIZONTAL;
        gbcons.anchor = GridBagConstraints.CENTER;
        adauga(txtUtilizator, 1, 2, 2, 1, gbcons, addClient, gridBag);

        JTextField txtCNP = new JTextField("", 30);
        adauga(txtCNP, 1, 3, 2, 1, gbcons, addClient, gridBag);

        JButton btnSalvare = new JButton(" Salvare ");
        gbcons.fill = GridBagConstraints.HORIZONTAL;
        adauga(btnSalvare, 1, 4, 1, 1, gbcons, addClient, gridBag);

        btnSalvare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                data.addClient(txtUtilizator.getText(), txtCNP.getText());
                model.addRow(new Object[]{data.getNewId() ,txtUtilizator.getText(), txtCNP.getText()});
            }
        });



        JButton btnIesire = new JButton(" Iesire ");
        adauga(btnIesire, 2, 4, 1, 1, gbcons, addClient, gridBag);

        btnIesire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addClient.dispose();
            }
        });

        addClient.setSize(new Dimension(300, 300));
        addClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addClient.setVisible(true);
        data.addClient(txtUtilizator.getText(), txtCNP.getText());
//        table

    }
}
