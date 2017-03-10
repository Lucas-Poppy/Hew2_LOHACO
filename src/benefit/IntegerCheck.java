package benefit;

public class IntegerCheck {
	public boolean check(String s){

		if(s.equals("")){
			return true;
		}else{
			try{
				Integer.parseInt(s);
				return true;

			}catch(Exception e){
				return false;
			}
		}


	}



	public int henkan(String s){

		if(s.equals("")){
			return 0;
		}else{
			try{
				return Integer.parseInt(s);


			}catch(Exception e){
				return 0;
			}
		}


	}

	public boolean procheck(String s){

		int i = 0;
				try{
					i=Integer.parseInt(s);
					if(i<251 && i>0){
						return true;
					}else{
						return false;
					}


				}catch(Exception e){
					return false;
				}



		}
}
