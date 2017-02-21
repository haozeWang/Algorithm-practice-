/**
 * Created by haozewang on 17/2/21.
 */
public class Compare_Version_Numbers {
    public static int compareVersion(String version1, String version2) {
        String []ver1 = new String[1];
        String []ver2 = new String[1];
        if(version1.indexOf(".")==-1){
            ver1[0] = version1;
        }
        else{
            ver1 = version1.split("\\.");
        }
        if(version2.indexOf(".")==-1){
            ver2[0] = version2;
        }
        else{
            ver2 = version2.split("\\.");
        }
        int i = 0;
        int j = 0;
        while (i < ver1.length || j < ver2.length){
            int num1 = i>=ver1.length?0:Integer.parseInt(ver1[i]);
            int num2 = j>=ver2.length?0:Integer.parseInt(ver2[j]);
            if(num1 > num2) return 1;
            else if(num1 < num2) return -1;
            else {
                i++;
                j++;
            }
        }
        return 0;
    }
    public static void main(String args[]){
        System.out.print(compareVersion("1.0","1.1"));
    }
}
