import java.util.*;
class Solution {
    static PriorityQueue<Integer> queue;
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        queue = new PriorityQueue<>((o1,o2)->{
            return o1.compareTo(o2);
        });
        
        for(int i : scoville) queue.add(i);
        
        int sum = 0;
        int min = queue.peek();
        while(K > min && queue.size() > 1){
            // if(queue.size() < 2) break; -> 하나만 남았을때 스코빌 지수를 넘는다면 틀림.
                int first = queue.poll();
                int second = queue.poll();

                sum = first + (2 * second);
                queue.add(sum);
                answer++;
                min = queue.peek();
                //print();
                //if(check(K)) return answer;
                
        }
        
        if(min < K) return -1;
        
        return answer;
    }

    
    static boolean check(int k){
        if(queue.isEmpty()) return false; // 비어있어도 아래의 코드는 true를 리턴함.
        return queue.stream().allMatch(item -> item >= k);
    }
    
    static void print(){
        List<Integer> tmp = new ArrayList<>();
        while(!queue.isEmpty()){
            int i = queue.poll();
            tmp.add(i);
            System.out.println(i);
        }
        System.out.println("------------------");
        for(int i : tmp) queue.add(i);
    }
}