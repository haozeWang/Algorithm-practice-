/**
 * Created by haozewang on 17/2/21.
 */
import java.util.ArrayList;
import java.util.List;
public class Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        int []num = new int[n];
        for(int i = 0; i < n; i++){
            num[i] = i+1;
        }
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(num,0,k,temp,list);
        return list;
    }
    public static void helper(int []num, int index, int k, List<Integer> temp, List<List<Integer>> list){
        if(k == 0){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i = index; i < num.length; i++){
            temp.add(num[i]);
            helper(num,i+1,k-1,temp,list);
            temp.remove(temp.size()-1);
        }
    }
    public static void main(String args[]){
        System.out.print(combine(4,2));
    }
}
