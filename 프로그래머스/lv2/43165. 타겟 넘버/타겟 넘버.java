class Solution {
    static int[] graph;
    static boolean[] visited;
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        graph = numbers.clone();
        visited = new boolean[numbers.length];
        
        for(int i = 1; i <= numbers.length; i++){
            comb(0,numbers.length,i,target);
        }
        return answer;
    }
    
     // - 로 만들 수 개수 선택 1개 ~ number.length 개 까지
     static void comb(int depth, int n, int r,int target) {
        if(r == 0) {
            int tmp = process(graph, visited);
            if(tmp == target) answer++;
            return;
        }
        if(depth == n) {
            return;
        } else {
            visited[depth] = true;
            comb(depth + 1, n, r - 1,target);
 
            visited[depth] = false;
            comb(depth + 1, n, r, target);
        }
    }
    
     static int process(int[] arr, boolean[] visited) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            if(visited[i] == true) sum -= arr[i];
            else sum += arr[i];
        }
        return sum;
    }
   
}