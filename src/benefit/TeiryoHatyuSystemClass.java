package benefit;

public class TeiryoHatyuSystemClass {
	//発注点 = 調達期間中の平均在庫量　＋　安全在庫量=（単位期間の平均需要量 X 調達期間) + 安全在庫量 　
	/*
	 * 発注点を計算するメソッド
	 * */
	public int Hatyuten(double HekinZyuyoRyo,double TyotatuKiakn,double AnzenZaiko){

		double Hatyuten = (HekinZyuyoRyo * TyotatuKiakn) + AnzenZaiko;
		return (int)Math.round(Hatyuten);
	}

	//安全在庫量　= 安全係数　X 標準偏差　X 　√調達期間
	//安全係数は1.65

	/*
	 * 安全在庫量を計算するメソッド
	 * hyozyunhensaはまだルートをかけていない
	 * Rhyozyunhensaでルートをかける
	 * 調達期間は3日とする
	 * */
	public int AnzenZaiko(double hyozyunhensa){
		double tyotatu = Math.sqrt(3);
		double Rhyozyunhensa =Math.sqrt(hyozyunhensa);
		double AnzenZaiko=1.65*tyotatu*Rhyozyunhensa;
		return (int)Math.round(AnzenZaiko);
	}
	/*
	 * 最適発注量を計算するメソッド
	 * 1回あたりの調達費用を1万円とする
	 * 在庫保管比率を10%とする
	 *
	 *
	 * */
	public int SaitekiHatyu(double nenkanzyuyoryo,double konyutanka){
		double keisan1 = 2*nenkanzyuyoryo*5000;
		double keisan2 = konyutanka * 0.25;
		double keisan3 = keisan1/keisan2;
		double SaitekiHatyu = Math.sqrt(keisan3);
		return (int)Math.round(SaitekiHatyu);
	}

	public int KonyuTanka(int hanbai){
		double tanka = hanbai*0.3;

		return (int)Math.round(tanka);
	}



}
