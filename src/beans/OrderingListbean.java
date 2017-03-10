package beans;

import java.sql.ResultSet;

public class OrderingListbean {
	private String ProID;
	private String ProName;
	private String SumQuan;
	private String order_p;
	private String order_quan;

	public OrderingListbean(ResultSet rs){
		try{
			ProID=rs.getString(1);
			ProName=rs.getString(2);
			SumQuan=rs.getString(3);
			order_p=rs.getString(4);
			order_quan=rs.getString(5);
		}catch(Exception e){

		}

	}

	/**
	 * ProIDを取得します。
	 * @return ProID
	 */
	public String getProID() {
	    return ProID;
	}

	/**
	 * ProIDを設定します。
	 * @param ProID ProID
	 */
	public void setProID(String ProID) {
	    this.ProID = ProID;
	}

	/**
	 * ProNameを取得します。
	 * @return ProName
	 */
	public String getProName() {
	    return ProName;
	}

	/**
	 * ProNameを設定します。
	 * @param ProName ProName
	 */
	public void setProName(String ProName) {
	    this.ProName = ProName;
	}

	/**
	 * SumQuanを取得します。
	 * @return SumQuan
	 */
	public String getSumQuan() {
	    return SumQuan;
	}

	/**
	 * SumQuanを設定します。
	 * @param SumQuan SumQuan
	 */
	public void setSumQuan(String SumQuan) {
	    this.SumQuan = SumQuan;
	}

	/**
	 * order_pを取得します。
	 * @return order_p
	 */
	public String getOrder_p() {
	    return order_p;
	}

	/**
	 * order_pを設定します。
	 * @param order_p order_p
	 */
	public void setOrder_p(String order_p) {
	    this.order_p = order_p;
	}

	/**
	 * order_quanを取得します。
	 * @return order_quan
	 */
	public String getOrder_quan() {
	    return order_quan;
	}

	/**
	 * order_quanを設定します。
	 * @param order_quan order_quan
	 */
	public void setOrder_quan(String order_quan) {
	    this.order_quan = order_quan;
	}

}
