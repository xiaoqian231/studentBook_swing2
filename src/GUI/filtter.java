package GUI;

import StudentBook.Group;
import StudentBook.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class filtter extends JFrame {
    private JPanel filter;
    private JTable filterResult;
    private JButton ok;
    private JTextField inputField;
    private JButton cancle;
    private JLabel input;
    private Group group;

    public filtter(Group group) {
        this.group = group;

    }

    public filtter(String title) throws HeadlessException {
        super("searchPartial");
        setContentPane(filter);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(400, 300));
        pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
        Student student = new Student();

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] header = {"Name","last Name","status","year of birth","credits","id"};
              ArrayList list= group.searchPartial(inputField.getText());//return arraylist
                DefaultTableModel model = new DefaultTableModel(header, 0);


                ////?????


               // for (int i = 0; i < list.size(); i++) {
                 //   model.addRow(new Object[]{1 + i, list., arrMark[i], grade});
               // }

                JTable table = new JTable(model);
            }
        });


        cancle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtter.super.dispose();
            }
        });
    }
}
