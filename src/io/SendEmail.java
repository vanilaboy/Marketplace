package io;

import javax.jms.Session;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

/**
 * Created by root on 18.12.17 with love.
 */
public class SendEmail {

    public SendEmail() {

    }


    public String send(String recipient) {
        final String username = "marketplacehydra@yandex.ru";
        final String password = "fgdhjIOJ*(@Dsjkdasd";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.yandex.ru");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        javax.mail.Session session = javax.mail.Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("marketplacehydra@yandex.ru"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(recipient));
            message.setSubject("Подтверждение аккаунта");
            Random random = new Random();
            String passcode = "";
            for(int i = 0; i < 10; i++) {
                int tmp = random.nextInt(9);
                passcode += Integer.toString(tmp);
            }
            message.setText("Введите этот код на сайте\n" + passcode);
            Transport.send(message);
            return passcode;
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void send(String recipient, String textForMessage) {
        final String username = "marketplacehydra@yandex.ru";
        final String password = "fgdhjIOJ*(@Dsjkdasd";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.yandex.ru");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        javax.mail.Session session = javax.mail.Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("marketplacehydra@yandex.ru"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(recipient));
            message.setSubject("Товар в вашей корзине со скидкой");
            message.setText(textForMessage);
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
