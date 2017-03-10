package receive;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import benefit.IntegerCheck;
import db_connect.DBManager;

/**
 * Servlet implementation class ReceiveKanriServlet
 */
@WebServlet("/ReceiveKanriServlet")
public class ReceiveKanriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceiveKanriServlet() {
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
		request.setCharacterEncoding("UTF8");
	      response.setContentType("text/html; charset=UTF8");
		String Orderno = (String)request.getParameter("orderno"); //getParameterで取得
		String Proid = (String)request.getParameter("proid"); //getParameterで取得
		String Quant1 = (String)request.getParameter("kosu1"); //getParameterで取得
		String Quant2 = (String)request.getParameter("kosu2"); //getParameterで取得
		String Quant3 = (String)request.getParameter("kosu3"); //getParameterで取得
		String Quant4 = (String)request.getParameter("kosu4"); //getParameterで取得
		String Quant5 = (String)request.getParameter("kosu5"); //getParameterで取得
		String Quant = new String();
//		System.out.println("Orderno="+Orderno);
//		System.out.println("Proid="+Proid);
//		System.out.println("Quant1="+Quant1);
//		System.out.println("="+Orderno);
//		System.out.println("Orderno="+Orderno);
//		System.out.println("Orderno="+Orderno);


		IntegerCheck IC = new IntegerCheck();
		ReceiveKanriClass receivekanri = new ReceiveKanriClass();

		int Quant1_1 = IC.henkan(Quant1);
		int Quant2_1 = IC.henkan(Quant2);
		int Quant3_1 = IC.henkan(Quant3);
		int Quant4_1 = IC.henkan(Quant4);
		int Quant5_1 = IC.henkan(Quant5);
		Connection con;

		try{
			con=DBManager.getConnection();
			con.setAutoCommit(false);
			if(Quant1_1 != 0){
				Quant = Quant1;

				/* 受注Insert */
				receivekanri.ReceiveInsert(Orderno, Proid,"1", Quant);
				/* 在庫Update */
				receivekanri.StockUpdate(Quant,"1", Proid);
			}
			if(Quant2_1 != 0){
				Quant = Quant2;

				/* 受注Insert */
				receivekanri.ReceiveInsert(Orderno, Proid,"2", Quant);
				/* 在庫Update */
				receivekanri.StockUpdate(Quant,"2", Proid);
			}
			if(Quant3_1 != 0){
				Quant = Quant3;

				/* 受注Insert */
				receivekanri.ReceiveInsert(Orderno, Proid, "3", Quant);
				/* 在庫Update */
				receivekanri.StockUpdate(Quant,"3", Proid);
			}
			if(Quant4_1 != 0){
				Quant = Quant4;

				/* 受注Insert */
				receivekanri.ReceiveInsert(Orderno, Proid, "4", Quant);
				/* 在庫Update */
				receivekanri.StockUpdate(Quant, "4", Proid);
			}
			if(Quant5_1 != 0){
				Quant = Quant5;

				/* 受注Insert */
				receivekanri.ReceiveInsert(Orderno, Proid, "5", Quant);
				/* 在庫Update */
				receivekanri.StockUpdate(Quant, "5", Proid);
			}

				/* 注文Update */
				receivekanri.OrderDetailUpdate(Orderno, Proid);

			con.commit();
		}catch (Exception e){

		}



	}

}
