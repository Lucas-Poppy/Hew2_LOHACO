package denpyo;

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

import receive.ReceiveKanriClass;
import stock.StockKanriClass;
import beans.Haitatsubean;

/**
 * Servlet implementation class DenpyoServlet
 */
@WebServlet("/DenpyoServlet")
public class DenpyoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DenpyoServlet() {
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
		HttpSession session = request.getSession();

		String wareid=request.getParameter("wareid");
		String address=request.getParameter("address");
		String orderno=request.getParameter("orderno");
		String Kname=request.getParameter("Kname");
		String Knumber = request.getParameter("Knumber");

		List<Haitatsubean> haitalist = new ArrayList<Haitatsubean>();
		ReceiveKanriClass RK = new ReceiveKanriClass();
		haitalist=RK.selectHaitatsu(wareid, orderno);
		StockKanriClass SK = new StockKanriClass();
		String warename= SK.WareName(wareid);

		String tbl=new String();
		for(int i=0;i<haitalist.size();i++){
			tbl+="<tr>" +
				 "<th>"+haitalist.get(i).getPro_id()+"</th>" +
				 "<td>"+haitalist.get(i).getPro_name()+"</td>" +
				 "<td>"+haitalist.get(i).getQuantity()+"</td>" +
				 "</tr>";
		}

		String hairetu[] = {warename,address,orderno,Kname,Knumber,wareid};

		session.setAttribute("denpyolist", hairetu);
		session.setAttribute("prolist",tbl);

		System.out.println("denpyo.jspに送る");
		RequestDispatcher dispatcher=request.getRequestDispatcher("denpyo.jsp");
		dispatcher.forward(request,response);







	}

}
