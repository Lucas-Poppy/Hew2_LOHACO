package ordering;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Deliverbean;
import beans.OrderingListbean;
import benefit.IntegerCheck;
import db_connect.DBManager;

public class OrderingKanriClass {

	IntegerCheck IC = new IntegerCheck();
	String sql = "select PRODUCT_ID,Product_name,sum(QUANTITY),order_point,OPT_ORDER_QUANTITY from Stock s " +
			"join PRODUCTS p using(product_id) " +
			"where ORDER_FLG=0 " +
			"group by PRODUCT_ID,Product_Name,order_point,OPT_ORDER_QUANTITY " +
			"having sum(quantity)<Order_point " +
			"order by 1";



	public List<OrderingListbean> OrderingList(){
		List<OrderingListbean> Olist = new ArrayList<OrderingListbean>();
		Connection con = null;
		ResultSet res = null;
		try{
			con = DBManager.getConnection();
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			res=pstmt.executeQuery();
			while(res.next()){
				OrderingListbean ol=new OrderingListbean(res);
				Olist.add(ol);
			}
		}catch(Exception e){

		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}

		return Olist;

	}

	public int OrderingNoGet(){

		String count="select count(*)+1 from Ordering";
		Connection con = null;
		ResultSet rs = null;
		int i = 0;
		try{
			con=DBManager.getConnection();
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(count);
			rs=pstmt.executeQuery();
			if(rs.next()){
				i=rs.getInt(1);
			}

		}catch (Exception e){

		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		return i;


	}

	private String InsertOrdering="insert into Ordering values(?,?,?,1,sysdate)";
	public void insertOrdering(String proid,int orderingno,int quantity){
		Connection con = null;
		try{
			con=DBManager.getConnection();
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(InsertOrdering);
			pstmt.setInt(1, orderingno);
			pstmt.setInt(2, IC.henkan(proid));
			pstmt.setInt(3,quantity);
			pstmt.executeUpdate();

		}catch (Exception e){

		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}

	private String InsertOrderingDetail="insert into Ordering_details values(?,?,?,1)";
	public void insertOrderingDetail(int orderingno,String quantity,int wareid){
		Connection con = null;
		try{
			System.out.println("test");
			con=DBManager.getConnection();
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(InsertOrderingDetail);
			pstmt.setInt(1, orderingno);
			pstmt.setInt(2,IC.henkan(quantity));
			pstmt.setInt(3,wareid);
			pstmt.executeUpdate();

		}catch (Exception e){
			System.out.println(e);


		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}

	private String SelectDeliver = "SELECT o.ORDERING_ID,o.PRODUCT_ID,p.PRODUCT_NAME,od.QUANTITY,w.WAREHOUSE_NAME,o.ORDERING_DATE FROM ORDERING o "
			+ "INNER JOIN ORDERING_DETAILS od ON o.ORDERING_ID = od.ORDERING_ID "
			+ "INNER JOIN WAREHOUSE w ON od.WAREHOUSE_ID = w.WAREHOUSE_ID "
			+ "INNER JOIN PRODUCTS p ON o.PRODUCT_ID = p.PRODUCT_ID "
			+ "WHERE od.DELIVERY_FLG=1 "
			+ "ORDER BY 1,5";
			public List<Deliverbean> selectDeliver(){
					Connection con = null;
					List<Deliverbean> deliverlist = new ArrayList<Deliverbean>();

					try {
						con = DBManager.getConnection();
						PreparedStatement pstm = con.prepareStatement(SelectDeliver);
						ResultSet res = pstm.executeQuery();

						while(res.next()){
							Deliverbean bean = new Deliverbean(res);
							deliverlist.add(bean);
						}

					} catch (Exception e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					} finally{
						try {
							con.close();
						} catch (SQLException e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						}
					}
					return deliverlist;

		}




}
