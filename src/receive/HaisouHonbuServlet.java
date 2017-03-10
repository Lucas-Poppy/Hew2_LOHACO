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
import beans.Receive_details;
import benefit.IntegerCheck;

/**
 * Servlet implementation class HaisouHonbuServlet
 */
@WebServlet("/HaisouHonbuServlet")
public class HaisouHonbuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HaisouHonbuServlet() {
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
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF8");


		HttpSession session = request.getSession();

		String tbl=new String();
		String flag = request.getParameter("flag");
		ReceiveKanriClass RK = new ReceiveKanriClass();
		List<Receive_details> rdlist = new ArrayList<Receive_details>();
		List<Receive_details> rdlist2 = new ArrayList<Receive_details>();

		List<Receive_details> rdlist3 = new ArrayList<Receive_details>();
		IntegerCheck IC = new IntegerCheck();


		rdlist2=RK.Flg0allGroupby();
		rdlist3=RK.Flg1allGroupby();
		System.out.println(rdlist.size());

		String hanteiclass=" in";




		for(int i=0;i<rdlist2.size();i++){
			rdlist=RK.Flg0all(rdlist2.get(i).getOrder_no());
			if(i==0){
				hanteiclass=" in";
			}else{
				hanteiclass="";
			}
			tbl+="<div class='panel panel-default'>" +
				"<div class='panel-heading'>" +
				"<h4 class='panel-title accordion-toggle'>" +
				"<a data-toggle='collapse' data-parent='#accordion' href='#collapse"+i+"'>" +
				"<table class='table'>" +
				"<thead><tr><th class='col-sm-1'>"+rdlist2.get(i).getOrder_no()+"</th>" + 	//変数
				"</tr></thead></table>注文明細</a></h4></div>" +
				"<div id='collapse"+i+"' class='panel-collapse collapse "+hanteiclass+"'>" +
				"<div class='panel-body'><table class='table'><thead><tr><th>商品名</th><th>倉庫名</th><th>配送個数</th><th>配送済みチェック</th></tr></thead>";
			tbl+="<tbody>";
			for(int i2=0;i2<rdlist.size();i2++){
				tbl+="<tr>";
				tbl+="<td class='proid'>"+rdlist.get(i2).getProduct_name()+"</td>";
				tbl+="<td>"+rdlist.get(i2).getWarehouse_name()+"</td>";
				tbl+="<td class='quan'>"+rdlist.get(i2).getQuantity()+"</td>";
				if(IC.henkan(rdlist.get(i2).getDELIVERY_FLG())==0){
					tbl+="<td><i class='material-icons' style='color: #FD2626'>not_interested</i></td>";
				}else if(IC.henkan(rdlist.get(i2).getDELIVERY_FLG())==2){
					tbl+="<td><i class='material-icons' style='color: #999999'>local_shipping</i></td>";
				}else{
					tbl+="<td><i class='material-icons' style='color: #7BE04F'>check_circle</i></td>";
				}

	      		tbl+="</tr>";
			}
			tbl+="</tbody></table></div></div></div>";

		}

		String tbl2 = new String();

		for(int i=0;i<rdlist3.size();i++){
			rdlist=RK.Flg0all(rdlist3.get(i).getOrder_no());
			if(i==0){
				hanteiclass=" in";
			}else{
				hanteiclass="";
			}
			tbl2+="<div class='panel panel-default'>" +
				"<div class='panel-heading'>" +
				"<h4 class='panel-title accordion-toggle'>" +
				"<a data-toggle='collapse' data-parent='#accordion' href='#collapseT"+i+"'>" +
				"<table class='table'>" +
				"<thead><tr><th class='col-sm-1'>"+rdlist3.get(i).getOrder_no()+"</th>" + 	//変数
				"</tr></thead></table>注文明細</a></h4></div>" +
				"<div id='collapseT"+i+"' class='panel-collapse collapse "+hanteiclass+"'>" +
				"<div class='panel-body'><table class='table'><thead><tr><th>商品名</th><th>倉庫名</th><th>配送個数</th><th>配送済みチェック</th></tr></thead>";
			tbl2+="<tbody>";
			for(int i2=0;i2<rdlist.size();i2++){
				tbl2+="<tr>";
				tbl2+="<td class='proid'>"+rdlist.get(i2).getProduct_name()+"</td>";
				tbl2+="<td>"+rdlist.get(i2).getWarehouse_name()+"</td>";
				tbl2+="<td class='quan'>"+rdlist.get(i2).getQuantity()+"</td>";
				if(IC.henkan(rdlist.get(i2).getDELIVERY_FLG())==0){
					tbl2+="<td><i class='material-icons' style='color: #FD2626'>not_interested</i></td>";
				}else{
					tbl2+="<td><i class='material-icons' style='color: #7BE04F'>check_circle</i></td>";
				}

	      		tbl2+="</tr>";
			}
			tbl2+="</tbody></table></div></div></div>";

		}

		String hairetu[]={tbl,tbl2};


		session.setAttribute("honbulist", hairetu);

		if(flag!=null){
			System.out.println("HaisouHonbuServlet:ajaxつかった。");
			session.removeAttribute("honbulist");
			PrintWriter out = response.getWriter();
		    out.println(JSON.encode(hairetu));
		}else{
			System.out.println("HaisouHonbuServlet:ajaxつかってない。");
			RequestDispatcher dispatcher=request.getRequestDispatcher("HaisouHonbu.jsp");
			dispatcher.forward(request,response);
		}



	}

}
