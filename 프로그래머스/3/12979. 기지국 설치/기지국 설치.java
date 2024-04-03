import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        /*
            전파 최대 범위 -> station - w ~ stations + w
            즉 w = 1 최대 3, w = 2 최대 5 -> 2w + 1
            최대 범위를 커버할 수 있는 위치에 설치
            현재 설치된 기지국 기준 남아있는 범위를 계산
            1. 전파가 닿지 않는 범위 계산
            2. 해당 범위
        */
        int answer = 0;
        int maxRange = 2 * w + 1;
        
        int start = 1;
        int end = 0;
        for(int i = 0; i < stations.length; i++){
            int s = stations[i];
            if(start < s - w){
                int length = s - w - start;
                answer += process(maxRange,length);
            }
            start = s + w + 1;
        }
        if(start <= n) answer += process(maxRange,n - start + 1);
        return answer;
    }
    
    int process(int maxRange, int length){
        int answer = 0;
        if(length <= maxRange){
            answer++;
        } else {
            answer += Math.ceil((double)length / maxRange);
         
        }
        return answer;
    }
}