package mail;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MaikSendClass {
	public static void MailSend(HttpServletRequest request, HttpServletResponse response, String name,String mail) throws IOException {

		String title ="【LOHACO】ご注文確認メール\r\n";





        //request.getParameter("title");
        String message = name+"様\r\n" +
        		"※このメールは、ご注文いただきますと自動的に送信されます。\r\n" +
        		"このメールに心当たりのない場合や、ご不明な点がございましたら sword.of.the.sky@gmail.com までご連絡ください。\r\n" +
        		"このたびは、ご注文いただき誠にありがとうございます。\r\n" +
        		"本日、以下のご注文を承りましたので、ご確認をお願い申し上げます。\r\n" +
        		"この後『注文確認』→『発送開始』→『発送完了』と随時メールにてご連絡いたします。商品ができるかぎり早くお届けできるよう心がけていきますので、どうぞよろしくおねがいします！\r\n" +
        		"（以下、受注内容を記載）\r\n" +
        		"****************************************************\r\n" +
        		"LOHACO（担当山田）\r\n" +
        		"〒:135-0061	住所:東京都江東区豊洲三丁目2番3号\r\n" +
        		"URL : https://lohaco.jp/support/index.html\r\n" +
        		"MAIL : sword.of.the.sky@gmail.com\r\n" +
        		"TEL:03-4330-5001\r\n" +
        		"FAX:03-4330-4100"+
        		"****************************************************\r\n";//request.getParameter("message");

        //System.out.println("タイトル：" + title);
        //System.out.println("メッセージ" + message);

        response.setContentType("text/html; charset=UTF-8");

        try{
            Properties property = new Properties();

            property.put("mail.smtp.host","smtp.gmail.com");

            //GmailのSMTPを使う場合
            property.put("mail.smtp.ssl.enable", "false");
            property.put("mail.smtp.starttls.enable", "true");
            property.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            property.put("mail.smtp.auth", "true");
            property.put("mail.smtp.starttls.enable", "true");
            property.put("mail.smtp.host", "smtp.gmail.com");
            property.put("mail.smtp.port", "587");
            property.put("mail.smtp.debug", "true");

            Session session = Session.getInstance(property, new javax.mail.Authenticator(){
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication("sword.of.the.sky@gmail.com", "87718771");
                }
            });

            /*
            //一般的なSMTPを使う場合

            //ポートが25の場合は省略可能
            property.put("mail.smtp.port", 25);

            Session session =
                    Session.getDefaultInstance(property, null);
            */

            MimeMessage mimeMessage = new MimeMessage(session);

            InternetAddress toAddress =
                    new InternetAddress("sword.of.the.sky@gmail.com", name+"様");//適当なアドレスなので今回は固定のメールアドレスに送信

            mimeMessage.setRecipient(Message.RecipientType.TO, toAddress);

            InternetAddress fromAddress =
                    new InternetAddress("sword.of.the.sky@gmail.com","LOHACO");

            mimeMessage.setFrom(fromAddress);

            mimeMessage.setSubject(title, "ISO-2022-JP");

            mimeMessage.setText(message, "ISO-2022-JP");

            Transport.send(mimeMessage);

        }
        catch(Exception e){
        	System.out.println(e);
        }

    }
}
