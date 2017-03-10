package member;

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
import beans.Deli_checkbean;
import beans.Historybean;

/**
 * Servlet implementation class HistoryKanriServlet
 */
@WebServlet("/HistoryKanriServlet")
public class HistoryKanriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoryKanriServlet() {
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
	    response.setContentType("text/html; charset=UTF8");
	    String mem_no = (String)request.getAttribute("memno");
	    if(mem_no == null){
	    	mem_no= CookieMemidGet.getCookie(request, "memno");//クッキー
	    }


	    if(mem_no == null || mem_no.equals("")){
	    	request.setAttribute("url", "HistoryKanriServlet");
	    	RequestDispatcher disp = request.getRequestDispatcher("login.jsp");
	    	disp.forward(request, response);
	    }else{
			HttpSession session = request.getSession();
			List<Historybean> Hlist = new ArrayList<Historybean>();

			HistoryKanriClass HK = new HistoryKanriClass();
			DelickClass DC = new DelickClass();

			Hlist=HK.mem_history(mem_no);

			List<Deli_checkbean> Dlist = new ArrayList<Deli_checkbean>();
			DeliKanriClass DK = new DeliKanriClass();

			String tbl = new String();
			for(int i=0;i<Hlist.size();i++){
				Dlist=DK.dcheck(Hlist.get(i).getOrder_no(), Hlist.get(i).getPro_id());
				int ilist[] = new int[Dlist.size()];
				for(int i2=0;i2<Dlist.size();i2++){
					ilist[i2]=(Dlist.get(i2).getDeli());
				}
				String haizyokyo = DC.deli(ilist);


				tbl+="<tr>" +
					 "<th>"+Hlist.get(i).getPro_id()+"</th>" +
					 "<td><a href='ProductSearchDetail?proid="+ Hlist.get(i).getPro_id() +"' class='textcolorblue'>"+Hlist.get(i).getPro_name()+"</a></td>" +
					 "<td>"+Hlist.get(i).getQuantity()+"個</td>" +
					 "<td>￥"+Hlist.get(i).getPrice()+"</td>" +
					 "<td>"+Hlist.get(i).getOrder_date()+"</td>" +
					 "<td>"+haizyokyo+"</td>" +
					 "</tr>";
			}
			session.setAttribute("hislist", tbl);
			RequestDispatcher dispatcher=request.getRequestDispatcher("history.jsp");
			dispatcher.forward(request,response);
	    }

	}

}
