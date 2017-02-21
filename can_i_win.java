import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by haozewang on 17/2/20.
 */
//for this problem, we could use top-down dp, use a hashmap to memory record.
public class can_i_win {
    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        HashMap<String,Boolean> map = new HashMap<>();
        boolean []used = new boolean[maxChoosableInteger+1];
        if(desiredTotal <= 0) return true;
        if(((1+maxChoosableInteger)*maxChoosableInteger/2) < desiredTotal){
            return false;
        }
        return helper(desiredTotal,used,map);

    }

    public static boolean helper(int desiredTotal, boolean []used, HashMap<String,Boolean> map){
        if(desiredTotal <= 0) return false;
        String key = Arrays.toString(used);
        if(!map.containsKey(key)) {
            for (int i = 1; i <  used.length; i++) {
                if (used[i] == false) {
                    used[i] = true;
                    if (!helper(desiredTotal-i, used, map)) {
                        map.put(key, true);
                        used[i] = false;
                        return true;
                    }
                    used[i] = false;
                }
            }
            map.put(key,false);
        }
        return map.get(key);
    }
    public static void main(String args[]){
        System.out.print(canIWin(10,11));
    }

}
