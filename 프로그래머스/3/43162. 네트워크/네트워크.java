import java.util.*;
class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        /*
            연결된 컴퓨터를 queue 에 offer
            탐색한 링크는 방문 처리 
            연결 되지 않았을 때 return 
        */
        
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            answer++;
            bfs(computers,i);
        }
        return answer;
    }
    static void bfs(int[][] computers,int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        while(!queue.isEmpty()){
            int c = queue.poll();
            if(!visited[c]){
                visited[c] = true;
                for(int j = 0; j < computers[c].length; j++){
                    if(computers[c][j] == 1 && j != c) queue.offer(j);
                }
            }
        }
    }
}