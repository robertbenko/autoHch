package com.ibm.autochecker;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

    public void sendEmail() {

        String to = "robert.benko@pl.ibm.com";
        //String cc = "robert.benko@pl.ibm.com";

        // Sender's email ID needs to be mentioned
        String from = "antoniopanterass@gmail.com";
        final String username = "xx";
        final String password = "xx";

        String host = "smtp.gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

//            message.setRecipients(Message.RecipientType.CC,
//                    InternetAddress.parse(cc));

            message.setSubject("Mail Testowy");

            message.setContent(
                    "<h2>To jest mail ze skryptu</h2><br><br>" +
                            "<font color=\"red\">Robert</font>","text/html"
            );

            Transport.send(message);

            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
