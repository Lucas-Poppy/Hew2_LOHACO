package order;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.CookieMemidGet;
import mail.MaikSendClass;
import member.MemberKanriClass;
import products.ProductKanriClass;
import beans.Cartbean;
import beans.Creditcardbean;
import beans.Memberbean;
import beans.Productsbean;
import benefit.IntegerCheck;
import benefit.MaskCnt;
import cart.CartKanriClass;

/**
 * Servlet implementation class OrderKanriServlet
 */
@WebServlet("/OrderKanriServlet")
public class OrderKanriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderKanriServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String memno = CookieMemidGet.getCookie(request, "memno");
		IntegerCheck IC = new IntegerCheck();
		String order = (String)request.getParameter("orderhantei");
		if(order == null){
			order = "";
		}
		int orderhantei = IC.henkan(order);

		String proid = new String();
		String quantity = new String();
		String price = new String();
		String tbl = new String();
		int proprice = 0;
		int kosu = 0;
		int sumprice = 0;
		int allsumprice = 0;
		String tbl2[] = new String[4];
		String tbl3[] = new String[5];
		String url = "ordercheck.jsp";

		//カート管理クラス
		CartKanriClass CK = new CartKanriClass();

		//カートから情報をとってくる　後で追記
		List<Cartbean> cartlist = new ArrayList<Cartbean>();

		//商品情報取得
		ProductKanriClass productkanri = new ProductKanriClass();

		cartlist = CK.getCartSelect(memno);

		for(int i=0; cartlist.size()>i; i++){
			proid = cartlist.get(i).getProduct_id();
			tbl += "<tr>";

			try {
				Productsbean productlist = productkanri.getSelectOne(proid);

				proprice = IC.henkan(productlist.getProduct_sale_price());
				kosu = IC.henkan(cartlist.get(i).getQuanity());
				sumprice = proprice * kosu;

				if(productlist != null){
					tbl += "<td><a href='ProductSearchDetail?proid=" + proid + "' class='textcolorblue'>" + productlist.getProduct_name() + "</a></td>";
					tbl += "<td>￥" + productlist.getProduct_sale_price() + "</td>";
					tbl += "<td>" + cartlist.get(i).getQuanity() + "</td>";
					tbl += "<td>￥" + sumprice + "</td>";
				}

				allsumprice += sumprice;
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		tbl += "</tr><tr class='warning'><td colspan='3'>合計金額</td>";
		tbl += "<td id='allprice'>￥" + allsumprice + "</td></tr>";

		System.out.println(tbl);
		request.setAttribute("ordertbl", tbl);

		//クレジットカード情報取得
		CreditecardKanriClass creditekanri = new CreditecardKanriClass();
		Creditcardbean creditelist = creditekanri.CreditSelectOne(memno);

		//クレジットカード番号暗号化
		MaskCnt MC = new MaskCnt();
		String num = creditelist.getCard_num();
		num = MC.masktest(num, 15);

		tbl2[0] = "<td>" + num + "</td>";
		tbl2[1] = "<td>" + creditelist.getCard_kind() + "</td>";
		tbl2[2]	= "<td>" + creditelist.getCard_name() + "</td>";
		tbl2[3] = "<td>" + creditelist.getCard_limit() + "</td>";

		System.out.println(tbl2);
		request.setAttribute("credittbl", tbl2);

		MemberKanriClass memberkanri = new MemberKanriClass();
		Memberbean memberlist = memberkanri.men_info_zaikokanri(memno);

		tbl3[0] = "〒" + memberlist.getMem_pscd();
		tbl3[1] = memberlist.getMem_pref();
		tbl3[2] = memberlist.getMem_minu();
		tbl3[3] = memberlist.getMem_ads();
		tbl3[4] = memberlist.getMem_name();

		System.out.println(tbl3);
		request.setAttribute("membertbl", tbl3);

		if(orderhantei == 1){
			//注文管理クラス
			OrderKanriClass OK = new OrderKanriClass();
			String no=OK.OrderNo();//次に使う注文Noの取得

			//注文の生成
			OK.OrderInsert(no,memno);
			MemberKanriClass MK = new MemberKanriClass();
			Memberbean bean = MK.men_info_zaikokanri(memno);


			//注文明細の生成
			for(int i=0; cartlist.size()>i;i++){
				proid = cartlist.get(i).getProduct_id();
				quantity = cartlist.get(i).getQuanity();

				try{
					Productsbean productlist = productkanri.getSelectOne(proid);
					price = productlist.getProduct_sale_price();
				}catch(Exception e){e.printStackTrace();}

				OK.insertOrder_detail(no, proid, price, quantity);
				CK.getCartProductDelete(memno, proid);

				url = "ordercomp.jsp";
			}
			MaikSendClass.MailSend(request, response,bean.getMem_name() , bean.getMail_address());

		}
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);

	}

}
