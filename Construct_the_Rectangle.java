/**
 * Created by haozewang on 17/2/21.
 */
public class Construct_the_Rectangle {
    public static int[] constructRectangle(int area) {
        int num = (int)Math.sqrt(area);
        for(int i = num; i <= area; i++){
            if(area % i == 0 && i >= area/i){
                 return new int[]{i,area/i};
            }
        }
        return new int[]{0,0};
    }
    public static void main(String args[]){
        System.out.print(constructRectangle(8)[0]);
    }
}
