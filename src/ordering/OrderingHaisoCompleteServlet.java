package ordering;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import products.ProductKanriClass;
import stock.StockKanriClass;
import benefit.IntegerCheck;
import db_connect.DBManager;

/**
 * Servlet implementation class OrderingHaisoCompleteServlet
 */
@WebServlet("/OrderingHaisoCompleteServlet")
public class OrderingHaisoCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderingHaisoCompleteServlet() {
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
		request.setCharacterEncoding("UTF8");
	      response.setContentType("text/html; charset=UTF8");
		String Proid = (String)request.getParameter("proid"); //getParameterで取得
		String Quant1 = (String)request.getParameter("kosu1"); //getParameterで取得
		String Quant2 = (String)request.getParameter("kosu2"); //getParameterで取得
		String Quant3 = (String)request.getParameter("kosu3"); //getParameterで取得
		String Quant4 = (String)request.getParameter("kosu4"); //getParameterで取得
		String Quant5 = (String)request.getParameter("kosu5"); //getParameterで取得
		String Quant = new String();

		IntegerCheck IC = new IntegerCheck();
		StockKanriClass SK = new StockKanriClass();
		ProductKanriClass PK = new ProductKanriClass();
		OrderingKanriClass OK = new OrderingKanriClass();
		int orderingno=OK.OrderingNoGet();

		int Quant1_1 = IC.henkan(Quant1);
		int Quant2_1 = IC.henkan(Quant2);
		int Quant3_1 = IC.henkan(Quant3);
		int Quant4_1 = IC.henkan(Quant4);
		int Quant5_1 = IC.henkan(Quant5);
		int sum = Quant1_1+Quant2_1+Quant3_1+Quant4_1+Quant5_1;
		Connection con;

		try{
			con=DBManager.getConnection();
			con.setAutoCommit(false);
			OK.insertOrdering(Proid, orderingno,sum);


			if(Quant1_1 != 0){
				Quant = Quant1;
				SK.stockpulus(Quant, "1", Proid);
				OK.insertOrderingDetail(orderingno, Quant,1);



			}
			if(Quant2_1 != 0){
				Quant = Quant2;

				SK.stockpulus(Quant, "2", Proid);
				OK.insertOrderingDetail(orderingno, Quant,2);

			}
			if(Quant3_1 != 0){
				Quant = Quant3;
				SK.stockpulus(Quant, "3", Proid);
				OK.insertOrderingDetail(orderingno, Quant,3);


			}
			if(Quant4_1 != 0){
				Quant = Quant4;
				SK.stockpulus(Quant, "4", Proid);
				OK.insertOrderingDetail(orderingno, Quant,4);

			}
			if(Quant5_1 != 0){
				Quant = Quant5;
				SK.stockpulus(Quant, "5", Proid);
				OK.insertOrderingDetail(orderingno, Quant,5);


			}

			PK.productflg(Proid);
			con.commit();
		}catch (Exception e){

		}

	}

}
