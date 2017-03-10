package beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Orderbean {

	String Order_no;
	String Order_date;
	String Mem_no;
	String Mem_name;

	public Orderbean(ResultSet res) {
		// TODO 自動生成されたコンストラクター・スタブ
		 try {
			Order_no =res.getString(1);
			Order_date =res.getString(2);
			Mem_no =res.getString(4);
			Mem_name = res.getString(3);

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
}
