package receive;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Haisoubean;
import beans.Haitatsubean;
import beans.Kokyakubean;
import beans.Receive_details;
import benefit.IntegerCheck;
import db_connect.DBManager;

public class ReceiveKanriClass {

	IntegerCheck IC = new IntegerCheck();

	private String insertsql = "Insert into receive_details Values(?,?,?,?,0)";
	private String flg0select="select Order_no,product_id,Product_name,quantity,Warehouse_id,Warehouse_name,Delivery_flg from RECEIVE_DETAILS " +
			"join warehouse using(warehouse_id) " +
			"join products using(product_id) where Order_no=? order by 1,2,5";
	private String flg0Group="select Order_no,0,0,0,0,0,0 from RECEIVE_DETAILS rd1 " +
			"where exists(select * from RECEIVE_DETAILS rd2 where (DELIVERY_FLG=0 or DELIVERY_FLG=2) and rd1.ORDER_NO=rd2.ORDER_NO) " +
			"group by ORDER_NO order by 1";


	private String flg1Group="select Order_no,0,0,0,0,0,0 from RECEIVE_DETAILS rd1 " +
			"where not exists(select * from RECEIVE_DETAILS rd2 where (DELIVERY_FLG=0 or DELIVERY_FLG=2) and rd1.ORDER_NO=rd2.ORDER_NO) " +
			"group by ORDER_NO order by 1 desc";

	private String updateDELIflg = "update receive_details set DELIVERY_FLG=? where ORDER_NO=? and PRODUCT_ID=? and WAREHOUSE_ID=?";

	public void updateDELI(String orderno,String proid,String wareid,String deliflag){
		Connection con = null;

		try{
			con = DBManager.getConnection();
			PreparedStatement pstm = con.prepareStatement(updateDELIflg);
			pstm.setInt(1, IC.henkan(deliflag));
			pstm.setInt(2, IC.henkan(orderno));
			pstm.setInt(3, IC.henkan(proid));
			pstm.setInt(4, IC.henkan(wareid));
			pstm.executeUpdate();

		}catch(Exception e){
			System.out.println(e);

		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}




	public List<Receive_details> Flg0all(String orderno){
		Connection con = null;
		ResultSet rs = null;
		List<Receive_details> rdbean = new ArrayList<Receive_details>();


		try{
			con = DBManager.getConnection();
			PreparedStatement ptsm = con.prepareStatement(flg0select);
			ptsm.setInt(1,IC.henkan(orderno));
			rs=ptsm.executeQuery();


			while(rs.next()){
				Receive_details rd = new Receive_details(rs);
				rdbean.add(rd);
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

		return rdbean;

	}

	public List<Receive_details> Flg0allGroupby(){
		Connection con = null;
		ResultSet rs = null;
		List<Receive_details> rdbean = new ArrayList<Receive_details>();


		try{
			con = DBManager.getConnection();
			PreparedStatement ptsm = con.prepareStatement(flg0Group);
			rs=ptsm.executeQuery();

			while(rs.next()){
				Receive_details rd = new Receive_details(rs);
				rdbean.add(rd);

			}
		}catch(Exception e){
			System.out.println(e);

		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}

		return rdbean;

	}

	public List<Receive_details> Flg1allGroupby(){
		Connection con = null;
		ResultSet rs = null;
		List<Receive_details> rdbean = new ArrayList<Receive_details>();


		try{
			con = DBManager.getConnection();
			PreparedStatement ptsm = con.prepareStatement(flg1Group);
			rs=ptsm.executeQuery();

			while(rs.next()){
				Receive_details rd = new Receive_details(rs);
				rdbean.add(rd);

			}
		}catch(Exception e){
			System.out.println(e);

		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}

		return rdbean;

	}

	//倉庫ごとの配送リスト
	String sokohaisoSQL ="select Order_no,Product_id,Product_name,Quantity,mem_name,MEM_PSCD,MEM_PREF||MEM_MINU||MEM_ADS,DELIVERY_FLG 住所 from RECEIVE_DETAILS " +
			"join warehouse using(warehouse_id) " +
			"join products using(product_id) " +
			"join ORDER_TBL using(order_no) " +
			"join MEMBER using(mem_no) " +
			"where (DELIVERY_FLG=0 or DELIVERY_FLG=2) and warehouse_id=? order by 1";

	public List<Haisoubean> Flg0sokoall(String warehouseid){
		Connection con = null;
		ResultSet rs = null;
		List<Haisoubean> rdbean = new ArrayList<Haisoubean>();


		try{
			con = DBManager.getConnection();
			PreparedStatement ptsm = con.prepareStatement(sokohaisoSQL);
			ptsm.setInt(1,IC.henkan(warehouseid));
			rs=ptsm.executeQuery();


			while(rs.next()){
				Haisoubean rd = new Haisoubean(rs);
				rdbean.add(rd);
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

		return rdbean;

	}


	String sokohaisoSQLandroid ="select Order_no,Product_id,Product_name,Quantity,mem_name,MEM_PSCD,MEM_PREF||MEM_MINU||MEM_ADS,DELIVERY_FLG 住所 from RECEIVE_DETAILS " +
			"join warehouse using(warehouse_id) " +
			"join products using(product_id) " +
			"join ORDER_TBL using(order_no) " +
			"join MEMBER using(mem_no) " +
			"where (DELIVERY_FLG=0 or DELIVERY_FLG=2) and warehouse_id=? and order_no=? order by 1";

	public List<Haisoubean> android(String warehouseid,String order_no){
		Connection con = null;
		ResultSet rs = null;
		List<Haisoubean> rdbean = new ArrayList<Haisoubean>();


		try{
			con = DBManager.getConnection();
			PreparedStatement ptsm = con.prepareStatement(sokohaisoSQLandroid);
			ptsm.setInt(1,IC.henkan(warehouseid));
			ptsm.setInt(2,IC.henkan(order_no));
			rs=ptsm.executeQuery();


			while(rs.next()){
				Haisoubean rd = new Haisoubean(rs);
				rdbean.add(rd);
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

		return rdbean;

	}



	public void ReceiveInsert(String Orderno,String Proid,String Wareid,String Quant){

		Connection con = null;
		try {
			con = DBManager.getConnection();
			PreparedStatement ptsm = con.prepareStatement(insertsql);

			ptsm.setInt(1, IC.henkan(Orderno));
			ptsm.setInt(2, IC.henkan(Proid));
			ptsm.setInt(3, IC.henkan(Wareid));
			ptsm.setInt(4, IC.henkan(Quant));

			ptsm.executeUpdate();

			con.close();
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
	}

	private String updatesql = "Update order_details Set rece_flg = 1 Where order_no = ? AND product_id = ?";
	public void OrderDetailUpdate(String Orderno,String Proid){
		Connection con = null;
		try {
			con = DBManager.getConnection();
			PreparedStatement ptsm = con.prepareStatement(updatesql);

			ptsm.setInt(1, IC.henkan(Orderno));
			ptsm.setInt(2, IC.henkan(Proid));

			ptsm.executeUpdate();

			con.close();
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

	}

	private String stocksql = "Update stock Set quantity = Quantity-? Where warehouse_id = ? AND product_id =?";
	public void StockUpdate(String Quant,String Wareid,String Proid){
		Connection con = null;
		try {
			con = DBManager.getConnection();
			PreparedStatement ptsm = con.prepareStatement(stocksql);

			ptsm.setInt(1, IC.henkan(Quant));
			ptsm.setInt(2, IC.henkan(Wareid));
			ptsm.setInt(3, IC.henkan(Proid));

			ptsm.executeUpdate();

			con.close();
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
	}

	private String haitastusql = "SELECT rd.ORDER_NO,p.PRODUCT_ID,p.PRODUCT_NAME,rd.QUANTITY,w.WAREHOUSE_ID FROM RECEIVE_DETAILS rd "
			+ "INNER JOIN PRODUCTS p ON rd.PRODUCT_ID = p.PRODUCT_ID "
			+ "INNER JOIN WAREHOUSE w ON rd.WAREHOUSE_ID = w.WAREHOUSE_ID "
			+ "WHERE w.WAREHOUSE_ID = ? AND rd.ORDER_NO = ? "
			+ "GROUP BY rd.ORDER_NO,p.PRODUCT_ID,p.PRODUCT_NAME,rd.QUANTITY,w.WAREHOUSE_ID order by 2";
	public List<Haitatsubean> selectHaitatsu(String Wareid,String Orderno){
		Connection con = null;
		List<Haitatsubean> haitatsulist = new ArrayList<Haitatsubean>();
		try {
			con = DBManager.getConnection();
			PreparedStatement pstm = con.prepareStatement(haitastusql);
			pstm.setInt(1, IC.henkan(Wareid));
			pstm.setInt(2, IC.henkan(Orderno));
			ResultSet res = pstm.executeQuery();

			while(res.next()){
				Haitatsubean bean = new Haitatsubean(res);
				haitatsulist.add(bean);
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
		return haitatsulist;
	}

	private String kokyakusql = "SELECT ot.ORDER_NO,ot.ORDER_DATE,m.MEM_NAME,m.MEM_PSCD,m.MEM_PREF||m.MEM_MINU||m.MEM_ADS,w.WAREHOUSE_ID FROM MEMBER m "
									+ "INNER JOIN ORDER_TBL ot ON m.MEM_NO = ot.MEM_NO "
									+ "INNER JOIN RECEIVE_DETAILS rd ON ot.ORDER_NO = rd.ORDER_NO "
									+ "INNER JOIN WAREHOUSE w ON rd.WAREHOUSE_ID = w.WAREHOUSE_ID "
									+ "WHERE (rd.DELIVERY_FLG = 0 or rd.DELIVERY_FLG = 2) AND w.WAREHOUSE_ID = ? "
									+ "GROUP BY ot.ORDER_NO,ot.ORDER_DATE,m.MEM_NAME,m.MEM_PSCD,m.MEM_PREF||m.MEM_MINU||m.MEM_ADS,w.WAREHOUSE_ID order by 1";

	public List<Kokyakubean> selectKokyaku(String wareid){
		Connection con = null;
		List<Kokyakubean> kokyakulist = new ArrayList<Kokyakubean>();
		try {
			con = DBManager.getConnection();
			PreparedStatement pstm = con.prepareStatement(kokyakusql);
			pstm.setInt(1, IC.henkan(wareid));
			ResultSet res = pstm.executeQuery();

			while(res.next()){
				Kokyakubean bean = new Kokyakubean(res);
				kokyakulist.add(bean);
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		return kokyakulist;
	}

}

