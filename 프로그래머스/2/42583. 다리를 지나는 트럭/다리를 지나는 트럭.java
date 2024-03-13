import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> ready = new LinkedList<>();
        Queue<Integer> run = new LinkedList<>();
        
        for(int i : truck_weights) ready.offer(i);
        
        int currentTime = 0;
        int limit = 0;
        int loop = 0;
        
        while(loop != truck_weights.length){
            if(run.isEmpty()){
                if(!ready.isEmpty()){
                    int t = ready.poll();
                    limit += t;
                    run.offer(t);
                    currentTime++;
                }
            } else {
                if(run.size() == bridge_length){
                    int t = run.poll();
                    if(t == 0) continue;
                    limit -= t;
                    loop++;
                }
                if(!ready.isEmpty()){
                    if(run.size() + 1 <= bridge_length && limit + ready.peek() <= weight){
                        int t = ready.poll();
                        limit += t;
                        run.offer(t);
                        currentTime++;
                    } else {
                        run.offer(0);
                        currentTime++;
                    }
                } else {
                    run.offer(0);
                    currentTime++;
                }
            }
        }

        return currentTime;
    }
}