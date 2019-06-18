package com.ibm.autochecker;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {

        SQLRunner sqlRunner = new SQLRunner();
        sqlRunner.DBconnect();
        sqlRunner.runSQLQuery();
        sqlRunner.DBclose();

        SendEmail sendEmail = new SendEmail();
        sendEmail.sendEmail();
    }
}
