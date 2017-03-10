package ordering;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.arnx.jsonic.JSON;
import stock.StockKanriClass;
import beans.Stockbean;
import benefit.HatyuWarihuriClass;
import benefit.IntegerCheck;

/**
 * Servlet implementation class OrderingModalServlet
 */
@WebServlet("/OrderingModalServlet")
public class OrderingModalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderingModalServlet() {
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
		 request.setCharacterEncoding("UTF8");
	      response.setContentType("text/html; charset=UTF8");
	      //

	      System.out.println("OrderingModal開始");

	      String quantity=null;
	      String proid = null;
	      String proname = null;
	      String tbl=new String();
	      try {

	        quantity=request.getParameter("quantity");
	        proid = request.getParameter("proid");
	        proname=request.getParameter("proname");

	        StockKanriClass SK = new StockKanriClass();
	        List<Stockbean> sbean = new ArrayList<Stockbean>();
	        HatyuWarihuriClass HW = new HatyuWarihuriClass();
	        IntegerCheck IC = new IntegerCheck();





	        int kosu[] = new int[5];
	        kosu =HW.Warihuri(IC.henkan(quantity));




	        //倉庫のIDで在庫を検索する
	        sbean=SK.id_search(proid);



	        //表示するモーダルの作成


			tbl="" +
					"<button data-remodal-action='close' class='remodal-close'></button>" +
					"<input type='hidden' name='proid' value='"+proid+"'>"+
					"<table class='mdl-data-table mdl-js-data-table  mdl-shadow--2dp' style='margin-bottom: 10px;'>" +
					"<div class='h3 title pull-left'><div class='protitle pull-left'>　"+proname+ "</div><span id='sum'>"+quantity+"</span>個　　<span id='sa'>誤差0個</span></div>" +//変数
					"<thead><tr><th class='mdl-data-table__cell--non-numeric'>倉庫名</th><th>在庫数</th><th>倉庫住所</th><th>個数選択</th></tr></thead><tbody>";
	        for(int i=0;i<sbean.size();i++){
	        	tbl+="<tr>" +
						"<td class='mdl-data-table__cell--non-numeric'>"+sbean.get(i).getWarehouse_name()+"</td>"+ //変数
						"<td>"+sbean.get(i).getQuantity()+"個</td>" +
						"<td>"+sbean.get(i).getW_pref()+sbean.get(i).getW_minu()+sbean.get(i).getW_ads()+"</td>" +
						"<td><input type='number' min='1' name='kosu' id='kosu' value='"+kosu[i]+"'></td>" +
						"</tr>";
	        }
			tbl+="</tbody></table><button data-remodal-action='cancel' class='remodal-cancel'>Cancel</button><button data-remodal-action='confirm' class='remodal-confirm Hatyu'>配送命令</button>";


	      }
	      catch(Exception ex) {
	        // 無視 ⇒ 0になる
	      }

	      //
	      // カウントをクライアントに戻す
	      // 本当は、JSONとかXMLにする⇒サンプルなので許す
	      PrintWriter out = response.getWriter();
	      out.println(JSON.encode(tbl));

	}

}
