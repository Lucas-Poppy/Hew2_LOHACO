package stock;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberKanriClass;
import net.arnx.jsonic.JSON;
import beans.Stockbean;

/**
 * Servlet implementation class ZyutyuStockServlet
 */
@WebServlet("/ZyutyuStockServlet")
public class ZyutyuStockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZyutyuStockServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF8");
	      response.setContentType("text/html; charset=UTF8");
	      //
	      // クライアントから送信されてきたカウントを取得して更新する
	      String memid = null;
	      String orderno = null;
	      String quantity=null;
	      String proid = null;
	      String tbl=new String();
	      try {
	        memid=request.getParameter("memid");
	        orderno=request.getParameter("orderno");
	        quantity=request.getParameter("quantity");
	        proid = request.getParameter("proid");

	        StockKanriClass SK = new StockKanriClass();
	        List<Stockbean> sbean = new ArrayList<Stockbean>();

	        MemberKanriClass MK = new MemberKanriClass();



	        //倉庫のIDで在庫を検索する
	        sbean=SK.id_search(proid);


//
//	        //表示するモーダルの作成
//	        System.out.println("memid"+memid);


			tbl="" +
					"<button data-remodal-action='close' class='remodal-close'></button>" +
					"<input type='hidden' name='orderno' value='"+orderno+"'>"+
					"<input type='hidden' name='proid' value='"+proid+"'>"+
					"<table class='mdl-data-table mdl-js-data-table  mdl-shadow--2dp' style='margin-bottom: 10px;'>" +
					"<div class='h2 title pull-left'>"+MK.men_info_zaikokanri(memid).getMem_name()+"　　"+MK.men_info_zaikokanri(memid).getMem_pref()+"<span id='sum'>　　"+quantity+"</span>個　　<span id='sa'>誤差"+quantity+"個</span></div>" +//変数
					"<thead><tr><th class='mdl-data-table__cell--non-numeric'>倉庫名</th><th>在庫数</th><th>倉庫住所</th><th>個数選択</th></tr></thead><tbody>";
	        for(int i=0;i<sbean.size();i++){
	        	tbl+="<tr>" +
						"<td class='mdl-data-table__cell--non-numeric'>"+sbean.get(i).getWarehouse_name()+"</td>"+ //変数
						"<td>"+sbean.get(i).getQuantity()+"個</td>" +
						"<td>"+sbean.get(i).getW_pref()+sbean.get(i).getW_minu()+sbean.get(i).getW_ads()+"</td>" +
						"<td><input type='number' min='1' name='kosu' id='kosu'></td>" +
						"</tr>";
	        }
			tbl+="</tbody></table><button data-remodal-action='cancel' class='remodal-cancel'>Cancel</button><button data-remodal-action='confirm' class='remodal-confirm ZyutyuStock'>配送処理</button>";


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
