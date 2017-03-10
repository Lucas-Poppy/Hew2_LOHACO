package receive;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HaisouOKServlet
 */
@WebServlet("/HaisouOKServlet")
public class HaisouOKServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HaisouOKServlet() {
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

		System.out.println("HaisouOK ajaxきた");

		String wareid=request.getParameter("wareid");
		String proid = request.getParameter("proid");
		String orderno = request.getParameter("orderno");

		String deliflag=request.getParameter("deliflag"); //2なら配送開始　1なら配送完了

		System.out.println("HaisouOK"+wareid);
		System.out.println("HaisouOK"+proid);
		System.out.println("HaisouOK"+orderno);

		ReceiveKanriClass RK = new ReceiveKanriClass();
		RK.updateDELI(orderno, proid, wareid,deliflag);

	}

}
