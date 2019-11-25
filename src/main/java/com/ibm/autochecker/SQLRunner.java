package com.ibm.autochecker;

import java.sql.*;
import java.util.Properties;

import static java.lang.System.*;

class SQLRunner {
    private Connection con;
    private Statement stmt;
    private ResultSet rs = null;

    void DBconnect() {
        final String DRIVER = "jdbc:db2";
        final String DB2 = "com.ibm.db2.jcc.DB2Driver";
        final String HOST = "xx";
        final String PORT = "8484";
        final String DATABASE = "SAASTST";
        final String USERNAME = "xx";
        final String PASSWORD = "xx";

        Properties properties = new Properties();
        properties.put("user", USERNAME);
        properties.put("password", PASSWORD);
        String url = DRIVER + "://" + HOST + ":" + PORT + "/" + DATABASE;

        try {
            Class.forName(DB2);
            out.println("**** Loaded the JDBC driver");

            con = DriverManager.getConnection(url, properties);
            con.setAutoCommit(false);
            out.println("**** Created a JDBC connection to the data source");

            stmt = con.createStatement();
            out.println("**** Created JDBC ResultSet object");

        } catch (ClassNotFoundException e) {
            err.println("Could not load JDBC driver");
            out.println("Exception: " + e);
            e.printStackTrace();
        } catch (SQLException ex) {
            err.println("Opening SQLException information");
            while (ex != null) {
                err.println("Opening Error msg: " + ex.getMessage());
                err.println("Opening SQLSTATE: " + ex.getSQLState());
                err.println("Opening Error code: " + ex.getErrorCode());
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }
    }

    void runSQLQuery() throws SQLException {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM COMPANY");

            while (rs.next()) {

                int clinet_ID = rs.getInt(1);
                String CURRENCY = rs.getString("BASECURRENCY");
                String EMAILADMIN = rs.getString("EMAILADMIN");
                String POLLINGEMAIL = rs.getString("POLLINGEMAIL");
                String SMTPSERVER = rs.getString("SMTPSERVER");
                int MSERVICEOUTON = rs.getInt("MSERVICEOUTON");
                int BUSERVICEINI = rs.getInt("BUSERVICEINI");
                int BUSERVICEON = rs.getInt("BUSERVICEON");

                System.out.println(clinet_ID + "\t" + CURRENCY +
                        "\t" + EMAILADMIN + "\t" + POLLINGEMAIL +
                        "\t" + SMTPSERVER + "\t" + MSERVICEOUTON +
                        "\t" + BUSERVICEINI + "\t" + BUSERVICEON);

     //           Employee employee = new Employee(CURRENCY, EMAILADMIN, POLLINGEMAIL, SMTPSERVER, MSERVICEOUTON, BUSERVICEINI, BUSERVICEON);
            }

        } catch (SQLException ex) {
            err.println("While SQL running SQLException information");
            while (ex != null) {
                err.println("While SQL running Error msg: " + ex.getMessage());
                err.println("While SQL running SQLSTATE: " + ex.getSQLState());
                err.println("While SQL running Error code: " + ex.getErrorCode());
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }
    }

    void DBclose() throws SQLException {

        try {
            out.println("**** Closing started");

            rs.close();
            out.println("**** Closed JDBC ResultSet");

            stmt.close();
            out.println("**** Closed JDBC Statement");

            con.commit();
            out.println("**** Transaction committed");

            con.close();
            out.println("**** Disconnected from data source");

            out.println("**** JDBC Exit from class SQLRunner - no errors");

        } catch (SQLException ex) {
            err.println("Closing SQLException information");
            while (ex != null) {
                err.println("Closing Error msg: " + ex.getMessage());
                err.println("SClosing QLSTATE: " + ex.getSQLState());
                err.println("Closing Error code: " + ex.getErrorCode());
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }

    }
}
