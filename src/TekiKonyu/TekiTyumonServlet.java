package TekiKonyu;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import order.OrderKanriClass;
import products.ProductKanriClass;
import beans.Productsbean;
import beans.Subscriptionsbean;

/**
 * Servlet implementation class TekiTyumonServlet
 */
@WebServlet("/TekiTyumonServlet")
public class TekiTyumonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TekiTyumonServlet() {
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

		String memno = request.getParameter("memno");
		//商品情報取得
		ProductKanriClass pk = new ProductKanriClass();
		//注文管理クラス
		OrderKanriClass OK = new OrderKanriClass();
		String no=OK.OrderNo();//次に使う注文Noの取得

		//注文の生成
		OK.OrderInsert(no,memno);
		TekiKanriClass TK = new TekiKanriClass();
		List<Subscriptionsbean> sublist = new ArrayList<Subscriptionsbean>();
		sublist=TK.TekilistToday(memno);
		System.out.println("sublistのサイズは"+sublist.size());
		for(int i=0;i<sublist.size();i++){
			Productsbean pbean;
			try {
				pbean = pk.getSelectOne(sublist.get(i).getProduct_id());
				System.out.println("proidは"+sublist.get(i).getProduct_id());
				System.out.println("個数は"+sublist.get(i).getQuantity());

				OK.insertOrder_detail(no, sublist.get(i).getProduct_id(), pbean.getProduct_sale_price(),sublist.get(i).getQuantity());

				TK.UpdateDate(sublist.get(i).getProduct_id(), memno);
			} catch (SQLException e) {
//				// TODO 自動生成された catch ブロック
//				e.printStackTrace();
			}
		}


	}

}
