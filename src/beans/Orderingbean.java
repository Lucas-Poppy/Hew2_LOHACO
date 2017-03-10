package beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Orderingbean {

	String Ordering_no;	//発注ID
	String Warehouse_id;	//倉庫ID
	String Product_id;		//商品ID
	String All_quantity;	//全体在庫数
	String Warehouse_quantity;	  //倉庫在庫数
	String Delivery_flg;	//納品完了フラグ
	String Delivery_flg_2; //納品完了フラグ2

	public Orderingbean(ResultSet res){
		try {
			Ordering_no = res.getString(1);
			Warehouse_id = res.getString(2);
			Product_id = res.getString(3);
			All_quantity = res.getString(4);
			Warehouse_quantity = res.getString(5);
			Delivery_flg = res.getString(6);
			Delivery_flg_2 = res.getString(7);

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public String getOrdering_no() {
		return Ordering_no;
	}
	public void setOrdering_no(String ordering_no) {
		Ordering_no = ordering_no;
	}
	public String getWarehouse_id() {
		return Warehouse_id;
	}
	public void setWarehouse_id(String warehouse_id) {
		Warehouse_id = warehouse_id;
	}
	public String getProduct_id() {
		return Product_id;
	}
	public void setProduct_id(String product_id) {
		Product_id = product_id;
	}
	public String getAll_quantity() {
		return All_quantity;
	}
	public void setAll_quantity(String all_quantity) {
		All_quantity = all_quantity;
	}
	public String getWarehouse_quantity() {
		return Warehouse_quantity;
	}
	public void setWarehouse_quantity(String warehouse_quantity) {
		Warehouse_quantity = warehouse_quantity;
	}
	public String getDelivery_flg() {
		return Delivery_flg;
	}
	public void setDelivery_flg(String delivery_flg) {
		Delivery_flg = delivery_flg;
	}
	public String getDelivery_flg_2() {
		return Delivery_flg_2;
	}
	public void setDelivery_flg_2(String delivery_flg_2) {
		Delivery_flg_2 = delivery_flg_2;
	}
}
