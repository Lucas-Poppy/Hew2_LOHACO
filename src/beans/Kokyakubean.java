package beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Kokyakubean {
	String Order_no;
	String Order_date;
	String Mem_name;
	String Mem_pscd;
	String Address;
	String Warehouseid;

	public Kokyakubean(ResultSet res){
		try {
			Order_no = res.getString(1);
			Order_date = res.getString(2);
			Mem_name = res.getString(3);
			Mem_pscd = res.getString(4);
			Address = res.getString(5);
			Warehouseid = res.getString(6);
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
	 * Order_dateを取得します。
	 * @return Order_date
	 */
	public String getOrder_date() {
	    return Order_date;
	}

	/**
	 * Order_dateを設定します。
	 * @param Order_date Order_date
	 */
	public void setOrder_date(String Order_date) {
	    this.Order_date = Order_date;
	}

	/**
	 * Mem_nameを取得します。
	 * @return Mem_name
	 */
	public String getMem_name() {
	    return Mem_name;
	}

	/**
	 * Mem_nameを設定します。
	 * @param Mem_name Mem_name
	 */
	public void setMem_name(String Mem_name) {
	    this.Mem_name = Mem_name;
	}

	/**
	 * Mem_pscdを取得します。
	 * @return Mem_pscd
	 */
	public String getMem_pscd() {
	    return Mem_pscd;
	}

	/**
	 * Mem_pscdを設定します。
	 * @param Mem_pscd Mem_pscd
	 */
	public void setMem_pscd(String Mem_pscd) {
	    this.Mem_pscd = Mem_pscd;
	}

	/**
	 * Addressを取得します。
	 * @return Address
	 */
	public String getAddress() {
	    return Address;
	}

	/**
	 * Addressを設定します。
	 * @param Address Address
	 */
	public void setAddress(String Address) {
	    this.Address = Address;
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
