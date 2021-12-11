package GUI;

import StudentBook.ClassContainer;
import StudentBook.Group;

import javax.swing.table.AbstractTableModel;

public class GroupTableModel extends AbstractTableModel {
    private ClassContainer classContainer;
    private String columnNames[] = new String[]{"group name", "student limit"};
    public GroupTableModel(ClassContainer classContainer) {
        this.classContainer = classContainer;
    }


    @Override
    public int getRowCount() {
        Integer temp = classContainer.getGroupSize();
        if (temp == null) return 0;
        return temp;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }


    ///????
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                return classContainer.getClassByID(rowIndex).getGroupName();
            }
            case 1 -> {
                return classContainer.getClassByID(rowIndex).getMaxNumberStu();
            }
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }


    ///SETVALUEAT
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                classContainer.getClassByID(rowIndex).setGroupName((String) aValue);

            }
            case 1 -> {
                classContainer.getClassByID(rowIndex).setMaxNumberStu(Integer.parseInt((String)aValue ));
            }
        }

    }

}
