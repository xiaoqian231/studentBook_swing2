package GUI;

import StudentBook.ClassContainer;
import StudentBook.Group;
import StudentBook.Student;
import StudentBook.StudentCondition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.security.PrivateKey;

public class gui extends JFrame  {
    private JPanel PanelMain;
    private JTable TableGroup;
    private JTable JTableStudents;
    private JButton addGroupButton;
    private JButton addStudentButton;
    private JButton filterButton;
    private JButton deleteGroupButton;
    private JButton deleteStudentButton;
    private JButton sortByNameButton;
    private JButton sortByPointButton;


    ClassContainer classContainer = new ClassContainer();
    Group group=new Group();

    private GroupTableModel groupTableModel;
    private StudentTableModel studentTableModel;


    public gui() throws HeadlessException {
        super("Student grade book APP");
        setContentPane(PanelMain);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        groupTableModel = new GroupTableModel(classContainer);
        studentTableModel = new StudentTableModel(group);

        TableGroup.setModel(groupTableModel);
        JTableStudents.setModel(studentTableModel);


        addGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addGroup addGroup= new addGroup("add group");
                TableGroup.updateUI();
            }
        });


        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent addStudent=new addStudent("add student");
                JTableStudents.updateUI();
            }
        });




        sortByNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                group.sortByName();
                JTableStudents.updateUI();
            }
        });


        sortByPointButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                group.sortByPoints();
                JTableStudents.updateUI();
            }
        });


        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtter filtter=new filtter("filter");
            }
        });
    }

    private void createUIComponents(){
        TableGroup=new JTableStudents();
        JTableStudents=new JTableStudents();
    }

}
