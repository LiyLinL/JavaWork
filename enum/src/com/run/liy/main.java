package com.run.liy;

public class main {
    //    private static String to = "vip860180@gmail.com";
//
//    private static String from = "vip860180@gmail.com";
//
//    private static String usr = "vip860180";
//
//    private static String pas = "0938860180";
//
//    private static String host = "smtp.gmail.com";
    // for test something
    public static void main( String[] args ) throws Exception {
//        Properties properties = System.getProperties();
//        properties.setProperty("mail.transport.protocol", "smtp");
//        properties.setProperty("mail.smtp.host", host);
//        properties.setProperty("mail.smtp.port", "465");
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.ssl.enable", "true");
//        properties.put("mail.smtp.starttls.enable", "true");
//
//        Session session = Session.getInstance(properties, new Authenticator() {
//            protected PasswordAuthentication passwordAuthentication() {
//                return new PasswordAuthentication(usr, pas);
//            }
//        });
//
//        String subject = "主旨";
//        String body = "內文";
//
//        try {
//            MimeMessage message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(from));
//            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
//
//            message.setSubject(subject);
//
//            Multipart multipart = new MimeMultipart();
//            BodyPart messageBodyPart = new MimeBodyPart();
//            messageBodyPart.setText(body);
//            multipart.addBodyPart(messageBodyPart);
//
//            /*
//            BodyPart fileBodyPart = new MimeBodyPart(); //宣告一個BodyPart用以夾帶附加檔案
//            String filename = "要送的檔案路徑";  //要夾帶的檔案名稱
//            DataSource source = new FileDataSource(filename);//讀取檔案
//            fileBodyPart.setDataHandler(new DataHandler(source));
//            fileBodyPart.setFileName("要顯示的檔案名稱"); //設定附加檔案顯示的名稱
//            multipart.addBodyPart(fileBodyPart);//把BodyPart加入Multipart（這個part夾帶檔案）
//			*/
//            message.setContent(multipart); //設定eMultipart為messag的Content
//            Transport transport = session.getTransport("smtp");
//            transport.connect(host, usr, pas);
//            //傳送信件
//            transport.sendMessage(message, message.getAllRecipients());
//
//            System.out.println("發送成功");
//            //關閉連線
//            transport.close();
//        } catch (MessagingException mex) {
//            mex.printStackTrace();
//        }
    }
}
