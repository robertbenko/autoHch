package com.ibm.autochecker;

import java.util.List;

public class App {
    public static void main(String[] args) {

        List<Employee> employeeList = SQLiteJDBC.getAllEmployees();
        AllEmployeeReport report = AllEmployeeReport.create(employeeList);
        EmailService.sendEmail(report.getHtml());
    }
}
