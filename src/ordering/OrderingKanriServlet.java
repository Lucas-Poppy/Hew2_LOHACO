package ordering;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.arnx.jsonic.JSON;
import beans.Deliverbean;
import beans.OrderingListbean;

/**
 * Servlet implementation class OrderingKanriServlet
 */
@WebServlet("/OrderingKanriServlet")
public class OrderingKanriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderingKanriServlet() {
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

		String flag = request.getParameter("flag");



		HttpSession session = request.getSession();

		String tbl=new String();
		String tbl2 = new String();
		OrderingKanriClass OK = new OrderingKanriClass();
		List<OrderingListbean> Olist = new ArrayList<OrderingListbean>();
		Olist=OK.OrderingList();
		tbl="<table class='mui-table mui-table--bordered'><thead><tr>" +
				"<th>商品id</th><th>商品名</th>" +
				"<th>合計在庫量</th><th>発注点</th>" +
				"<th>最適発注量</th><th>発注処理</th></tr></thead><tbody>";


		for(int i=0;i<Olist.size();i++){
			tbl+="<tr id='rdlist"+i+1+"'>" +
					"<td>"+Olist.get(i).getProID()+"</td>" +
					"<td>"+Olist.get(i).getProName()+"</td>" +
					"<td>"+Olist.get(i).getSumQuan()+"</td>"+
					"<td>"+Olist.get(i).getOrder_p()+"</td>"+
					"<td>"+Olist.get(i).getOrder_quan()+"</td>"+
					"<td><button type='submit' class='btn btn-primary ordering'><font size='1'>発注処理</font></button></td>"+
					"</tr>";
		}
		tbl+="</tbody></table>";


		List<Deliverbean> Dlist = new ArrayList<Deliverbean>();
		Dlist = OK.selectDeliver();

		tbl2 += "<table class='mui-table mui-table--bordered'><thead><tr>";
		tbl2 += "<th>発注番号</th><th>商品番号</th><th>商品名</th>";
		tbl2 += "<th>倉庫名</th><th>発注数</th><th>発注日</th></tr></thead><tbody>";

		if(Dlist!=null){
			for(int i=0;Dlist.size()>i;i++){
				System.out.println("dlistsize"+Dlist.size());
				tbl2 += "<tr><td>" + Dlist.get(i).getOrdering_id() + "</td>";
				tbl2 += "<td>" + Dlist.get(i).getProduct_id() + "</td>";
				tbl2 += "<td>" + Dlist.get(i).getProduct_name() + "</td>";
				tbl2 += "<td>" + Dlist.get(i).getWarehouse_name() + "</td>";
				tbl2 += "<td>" + Dlist.get(i).getQuantity() + "</td>";
				tbl2 += "<td>" + Dlist.get(i).getOrdering_date() + "</td>";
				tbl2 += "</tr>";
			}

		}

		tbl2 += "</tbody></table>";

		String hairetu[] = {tbl,tbl2};
		session.setAttribute("haisolist", hairetu);


		if(flag!=null){
			System.out.println("OrderingKanriServlet:ajaxつかった。");
			session.removeAttribute("hatyulist");
			PrintWriter out = response.getWriter();
		    out.println(JSON.encode(hairetu));

		}else{
			System.out.println("OrderingKanriServlet:ajaxつかってない。");
			RequestDispatcher dispatcher=request.getRequestDispatcher("HatyuTOP.jsp");
			dispatcher.forward(request,response);
		}
	}

}
