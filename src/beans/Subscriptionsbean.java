package beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Subscriptionsbean {

	String Mem_no;
	String Mem_name;
	String Product_id;
	String Product_name;
	String quantity;
	String P_period;
	String P_start;

	public Subscriptionsbean (ResultSet res){
		try {
			Mem_no = res.getString(1);
			Mem_name = res.getString(2);
			Product_id = res.getString(3);
			Product_name = res.getString(4);
			quantity = res.getString(5);
			P_period = res.getString(6);
			P_start = res.getString(7);
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

	public String getMem_name() {
		return Mem_name;
	}

	public void setMem_name(String mem_name) {
		Mem_name = mem_name;
	}

	public String getProduct_id() {
		return Product_id;
	}

	public void setProduct_id(String product_id) {
		Product_id = product_id;
	}

	public String getProduct_name() {
		return Product_name;
	}

	public void setProduct_name(String product_name) {
		Product_name = product_name;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getP_period() {
		return P_period;
	}

	public void setP_period(String p_period) {
		P_period = p_period;
	}

	public String getP_start() {
		return P_start;
	}

	public void setP_start(String p_start) {
		P_start = p_start;
	}



}
