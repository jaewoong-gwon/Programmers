import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int price : prices) queue.add(price);
        
        int idx = 0;
        
        while(queue.size() != 0){
            int price = queue.poll();
            int time = 0;
            for(int tmp : queue){
                time++;
                if(price > tmp) break;
            }
            answer[idx++] = time;
        }
        
        return answer;
    }
}