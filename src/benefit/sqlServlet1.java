package benefit;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class sqlServlet1
 */
@WebServlet("/sqlServlet1")
public class sqlServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public sqlServlet1() {
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
		//商品番号,'商品名',値段,売れる個数,売れる数のばらつきの平均個数,カテゴリーID
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String pro = request.getParameter("pro");
		String proarry1[] = pro.replaceAll("[\r\n/\t]", "").split(";", 0);
		System.out.println("------------------------------------------");
		System.out.println(proarry1.length);
		String[][] sql = new String[proarry1.length][6];
		int[] anzen = new int[proarry1.length];
		int[] hatyuten =new int[proarry1.length];
		int[] Saiteki=new int[proarry1.length];



		for(int i=0;i<proarry1.length;i++){
			//System.out.println(proarry1[i]);
			String	proarry2[]=proarry1[i].split(",",0);
			for(int i2=0;i2<proarry2.length;i2++){
				sql[i][i2]=proarry2[i2].replaceAll("\r\n", "");
				//System.out.println(sql[i][i2]);
			}

		}


		TeiryoHatyuSystemClass ths = new TeiryoHatyuSystemClass();
		for(int i=0;i<sql.length;i++){
			anzen[i]=ths.AnzenZaiko(Integer.parseInt(sql[i][4]));
			hatyuten[i]=ths.Hatyuten(Integer.parseInt(sql[i][3]),3, anzen[i]);
			Saiteki[i]=ths.SaitekiHatyu(Integer.parseInt(sql[i][3])*365, ths.KonyuTanka(Integer.parseInt(sql[i][2])));
		}
		String tbl = new String();
		tbl="insert into Products values(商品ID,'商品名',販売価格,購入単価,カテゴリーID,在庫保管比率,標準偏差^2,安全在庫数,年間需要個数,最適発注量,発注点,調達期間,'画像ファイル名',発注フラグ)<br>";
		for(int i=0;i<sql.length;i++){
			tbl+="insert into products values("+sql[i][0]+","+sql[i][1]+","+sql[i][2]+","+ths.KonyuTanka(Integer.parseInt(sql[i][2]))+","+sql[i][5]+",0.25,"+sql[i][4]+","+anzen[i]+","+Integer.parseInt(sql[i][3])*365+","+Saiteki[i]+","+hatyuten[i]+",3,'"+sql[i][0]+".jpg',1);<br>";
		}

		session.setAttribute("tbl", tbl);
		RequestDispatcher dispatcher=request.getRequestDispatcher("SQL/sql_kekka.jsp");
		dispatcher.forward(request,response);

	}

}
