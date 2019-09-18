package com.qa.utility;


import javax.mail.*;
import java.util.Properties;

/**
 * @author Somnath.Chatterjee1
 * This class is use to read emails
 */

public class ReadMailData {

    public static void readMailDetails() {

        String host = "pop.gmail.com";// change accordingly
        String mailStoreType = "pop3s";
        String username = "your@email.id";// change accordingly
        String password = "password";// change accordingly

        check(host, mailStoreType, username, password);

    }

    private static void check(String host, String storeType, String user, String password)
    {
        try {

            //create properties field
            Properties properties = new Properties();

            properties.setProperty("mail.store.protocol", "pop3s");
            properties.put("mail.pop3s.auth", true);
            properties.put("mail.pop3s.ssl.enable", true);
            //properties.put("mail.pop3s.starttls.enable", true);
            properties.put("mail.pop3s.host", host);
            properties.put("mail.pop3s.port", "995");
            properties.setProperty("mail.pop3s.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory" );
            properties.setProperty("mail.pop3s.ssl.trust", "*");

           /* properties.put("mail.pop3.auth", true);

            properties.put("mail.pop3.host", "172.16.1.251");
            properties.put("mail.pop3.port", "465");*/

            Session emailSession = Session.getDefaultInstance(properties, new javax.mail.Authenticator(){
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(user, password);
                }
            } );

            //create the POP3 store object and connect with the pop server
            Store store = emailSession.getStore(storeType);

            store.connect(host,995, user, password);

            //create the folder object and open it
            Folder emailFolder = store.getFolder("Inbox");

            emailFolder.open(Folder.READ_ONLY);

            // retrieve the messages from the folder in an array and print it
            Message[] messages = emailFolder.getMessages();
            System.out.println("messages.length---" + messages.length);

            for (int i = 0, n = messages.length; i < n; i++) {
                Message message = messages[i];

                Object obj = message.getContent();
                Multipart mp = (Multipart)obj;
                BodyPart bp = mp.getBodyPart(0);

                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("To: " + message.getAllRecipients().toString());
                System.out.println("Received Date:" + message.getReceivedDate());
                System.out.println("Text: " + bp.getContent().toString());
            }

            //close the store and folder objects
            emailFolder.close(false);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}

