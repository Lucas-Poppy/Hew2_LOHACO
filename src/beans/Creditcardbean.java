package beans;

import java.sql.ResultSet;
import java.sql.SQLException;


//MemberテーブルCleditcardテーブルの結合

public class Creditcardbean {

	String Card_no;
	String Card_num;
	String Card_kind;
	String Card_name;
	String Card_limit;
	String Pin_code;

	String Mem_no;


	public Creditcardbean(ResultSet res){

		try {
			Card_no = res.getString(1);
			Card_num = res.getString(2);
			Card_kind = res.getString(3);
			Card_name = res.getString(4);
			Card_limit = res.getString(5);
			Pin_code = res.getString(6);

			Mem_no = res.getString(7);

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}


	public String getCard_no() {
		return Card_no;
	}

	public void setCard_no(String card_no) {
		Card_no = card_no;
	}

	public String getCard_num() {
		return Card_num;
	}

	public void setCard_num(String card_num) {
		Card_num = card_num;
	}

	public String getCard_kind() {
		return Card_kind;
	}

	public void setCard_kind(String card_kind) {
		Card_kind = card_kind;
	}

	public String getCard_name() {
		return Card_name;
	}

	public void setCard_name(String card_name) {
		Card_name = card_name;
	}

	public String getCard_limit() {
		return Card_limit;
	}

	public void setCard_limit(String card_limit) {
		Card_limit = card_limit;
	}

	public String getPin_code() {
		return Pin_code;
	}

	public void setPin_code(String pin_code) {
		Pin_code = pin_code;
	}

	public String getMem_no() {
		return Mem_no;
	}

	public void setMem_no(String mem_no) {
		Mem_no = mem_no;
	}
}
