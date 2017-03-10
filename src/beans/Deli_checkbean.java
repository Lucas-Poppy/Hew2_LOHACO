package beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Deli_checkbean {

	String Order_no;
	String Product_id;
	int Deli;

	public Deli_checkbean(ResultSet res){
		try {
			Order_no = res.getString(1);
			Product_id = res.getString(2);
			Deli = res.getInt(3);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public String getOrder_no() {
		return Order_no;
	}
	public void setOrder_no(String order_no) {
		Order_no = order_no;
	}
	public String getProduct_id() {
		return Product_id;
	}
	public void setProduct_id(String product_id) {
		Product_id = product_id;
	}
	public int getDeli() {
		return Deli;
	}
	public void setDeli(int deli) {
		Deli = deli;
	}

}
