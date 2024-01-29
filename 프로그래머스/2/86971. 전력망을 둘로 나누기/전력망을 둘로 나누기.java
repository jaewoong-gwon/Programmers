import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = -1;
        List<Node> graph = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++) graph.add(new Node(i + 1));
        
        for(int i = 0; i < wires.length; i++){
            Node n1 = graph.get(wires[i][0] - 1);
            Node n2 = graph.get(wires[i][1] - 1);
            n1.addLink(n2);
            n2.addLink(n1);
        }
        
        for(int i = 0; i < wires.length; i++){
            Node n1 = graph.get(wires[i][0] - 1);
            Node n2 = graph.get(wires[i][1] - 1);
            
            n1.deleteLink(n2);
            n2.deleteLink(n1);
            
            int count = bfs(graph.get(0),n);
            list.add(Math.abs(count - ( n - count)));
            
            n1.addLink(n2);
            n2.addLink(n1);
        }
        
        return list.stream().mapToInt(x->x).min().getAsInt();
    }
    
    static int bfs(Node root, int n){
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int count = 0;
        queue.offer(root);
        visited[root.id - 1] = true;
        while(!queue.isEmpty()){
            Node current = queue.poll();
            count++;
            for(Node next : current.links){
                if(!visited[next.id - 1]){
                    visited[next.id - 1] = true;
                    queue.offer(next);
                }
            }
        }
        return count;
    }
    static class Node {
        int id;
        List<Node> links;
        Node(int i){ id = i; links = new LinkedList<>(); }
        void addLink(Node n){ links.add(n); }
        void deleteLink(Node n) { links.remove(n); }
        
        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            for(Node n : links) sb.append(n.id + " ");
            return "Node{ id : " + id + ", links : " + sb.toString() + " }";
        }
    }
}