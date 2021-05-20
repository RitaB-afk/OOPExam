package Tables;

import javax.swing.table.AbstractTableModel;

import Classes.Employee;

import java.util.ArrayList;

public class EmployeeTable extends AbstractTableModel {

    public static final int OBJECT_COL = -1 ;
    private static final int LAST_NAME_COL = 1;
    private static final int FIRST_NAME_COL = 2;
    private static final int EMAIL_COL = 4;
    private static final int EMP_NUM_COL=0;
    private static final int EXT_COL=3;
    private static final int OFF_COL= 5;
    private static final int REP_COL=6;
    private static final int JTITLE_COL=7;


    private String[] columnNames = { "Employee Number","Last Name", "First Name", "Extension", "Email", "Office", "Reports to","JobTitle"};
    private ArrayList<Employee> employees;

    public EmployeeTable(ArrayList<Employee> AllEmployees) {
        employees = AllEmployees;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return employees.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {

        Employee selEmployee = employees.get(row);

         switch (col) {
            case FIRST_NAME_COL: return selEmployee.getFirstName();
            case EMAIL_COL: return selEmployee.getEmail();
            case EMP_NUM_COL: return selEmployee.getEmployeeNumber();
            case EXT_COL: return selEmployee.getExtension();
            case OFF_COL: return selEmployee.getOfficeCode();
            case REP_COL: return selEmployee.getReportsTo();
            case JTITLE_COL: return selEmployee.getJobTitle();
            case OBJECT_COL: return selEmployee;
            default: return selEmployee.getLastName();
        }
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}