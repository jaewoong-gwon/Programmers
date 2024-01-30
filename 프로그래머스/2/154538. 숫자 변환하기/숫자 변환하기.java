import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        if(x == y) return answer;
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        list.add(x);
        while(list.size() > 0){
            for(int i : list){
                if(i > y) continue;
                
                if(!set.contains(i + n)){
                    set.add(i + n);
                }
                if(!set.contains(i * 2)){
                    set.add(i * 2);
                }
                if(!set.contains(i * 3)){
                    set.add(i * 3);
                }
            }
            answer++;
            if(set.contains(y)) return answer;
            list.clear();
            list = new ArrayList<>(set);
            set.clear();
        }
        return -1;
    }
}