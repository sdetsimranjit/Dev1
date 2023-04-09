//package AutoPack1;
//
//import com.fasterxml.jackson.core.io.JsonStringEncoder;
//
//import java.net.Authenticator;
//import java.net.PasswordAuthentication;
//import java.util.Properties;
//
//public class Emailsendreport {
//    public static void main() {
//
//        // Recipient's email ID needs to be mentioned.
//
//        String message = "Its my first mail ";
//        String sub = "Testing";
//        String to = "mailto:kyclimit001@gmail.com";
//        String from = "mailto:cryptout431@gmail.com";
//
//        //sendEmail(message, sub, to, from);
//
//        // Assuming you are sending email through relay.jangosmtp.net
//
//        String host = "smtp.gmail.com";
//        Properties properties = System.getProperties();
//        properties.put("mail.smtp.host", host);
//        properties.put("mail.smtp.port", "465");
//        properties.put("mail.smtp.ssl.enable", "true");
//        properties.put("mail.smtp.auth", "true");
//
//        // Get the Session object.
//        JsonStringEncoder Session;
//        Session session = Session.getInstance(properties, new Authenticator() {
//            class passwordauthentication {
//                public passwordauthentication(String s, String slinrgxfzpjurbjy) {
//                }
//            }
//
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                //return super.getPasswordAuthentication();
//                return new passwordauthentication("cryptout431@gmail.com", "slinrgxfzpjurbjy");
//            }
//        });
//        Message m = new MimeMessage(session);  // Create a default MimeMessage object.
//        try {
//
//
//
//            // Set From: header field of the header.
//            m.setFrom(new InternetAddress(from));
//
//            // Set To: header field of the header.
//            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//
//            // Set Subject: header field
//            m.setSubject(sub);
//
//            // Create the message part
//            BodyPart messageBodyPart = new MimeBodyPart();
//
//            // Now set the actual message
//            messageBodyPart.setText("This is message body");
//
//            // Create a multipar message
//            Multipart multipart = new MimeMultipart();
//
//            // Set text message part
//            multipart.addBodyPart(messageBodyPart);
//
//            // Part two is attachment
//            messageBodyPart = new MimeBodyPart();
//            String filename = "C:/Users/user/IdeaProjects/CoinGeb/test-output/Default Suite/CoinGeb.html";
//            DataSource source = new FileDataSource(filename);
//            messageBodyPart.setDataHandler(new DataHandler(source));
//            messageBodyPart.setFileName(filename);
//            multipart.addBodyPart(messageBodyPart);
//
//            // Send the complete message parts
//            m.setContent(multipart);
//
//            // Send message
//            Transport.send(m);
//
//            System.out.println("Sent message successfully....");
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
