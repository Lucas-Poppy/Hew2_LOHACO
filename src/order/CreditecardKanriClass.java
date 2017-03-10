package order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.Creditcardbean;
import benefit.IntegerCheck;
import db_connect.DBManager;

public class CreditecardKanriClass {
	IntegerCheck IC = new IntegerCheck();

	private String creditselectsql = "SELECT card_no,card_num,card_kind,card_name,to_char(card_limit,'dd/mm/yy'),pin_code,Mem_no FROM creditcard INNER JOIN MEMBER_BY_CARD using(CARD_NO) WHERE Mem_no = ?";
	public Creditcardbean CreditSelectOne(String Memno){

		Connection con;
		try {
			con = DBManager.getConnection();
			PreparedStatement ptsm = con.prepareStatement(creditselectsql);

			ptsm.setInt(1, IC.henkan(Memno));
			ResultSet result = ptsm.executeQuery();

			if(result.next()){
				Creditcardbean bean = new Creditcardbean(result);
				return bean;
			}

			con.close();
			return null;

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		}
	}
}
