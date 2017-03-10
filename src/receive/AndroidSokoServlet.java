package receive;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.arnx.jsonic.JSON;
import beans.Haisoubean;

/**
 * Servlet implementation class AndroidSokoServlet
 */
@WebServlet("/AndroidSokoServlet")
public class AndroidSokoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AndroidSokoServlet() {
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
		String warehouseid=request.getParameter("wareid");
		String order_no = request.getParameter("orderno");
		String flag = request.getParameter("flag");

		ReceiveKanriClass RK = new ReceiveKanriClass();
		List<Haisoubean> rdlist = new ArrayList<Haisoubean>();
		System.out.println("android");
		System.out.println(order_no);
		System.out.println(warehouseid);
		rdlist=RK.android(warehouseid, order_no);


		String tbl = new String();
		for(int i=0;i<rdlist.size();i++){
			tbl+="<tr id='rdlist"+i+1+"'>" +
					"<td class='col-xs-2'>"+rdlist.get(i).getOrder_no()+"</td>" +
					"<td class='col-xs-2'>"+rdlist.get(i).getProduct_id()+"</td>" +
					"<td class='col-xs-2'>"+rdlist.get(i).getQuantity()+"</td>";
				if(rdlist.get(i).getFlg().equals("0")){
					tbl+="<td class='col-xs-1'><button type='submit' class='btn btn-success deliStart'><font size='1'>配送開始</font></button></td>";
				}else if(rdlist.get(i).getFlg().equals("2")){
					tbl+="<td class='col-xs-1'><button type='submit' class='btn btn-primary deliOK'><font size='1'>配送完了</font></button></td>";
				}
					tbl+="</tr>";
		}
		request.setAttribute("android", tbl);
		request.setAttribute("wareid", warehouseid);
		String hairetu[]={tbl,warehouseid};


		if(flag!=null){
			System.out.println("AndroidSokoServlet:ajaxつかった。");
			PrintWriter out = response.getWriter();
		    out.println(JSON.encode(hairetu));

		}else{
			System.out.println("AndroidSokoServlet:ajaxつかってない。");
			RequestDispatcher dispatcher=request.getRequestDispatcher("android.jsp");
			dispatcher.forward(request,response);
		}






	}

}
