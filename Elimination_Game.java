/**
 * Created by haozewang on 17/2/23.
 */
import java.util.ArrayList;
import java.util.List;

public class Elimination_Game {
    public static int lastRemaining(int n) {
        boolean left = true;
        int num = n;
        int head = 1;
        int step = 1;
        while (num > 1){
            if(left || num % 2 != 0){
                head = head + step;
            }
            step = step * 2;
            num = num / 2;
            left = !left;
        }
        return head;
    }
    public static void main(String args[]){
        System.out.print(lastRemaining(9));
    }
}
