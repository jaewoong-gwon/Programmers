import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public List<Integer> solution(int N, int[] stages) {
        List<Integer> count = new ArrayList<>();
        
        for(int i = 0; i <= N + 1; i++){
            count.add(0);
        }
        
        for(int i = 0; i < stages.length; i++){
            count.set(stages[i],count.get(stages[i]) + 1);
        }
        
        for(int i : count)System.out.println(i);
        
        Map<Integer,Double> fail = new HashMap<>();
        
        for(int i = 1; i <= N; i++){
            double passPlayer = getPassPlayer(i,count);
            if(passPlayer != 0) fail.put(i,count.get(i) / passPlayer);
            else fail.put(i,0.0);
        }
        
        
        
        List<Integer> answer = new ArrayList<>(fail.keySet());
        
        answer.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return fail.get(o2).compareTo(fail.get(o1));
            }
        });
        
        return answer;
    }
    
    static double getPassPlayer(int index, List<Integer> count){
        double result = 0;
        for(int i = 1; i < count.size(); i++){
            if(i >= index) result += count.get(i);
        }
        return result;
    }
}