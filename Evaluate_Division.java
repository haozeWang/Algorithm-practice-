import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by haozewang on 17/2/23.
 */
public class Evaluate_Division {
    public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        HashMap<String,ArrayList<Double>> weight = new HashMap<>();
        double []res = new double[queries.length];
        for(int i = 0; i < equations.length; i++){
            if(!map.containsKey(equations[i][0])){
                map.put(equations[i][0],new ArrayList<String>());
                weight.put(equations[i][0],new ArrayList<Double>());
            }
            if(!map.containsKey(equations[i][1])){
                map.put(equations[i][1],new ArrayList<String>());
                weight.put(equations[i][1],new ArrayList<Double>());
            }
            map.get(equations[i][0]).add(equations[i][1]);
            map.get(equations[i][1]).add(equations[i][0]);
            weight.get(equations[i][0]).add(values[i]);
            weight.get(equations[i][1]).add(1/values[i]);
        }
        for(int i = 0; i < queries.length; i++){
            HashSet<String> set = new HashSet<>();
            res[i] = helper(map,weight,1,queries[i][0],set,queries[i][1]);
        }
        return res;
    }
    public static double helper(HashMap<String,ArrayList<String>> map, HashMap<String,ArrayList<Double>> weight, double count, String s, HashSet<String> set, String end){
        if(!map.containsKey(s)) return -1;
        ArrayList<String> next = map.get(s);
        ArrayList<Double> price = weight.get(s);
        for(int i = 0; i < next.size(); i++){
            if(next.get(i).equals(end)){
                return count * price.get(i);
            }
            if(set.contains(next.get(i))){
                continue;
            }
            else{
                set.add(next.get(i));
                double temp = helper(map,weight,count*price.get(i),next.get(i),set,end);
                set.remove(set.size()-1);
                if(temp != -1){
                    return temp;
                }
            }
        }
        return -1;
    }
    public static void main(String args[]){
        String [][]equations = new String[][]{{"a","b"},{"b","c"}};
        double []values = new double[]{2.0,3.0};
        String [][]queries = new String[][]{{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        calcEquation(equations,values,queries);
    }
}
