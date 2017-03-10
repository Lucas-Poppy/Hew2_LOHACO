package beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Categoriesbean {
	String Category_id;
	String Category_name;

	public Categoriesbean(ResultSet res){
		try {
			Category_id = res.getString(1);
			Category_name = res.getString(2);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	public String getCategory_id(){
		return Category_id;
	}
	public String getCategory_name(){
		return Category_name;
	}
}
