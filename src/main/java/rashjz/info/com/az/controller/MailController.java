/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.controller;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Rashad Javadov
 */
@Controller
public class MailController implements Serializable {

    private static final Logger LOG = Logger.getLogger(MailController.class.getName());

    @Autowired
    private JavaMailSender javaMailSender;

    @RequestMapping(value = "/mailsend", method = RequestMethod.GET)
    public String sendEmail() {
        javaMailSender.send(new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws MessagingException, UnsupportedEncodingException {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                InternetAddress me = new InternetAddress("rashadjavad@gmail.com");
                me.setPersonal("Handwork");
                message.setFrom(me);
                message.setTo("rashadjavad@hotmail.com");
                message.setSubject("A file for you");
                message.setText("<b>See the attached</b>", true);
//    message.addAttachment("CoolStuff.doc", new File("CoolStuff.doc"));
            }
        });
        return "login";
    }
}
