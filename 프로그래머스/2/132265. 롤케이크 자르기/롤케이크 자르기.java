import java.util.Arrays;

class Solution {
    public int solution(int[] topping) {
        /*
            각 조각에 동일한 가짓수의 토핑이 올라가도록
            나눴을때 양쪽의 토핑 개수가 동일하게
        */
        
        int answer = 0;
        
        int max = Integer.MIN_VALUE;
        
        for(int i : topping){
            if(max <= i) max = i;
        }
        
        int[] left = new int[max + 1];
        int[] right = new int[max + 1];
        
        int slice = 1;
        
        for(int i = 0; i < slice; i++) {
            left[topping[i]] += 1;
        }

        for(int i = topping.length - 1; i >= slice; i--) {
            right[topping[i]] += 1;
        }

        // System.out.println(Arrays.toString(left) + "\n" + 
        //                 Arrays.toString(right) + "\n");

        int lCount = 0;
        for(int i = 1; i < left.length; i++) {
            if(left[i] != 0) lCount++;
        }

        int rCount = 0;
        for(int i = 1; i < right.length; i++) {
            if(right[i] != 0) rCount++;
        }        
        
        
        while(slice != topping.length) {
            // System.out.println(Arrays.toString(left) + "\n" + 
            //             Arrays.toString(right) + "\n");
            int n = topping[slice++];
            
            // left[n] -> +1 right[n] -> -1
            if(left[n] == 0) lCount += 1;
            
            left[n] += 1;
            
            if(right[n] == 1) rCount -= 1;
            else if(right[n] > 1){
                right[n] -= 1;
            }
                
            if(lCount == rCount) answer++;
        }    
            
        
        return answer;
    }
}