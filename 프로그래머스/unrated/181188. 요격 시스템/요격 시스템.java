import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets,(int[] o1, int[] o2)->{
            return o1[0] - o2[0];
        });
        
        
        // for(int[] arr : targets){
        //     for(int i : arr) System.out.print(i + " ");
        //     System.out.println("");
        // }
        
        
        int s = targets[0][0];
        int e = targets[0][1];
        answer++;
        
        for(int i = 1; i < targets.length; i++){   
            if((s <= targets[i][0] && targets[i][0] < e) || 
                (e >= targets[i][1])){
                s = Math.max(s,targets[i][0]);
                e = Math.min(e,targets[i][1]);
            } else {
                s = targets[i][0];
                e = targets[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}