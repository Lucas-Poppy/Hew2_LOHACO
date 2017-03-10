package beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Productsbean {
	String Product_id;
	String Product_name;
	String Product_sale_price;
	String Product_purchease_price;
	String Category_id;
	String Stock_raito;
	String Standard_deviation;
	String Safe_stock;
	String Demand_quantity;
	String Opt_order_quantity;
	String Order_point;
	String Pro_priod;
	String Image_file_name;
	String Order_flg;


	public Productsbean(ResultSet res){
		try {
			Product_id = res.getString(1);
			Product_name = res.getString(2);
			Product_sale_price = res.getString(3);
			Product_purchease_price = res.getString(4);
			Category_id = res.getString(5);
			Stock_raito = res.getString(6);
			Standard_deviation = res.getString(7);
			Safe_stock = res.getString(8);
			Demand_quantity = res.getString(9);
			Opt_order_quantity = res.getString(10);
			Order_point = res.getString(11);
			Pro_priod = res.getString(12);
			Image_file_name = res.getString(13);
			Order_flg = res.getString(14);

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public String getProduct_id() {
		return Product_id;
	}
	public void setProduct_id(String product_id) {
		Product_id = product_id;
	}
	public String getProduct_name() {
		return Product_name;
	}
	public void setProduct_name(String product_name) {
		Product_name = product_name;
	}
	public String getProduct_sale_price() {
		return Product_sale_price;
	}
	public void setProduct_sale_price(String product_sale_price) {
		Product_sale_price = product_sale_price;
	}
	public String getProduct_purchease_price() {
		return Product_purchease_price;
	}
	public void setProduct_purchease_price(String product_purchease_price) {
		Product_purchease_price = product_purchease_price;
	}
	public String getCategory_id() {
		return Category_id;
	}
	public void setCategory_id(String category_id) {
		Category_id = category_id;
	}
	public String getStock_raito() {
		return Stock_raito;
	}
	public void setStock_raito(String stock_raito) {
		Stock_raito = stock_raito;
	}
	public String getStandard_deviation() {
		return Standard_deviation;
	}
	public void setStandard_deviation(String standard_deviation) {
		Standard_deviation = standard_deviation;
	}
	public String getSafe_stock() {
		return Safe_stock;
	}
	public void setSafe_stock(String safe_stock) {
		Safe_stock = safe_stock;
	}
	public String getDemand_quantity() {
		return Demand_quantity;
	}
	public void setDemand_quantity(String demand_quantity) {
		Demand_quantity = demand_quantity;
	}
	public String getOpt_order_quantity() {
		return Opt_order_quantity;
	}
	public void setOpt_order_quantity(String opt_order_quantity) {
		Opt_order_quantity = opt_order_quantity;
	}
	public String getOrder_point() {
		return Order_point;
	}
	public void setOrder_point(String order_point) {
		Order_point = order_point;
	}
	public String getPro_priod() {
		return Pro_priod;
	}
	public void setPro_priod(String pro_priod) {
		Pro_priod = pro_priod;
	}
	public String getImage_file_name() {
		return Image_file_name;
	}
	public void setImage_file_name(String image_file_name) {
		Image_file_name = image_file_name;
	}
	public String getOrder_flg() {
		return Order_flg;
	}
	public void setOrder_flg(String order_flg) {
		Order_flg = order_flg;
	}
}
