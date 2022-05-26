package co.edu.uniquindio.unitravel.servicios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailServices {

    @Autowired
    private JavaMailSender sender;


    public boolean enviarEmail(String destinatario, String asunto, String mensaje) {
        //System.out.println("Enviando email a: " + destinatario + " con asunto: " + asunto + " y mensaje: " + mensaje);
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {

            helper.setText(mensaje, true);
            helper.setTo(destinatario);
            helper.setSubject(asunto);

            sender.send(message);

            return true ;
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return false;
    }

}
