package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Historybean;
import benefit.IntegerCheck;
import db_connect.DBManager;

public class HistoryKanriClass {
	IntegerCheck IC = new IntegerCheck();

	private String hisSQL = "select PRODUCT_ID,product_name,Price,Quantity,order_date,order_no " +
			"from order_tbl " +
			"join ORDER_DETAILS using(order_no) " +
			"join products using(product_id) " +
			"where mem_no=? order by 5 desc";

	public List<Historybean> mem_history(String mem_no){
		List<Historybean> hislist = new ArrayList<Historybean>();
		Connection con = null;
		ResultSet res = null;
		try{
			con = DBManager.getConnection();
			PreparedStatement ptsm = con.prepareStatement(hisSQL);
			ptsm.setInt(1,IC.henkan(mem_no));
			res=ptsm.executeQuery();
			System.out.println(hisSQL);
			while(res.next()){
				System.out.println("HK確認"+res.getString(2));
				Historybean bean = new Historybean(res);
//				System.out.println("HK確認"+res.getString(2));
				hislist.add(bean);
			}


		}catch(Exception e){
			System.out.println("HK確認"+e);

		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		return hislist;


	}
}
