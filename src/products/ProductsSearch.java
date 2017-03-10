package products;

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

import beans.Productsbean;

/**
 * Servlet implementation class ProductsSearch
 */
@WebServlet("/ProductsSearch")
public class ProductsSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsSearch() {
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
		request.setCharacterEncoding("UTF8");
		String tbl = new String();
		String cateid =(String)request.getParameter("cateid");
		String hantei =(String)request.getParameter("hantei");//カテゴリー検索のとき判定は0普通の検索のときは1
		String search =(String)request.getParameter("search");
		if(hantei==null){
			hantei="0";
		}

		String searchtitle="";




		ProductKanriClass productskanri = new ProductKanriClass();
		List<Productsbean> productlist = new ArrayList<Productsbean>();

		if(hantei.equals("0")){//カテゴリー検索
			System.out.println("カテゴリー検索");
			searchtitle="カテゴリー:　"+productskanri.getCategorySelect(cateid);


			try{
				productlist = productskanri.getSelectAll(cateid);
			}catch(Exception e){
				e.printStackTrace();
			}
					for(int i=0; productlist.size()>i; i++){
						tbl +="<div class='col-md-6 col-xs-6 pull-left'><div class='p-block'>" +
								"<div class='container-fluid p-in'>" +
								"<a href='ProductSearchDetail?proid="+ productlist.get(i).getProduct_id() +"' class='textcolorblue'>"+
								"<div class='row'>" +
								"<div class='col-md-3 col-xs-3'>" +
								"<img  src='images/"+productlist.get(i).getImage_file_name()+"' height='120' width='120' style='margin-right:10px;margin-top:10px;margin-bottom:10px;'>" +
								"</div>" +
								"<div class='col-md-9 col-xs-9'>" +
								"<div class='protitle'>"+productlist.get(i).getProduct_name()+"</div>" +
								"<p>￥" + productlist.get(i).getProduct_sale_price() + "</p>" +
								"<p>商品説明</p>" +
								"</div>" +
								"</div></a>" +
								"</div>" +
								"</div></div>";

					}

					HttpSession session = request.getSession();
					session.setAttribute("searchtitle",searchtitle);
					session.setAttribute("tbl", tbl);


			}else if(hantei.equals("1")){//ワード検索
				System.out.println("ワード検索");
				String SearchArry[] = search.split("[,/\n/　/\t/、/ ]", 0);//半角スペース　全角スペース　,で区切ることが可能
				searchtitle="検索ワード:　"+search;
				request.setAttribute("searchinput",search) ;

				try{
					productlist = productskanri.NameSearch(SearchArry);

				}catch(Exception e){

				}


				for(int i=0; productlist.size()>i; i++){

					tbl +="<div class='col-md-6 pull-left'><div class='p-block'>" +
							"<div class='container-fluid p-in'>" +
							"<a href='ProductSearchDetail?proid="+ productlist.get(i).getProduct_id() +"' class='textcolorblue'>"+
							"<div class='row'>" +
							"<div class='col-md-3 col-xs-3'>" +
							"<img src='images/"+productlist.get(i).getImage_file_name()+"' height='150' width='150' style='margin-right:10px;margin-top:10px;margin-bottom:10px;'>" +
							"</div>" +
							"<div class='col-md-9 col-xs-9'>" +
							"<div class='protitle'>"+productlist.get(i).getProduct_name()+"</div>" +
							"<p>￥" + productlist.get(i).getProduct_sale_price() + "</p>" +
							"<p>商品説明</p>" +
							"</div>" +
							"</div></a>" +
							"</div>" +
							"</div></div>";

				}

				HttpSession session = request.getSession();
				session.setAttribute("searchtitle",searchtitle);
				session.setAttribute("tbl", tbl);
			}



		RequestDispatcher disp = request.getRequestDispatcher("Productlist.jsp");
		disp.forward(request, response);
	}

}
