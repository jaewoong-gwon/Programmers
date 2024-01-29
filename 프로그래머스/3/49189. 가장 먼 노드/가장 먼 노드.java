import java.util.*;
class Solution {
    static boolean[] visited;
    static int max;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        visited = new boolean[n];
        max = 0;
        List<Node> graph = new ArrayList<>();
        for(int i = 1; i <= n; i++) graph.add(new Node(i,0));
           
        for(int[] arr : edge){
            Node n1 = graph.get(arr[0] - 1);    
            Node n2 = graph.get(arr[1] - 1);
            n1.addLink(n2);
            n2.addLink(n1);
        }
        
        bfs(graph.get(0),0);
        for(Node node : graph){
            if(node.depth == max) answer++;
        }
        return answer;
    }
    
    static void bfs(Node root,int depth){
        Queue<Node> queue = new LinkedList<>();
        visited[root.id - 1] = true;
        queue.offer(root);
        
        while(!queue.isEmpty()){
            Node current = queue.poll();
            // System.out.println(current);
            for(Node next : current.links){
                if(!visited[next.id - 1]){
                    visited[next.id - 1] = true;
                    next.depth = current.depth + 1;
                    max = next.depth;
                    queue.offer(next);
                } 
            }
        }
    }
    
    static class Node {
        int id;
        int depth;
        List<Node> links;
        Node(int i,int d){ id = i; depth = d; links = new LinkedList<>(); }
        void addLink(Node n){ links.add(n); }
        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            for(Node node : links) sb.append(node.id + " ");
            return "Node{ id : " + id + ", depth : " + depth + ", links : [" + sb.toString() + "] }";
        }
    }
}