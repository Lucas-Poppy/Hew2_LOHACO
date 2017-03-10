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
 * Servlet implementation class sql2Servlet
 */
@WebServlet("/sql2Servlet")
public class sql2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public sql2Servlet() {
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
		String row =request.getParameter("row");
		String tablename=request.getParameter("tablename");
		String sql1 = request.getParameter("sql");
		String sql2[] = sql1.replaceAll("[\r\n/\t]", "").split(";", 0);
		System.out.println("------------------------------------------");
		System.out.println(sql2.length);
		String[][] sql3 = new String[sql2.length][Integer.parseInt(row)];




		for(int i=0;i<sql2.length;i++){
			//System.out.println(proarry1[i]);
			String	sql4[]=sql2[i].split(",",0);
			for(int i2=0;i2<sql4.length;i2++){
				sql3[i][i2]=sql4[i2].replaceAll("\r\n", "");

			}
		}

			String tbl = new String();
			String colmus=new String();
			for(int i=0;i<sql3.length;i++){
				for(int i2=0;i2<sql3[1].length;i2++){
					if(i2==sql3[1].length-1){
					colmus+=sql3[i][i2];
					}else{
					colmus+=sql3[i][i2]+",";
					}
				}
				tbl+="insert into "+tablename+" values("+colmus+");<br>";
					colmus="";
			}
			session.setAttribute("tbl", tbl);

			RequestDispatcher dispatcher=request.getRequestDispatcher("SQL/sql_kekka.jsp");
			dispatcher.forward(request,response);







	}

}
