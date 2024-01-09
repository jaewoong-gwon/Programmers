import java.util.*;
class Solution {
    static List<Integer> list;
    public int[][] solution(int n) {
        list = new ArrayList<>();
        hanoi(n,1,3,2);
        int[][] answer = new int[list.size()/2][2];
        int idx = 0;
        for(int i = 0; i < answer.length; i++){
            for(int j = 0; j < answer[i].length; j++){
                answer[i][j] = list.get(idx++);
            }
        }
        return answer;
    }
    static void hanoi(int n, int a, int b, int c){
        if(n == 1){
            list.add(a);
            list.add(b);
            return;
        }
        
        hanoi(n - 1,a,c,b);
        list.add(a);
        list.add(b);
        hanoi(n - 1,c,b,a);
    }
}
