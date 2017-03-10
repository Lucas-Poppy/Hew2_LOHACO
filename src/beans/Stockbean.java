package beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Stockbean {

	String Warehouse_id;
	String Warehouse_name;
	String W_pref;
	String W_minu;
	String W_ads;
	String W_pscd;
	String Product_id;
	String Quantity;


	public Stockbean(ResultSet res){

		try {
			Warehouse_id = res.getString(1);
			Warehouse_name = res.getString(2);
			W_pref = res.getString(3);
			W_minu = res.getString(4);
			W_ads = res.getString(5);
			W_pscd = res.getString(6);
			Product_id = res.getString(7);
			Quantity = res.getString(8);

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public String getWarehouse_id() {
		return Warehouse_id;
	}
	public void setWarehouse_id(String warehouse_id) {
		Warehouse_id = warehouse_id;
	}
	public String getWarehouse_name() {
		return Warehouse_name;
	}
	public void setWarehouse_name(String warehouse_name) {
		Warehouse_name = warehouse_name;
	}
	public String getW_pref() {
		return W_pref;
	}
	public void setW_pref(String w_pref) {
		W_pref = w_pref;
	}
	public String getW_minu() {
		return W_minu;
	}
	public void setW_minu(String w_minu) {
		W_minu = w_minu;
	}
	public String getW_ads() {
		return W_ads;
	}
	public void setW_ads(String w_ads) {
		W_ads = w_ads;
	}
	public String getW_pscd() {
		return W_pscd;
	}
	public void setW_pscd(String w_pscd) {
		W_pscd = w_pscd;
	}
	public String getProduct_id() {
		return Product_id;
	}
	public void setProduct_id(String product_id) {
		Product_id = product_id;
	}
	public String getQuantity() {
		return Quantity;
	}
	public void setQuantity(String quantity) {
		Quantity = quantity;
	}
}
