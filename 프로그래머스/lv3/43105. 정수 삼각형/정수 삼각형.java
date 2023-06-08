import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        for(int i = 1; i < triangle.length; i++){
            for(int j = 0; j < triangle[i].length; j++){
                if(j == 0) triangle[i][j] += triangle[i-1][j];
                else if(j == i) triangle[i][j] += triangle[i-1][j-1];
                else {
                    int left = triangle[i][j] + triangle[i-1][j-1];
                    int right = triangle[i][j] + triangle[i-1][j];
                    triangle[i][j] = ( left < right ) ? right : left;
                }
            }
        }

        return Arrays.stream(triangle[triangle.length -1]).map(x->x).max().getAsInt();
    }
}