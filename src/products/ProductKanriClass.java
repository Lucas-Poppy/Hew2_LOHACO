package products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Productsbean;
import benefit.IntegerCheck;
import db_connect.DBManager;


public class ProductKanriClass {
	IntegerCheck IC = new IntegerCheck();
	private String selectAll = "Select * From products Where category_id = ?";

	public List<Productsbean> getSelectAll(String cateid){
		Connection con = null;
		List<Productsbean> productlist = new ArrayList<Productsbean>();

			try {
				con = DBManager.getConnection();
				PreparedStatement ptsm = con.prepareStatement(selectAll);
				ptsm.setInt(1, IC.henkan(cateid));
				ResultSet result =ptsm.executeQuery();

				System.out.println(ptsm);

				while(result.next()){
					Productsbean bean = new Productsbean(result);
					productlist.add(bean);
				}
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}finally{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}

		return productlist;
	}



	private String proflg ="update products set ORDER_FLG = 1 where Product_id = ?";
	public void productflg(String proid){
		Connection con = null;
		try{
			con=DBManager.getConnection();
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(proflg);
			pstmt.setInt(1, IC.henkan(proid));
			pstmt.executeUpdate();


		}catch(Exception e){

		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		}
	}

	private String selectOne = "Select * From products Where product_id = ?";

	public Productsbean getSelectOne(String proid) throws SQLException{
		Connection con = null;
		try{
			con = DBManager.getConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		PreparedStatement ptsm2 = con.prepareStatement(selectOne);
		ptsm2.setInt(1, IC.henkan(proid));
		ResultSet result = ptsm2.executeQuery();

		if(result.next()){
			Productsbean bean = new Productsbean(result);
			return bean;
		}
		con.close();
		return null;
	}




	private String selectName="select * from Products where 1=1";






	public List<Productsbean> NameSearch(String... Name){

		System.out.println(Name.length);
		Connection con = null;
		ResultSet result=null;
		List<Productsbean> productslist = new ArrayList<Productsbean>();


		try{
			con=DBManager.getConnection();
			System.out.println(Name.length);
			System.out.println(Name.length*2);

			for (int i = 0; i < Name.length; i++) {
				selectName +=" and (upper(product_Name) Like upper(?)";
				selectName +=" or lower(product_Name) Like lower(?)";
				selectName +=" or SYS.UTL_I18N.TRANSLITERATE(product_Name,'HIRAGANA_FWKATAKANA') Like SYS.UTL_I18N.TRANSLITERATE(?,'HIRAGANA_FWKATAKANA')";
				selectName +=" or SYS.UTL_I18N.TRANSLITERATE(product_Name,'FWKATAKANA_HIRAGANA') Like SYS.UTL_I18N.TRANSLITERATE(?,'FWKATAKANA_HIRAGANA'))";

				System.out.println(selectName);

	        }
			PreparedStatement pstm=(PreparedStatement) con.prepareStatement(selectName);
			int i2=0;
			for (int i = 0; i < Name.length*4; i=i+4) {
				System.out.println(Name[i2]);
				pstm.setString(i+1,"%"+Name[i2]+"%");
				pstm.setString(i+2,"%"+Name[i2]+"%");
				pstm.setString(i+3,"%"+Name[i2]+"%");
				pstm.setString(i+4,"%"+Name[i2]+"%");
				i2++;
	        }
			System.out.println(selectName);


			result = pstm.executeQuery();

			while(result.next()){
				Productsbean bean = new Productsbean(result);
				productslist.add(bean);
			}
		}catch(Exception e){

		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}



		return productslist;
	}


	private String categoryseelct = "Select * From categories Where category_id = ?";

	public String getCategorySelect(String category_id){
		Connection con = null;
		String catename = null;
		try {
			con = DBManager.getConnection();
			PreparedStatement ptsm = con.prepareStatement(categoryseelct);

			ptsm.setInt(1, IC.henkan(category_id));
			ResultSet result = ptsm.executeQuery();

			if(result.next()){
				catename=result.getString(2);
			}

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();

		} finally{

			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		}

		return catename;
	}

	private String pronamesql="select product_name from products where product_id=?";
	public String proName(String proid){
		Connection con = null;
		String proname = null;
		try {
			con = DBManager.getConnection();
			PreparedStatement ptsm = con.prepareStatement(pronamesql);

			ptsm.setInt(1, IC.henkan(proid));
			ResultSet result = ptsm.executeQuery();

			if(result.next()){
				proname=result.getString(1);
			}

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();

		} finally{

			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		}

		return proname;

	}

	private String selectCartPro = "Select * from products where product_id = ?";

	public List<Productsbean> CartPro(String proid){
		Connection con = null;
		List<Productsbean> productslist = new ArrayList<Productsbean>();
		try {
			con = DBManager.getConnection();
			PreparedStatement pstm = con.prepareStatement(selectCartPro);
			pstm.setInt(1, IC.henkan(proid));
			ResultSet res = pstm.executeQuery();

			while(res.next()){
				Productsbean bean = new Productsbean(res);
				productslist.add(bean);
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return productslist;
	}





	}
