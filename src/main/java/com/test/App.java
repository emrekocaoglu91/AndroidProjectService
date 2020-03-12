package com.test;

import com.com.elasticemail.app.functions.Email;
import com.deneme.Korku.Hikayeleri.shared.dto.UserDto;
import com.elasticemail.app.API;
import com.elasticemail.app.ApiTypes;

public class App {

    Email email = new Email();
    ApiTypes.EmailSend response = null;
    String subject = "Email Onayı";
    String fromEmail = "softwareoffear@gmail.com";
    String fromName = "Korku Hikayeleri";
    final String PASSWORD_RESET_SUBJECT = "Password reset request";
    // The HTML body for the email.
    final String HTMLBODY = "<h1>Please verify your email address</h1>"
            + "<p>Thank you for registering with our mobile app. To complete registration process and be able to log in,"
            + " click on the following link: "
            + "<a href='ec2-52-59-205-203.eu-central-1.compute.amazonaws.com:8080/verification-service/email-verification.html?token=$tokenValue'>"
            + "Final step to complete your registration" + "</a><br/><br/>"
            + "Thank you! And we are waiting for you inside!";

    // The email body for recipients with non-HTML email clients.
    final String TEXTBODY = "Please verify your email address. "
            + "Thank you for registering with our mobile app. To complete registration process and be able to log in,"
            + " open then the following URL in your browser window: "
            + " http://ec2-52-59-205-203.eu-central-1.compute.amazonaws.com:8080/verification-service/email-verification.html?token=$tokenValue"
            + " Thank you! And we are waiting for you inside!";

    final String PASSWORD_RESET_HTMLBODY = "<h1>A request to reset your password</h1>"
            + "<p>Hi, $firstName!</p> "
            + "<p>Someone has requested to reset your password with our project. If it were not you, please ignore it."
            + " otherwise please click on the link below to set a new password: "
            + "<a href='ec2-52-59-205-203.eu-central-1.compute.amazonaws.com:8080/verification-service/password-reset.html?token=$tokenValue'>"
            + " Click this link to Reset Password"
            + "</a><br/><br/>"
            + "Thank you!";

    // The email body for recipients with non-HTML email clients.
    final String PASSWORD_RESET_TEXTBODY = "A request to reset your password "
            + "Hi, $firstName! "
            + "Someone has requested to reset your password with our project. If it were not you, please ignore it."
            + " otherwise please open the link below in your browser window to set a new password:"
            + " http://ec2-52-59-205-203.eu-central-1.compute.amazonaws.com:8080/verification-service/password-reset.html?token=$tokenValue"
            + " Thank you!";




    public void verifyEmail(UserDto userDto) {

        // You can also set your keys this way. And it will work!
        System.setProperty("aws.accessKeyId", "AKIAV26WVOF2JMQDSWQK");
        System.setProperty("aws.secretKey", "GYUuNWxhVnKwycUmMurclTgEShsaa+RPjW8H3nrH");


        String htmlBodyWithToken = HTMLBODY.replace("$tokenValue", userDto.getEmailVerificationToken());
        String textBodyWithToken = TEXTBODY.replace("$tokenValue", userDto.getEmailVerificationToken());

        try {
            ApiTypes.StringArray abc = new ApiTypes.StringArray();
            abc.add(userDto.getEmail());
            response = email.send(subject, fromEmail, fromName, "", "", "", "", "", "", abc,
                    null, null, null, null, null, null, "", htmlBodyWithToken, htmlBodyWithToken, "",
                    "", "", null, ApiTypes.EncodingType.BASE64, null, null, null, null, null, null, null, true, null, false, false, null
                    , null, null, null, null, null);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        if (response != null) {
            System.out.println("MsgID to store locally: " + response.messageid); // Available only if sent to a single recipient
            System.out.println("TransactionID to store locally: " + response.transactionid);
        }

        System.out.println("Email sent!");

    }


    public boolean sendPasswordResetRequest(String firstName, String email, String token) {
        boolean returnValue = false;

        String htmlBodyWithToken = PASSWORD_RESET_HTMLBODY.replace("$tokenValue", token);
        htmlBodyWithToken = htmlBodyWithToken.replace("$firstName", firstName);

        String textBodyWithToken = PASSWORD_RESET_TEXTBODY.replace("$tokenValue", token);
        textBodyWithToken = textBodyWithToken.replace("$firstName", firstName);


        try {
            Email email2 = new Email();
            ApiTypes.StringArray abc = new ApiTypes.StringArray();
            abc.add(email);
            subject="Parola Yenileme";
            response = email2.send(subject, fromEmail, fromName, "", "", "", "", "", "", abc,
                    null, null, null, null, null, null, "", htmlBodyWithToken, htmlBodyWithToken, "",
                    "", "", null, ApiTypes.EncodingType.BASE64, null, null, null, null, null, null, null, true, null, false, false, null
                    , null, null, null, null, null);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        if (response != null) {
            System.out.println("MsgID to store locally: " + response.messageid); // Available only if sent to a single recipient
            System.out.println("TransactionID to store locally: " + response.transactionid);
            returnValue = true;
        }

        System.out.println("Email sent!");


        return returnValue;
    }

}


