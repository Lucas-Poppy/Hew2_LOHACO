package beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Receive_details {
/*
 * 受注詳細のbean
 */
	String Order_no;
	String Product_id;
	String Product_name;
	String quantity;
	String Warehouse_id;
	String Warehouse_name;
	String DELIVERY_FLG;

	public Receive_details(ResultSet res){
		try {
			Order_no = res.getString(1);
			Product_id = res.getString(2);
			Product_name=res.getString(3);
			quantity = res.getString(4);
			Warehouse_id = res.getString(5);
			Warehouse_name=res.getString(6);
			DELIVERY_FLG=res.getString(7);

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
	public String getWarehouse_id() {
		return Warehouse_id;
	}
	public void setWarehouse_id(String warehouse_id) {
		Warehouse_id = warehouse_id;
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

	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
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
	 * DELIVERY_FLGを取得します。
	 * @return DELIVERY_FLG
	 */
	public String getDELIVERY_FLG() {
	    return DELIVERY_FLG;
	}

	/**
	 * DELIVERY_FLGを設定します。
	 * @param DELIVERY_FLG DELIVERY_FLG
	 */
	public void setDELIVERY_FLG(String DELIVERY_FLG) {
	    this.DELIVERY_FLG = DELIVERY_FLG;
	}

}
