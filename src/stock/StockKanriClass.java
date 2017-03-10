package stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Stockbean;
import benefit.IntegerCheck;
import db_connect.DBManager;

public class StockKanriClass {
	IntegerCheck IC = new IntegerCheck();

	public List<Stockbean> id_search(String pid){
		String Productsearch ="SELECT * FROM stock_view WHERE Product_id = ? order by 1";
		Connection con = null;
		ResultSet res = null;
		List<Stockbean> stockbean = new ArrayList<Stockbean>();

		try {
			con = DBManager.getConnection();
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(Productsearch);
			pstmt.setString(1,pid);
			res = pstmt.executeQuery();
			while(res.next()){

				Stockbean sb = new Stockbean(res);
				stockbean.add(sb);
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
			return stockbean;
	}

	public Stockbean quantitycount(String quantity){
		String quantitysearch ="SELECT PRODUCT_ID,SUM(quantity) FROM stock_view GROUP BY Product_id order by 1";
		Connection con = null;
		ResultSet res = null;
		Stockbean sumquantity = null;


		try {
			con = DBManager.getConnection();
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(quantitysearch);
			res = pstmt.executeQuery();
			if(res.next()){
				sumquantity = new Stockbean(res);
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
		return sumquantity;
	}

	public void stockpulus(String quantity,String wareid,String proid){
		String stockup = "update stock set quantity = quantity + ? where warehouse_id=? and product_id=?";

		Connection con = null;
		try{
			con = DBManager.getConnection();
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(stockup);
			pstmt.setInt(1, IC.henkan(quantity));
			pstmt.setInt(2, IC.henkan(wareid));
			pstmt.setInt(3,IC.henkan(proid));
			pstmt.executeUpdate();
		}catch(Exception e){

		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}

	}

	private String warename ="select WAREHOUSE_NAME from warehouse where warehouse_id=?";
	public String WareName(String wareid){

		Connection con = null;
		String ware_name = null;
		ResultSet res = null;
		try{
			con = DBManager.getConnection();
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(warename);
			pstmt.setInt(1, IC.henkan(wareid));
			res=pstmt.executeQuery();
			if(res.next()){
				ware_name=res.getString(1);
			}
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
		return ware_name;
	}
}
