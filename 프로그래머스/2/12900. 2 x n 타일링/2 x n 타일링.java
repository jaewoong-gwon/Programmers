import java.util.*;
class Solution {
    static Map<Integer,Integer> memo;
    public int solution(int n) {
        /*
            가로 2 세로 1 -> 직사각형
            가로 n 세로 2 -> 바닥
            
            n 이 홀수 -> 직사각형 -> 가로로만 배치 x -> 세로로만 배치 1가지
            n 이 짝수 -> 정사각형 -> 1번,2번 각각 하나씩 -> 총 2가지
            
            1. 가로로만 배치
            2. 세로로만 배치
            3. 가로 + 세로로 배치         
            
            가로가 n -> n 개의 타일을 사용
            가로로 배치 -> 한번에 2개 사용해야함
            세로로 배치 -> 하나만 사용 가능
        */
        int answer = 0;
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        for(int i = 4; i <= n; i++){
            arr[i] = ( arr[i - 1] + arr[i - 2] ) % 1_000_000_007;
        }
        return arr[n];
    }   

}