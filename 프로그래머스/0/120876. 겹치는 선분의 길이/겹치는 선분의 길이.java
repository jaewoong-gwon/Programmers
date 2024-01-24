import java.util.*;
class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < lines.length; i++){
            for(int j = lines[i][0]; j < lines[i][1]; j++){
                map.put(j,map.getOrDefault(j,0) + 1 );
            }
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        for(int i : list){
            if(map.get(i) >= 2) answer++;
        }
        
        return answer;
    }
}