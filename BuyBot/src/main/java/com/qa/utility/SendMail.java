package com.qa.utility;

import com.qa.configuration.ConfigManager;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;


public class SendMail extends ConfigManager {

    public static String path1= System.getProperty("user.dir");

    public static void sendEmails(){
        try {
            // Create the attachment

            System.out.println("Start creating the attachment");
            EmailAttachment attachment = new EmailAttachment();
            attachment.setPath(path1 + "Report/FinanceTestReport.html");
            System.out.println("Report's path was found");
            attachment.setDisposition(EmailAttachment.ATTACHMENT);
            Thread.sleep(4000);
            attachment.setDescription("Automation report of finance junction market place");
            attachment.setName("REPORT");
            System.out.println("Create the attachment");

            // Create the email message
            System.out.println("Start configuring email");
            MultiPartEmail email = new MultiPartEmail();
            email.setHostName(Config.getProperty("mail.smtp.host"));
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator(Config.getProperty("emailid"), Config.getProperty("emailpassword")));
            email.setSSLOnConnect(true);
            Thread.sleep(4000);
            email.setFrom("somtech20@gmail.com");
            email.setSubject("Finance Junction Report");
            email.setMsg("Hi All, \n");
            email.setMsg("The Finance junction automation test report is attached in format of html.");
            email.setMsg("So, please use browser to open the report\n\n");
            email.setMsg("Thanks & Regards,");
            email.setMsg("Somnath Chatterjee");
            //email.attach(file);
            email.addTo("somnath.chatterjee1@mjunction.in");
            //email.addCc("faiyaz.ahmed@mjunction.in");
            //email.addCc("moshahar.bayen@mjunction.in");
            // add the attachment
            email.attach(attachment);
            System.out.println("Email is ready with attachment");

            Thread.sleep(5000);
            // send the email
            String a = email.send();
            Thread.sleep(2000);
            System.out.println(a);
            System.out.println("The mail is sent successfully... Please check your mailbox...:-)");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
