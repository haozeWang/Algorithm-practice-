/**
 * Created by haozewang on 17/2/20.
 */
// A basic problem to use backtrack. Easy.

import java.util.LinkedList;
import java.util.List;
public class BinaryWatch {
    public static List<String> readBinaryWatch(int num) {
        int []hour = new int[]{1,2,4,8};
        int []minute = new int[]{1,2,4,8,16,32};
        List<String> res = new LinkedList<>();
        for(int i = 0; i <= 4 && i <= num ; i++){
            if(num - i > 6) continue;
            List<Integer> hlist = new LinkedList<>();
            List<Integer> mlist = new LinkedList<>();
            backtrack(hour,i,hlist,0,0);
            backtrack(minute,num-i,mlist,0,0);
            for(int j = 0; j < hlist.size(); j++) {
                if(hlist.get(j) >= 12) continue;
                for (int k = 0; k < mlist.size(); k++) {
                    if(mlist.get(k) >= 60) continue;
                    StringBuilder temp = new StringBuilder();
                    temp.append(hlist.get(j));
                    temp.append(":");
                    if (mlist.get(k) < 10) {
                        temp.append("0");
                        temp.append(mlist.get(k));
                    } else {
                        temp.append(mlist.get(k));
                    }
                    res.add(temp.toString());
                }
            }
        }
        return res;

    }
    public static void backtrack(int []num, int times, List<Integer> temp, int index, int sum){
        if(times == 0) {
            temp.add(sum);
            return;
        }
        for(int i = index; i < num.length; i++){
            backtrack(num,times-1,temp,i+1,sum+num[i]);
        }

    }
    public static void main(String args[]){
         System.out.print(readBinaryWatch(7));
    }
}
