package GUI;

import StudentBook.ClassContainer;
import StudentBook.Group;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addGroup extends JFrame {
    private JTextField TextGroupName;
    private JTextField TextCapacity;
    private JPanel PanelAddGroup;
    private JButton submitButton;
    private JButton cancelButton;
    private ClassContainer classContainer;
    public addGroup(ClassContainer classContainer) {
        this.classContainer = classContainer;
    }


    public addGroup(String title) throws HeadlessException {
        // prepare frame
        super("Add group");
        setContentPane(PanelAddGroup);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(200, 200));
        pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);





        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String groupName = TextGroupName.getText();
               int capacity = Integer.parseInt(TextCapacity.getText());
                classContainer.addClass(groupName,capacity);
                JOptionPane.showMessageDialog(null, "add successfully!", "Information", JOptionPane.PLAIN_MESSAGE);
              // addGroup.super.dispose();

            }
        });


        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addGroup.super.dispose();
            }
        });
    }
}
