package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Memberbean;
import db_connect.DBManager;

public class MemberKanriClass {
	private String sql = "Select * From member Where mem_id = ? AND mem_pass = ?";
	public Memberbean member_search(String id,String pass){
		System.out.println(id);

		Connection con = null;

		try {
			con = DBManager.getConnection();
			PreparedStatement ptsm = con.prepareStatement(sql);
			ptsm.setString(1, id);
			ptsm.setString(2, pass);

			ResultSet res = ptsm.executeQuery();


			if(res.next()){
				Memberbean bean = new Memberbean(res);
				return bean;
			}
			return null;

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
				return null;

		}

	}

	public Memberbean men_info_zaikokanri(String no){
		String sql = "SELECT * FROM member WHERE Mem_no = ?";
		Connection con = null;

		try {
			con=DBManager.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);
			ResultSet res = pstmt.executeQuery();
			if(res.next()){
				Memberbean member =new Memberbean(res);
				return member;
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
		return null;

	}
}
