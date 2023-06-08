import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};

        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < operations.length; i++){
            String[] arr = operations[i].split(" ");
            String flag = arr[0];
            int num = Integer.parseInt(arr[1]);
            if(flag.equals("I")){
                min.add(num);
                max.add(num);
            } else {
                if(num == 1){
                    if(!max.isEmpty()){
                        min.remove(max.poll());
                    }
                } else {
                    if(!min.isEmpty()){
                        max.remove(min.poll());
                    }
                }
            }
        }
        
        if(min.isEmpty() && max.isEmpty()) return new int[]{0,0};
        
        
        return new int[]{max.poll(),min.poll()};
    }
}