package ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mailServlet
 */
@WebServlet("/mailServlet")
public class mailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public mailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

        String title ="【LOHACO】ご注文確認メール\r\n" +
        		"◯◯◯◯様\r\n" +
        		"※このメールは、ご注文いただきますと自動的に送信されます。\r\n" +
        		"このメールに心当たりのない場合や、ご不明な点がございましたら sword.of.the.sky@gmail.com までご連絡ください。\r\n" +
        		"このたびは、ご注文いただき誠にありがとうございます。\r\n" +
        		"本日、以下のご注文を承りましたので、ご確認をお願い申し上げます。\r\n" +
        		"この後『受注確認』→『入金確認』→\n『発送完了』と随時メールにてご連絡いたします。商品ができるかぎり早くお届けできるよう心がけていきますので、どうぞよろしくおねがいします！\r\n" +
        		"（以下、受注内容を記載）\r\n" +
        		"****************************************************\r\n" +
        		"LOHACO（担当山田）\r\n" +
        		"〒000-0000 東京都◯◯◯◯◯◯◯◯◯◯◯◯◯\r\n" +
        		"URL : http://wwwwwwww.com\r\n" +
        		"MAIL : xxxxx@xxxx.xx\r\n" +
        		"TEL：000-00000000\r\n" +
        		"****************************************************\r\n";





        //request.getParameter("title");
        String message = "";//request.getParameter("message");

        //System.out.println("タイトル：" + title);
        //System.out.println("メッセージ" + message);

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

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
                    new InternetAddress("yuuki9552@gmail.com", "佐藤 健一");//tk4241@gmail.com

            mimeMessage.setRecipient(Message.RecipientType.TO, toAddress);

            InternetAddress fromAddress =
                    new InternetAddress("sword.of.the.sky@gmail.com","LOHACO");

            mimeMessage.setFrom(fromAddress);

            mimeMessage.setSubject(title, "ISO-2022-JP");

            mimeMessage.setText(message, "ISO-2022-JP");

            Transport.send(mimeMessage);

            out.println("<htm><body>");
            out.println("■お問い合わせ内容を担当者へ送信しました。");
            out.println("<body></html>");
        }
        catch(Exception e){
        	System.out.println(e);
            out.println("<html><body>");
            out.println("■担当者への送信に失敗しました");
            out.println("<br>エラーの内容" + e);
            out.println("</body></html>");
        }

        out.close();
    }



}
