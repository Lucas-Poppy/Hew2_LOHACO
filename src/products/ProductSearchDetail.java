package products;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Productsbean;
import benefit.IntegerCheck;

/**
 * Servlet implementation class ProductSearchDetail
 */
@WebServlet("/ProductSearchDetail")
public class ProductSearchDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductSearchDetail() {
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
		request.setCharacterEncoding("UTF8");

		String proid = (String)request.getParameter("proid");
		String[] tbl = new String[6];
		IntegerCheck IC = new IntegerCheck();
		HttpSession session = request.getSession();
		String catename = "";

		System.out.println(proid);

		if( IC.procheck(proid) == false ){
			tbl[0] = "存在する商品がありません";
			tbl[1] = "存在する商品がありません";
			tbl[2] = "";
			tbl[3] = "カテゴリ―:";
			tbl[4] = "";
			tbl[5] = "在庫なし";
		}else{
			ProductKanriClass productskanri = new ProductKanriClass();
			try {
				Productsbean productlist = productskanri.getSelectOne(proid);
				catename = "カテゴリー:　" + productskanri.getCategorySelect(productlist.getCategory_id());
				if(productlist != null){

				tbl[0] = "images/" + productlist.getImage_file_name();
				tbl[1] = productlist.getProduct_name();
				tbl[2] = productlist.getProduct_sale_price();
				tbl[3] = catename;
				tbl[4] = productlist.getProduct_id();
				tbl[5] = "在庫あり";

				}
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		session.setAttribute("selecttbl", tbl);

		RequestDispatcher disp = request.getRequestDispatcher("product.jsp");
		disp.forward(request,response);
	}

}
