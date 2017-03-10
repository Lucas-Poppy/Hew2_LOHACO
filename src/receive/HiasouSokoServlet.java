package receive;

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
import stock.StockKanriClass;
import beans.Haisoubean;
import beans.Haitatsubean;
import beans.Kokyakubean;

/**
 * Servlet implementation class HiasouSokoServlet
 */
@WebServlet("/HiasouSokoServlet")
public class HiasouSokoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HiasouSokoServlet() {
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
		String warehouseid=request.getParameter("wareid");
		StockKanriClass SK = new StockKanriClass();
		String warename= SK.WareName(warehouseid);

		System.out.println("haisousokoservletのAjaxから送られてきた"+warehouseid);


		HttpSession session = request.getSession();

		String tbl=new String();
		String tbl2=new String();
		String flag = request.getParameter("flag");
		ReceiveKanriClass RK = new ReceiveKanriClass();
		List<Haisoubean> rdlist = new ArrayList<Haisoubean>();

		rdlist=RK.Flg0sokoall(warehouseid);
			tbl="<table class='mui-table mui-table--bordered'><thead><tr>" +
					"<input type='hidden' name='wareid' value='"+warehouseid+"'>" +
					"<th>注文番号</th><th>商品ID</th>" +
					"<th>商品名</th><th>数量</th>" +
					"<th>顧客名</th><th>顧客郵便番号</th><th>顧客住所</th></tr></thead><tbody>";

		for(int i=0;i<rdlist.size();i++){
			tbl+="<tr id='rdlist"+i+1+"'>" +
					"<td>"+rdlist.get(i).getOrder_no()+"</td>" +
					"<td>"+rdlist.get(i).getProduct_id()+"</td>" +
					"<td>"+rdlist.get(i).getProduct_name()+"</td>"+
					"<td>"+rdlist.get(i).getQuantity()+"</td>"+
					"<td>"+rdlist.get(i).getMem_name()+"</td>"+
					"<td>"+rdlist.get(i).getMem_yubin()+"</td>"+
					"<td>"+rdlist.get(i).getMem_zyusyo()+"</td>";
				if(rdlist.get(i).getFlg().equals("0")){
					tbl+="<td><button type='submit' class='btn btn-success deliStart'><font size='1'>配送開始</font></button></td>";
				}else if(rdlist.get(i).getFlg().equals("2")){
					tbl+="<td><button type='submit' class='btn btn-primary deliOK'><font size='1'>配送完了</font></button></td>";
				}
					tbl+="</tr>";
		}
		tbl+="</tbody></table>";

		String haitaclass = "in";
		String Togclass="";

		List<Haitatsubean> haitalist = new ArrayList<Haitatsubean>();
		List<Kokyakubean> kokyakulist = new ArrayList<Kokyakubean>();
		kokyakulist = RK.selectKokyaku(warehouseid);

		tbl2="<table class='mui-table mui-table--bordered'><thead><tr>" +
				"<th class='col-sm-0.5'>注文番号</th><th  class='col-sm-2'>注文日時</th>" +
				"<th  class='col-sm-0.5'>顧客名</th><th  class='col-sm-0.5'>顧客郵便番号</th>" +
				"<th  class='col-sm-2'>顧客住所</th><th  class='col-sm-0.5'>伝票発行</th></tr></thead></table>";

		for(int i=0; i<kokyakulist.size(); i++){
			haitalist = RK.selectHaitatsu(kokyakulist.get(i).getWarehouseid(),kokyakulist.get(i).getOrder_no());
			System.out.println(haitalist.size());
			System.out.println(haitalist.get(0).getPro_id());

			if(i==0){
				haitaclass = "in";
				Togclass="";
			}else{
				haitaclass = "";
				Togclass=" class='collapsed'";
			}
			tbl2	+= "<div class='panel panel-default'>"
					+ "<div class='panel-heading'>"
					+ "<h4 class='panel-title accordion-toggle'>"
					+ "<table class='table'>"
					+ "<thead><tr><th class='col-sm-2'>" + kokyakulist.get(i).getOrder_no() + "</th>"	//注文番号
					+ "<th class='col-sm-2'>" + kokyakulist.get(i).getOrder_date() + "</th>"			//注文日
					+ "<th class='col-sm-0.5'>" + kokyakulist.get(i).getMem_name() + "</th>"			//顧客名
					+ "<th class='col-sm-0.5'>〒" + kokyakulist.get(i).getMem_pscd() + "</th>"			//配達先郵便番号
					+ "<th class='col-sm-2'>" + kokyakulist.get(i).getAddress() + "</th>"			//配達先住所
					+ "<th class='col-sm-0.5'><form action='DenpyoServlet' target='_blank' id='form"+i+"'><button type='submit' class='print btn btn-primary'>印刷</button></form></th>"
					+ "</tr></thead></table><a data-toggle='collapse' data-parent='#accordion' href='#collapse"+i+"'"+Togclass+">配送明細</a></h4></div>"
					+ "<div id='collapse"+i+"' class='panel-collapse collapse "+haitaclass+"'>"
					+ "<div class='panel-body'><table class='table printbl'><thead><tr><th>商品ID</th><th>商品名</th><th>配送個数</th></tr></thead>";
			// 以下、明細情報
			tbl2	+= "<tbody>";
			for(int i2=0; i2<haitalist.size();i2++){
				tbl2 += "<tr>";
				tbl2 += "<td>" + haitalist.get(i2).getPro_id() + "</td>";
				tbl2 += "<td>" + haitalist.get(i2).getPro_name() + "</td>";
				tbl2 += "<td>" + haitalist.get(i2).getQuantity() + "</td>";
				tbl2 += "</tr>";

			}
			tbl2 += "</tbody></table></div></div></div>";
		}



		String hairetu[]={tbl,tbl2};

		session.setAttribute("haitatsu", hairetu);
		session.setAttribute("sokomei",warename);

		if(flag!=null){
			System.out.println("HiasouSokoServlet:ajaxつかった。");
			session.removeAttribute("haisolist");
			PrintWriter out = response.getWriter();
		    out.println(JSON.encode(hairetu));

		}else{
			System.out.println("HiasouSokServlet:ajaxつかってない。");
			RequestDispatcher dispatcher=request.getRequestDispatcher("HaisoSoko.jsp");
			dispatcher.forward(request,response);
		}
	}


}
