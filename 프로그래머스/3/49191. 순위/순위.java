import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        Node[] graph = new Node[n];
        for(int i = 0; i < n; i++){
            graph[i] = new Node(i + 1);
        }
        
        for(int i = 0; i < results.length; i++){
            graph[results[i][0] - 1].addLink(graph[results[i][1] - 1]);
        }
        
        for(Node node : graph){
            bfs(graph,node);
            // System.out.println("");
        }
        
        for(Node node : graph){
            if(node.win + node.lose == n-1) answer++;
        }
        return answer;
    }
    
    static void bfs(Node[] graph,Node root){
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];
        
        visited[root.id - 1] = true;
        queue.offer(root);
        
        while(!queue.isEmpty()){
            Node current = queue.poll();
            // System.out.println(current);
            for(Node next : current.links){
                if(!visited[next.id - 1]){
                    visited[next.id - 1] = true;
                    queue.offer(next);
                    root.win++;
                    next.lose++;
                }
            }
        }
    }

    static class Node {
        int id;
        int win;
        int lose;
        List<Node> links;
        Node(int i){ id = i; win = 0; lose = 0; links = new LinkedList<>(); }
        void addLink(Node n){ links.add(n); }
        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            for(Node node : links) sb.append(node.id + " ");
            return "Node{ id : " + id + ", win : " + win + ", lose : " + lose +
                ", links : " + sb.toString() + " }";
        }
    }
    
}