package beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Historybean {
	private String pro_id;
	private String pro_name;
	private String price;
	private String quantity;
	private String order_date;
	private String order_no;

	public Historybean(ResultSet res){
		try {
				pro_id=res.getString(1);
				pro_name=res.getString(2);
				price=res.getString(3);
				quantity=res.getString(4);
				order_date=res.getString(5);
				order_no=res.getString(6);

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	/**
	 * pro_idを取得します。
	 * @return pro_id
	 */
	public String getPro_id() {
	    return pro_id;
	}
	/**
	 * pro_idを設定します。
	 * @param pro_id pro_id
	 */
	public void setPro_id(String pro_id) {
	    this.pro_id = pro_id;
	}
	/**
	 * pro_nameを取得します。
	 * @return pro_name
	 */
	public String getPro_name() {
	    return pro_name;
	}
	/**
	 * pro_nameを設定します。
	 * @param pro_name pro_name
	 */
	public void setPro_name(String pro_name) {
	    this.pro_name = pro_name;
	}
	/**
	 * priceを取得します。
	 * @return price
	 */
	public String getPrice() {
	    return price;
	}
	/**
	 * priceを設定します。
	 * @param price price
	 */
	public void setPrice(String price) {
	    this.price = price;
	}
	/**
	 * quantityを取得します。
	 * @return quantity
	 */
	public String getQuantity() {
	    return quantity;
	}
	/**
	 * quantityを設定します。
	 * @param quantity quantity
	 */
	public void setQuantity(String quantity) {
	    this.quantity = quantity;
	}
	/**
	 * order_dateを取得します。
	 * @return order_date
	 */
	public String getOrder_date() {
	    return order_date;
	}
	/**
	 * order_dateを設定します。
	 * @param order_date order_date
	 */
	public void setOrder_date(String order_date) {
	    this.order_date = order_date;
	}
	/**
	 * order_noを取得します。
	 * @return order_no
	 */
	public String getOrder_no() {
	    return order_no;
	}
	/**
	 * order_noを設定します。
	 * @param order_no order_no
	 */
	public void setOrder_no(String order_no) {
	    this.order_no = order_no;
	}


	/**
	 * prder_noを取得します。
	 * @return prder_no
	 */



}
