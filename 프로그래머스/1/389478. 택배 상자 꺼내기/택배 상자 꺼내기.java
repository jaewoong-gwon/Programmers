import java.util.Arrays;

class Solution {
    public int solution(int n, int w, int num) {
        /*
            상자의 개수 n, 가로줄 w 개, 꺼내는 상자 번호 num
            
            이차원 배열에 각 번호대로 상자 적재
            인덱스로 접근하여 꺼내야하느 상자 알아내기
        */
        int answer = 0;
        
        int[][] storage = new int[n + 1][w + 1];
        
        int box = 1;
        
        for(int i = 1; i < storage.length; i++) { 
            if(box > n) break;
            if(i % 2 == 1) {
                for(int j = 1; j < storage[i].length; j++) {
                    storage[i][j] = box++;
                    if(box > n) break;
                 } 
            } else {
                for(int j = storage[i].length - 1; j >= 1; j--) {
                    storage[i][j]  = box++;
                    if(box > n ) break;
                }
            }
        }
        
        for(int[] arr : storage){
           // System.out.println(Arrays.toString(arr));
        }
        
        for(int i = 1; i < storage.length; i++) {
            for(int j = 1; j < storage[i].length; j++) {
                if(storage[i][j] == num) {
                    int idx = i + 1;
                    while(idx < storage.length) {
                        if(storage[idx][j] == 0) break;
                        //System.out.println(storage[idx][j]);
                        answer++;
                        idx++;
                    }
                } 
            }
        }
        return answer + 1;
    }
}