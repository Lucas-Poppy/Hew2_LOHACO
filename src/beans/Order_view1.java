package beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Order_view1 {
	String Oreder_no;
	String Order_date;
	String Mem_no;
	String Mem_name;
	String Mem_pref;
	String Product_id;
	String Product_name;
	String Quantity;
	String price;
	String rece_flg;

	public Order_view1(ResultSet res){
		try {
			Oreder_no = res.getString(1);
			Order_date = res.getString(2);
			Mem_no = res.getString(3);
			Mem_name = res.getString(4);
			Mem_pref = res.getString(5);
			Product_id = res.getString(6);
			Product_name = res.getString(7);
			Quantity = res.getString(8);
			price = res.getString(9);
			rece_flg = res.getString(10);

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public String getOreder_no() {
		return Oreder_no;
	}
	public void setOreder_no(String oreder_no) {
		Oreder_no = oreder_no;
	}
	public String getOrder_date() {
		return Order_date;
	}
	public void setOrder_date(String order_date) {
		Order_date = order_date;
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
	public String getMem_pref() {
		return Mem_pref;
	}
	public void setMem_pref(String mem_pref) {
		Mem_pref = mem_pref;
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
		return Quantity;
	}
	public void setQuantity(String quantity) {
		Quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getRece_flg() {
		return rece_flg;
	}
	public void setRece_flg(String rece_flg) {
		this.rece_flg = rece_flg;
	}
}
