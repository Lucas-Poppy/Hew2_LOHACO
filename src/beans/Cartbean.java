package beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Cartbean {

	String Mem_no;
	String Product_id;
	String Quanity;

	public Cartbean(ResultSet res){
		try {
			Mem_no = res.getString(1);
			Product_id = res.getString(2);
			Quanity = res.getString(3);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public String getMem_no() {
		return Mem_no;
	}
	public void setMem_no(String mem_no) {
		Mem_no = mem_no;
	}
	public String getProduct_id() {
		return Product_id;
	}
	public void setProduct_id(String product_id) {
		Product_id = product_id;
	}
	public String getQuanity() {
		return Quanity;
	}
	public void setQuanity(String quanity) {
		Quanity = quanity;
	}
}
