/**
 * Created by haozewang on 17/2/20.
 */
import java.util.List;
public class Beautiful_Arrangement {
    public static int countArrangement(int N) {
        int []num = new int[N];
        for(int i = 0; i < N; i++){
            num[i] = i+1;
        }
        int []visited = new int[N];
        int []sum = new int[]{0};
        backtrack(num,1,visited,sum);
        return sum[0];
    }
    public static void backtrack(int []num, int count, int []visited, int []sum ){
        if(count == num.length+1){
            sum[0]++;
            return;
        }
        for(int i = 0; i < num.length; i++){
            if(visited[i] == 1) continue;
            if(count % num[i] == 0 || num[i] % count == 0){
                visited[i] = 1;
                backtrack(num,count+1,visited,sum);
                visited[i] = 0;
            }
        }
    }
    public static void main(String args[]){
        System.out.print(countArrangement(2));
    }
}
