package GUI;

import StudentBook.ClassContainer;
import StudentBook.Group;
import StudentBook.Student;
import StudentBook.StudentCondition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.security.PrivateKey;

public class gui extends JFrame {
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
    Group group = new Group();

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

                addGroup addGroup = new addGroup("add group", classContainer);
                TableGroup.updateUI();
                System.out.println("output at gui");
            }
        });


        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = TableGroup.getSelectedRow();
                addStudent addStudent = new addStudent("add student", classContainer, index);
                JTableStudents.updateUI();
            }
        });


        sortByNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = TableGroup.getSelectedRow();
                classContainer.getClassByID(index).sortByName();
                JTableStudents.updateUI();
            }
        });


        sortByPointButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = TableGroup.getSelectedRow();
                classContainer.getClassByID(index).sortByPoints();
                JTableStudents.updateUI();
            }
        });


        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtter filtter = new filtter("filter");
            }
        });
        TableGroup.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = TableGroup.getSelectedRow();
                if (groupTableModel.getRowCount() > index && index != -1) {
                    studentTableModel.setGroup(classContainer.getClassByID(index));

                    JTableStudents.updateUI();
                }

            }
        });
        deleteGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = TableGroup.getSelectedRow();
                classContainer.removeClassBYid(index);
                TableGroup.updateUI();
            }
        });
        deleteStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indexs = JTableStudents.getSelectedRow();
                int indexg = TableGroup.getSelectedRow();
                classContainer.getClassByID(indexg).decreasingStudent(classContainer.getClassByID(indexg).getStudentByID(indexs));
                JTableStudents.updateUI();
            }
        });
    }

    private void createUIComponents() {
        TableGroup = new JTableStudents();
        JTableStudents = new JTableStudents();
    }

}
