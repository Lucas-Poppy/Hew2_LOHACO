package beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Haitatsubean {
	String Order_no;
	String Pro_id;
	String Pro_name;
	String Quantity;
	String Warehouseid;

	public Haitatsubean(ResultSet res){
		try {
			Order_no = res.getString(1);
			Pro_id = res.getString(2);
			Pro_name = res.getString(3);
			Quantity = res.getString(4);
			Warehouseid = res.getString(5);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	/**
	 * Order_noを取得します。
	 * @return Order_no
	 */
	public String getOrder_no() {
	    return Order_no;
	}

	/**
	 * Order_noを設定します。
	 * @param Order_no Order_no
	 */
	public void setOrder_no(String Order_no) {
	    this.Order_no = Order_no;
	}

	/**
	 * Pro_idを取得します。
	 * @return Pro_id
	 */
	public String getPro_id() {
	    return Pro_id;
	}

	/**
	 * Pro_idを設定します。
	 * @param Pro_id Pro_id
	 */
	public void setPro_id(String Pro_id) {
	    this.Pro_id = Pro_id;
	}

	/**
	 * Pro_nameを取得します。
	 * @return Pro_name
	 */
	public String getPro_name() {
	    return Pro_name;
	}

	/**
	 * Pro_nameを設定します。
	 * @param Pro_name Pro_name
	 */
	public void setPro_name(String Pro_name) {
	    this.Pro_name = Pro_name;
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
	 * Warehouseidを取得します。
	 * @return Warehouseid
	 */
	public String getWarehouseid() {
	    return Warehouseid;
	}

	/**
	 * Warehouseidを設定します。
	 * @param Warehouseid Warehouseid
	 */
	public void setWarehouseid(String Warehouseid) {
	    this.Warehouseid = Warehouseid;
	}
}
