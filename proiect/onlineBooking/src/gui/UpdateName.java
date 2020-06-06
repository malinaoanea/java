package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateName {
    public UpdateName() {
    }

    public String getName() {
        JFrame jFrame = new JFrame("Update Name");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(new Dimension(300, 300));

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel eticheta = new JLabel("Insert name");
        JButton button = new JButton("OK");
        JTextField text = new JTextField(20);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jFrame.dispose();
            }
        });

        panel.add(eticheta);
        panel.add(text);
        panel.add(button);

        jFrame.getContentPane().add(panel);
        jFrame.setVisible(true);

        return text.getText();

    }


}
