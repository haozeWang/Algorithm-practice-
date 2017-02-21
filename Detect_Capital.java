/**
 * Created by haozewang on 17/2/21.
 */
public class Detect_Capital {
    public static boolean detectCapitalUse(String word) {
        char c[] = word.toCharArray();
        boolean flag = false;
        for(int i = 0; i < c.length; i++){
            if(i == 0&& Character.isUpperCase(c[i])) flag = true;
            else if(i != 0 && Character.isUpperCase(c[i])){
                if(flag == false) return false;
                if(!Character.isUpperCase(c[i-1])) return false;
            }
            else{
                if(i-1 > 0 && Character.isUpperCase(c[i-1])) return false;
            }
        }
        return  true;
    }
    
    public static void main(String args[]){
        System.out.print(detectCapitalUse("flaF"));
    }
}
