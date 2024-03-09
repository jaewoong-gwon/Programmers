import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        List<int[]> list = new ArrayList<>();
        int start = 0;
        int end = 0;
        int sum = sequence[start];
        while(start <= end){
            if(sum < k){
                if(end + 1 >= sequence.length) break; 
                sum += sequence[++end];
            } else if(sum > k){
                sum -= sequence[start++];
            } else {
                list.add(new int[]{start,end});
                sum -= sequence[start++];
            }
        }
        
        Collections.sort(list,(o1,o2) -> {
            int size1 = o1[1] - o1[0];
            int size2 = o2[1] - o2[0];
            if(size1 < size2) return -1;
            else if(size1 > size2) return 1;
            else {
                return o1[1] - o2[1];
            }
        });
        
        // for(int[] arr : list){
        //     System.out.println(Arrays.toString(arr)); 
        // }
        
        return list.get(0);
    }
}