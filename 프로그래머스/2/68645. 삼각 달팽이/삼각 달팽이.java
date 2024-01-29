import java.util.*;
class Solution {
    public int[] solution(int n) {
        List<Integer> answer = new ArrayList<>();
        int[][] t = new int[n][n];
        
        int num = 1;
        int x = -1;
        int y = 0;
        for(int i = n; i > 0; i-=3){
            for(int j = 0; j < i; j++) t[++x][y] = num++;
            for(int j = 0; j < i - 1; j++) t[x][++y] = num++;
            for(int j = 0; j < i - 2; j++) t[--x][--y] = num++;
        }
        
        for(int[] arr : t){
            for(int i : arr){
                if(i == 0) continue;
                answer.add(i);
            }
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
   
}