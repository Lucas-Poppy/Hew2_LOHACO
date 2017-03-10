package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Deli_checkbean;
import benefit.IntegerCheck;
import db_connect.DBManager;

public class DeliKanriClass {
private String sql="SELECT * FROM deli_ck WHERE Order_no = ? and Product_id = ?";
	IntegerCheck IC = new IntegerCheck();
	public List<Deli_checkbean> dcheck(String Order_no, String Product_id){
		Connection con = null;
		ResultSet res =null;
		List<Deli_checkbean> DeliCheck = new ArrayList<Deli_checkbean>();

		try {
			con = DBManager.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			System.out.println(Order_no);
			pstmt.setInt(1, IC.henkan(Order_no));
			pstmt.setInt(2, IC.henkan(Product_id));
			res = pstmt.executeQuery();
			while (res.next()) {
				Deli_checkbean bean = new Deli_checkbean(res);
				DeliCheck.add(bean);
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		return DeliCheck;
		}

}
