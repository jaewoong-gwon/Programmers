class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        for(int i = 1; i < land.length; i++){
            for(int j = 0; j < land[i].length; j++){
                land[i][j] += getMax(land[i-1],j);
            }
        }


        for(int i = 0; i < 4; i++){
            answer = Math.max(answer,land[land.length-1][i]);
        }
        
        return answer;
    }
    
    static int getMax(int[] arr, int idx){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(i != idx && max <= arr[i]){
                max = arr[i];
            }
        }
        return max;
    }
}