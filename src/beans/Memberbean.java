package beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Memberbean {

	String Mem_no;
	String Mem_name;
	String Mail_address;
	String Mem_id;
	String Mem_pass;
	String Mem_pref;
	String Mem_minu;
	String Mem_ads;
	String Mem_pscd;

	public Memberbean(ResultSet res) {
		try {
			Mem_no =res.getString(1);
			Mem_name = res.getString(2);
			Mail_address = res.getString(3);
			Mem_id = res.getString(4);
			Mem_pass = res.getString(5);
			Mem_pref = res.getString(6);
			Mem_minu = res.getString(7);
			Mem_ads = res.getString(8);
			Mem_pscd = res.getString(9);

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public String getMem_no() {
		return Mem_no;
	}
	public void setMem_no(String mem_no) {
		Mem_no = mem_no;
	}
	public String getMem_name() {
		return Mem_name;
	}
	public void setMem_name(String mem_name) {
		Mem_name = mem_name;
	}
	public String getMail_address() {
		return Mail_address;
	}
	public void setMail_address(String mail_address) {
		Mail_address = mail_address;
	}
	public String getMem_id() {
		return Mem_id;
	}
	public void setMem_id(String mem_id) {
		Mem_id = mem_id;
	}
	public String getMem_pass() {
		return Mem_pass;
	}
	public void setMem_pass(String mem_pass) {
		Mem_pass = mem_pass;
	}
	public String getMem_pref() {
		return Mem_pref;
	}
	public void setMem_pref(String mem_pref) {
		Mem_pref = mem_pref;
	}
	public String getMem_minu() {
		return Mem_minu;
	}
	public void setMem_minu(String mem_minu) {
		Mem_minu = mem_minu;
	}
	public String getMem_ads() {
		return Mem_ads;
	}
	public void setMem_ads(String mem_ads) {
		Mem_ads = mem_ads;
	}
	public String getMem_pscd() {
		return Mem_pscd;
	}
	public void setMem_pscd(String mem_pscd) {
		Mem_pscd = mem_pscd;
	}
}
