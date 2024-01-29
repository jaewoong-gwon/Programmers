import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = -1;
        Map<Integer,String> map = new HashMap<>();
        for(int i = 0; i < wires.length; i++){
            if(!map.containsKey(wires[i][0])) map.put(wires[i][0],String.valueOf(wires[i][1]));
            else {
                String str = map.get(wires[i][0]);
                map.replace(wires[i][0],str + wires[i][1]);
            }
        }
        
        System.out.println(map);
        return answer;
    }
}