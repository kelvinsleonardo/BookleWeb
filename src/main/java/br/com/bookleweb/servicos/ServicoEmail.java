package br.com.bookleweb.servicos;


import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

/**
 * Created by kelvin on 16/11/16.
 */
@Service
public class ServicoEmail {

    public static void enviar(String assunto, String texto, String destinatario) {
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", "smtp.gmail.com");
        //props.put("mail.smtp.user", "usuario");
        //props.put("mail.smtp.password", "senha");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", true);

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("email", "senha");
                    }
                });

        MimeMessage message = new MimeMessage(session);

        try {
            InternetAddress from = new InternetAddress("bookleweb");
            Multipart multipart = new MimeMultipart();
            BodyPart bodyPart = new MimeBodyPart();
            message.setContent(multipart);
            message.setFrom(from);
            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(assunto, "UTF-8");

            bodyPart.setContent(texto,"text/html");
            multipart.addBodyPart(bodyPart);

            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
