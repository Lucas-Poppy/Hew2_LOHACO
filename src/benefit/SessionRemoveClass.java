package benefit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionRemoveClass {
	public void SessionRemove(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.removeAttribute("list1");
		session.removeAttribute("honbulist");
		session.removeAttribute("haitatsu");
		session.removeAttribute("tbl");
		session.removeAttribute("haisolist");
		session.removeAttribute("haisolist");

		

	}
	
	

}
