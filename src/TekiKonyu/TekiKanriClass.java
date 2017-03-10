package TekiKonyu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Subscriptionsbean;
import benefit.IntegerCheck;
import db_connect.DBManager;

public class TekiKanriClass {
	IntegerCheck IC = new IntegerCheck();



	private String tekilist = "select mem_no,mem_name,Product_ID,Product_name,QUANTITY,P_PERIOD,P_START from SUBSCRIPTIONS " +
			"join PRODUCTS using(Product_ID) " +
			"join member using(mem_no) " +
			"where to_char(P_START,'yy-mm-dd')=to_char(sysdate,'yy-mm-dd') and mem_no=?" +
			"order by 1";

	public List<Subscriptionsbean> TekilistToday(String memno){
		List<Subscriptionsbean> Sublist = new ArrayList<Subscriptionsbean>();
		System.out.println(memno);

		Connection con = null;
		try {
			con = DBManager.getConnection();
			PreparedStatement ptsm = con.prepareStatement(tekilist);
			ptsm.setInt(1,IC.henkan(memno));
			ResultSet result =ptsm.executeQuery();


			while(result.next()){
				Subscriptionsbean bean = new Subscriptionsbean(result);
				Sublist.add(bean);
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		}



		return Sublist;
	}






	private String tekimemlist = "select distinct mem_no,mem_name,0,0,0,0,to_char(P_START,'yy-mm-dd') P_S from SUBSCRIPTIONS " +
			"join PRODUCTS using(Product_ID) " +
			"join member using(mem_no) " +
			"where to_char(P_START,'yy-mm-dd')=to_char(sysdate,'yy-mm-dd') " +
			"order by 1";

	public List<Subscriptionsbean> TekimemlistToday(){
		List<Subscriptionsbean> Sublist = new ArrayList<Subscriptionsbean>();

		Connection con = null;
		try {
			con = DBManager.getConnection();
			PreparedStatement ptsm = con.prepareStatement(tekimemlist);
			ResultSet result =ptsm.executeQuery();


			while(result.next()){
				Subscriptionsbean bean = new Subscriptionsbean(result);
				Sublist.add(bean);
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		}



		return Sublist;
	}
	private String updatesql = "update SUBSCRIPTIONS set P_start=add_months(P_START,P_Period) where product_id=? and mem_no = ?";
	public void UpdateDate(String proid,String memno){
		Connection con = null;
		try{
			con=DBManager.getConnection();
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(updatesql);
			pstmt.setInt(1,IC.henkan(proid));
			pstmt.setInt(2,IC.henkan(memno));
			int i=pstmt.executeUpdate();
			System.out.println("updateDateは"+i+"件更新");

		}catch(Exception e){
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

	private String deletesql = "delete from SUBSCRIPTIONS where product_id=? and mem_no = ?";
	public void Delete(String proid,String memno){
		Connection con = null;
		try{
			con=DBManager.getConnection();
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(deletesql);
			pstmt.setInt(1,IC.henkan(proid));
			pstmt.setInt(2,IC.henkan(memno));
			pstmt.executeUpdate();

		}catch(Exception e){
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


	private String insertsql = "insert into SUBSCRIPTIONS values(?,?,sysdate,?,?)";
	public void Insert(String memno,String proid,String p_period,String quantity){
		Connection con = null;
		try{
			con=DBManager.getConnection();
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(insertsql);
			pstmt.setInt(1,IC.henkan(memno));
			pstmt.setInt(2,IC.henkan(proid));
			pstmt.setInt(3,IC.henkan(p_period));
			pstmt.setInt(4,IC.henkan(quantity));
			pstmt.executeUpdate();

		}catch(Exception e){
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


	private String tekilistsql = "select mem_no,mem_name,product_id,product_name,quantity,P_PERIOD,P_Start from SUBSCRIPTIONS s" +
			" join products using(Product_id)" +
			" join member using(mem_no)" +
			" where mem_no=?";

	public List<Subscriptionsbean> Tekilist(String mem_no){
		List<Subscriptionsbean> Sublist = new ArrayList<Subscriptionsbean>();

		Connection con = null;
		try {
			con = DBManager.getConnection();
			PreparedStatement ptsm = con.prepareStatement(tekilistsql);
			ptsm.setInt(1,IC.henkan(mem_no));
			ResultSet result =ptsm.executeQuery();


			while(result.next()){
				Subscriptionsbean bean = new Subscriptionsbean(result);
				Sublist.add(bean);
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		}



		return Sublist;
	}

}
