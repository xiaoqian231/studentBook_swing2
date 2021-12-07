package GUI;

import StudentBook.ClassContainer;
import StudentBook.Group;
import StudentBook.Student;
import StudentBook.StudentCondition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addStudent extends JFrame{
    private JPanel addStudent;
    private JTextField stuNameTextField;
    private JTextField stuYearBirthTextField;
    private JTextField stuLastNameTextField;
    private JTextField stuCreditsTextField;
    private JTextField stuIDTextField;
    private JButton submitButton;
    private JButton cancelButton;
    private JComboBox StuStatus;
    private Group aGroup;
    public addStudent(Group group) {
        this.aGroup = aGroup;
    }

    public addStudent(String title) throws HeadlessException {
        super("Add student");
        setContentPane(addStudent);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(400, 300));
        pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
        Student student=new Student();

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               addStudent.super.dispose();
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String StuName=stuNameTextField.getText();
                String StuLastName=stuLastNameTextField.getText();
                int Year=Integer.parseInt(stuYearBirthTextField.getText());
                double Credits=Double.parseDouble(stuCreditsTextField.getText());
                int id = Integer.parseInt(stuIDTextField.getText());
                StudentCondition Condition=(StudentCondition)StuStatus.getSelectedItem();
                student.setName(StuName);
                student.setLastName(StuLastName);
                student.setYearOfBirth(Year);
                student.setNumberOfCredits(Credits);
                student.setId(id);
                student.setStatus(Condition);
                aGroup.addStudent(student);
                JOptionPane.showMessageDialog(null, "add successfully!", "Information", JOptionPane.PLAIN_MESSAGE);
                addStudent.super.dispose();

            }
        });
    }


}
