package GUI;

import StudentBook.ClassContainer;
import StudentBook.Group;
import StudentBook.Student;

import javax.swing.table.AbstractTableModel;

public class StudentTableModel extends AbstractTableModel {
    private ClassContainer classContainer;
    private String columnNames[] = new String[]{"name", "family name ","status","grade"};

    private Group group ;
    public StudentTableModel(Group group ){
        this.group = group;
    }
    public void setGroup(Group group){
        this.group = group;
    }



    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public int getRowCount() {
        Integer temp = group.StudentNum();
        if (temp == null) return 0;
        return temp;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         switch (columnIndex){
            case 0-> {return group.getStudentByID(rowIndex).getName();}
             case 1->{return group.getStudentByID(rowIndex).getLastName();}
             case 2->{return group.getStudentByID(rowIndex).getStatus();}
             case 3->{return group.getStudentByID(rowIndex).getNumberOfCredits();}
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0-> {group.getStudentByID(rowIndex).setName((String) aValue); }
            case 1->{ group.getStudentByID(rowIndex).setLastName((String) aValue);}
           // case 2->{ group.getStudentByID(rowIndex).setStatus();}
            case 3->{ group.getStudentByID(rowIndex).setNumberOfCredits(Integer.parseInt((String)aValue ));}
        }
    }
}
