package com.deneme.Korku.Hikayeleri.mailSender;

import com.deneme.Korku.Hikayeleri.shared.dto.UserDto;

import javax.mail.Message;
import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {


    // The email body for recipients with non-HTML email clients.
    final String TEXTBODY = "Lütfen mail adresinizi doğrulayınız. "
            + "Korku Hikayelerine kayıt olduğunuz için teşekkür ederiz."
            + "Kayıt işlemini tamamlamak ve giriş yapabilmek için aşağıdaki linke tıklayınız : "
            + " http://ec2-52-59-205-203.eu-central-1.compute.amazonaws.com:8080/verification-service/email-verification.html?token=$tokenValue"
            + " Teşekkürler! Uygulamada görüşmek üzere.";

    // The email body for recipients with non-HTML email clients.
    final String PASSWORD_RESET_TEXTBODY =
             "Merhaba, $firstName! "
            + " Birisi projemizle şifrenizi sıfırlamayı talep etti. Eğer siz değilseniz, lütfen dikkate almayınız."
            + " Bunu yapan sizseniz yeni bir şifre belirlemek için lütfen aşağıdaki bağlantıyı açın:"
            + " http://ec2-52-59-205-203.eu-central-1.compute.amazonaws.com:8080/verification-service/password-reset.html?token=$tokenValue"
            + " Teşekkürler !";


    public void verifyEmail(UserDto userDto) {
        Session session = getSession();
        try {
            String textBodyWithToken = TEXTBODY.replace("$tokenValue", userDto.getEmailVerificationToken());
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("softwareoffear@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userDto.getEmail()));
            message.setSubject("Korku Hikayeleri Email Onayı ");
            message.setText(textBodyWithToken);
            Transport.send(message);
            System.out.println("Mail şu adrese gönderildi : " +userDto.getEmail());
        } catch (MessagingException ex) {
            throw new RuntimeException(ex);
        }
    }



    public boolean sendPasswordResetRequest(String firstName,String email, String token){

        Session session = getSession();
        try {
            String textBodyWithToken = PASSWORD_RESET_TEXTBODY.replace("$tokenValue", token);
            textBodyWithToken = textBodyWithToken.replace("$firstName", firstName);

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("softwareoffear@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Korku Hikayeleri Şifre Sıfırlama ");
            message.setText(textBodyWithToken);
            Transport.send(message);
            System.out.println("Mail şu adrese gönderildi : " +email);
            return true;
        } catch (MessagingException ex) {
            throw new RuntimeException(ex);
        }
   }
    private Session getSession() {
        final String username = "softwareoffear@gmail.com";
        final String password = "nganausv";
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        return Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
    }

}



