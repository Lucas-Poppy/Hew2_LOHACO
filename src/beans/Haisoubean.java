package beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Haisoubean {
	private String Order_no;
	private String Product_id;
	private String Product_name;
	private String quantity;
	private String Mem_name;
	private String Mem_yubin;
	private String Mem_zyusyo;
	private String flg;
	public Haisoubean(ResultSet res){
		try {
			Order_no = res.getString(1);
			Product_id = res.getString(2);
			Product_name=res.getString(3);
			quantity = res.getString(4);
			Mem_name= res.getString(5);
			Mem_yubin=res.getString(6);
			Mem_zyusyo=res.getString(7);
			flg=res.getString(8);

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
	 * Mem_yubinを取得します。
	 * @return Mem_yubin
	 */
	public String getMem_yubin() {
	    return Mem_yubin;
	}
	/**
	 * Mem_yubinを設定します。
	 * @param Mem_yubin Mem_yubin
	 */
	public void setMem_yubin(String Mem_yubin) {
	    this.Mem_yubin = Mem_yubin;
	}
	/**
	 * Mem_zyusyoを取得します。
	 * @return Mem_zyusyo
	 */
	public String getMem_zyusyo() {
	    return Mem_zyusyo;
	}
	/**
	 * Mem_zyusyoを設定します。
	 * @param Mem_zyusyo Mem_zyusyo
	 */
	public void setMem_zyusyo(String Mem_zyusyo) {
	    this.Mem_zyusyo = Mem_zyusyo;
	}
	/**
	 * flgを取得します。
	 * @return flg
	 */
	public String getFlg() {
	    return flg;
	}
	/**
	 * flgを設定します。
	 * @param flg flg
	 */
	public void setFlg(String flg) {
	    this.flg = flg;
	}
}
