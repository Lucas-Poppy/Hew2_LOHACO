package cart;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.CookieMemidGet;
import products.ProductKanriClass;
import TekiKonyu.TekiKanriClass;
import beans.Productsbean;
import benefit.IntegerCheck;

/**
 * Servlet implementation class TekiSyoriServlet
 */
@WebServlet("/TekiSyoriServlet")
public class TekiSyoriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TekiSyoriServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String tekihantei = (String)request.getParameter("tekihantei"); //0のとき確認画面 1のとき
		String proid = request.getParameter("proid");
		String quantity=request.getParameter("quantity2");
		String p_period = request.getParameter("tekikikan");
		String url = "";
		String hairetu[] = new String[5];
		String memno = (String)request.getAttribute("memno");
		if(memno == null){
			memno = CookieMemidGet.getCookie(request, "memno");
		}

		if(memno == null || memno.equals("")){
			request.setAttribute("tekihantei",tekihantei);
			request.setAttribute("url", "ProductSearchDetail?proid=" + proid);
			RequestDispatcher disp = request.getRequestDispatcher("login.jsp");
			disp.forward(request, response);
		}else{
			ProductKanriClass PK = new ProductKanriClass();
			Productsbean pbean;
			if(proid!=null){
				try {
					pbean = PK.getSelectOne(proid);
					 hairetu[0] = pbean.getProduct_name();
					 hairetu[1] =pbean.getProduct_sale_price();
					 hairetu[2] =quantity;
					 hairetu[3] =p_period;
					 hairetu[4] =proid;
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}


			IntegerCheck IC = new IntegerCheck();

			TekiKanriClass TK = new TekiKanriClass();

			if(tekihantei.equals("0")){
				//確認画面の処理
				session.setAttribute("tekicheck",hairetu);
				url="regularlycheck.jsp";


			}else if(tekihantei.equals("1")){
				String hairetu2[]=(String[])session.getAttribute("tekicheck");
				TK.Insert(memno, hairetu2[4], hairetu2[3], hairetu2[2]);
				url="TekiTopServlet";


			}else if(tekihantei.equals("2")){
				System.out.println("削除確認" + proid + memno);

				TK.Delete(proid, memno);
				url="TekiTopServlet";
			}

			RequestDispatcher disp = request.getRequestDispatcher(url);
			disp.forward(request, response);
		}



	}

}
