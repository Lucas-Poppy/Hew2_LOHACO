package order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Order_view1;
import beans.Orderbean;
import benefit.IntegerCheck;
import db_connect.DBManager;

public class OrderKanriClass {
	String OrderInsertSql = "insert into Order_tbl values(?,sysdate,?)";
	String OrderNo ="select nvl(max(Order_no)+1,1) from Order_tbl";
	String Order_detail ="insert into Order_details values(?,?,?,?,0)";
	//受注済みフラグのあるリストのorder_noの商品一覧を取ってくる
	String Order_zyutyulist ="select * from order_view1 ot where EXISTS(" +
			"select * from ORDER_DETAILS od where RECE_FLG=0 and  ot.ORDER_NO=od.ORDER_NO)" +
			"and order_no = ? order by 6";
	//受注済みフラグのあるリストだけ取ってくる
		String Order_zyutyulist2 ="select Order_no,Order_date,Mem_name,mem_no from order_tbl ot " +
				"join member using(mem_no) " +
				"where EXISTS(select * from ORDER_DETAILS od where RECE_FLG=0 and  ot.ORDER_NO=od.ORDER_NO) order by 1";
		//受注済みフラグのないリストだけ取ってくる
				String Order_zyutyulistF0 ="select * from order_view1 ot where not EXISTS(" +
						"select * from ORDER_DETAILS od where RECE_FLG=0 and  ot.ORDER_NO=od.ORDER_NO) and order_no=? order by 6";
				//受注済みフラグのないリストだけ取ってくる
					String Order_zyutyulist2F0 ="select Order_no,Order_date,Mem_name,mem_no from order_tbl ot " +
							"join member using(mem_no) " +
							"where not EXISTS(select * from ORDER_DETAILS od where RECE_FLG=0 and  ot.ORDER_NO=od.ORDER_NO) order by 1 desc";

	IntegerCheck IC = new IntegerCheck();


	public void OrderInsert(String orderno,String memno){

		Connection con;

		try {
			con = DBManager.getConnection();
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(OrderInsertSql);
			pstmt.setInt(1,IC.henkan(orderno));
			pstmt.setInt(2,IC.henkan(memno));
			pstmt.executeUpdate();


		} catch (Exception e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}


	}

	public String OrderNo(){
		Connection con;
		ResultSet res = null;
		String no = null;

		try {
			con = DBManager.getConnection();
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(OrderNo);
			res=pstmt.executeQuery();
			if(res.next()){
				no=res.getString(1);
			}


		} catch (Exception e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		return no;
	}

	public void insertOrder_detail(String orderno,String proid,String price,String quantity){
		Connection con;

		try {
			con = DBManager.getConnection();
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(Order_detail);
			pstmt.setInt(1,IC.henkan(orderno));
			pstmt.setInt(2,IC.henkan(proid));
			pstmt.setInt(3,IC.henkan(price));
			pstmt.setInt(4,IC.henkan(quantity));
			pstmt.executeUpdate();


		} catch (Exception e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
	}

	public List<Order_view1> Order_zyutyulist(String id){
		List<Order_view1> oblist = new ArrayList<Order_view1>();
		Connection con;
		ResultSet res=null;

		try {
			con = DBManager.getConnection();
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(Order_zyutyulist);
			pstmt.setInt(1,IC.henkan(id));
			res=pstmt.executeQuery();
			while(res.next()){
				Order_view1 ob=new Order_view1(res);
				oblist.add(ob);
			}

		} catch (Exception e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		return oblist;
	}

	public List<Orderbean> Order_tyumonlist(){
		List<Orderbean> oblist = new ArrayList<Orderbean>();
		Connection con;
		ResultSet res=null;

		try {
			con = DBManager.getConnection();
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(Order_zyutyulist2);
			res=pstmt.executeQuery();
			while(res.next()){
				Orderbean ob=new Orderbean(res);
				oblist.add(ob);
			}

		} catch (Exception e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		return oblist;
	}

	//注文済みのほう

		public List<Order_view1> Order_zyutyulistF0(String id){
			List<Order_view1> oblist = new ArrayList<Order_view1>();
			Connection con = null;
			ResultSet res=null;

			try {
				con = DBManager.getConnection();
				PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(Order_zyutyulistF0);
				pstmt.setInt(1,IC.henkan(id));
				res=pstmt.executeQuery();
				while(res.next()){
					Order_view1 ob=new Order_view1(res);
					oblist.add(ob);
				}

			} catch (Exception e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}finally{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
			return oblist;
		}

		public List<Orderbean> Order_tyumonlistF0(){
			List<Orderbean> oblist = new ArrayList<Orderbean>();
			Connection con = null;
			ResultSet res=null;

			try {
				con = DBManager.getConnection();
				PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(Order_zyutyulist2F0);
				res=pstmt.executeQuery();
				while(res.next()){
					Orderbean ob=new Orderbean(res);
					oblist.add(ob);
				}

			} catch (Exception e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}finally{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
			return oblist;
		}
}
