package com.ibm.autochecker;

public class MessageHTML {
    private String CURRENCY;
    private String EMAILADMIN;
    private String POLLINGEMAIL;
    private String SMTPSERVER;
    private Integer MSERVICEOUTON;
    private Integer BUSERVICEINI;
    private Integer BUSERVICEON;


    MessageHTML(String currency, String emailadmin, String pollingemail, String smtpserver, Integer mserviceouton, Integer buserviceini, Integer buserviceon) {
        CURRENCY = currency;
        EMAILADMIN = emailadmin;
        POLLINGEMAIL = pollingemail;
        SMTPSERVER = smtpserver;
        MSERVICEOUTON = mserviceouton;
        BUSERVICEINI = buserviceini;
        BUSERVICEON = buserviceon;
    }

    public String getCURRENCY() {
        return CURRENCY;
    }

    public String getEMAILADMIN() {
        return EMAILADMIN;
    }

    public String getPOLLINGEMAIL() {
        return POLLINGEMAIL;
    }

    public String getSMTPSERVER() {
        return SMTPSERVER;
    }

    public Integer getMSERVICEOUTON() {
        return MSERVICEOUTON;
    }

    public Integer getBUSERVICEINI() {
        return BUSERVICEINI;
    }

    public Integer getBUSERVICEON() {
        return BUSERVICEON;
    }


    public void message() {
        if (CURRENCY == "EUR");

    }


}