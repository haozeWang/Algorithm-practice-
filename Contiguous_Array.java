import java.util.HashMap;

/**
 * Created by haozewang on 17/2/21.
 */
public class Contiguous_Array {
    public int findMaxLength(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) nums[i] = -1;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int max = 0;
        map.put(0,-1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum)){
                max = Math.max(max,i-map.get(sum));
            }
            else map.put(sum,i);
        }
        return max;
    }
}
