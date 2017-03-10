package TekiKonyu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.CookieMemidGet;
import beans.Subscriptionsbean;

/**
 * Servlet implementation class TekiTopServlet
 */
@WebServlet("/TekiTopServlet")
public class TekiTopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TekiTopServlet() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String memno =CookieMemidGet.getCookie(request, "memno");
		HttpSession session = request.getSession();

		TekiKanriClass TK = new TekiKanriClass();
		List<Subscriptionsbean> sublist = new ArrayList<Subscriptionsbean>();
		sublist=TK.Tekilist(memno);
		String tbl = new String();
		for(int i =0; i<sublist.size();i++){
			tbl +="<tr><td class='col-md-7 col-xs-7'>" +
					"<p><a href='ProductSearchDetail?proid="+ sublist.get(i).getProduct_id() +"' class='textcolorblue'>"+sublist.get(i).getProduct_name()+"</a></p>" +
					"</td><td class='col-md-1 col-xs-1'>" +
					"<p>"+sublist.get(i).getQuantity()+"個</p>" +
					"</td><td class='col-md-2 col-xs-2'>" +
					"<p>"+sublist.get(i).getP_period()+"ヶ月</p>" +
					"</td>" +
					"<td class='col-md-1 col-xs-1'><p>"+sublist.get(i).getP_start()+"</p></td>" +
					"<td class='col-md-1 col-xs-1'><button type='submit' class='btn btn-info center-block'>変更</button></td>" +
					"<form action='TekiSyoriServlet' method='Post'><input type='hidden' value='"+ sublist.get(i).getProduct_id() +"' name='proid'>" +
					"<input type='hidden' name='tekihantei' value='2'>" +
					"<td class='col-md-1 col-xs-1'><button type='submit' class='btn btn-danger center-block'>削除</button></td></form>" +
					"</tr>";
		}
		session.setAttribute("Teki",tbl);

		RequestDispatcher disp = request.getRequestDispatcher("subscriptions.jsp");
		disp.forward(request, response);


	}

}
