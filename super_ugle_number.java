import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.List;
/**
 * Created by haozewang on 17/2/22.
 */
public class super_ugle_number {
    public static int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<num> queue = new PriorityQueue<>();
        int res[] = new int[n];
        for(int i = 0; i < primes.length; i++){
            queue.add(new num(primes[i],1,primes[i]));
        }
        int i = 1;
        res[0] = 1;
        while (i < n){
            res[i] = queue.peek().val;
            while (res[i] == queue.peek().val){
                num temp = queue.poll();
                queue.add(new num(res[temp.index]*temp.prime,temp.index+1,temp.prime));
            }
            i++;
        }
        return res[n-1];

    }
    static class num implements Comparable<num> {
        int val;
        int index;
        int prime;
        num(int val, int index, int prime){
            this.val = val;
            this.index = index;
            this.prime = prime;
        }

        public int compareTo(num that){
            return this.val - that.val;
        }
    }
    public static void main(String args[]){
        System.out.print(nthSuperUglyNumber(12,new int[]{2,7,13,19}));
    }
}
