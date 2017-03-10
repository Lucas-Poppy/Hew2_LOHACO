package benefit;

import java.util.Random;

public class HatyuWarihuriClass {

	public int[] Warihuri(int quantity){
		 //Randomクラスのインスタンス化
        Random rnd = new Random();

		int soko[]={0,0,0,0,0};

		for(int i=0;i<quantity;i++){
			int random = rnd.nextInt(5);
			soko[random]+=1;

		}
		return soko;
	}
}
