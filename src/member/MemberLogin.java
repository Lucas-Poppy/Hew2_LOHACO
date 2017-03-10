package member;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.CookieMemidGet;
import beans.Memberbean;

/**
 * Servlet implementation class MemberLogin
 */
@WebServlet("/MemberLogin")
public class MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLogin() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String url = (String) request.getParameter("url");
		String mes = "";

		System.out.println("MemberLoginURL="+url);
		if(url.equals("null")){
			System.out.println("nullのとき");
			url = "index.jsp";
		}
		System.out.println("MemberLoginURL="+url);


		System.out.println("MemberLoginID="+id);
		System.out.println("MemberLoginPass="+pass);

			MemberKanriClass MK = new MemberKanriClass();
			Memberbean member = MK.member_search(id, pass);
			String memname = new String();
			String memno = new String();

			if(member != null){

				System.out.println(member.getMem_name()+56);
				try{

					CookieMemidGet.setCookie(request,response,"/", "memname",URLEncoder.encode(member.getMem_name(),"utf-8"),60*60*1);
					CookieMemidGet.setCookie(request,response, "/", "memno", URLEncoder.encode(member.getMem_no(),"utf-8"), 60*60*1);
					System.out.println("aaa");
				}catch(Exception e){
					System.out.println("cookie保存できず");
				}

				memname = member.getMem_name();
				memno = member.getMem_no();

				System.out.println(memname);
				request.setAttribute("memname", memname);
				request.setAttribute("memno", memno);

			}else{
				url = "login.jsp";
				mes = "ログインに失敗しました。再度ログインしてください。";
				request.setAttribute("error", mes);
			}

			System.out.println(url);
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
