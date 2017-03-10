package beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Deliverbean {
	String Ordering_id;
	String Product_id;
	String Product_name;
	String Quantity;
	String Warehouse_name;
	String Ordering_date;

	public Deliverbean(ResultSet res){
		try {
			Ordering_id = res.getString(1);
			Product_id = res.getString(2);
			Product_name = res.getString(3);
			Quantity = res.getString(4);
			Warehouse_name = res.getString(5);
			Ordering_date = res.getString(6);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	/**
	 * Ordering_idを取得します。
	 * @return Ordering_id
	 */
	public String getOrdering_id() {
	    return Ordering_id;
	}
	/**
	 * Ordering_idを設定します。
	 * @param Ordering_id Ordering_id
	 */
	public void setOrdering_id(String Ordering_id) {
	    this.Ordering_id = Ordering_id;
	}
	/**
	 * Product_idを取得します。
	 * @return Product_id
	 */
	public String getProduct_id() {
	    return Product_id;
	}
	/**
	 * Product_idを設定します。
	 * @param Product_id Product_id
	 */
	public void setProduct_id(String Product_id) {
	    this.Product_id = Product_id;
	}
	/**
	 * Product_nameを取得します。
	 * @return Product_name
	 */
	public String getProduct_name() {
	    return Product_name;
	}
	/**
	 * Product_nameを設定します。
	 * @param Product_name Product_name
	 */
	public void setProduct_name(String Product_name) {
	    this.Product_name = Product_name;
	}
	/**
	 * Quantityを取得します。
	 * @return Quantity
	 */
	public String getQuantity() {
	    return Quantity;
	}
	/**
	 * Quantityを設定します。
	 * @param Quantity Quantity
	 */
	public void setQuantity(String Quantity) {
	    this.Quantity = Quantity;
	}

	/**
	 * Warehouse_nameを取得します。
	 * @return Warehouse_name
	 */
	public String getWarehouse_name() {
	    return Warehouse_name;
	}
	/**
	 * Warehouse_nameを設定します。
	 * @param Warehouse_name Warehouse_name
	 */
	public void setWarehouse_name(String Warehouse_name) {
	    this.Warehouse_name = Warehouse_name;
	}
	/**
	 * Ordering_dateを取得します。
	 * @return Ordering_date
	 */
	public String getOrdering_date() {
	    return Ordering_date;
	}
	/**
	 * Ordering_dateを設定します。
	 * @param Ordering_date Ordering_date
	 */
	public void setOrdering_date(String Ordering_date) {
	    this.Ordering_date = Ordering_date;
	}
}
