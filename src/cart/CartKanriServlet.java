package cart;

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
import products.ProductKanriClass;
import beans.Cartbean;
import beans.Productsbean;
import benefit.IntegerCheck;

/**
 * Servlet implementation class CartKanriServlet
 */
@WebServlet("/CartKanriServlet")
public class CartKanriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartKanriServlet() {
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
		request.setCharacterEncoding("utf-8");
		IntegerCheck IC = new IntegerCheck();
		int hantei = (Integer)IC.henkan(request.getParameter("hantei"));
		String proid = (String)request.getParameter("proid");
		String quantity = (String)request.getParameter("quantity");
		String tbl = "";
		int price = 0;
		int kosu = 0;
		int sumprice = 0;
		int allsumprice = 0;
		String memno =  (String)request.getAttribute("memno");
		if(memno == null){
			memno = CookieMemidGet.getCookie(request, "memno");
		}

		if(memno == null || memno.equals("")){
			if(hantei == 2){
				request.setAttribute("url", "CartKanriServlet?hantei=3");
			}else{
				request.setAttribute("url", "ProductSearchDetail?proid=" + proid);
			}
			RequestDispatcher disp = request.getRequestDispatcher("login.jsp");
			disp.forward(request, response);

		}else{

//			System.out.println(hantei);
//			System.out.println(memno);
//			System.out.println(proid);
//			System.out.println(quantity);

			HttpSession session = request.getSession();
			CartKanriClass CKC = new CartKanriClass();
			List<Cartbean> cartlist = new ArrayList<Cartbean>();
			ProductKanriClass PKC = new ProductKanriClass();
			List<Productsbean> productslist = new ArrayList<Productsbean>();

			if(proid != null){
				boolean b = CKC.Exists(memno, proid);

				if(hantei == 0){
					if(b){
							CKC.CartUpdate(quantity, proid, memno);
						}else{
							CKC.CartInsert(memno, proid, quantity);
						}

				}else if(hantei == 1){
					CKC.getCartProductDelete(memno,proid);
				}
			}

			cartlist = CKC.getCartSelect(memno);

			tbl =   "<div class='col-md-7'>" +
					"<div class='alt-table-responsive'>" +
					"<table class='table'><thead><tr>" +
			        "<th class='col-xs-6 col-sm-6'>商品名</th>" +
					"<th class='col-xs-1 col-sm-1'>単価</th>" +
			        "<th class='col-xs-1 col-sm-1'>個数</th>" +
			        "<th class='col-xs-1 col-sm-1'>価格</th>" +
			        "<th class='col-xs-1 col-sm-1'>数変更</th>" +
			        "<th class='col-xs-2 col-sm-2'></th>" +
			        "</tr></thead><tbody>";

			for(int i=0;cartlist.size()>i;i++){
				productslist = PKC.CartPro(cartlist.get(i).getProduct_id());
				for(int i2=0;productslist.size()>i2;i2++){
					price = IC.henkan(productslist.get(i2).getProduct_sale_price());
					kosu = IC.henkan(cartlist.get(i).getQuanity());
					sumprice = price * kosu;

					tbl +=  "<tr>" +
							"<td class='col-xs-6 col-sm-6'><a href='ProductSearchDetail?proid=" + productslist.get(i2).getProduct_id() + "' class='textcolorblue'><div class='protitle'>" + productslist.get(i2).getProduct_name() + "</div></a></td>" +
					        "<td class='col-xs-1 col-sm-1'>￥" + productslist.get(i2).getProduct_sale_price() + "</td>" +
					        "<td class='col-xs-1 col-sm-1'>" + cartlist.get(i).getQuanity() + "</td>" +
					        "<td class='col-xs-1 col-sm-1'>￥" + sumprice + "</td>" +
					        "<td class='col-xs-1 col-sm-1'><button type='submit' class='btn btn-info center-block'>変更</button></td>" +
					        "<td class='col-xs-2 col-sm-2'><form action='CartKanriServlet' method='POST'><input type='hidden' name='hantei' value='1'><input type='hidden' name='proid' value='" + cartlist.get(i).getProduct_id() + "'>" +
					        "<button type='submit' class='btn btn-danger'><i class='material-icons'>remove_shopping_cart</i>カートから外す</button>" +
					        "</form></td>" +
					        "</tr>";

					allsumprice += sumprice;
					System.out.println(allsumprice);
				}
			}

			tbl += "<tr class='warning'><td colspan='5'>合計金額</td><td id='allprice'>￥" + allsumprice + "</td>";
			tbl += "</tr></tbody></table></div></div>";

			System.out.println(tbl);

			session.setAttribute("carttbl", tbl);
			session.setAttribute("allsumprice",allsumprice);

			RequestDispatcher dispatcher = request.getRequestDispatcher("cart.jsp");
			dispatcher.forward(request, response);
		}
	}

}
