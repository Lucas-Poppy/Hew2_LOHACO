package cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Cartbean;
import benefit.IntegerCheck;
import db_connect.DBManager;

public class CartKanriClass {
	String cartinsertsql ="insert into cart values(?,?,?)";

	IntegerCheck IC = new IntegerCheck();
	public void CartInsert(String Memno,String ProId,String Quantity){


		Connection con = null;

		try {
			con = DBManager.getConnection();
			PreparedStatement pstm =null;

			pstm=(PreparedStatement) con.prepareStatement(cartinsertsql);
			pstm.setInt(1,IC.henkan(Memno));
			pstm.setInt(2,IC.henkan(ProId));
			pstm.setInt(3,IC.henkan(Quantity));

			pstm.executeUpdate();
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


	}

	private String updatesql = "UPDATE cart SET Quantity = Quantity + ? WHERE Product_id = ? AND Mem_no = ?";
	public void CartUpdate(String Quantity,String ProId,String Memno){

		Connection con = null;
		try {
			con = DBManager.getConnection();
			PreparedStatement pstm =null;

			pstm=(PreparedStatement) con.prepareStatement(updatesql);
			pstm.setInt(1,IC.henkan(Quantity));
			pstm.setInt(2,IC.henkan(ProId));
			pstm.setInt(3,IC.henkan(Memno));

			pstm.executeUpdate();

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

	}

	String existssql = "Select * From cart Where mem_no = ? AND product_id = ?";

	public boolean Exists(String memno,String proid){

		Connection con = null;
		try {
			con = DBManager.getConnection();
			PreparedStatement ptsm = con.prepareStatement(existssql);

			ptsm.setInt(1,IC.henkan(memno));
			ptsm.setInt(2,IC.henkan(proid));
			ResultSet result = ptsm.executeQuery();

			return result.next();


		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return false;

		} finally{

			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}

	}

	String cartselectsql = "Select * From cart Where mem_no = ?";
	public List<Cartbean> getCartSelect(String memno){
		Connection con = null;
		try {
			con = DBManager.getConnection();
			PreparedStatement ptsm = con.prepareStatement(cartselectsql);

			ptsm.setInt(1, IC.henkan(memno));
			ResultSet result = ptsm.executeQuery();

			List<Cartbean> cartlist = new ArrayList<Cartbean>();

			while(result.next()){
				Cartbean bean = new Cartbean(result);
				cartlist.add(bean);
			}
			return cartlist;

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;

		} finally{

			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		}
	}

	String cartdeletesql = "Delete From cart Where Mem_no = ?";
	public void getCartDelete(String Memno){
		Connection con = null;
		try {
			con = DBManager.getConnection();
			PreparedStatement ptsm = con.prepareStatement(cartdeletesql);

			ptsm.setInt(1, IC.henkan(Memno));
			ptsm.executeUpdate();

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
	}

	String cartproductdeletesql = "Delete From cart Where mem_no = ? AND product_id = ?";
	public void getCartProductDelete(String memno,String proid){
		Connection con = null;
		try {
			con = DBManager.getConnection();
			PreparedStatement ptsm = con.prepareStatement(cartproductdeletesql);

			ptsm.setInt(1,IC.henkan(memno));
			ptsm.setInt(2,IC.henkan(proid));
			ptsm.executeUpdate();
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
	}
}
