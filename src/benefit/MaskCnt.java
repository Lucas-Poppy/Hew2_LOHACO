package benefit;

public class MaskCnt {

	public String masktest(String s, int maskCnt){
        //String型の変数a,tを宣言
        String a = "";
        String t = "";

        //引数s,maskCntの文字数比較によって条件分岐
        if(s.length() >= maskCnt){
            t = s.substring(maskCnt);
            for(int i = 1; i <= maskCnt; i++){
                a += "*";
            }
            return a+t;
        }else{
            t = s.substring(s.length());
            for(int i = 1; i <= s.length(); i++){
                a += "*";
            }
            return a;
        }
    }
}
