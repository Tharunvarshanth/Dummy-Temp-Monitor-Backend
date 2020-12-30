package com.se.dummytempmonitorbackend.notification;

import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class EmailNotification implements NotificationManager {





    public int sender(List<String> to, String subject, String description) throws AddressException, MessagingException, IOException {
        System.out.println("Email send it");
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("covidecode19@gmail.com", "tharun1998");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("covidecode19@gmail.com", false));



        StringBuilder emaillist =new StringBuilder();

        int i = 0;
        for (String email : to) {
            emaillist.append(email);
            i++;
            if (to.size() > i) {
                emaillist.append(", ");
            }
        }

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emaillist.toString()));
        msg.setSubject(subject);
        msg.setContent(description, "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(description, "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        msg.setContent(multipart);
        Transport.send(msg);
        return 1;
    }



}
