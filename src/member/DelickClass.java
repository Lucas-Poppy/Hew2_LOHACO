package member;

public class DelickClass {
	public String deli(int... a){
		for(int hairetu:a){
			if(hairetu==2){
				return "配達中";
			}
		}
		for(int hairetu:a){
			if(hairetu==0){
				return "配達前";
			}
		}
		return "配達完了";
	}
}
