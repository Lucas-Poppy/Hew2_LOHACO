package stock;

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
import order.OrderKanriClass;
import TekiKonyu.TekiKanriClass;
import beans.Order_view1;
import beans.Orderbean;
import beans.Subscriptionsbean;
import benefit.IntegerCheck;

/**
 * Servlet implementation class ZyutyuTopServlet
 */
@WebServlet("/ZyutyuTopServlet")
public class ZyutyuTopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZyutyuTopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF8");


		HttpSession session = request.getSession();

		String tbl=new String();
		OrderKanriClass OK = new OrderKanriClass();
		List<Order_view1> oblist = new ArrayList<Order_view1>();
		List<Orderbean> oblist2 = new ArrayList<Orderbean>();
		IntegerCheck IC = new IntegerCheck();
		String flag = request.getParameter("flag");



		oblist2=OK.Order_tyumonlist();

		String hanteiclass=" in";
		String Togclass="";




		for(int i=0;i<oblist2.size();i++){ //条件に当てはまる注文件数だけ繰り返す。
			oblist=OK.Order_zyutyulist(oblist2.get(i).getOrder_no());
			if(i==0){
				hanteiclass=" in";
				Togclass="";
			}else{
				hanteiclass="";
				Togclass=" class='collapsed'";
			}
			tbl+="<div class='panel panel-default'>" +
				"<div class='panel-heading'>" +
				"<h4 class='panel-title accordion-toggle'>" +
				"<a data-toggle='collapse' data-parent='#accordion' href='#collapse"+i+"'"+Togclass+">" +
				"<table class='table'>" +
				"<thead><tr><th class='col-sm-1'>"+oblist2.get(i).getOrder_no()+"</th>" + 	//変数
				"<th class='col-sm-2'>"+oblist2.get(i).getMem_name()+"</th>" +	//変数
				"<th class='col-sm-3'>"+oblist2.get(i).getOrder_date()+"</th>" +	//変数
				" <input type='hidden' name='memid' class='memid' value='"+oblist2.get(i).getMem_no()+"'>"+
				"</tr></thead></table>注文明細</a></h4></div>" +
				"<div id='collapse"+i+"' class='panel-collapse collapse "+hanteiclass+"'>" +
				"<div class='panel-body'><table class='table'><thead><tr><th>商品ID</th><th>商品名</th><th>注文個数</th><th>受注済みチェック</th></tr></thead>";
			tbl+="<tbody>";

			for(int i2=0;i2<oblist.size();i2++){ //注文番号の注文明細の数だけ繰り返す
				tbl+="<tr>";
				tbl+="<td class='proid'>"+oblist.get(i2).getProduct_id()+"</td>";
				tbl+="<td>"+oblist.get(i2).getProduct_name()+"</td>";
				tbl+="<td class='quan'>"+oblist.get(i2).getQuantity()+"</td>";
				if(IC.henkan(oblist.get(i2).getRece_flg())==0){
					tbl+="<td><button type='submit' class='btn btn-primary haisou'><font size='1'>配送命令</font></button></td>";
				}else{
					tbl+="<td><i class='material-icons' style='color: #7BE04F'>check_circle</i></td>";
				}

	      		tbl+="</tr>";
			}
			tbl+="</tbody></table></div></div></div>";

		}



		//受注済みリスト
		List<Order_view1> oblist3 = new ArrayList<Order_view1>();
		List<Orderbean> oblist4 = new ArrayList<Orderbean>();
		oblist4=OK.Order_tyumonlistF0();


		String tbl2=new String();


		for(int i=0;i<oblist4.size();i++){ //条件に当てはまる注文件数だけ繰り返す。
			oblist3=OK.Order_zyutyulistF0(oblist4.get(i).getOrder_no());
			if(i==0){
				hanteiclass=" in";
				Togclass="";
			}else{
				hanteiclass="";
				Togclass=" class='collapsed'";
			}
			tbl2+="<div class='panel panel-default'>" +
				"<div class='panel-heading'>" +
				"<h4 class='panel-title accordion-toggle'>" +
				"<a data-toggle='collapse' data-parent='#accordion' href='#collapseD"+i+"'"+Togclass+">" +
				"<table class='table'>" +
				"<thead><tr><th class='col-sm-1'>"+oblist4.get(i).getOrder_no()+"</th>" + 	//変数
				"<th class='col-sm-2'>"+oblist4.get(i).getMem_name()+"</th>" +	//変数
				"<th class='col-sm-3'>"+oblist4.get(i).getOrder_date()+"</th>" +	//変数
				" <input type='hidden' name='memid' class='memid' value='"+oblist4.get(i).getMem_no()+"'>"+
				"</tr></thead></table>注文明細</a></h4></div>" +
				"<div id='collapseD"+i+"' class='panel-collapse collapse "+hanteiclass+"'>" +
				"<div class='panel-body'><table class='table'><thead><tr><th>商品ID</th><th>商品名</th><th>注文個数</th><th>受注済みチェック</th></tr></thead>";
			tbl2+="<tbody>";

			for(int i2=0;i2<oblist3.size();i2++){ //注文番号の注文明細の数だけ繰り返す
				tbl2+="<tr>";
				tbl2+="<td class='proid'>"+oblist3.get(i2).getProduct_id()+"</td>";
				tbl2+="<td>"+oblist3.get(i2).getProduct_name()+"</td>";
				tbl2+="<td class='quan'>"+oblist3.get(i2).getQuantity()+"</td>";
				if(IC.henkan(oblist3.get(i2).getRece_flg())==0){
					tbl2+="<td><button type='submit' class='btn btn-primary haisou'><font size='1'>配送命令</font></button></td>";
				}else{
					tbl2+="<td><i class='material-icons' style='color: #7BE04F'>check_circle</i></td>";
				}

	      		tbl2+="</tr>";
			}
			tbl2+="</tbody></table></div></div></div>";

		}



		String tbl3 = new String();
		TekiKanriClass TK = new TekiKanriClass();
		List<Subscriptionsbean> sublist = new ArrayList<Subscriptionsbean>();
		List<Subscriptionsbean> sublist2 = new ArrayList<Subscriptionsbean>();

		sublist2=TK.TekimemlistToday();

		for(int i=0;i<sublist2.size();i++){ //条件に当てはまる注文件数だけ繰り返す。
			sublist=TK.TekilistToday(sublist2.get(i).getMem_no());
			if(i==0){
				hanteiclass=" in";
				Togclass="";
			}else{
				hanteiclass="";
				Togclass=" class='collapsed'";
			}
			tbl3+="<div class='panel panel-default'>" +
				"<div class='panel-heading' style='height:150px'>" +
				"<h4 class='panel-title accordion-toggle pull-left'>" +
				"<table class='table'>" +
				"<thead><tr><th class='col-sm-1'>"+sublist2.get(i).getMem_no()+"</th>" + 	//変数
				"<th class='col-sm-2'>"+sublist2.get(i).getMem_name()+"</th>" +	//変数
				"<th class='col-sm-2'>"+sublist2.get(i).getP_start()+"</th>" +	//変数
				"<th class='col-sm-2'><button type='submit' class='btn btn-primary tyumon'><font size='1'>注文処理</font></button></th>" +	//変数
				"</tr></thead></table><a data-toggle='collapse' data-parent='#accordion' href='#collapseT"+i+"'"+Togclass+"> 定期購入明細</a></h4></div>" +
				"<div id='collapseT"+i+"' class='panel-collapse collapse "+hanteiclass+"'>" +
				"<div class='panel-body'><table class='table'><thead><tr><th>商品ID</th><th>商品名</th><th>注文個数</th><th>定期購入期間</th></tr></thead>";
			tbl3+="<tbody>";

			for(int i2=0;i2<sublist.size();i2++){ //
				System.out.println("sublistsize="+sublist.size());
				tbl3+="<tr>";
				tbl3+="<td class='proid'>"+sublist.get(i2).getProduct_id()+"</td>";
				tbl3+="<td>"+sublist.get(i2).getProduct_name()+"</td>";
				tbl3+="<td class='quan'>"+sublist.get(i2).getQuantity()+"</td>";
				tbl3+="<td class='kikan'>"+sublist.get(i2).getP_period()+"</td>";


	      		tbl3+="</tr>";
			}
			tbl3+="</tbody></table></div></div></div>";

		}







		String Hairetu[] = {tbl,tbl2,tbl3};







		session.setAttribute("list1", Hairetu);

		if(flag!=null){
			System.out.println("ZyutyuTopServlet:ajaxつかった。");
			session.removeAttribute("list1");
			PrintWriter out = response.getWriter();
		    out.println(JSON.encode(Hairetu));

		}else{
			System.out.println("ZyutyuTopServlet:ajaxつかってない。");
			RequestDispatcher dispatcher=request.getRequestDispatcher("ZyutyuTop.jsp");
			dispatcher.forward(request,response);
		}


	}

}
