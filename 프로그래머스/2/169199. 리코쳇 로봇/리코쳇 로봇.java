import java.util.*;
class Solution {
    public int solution(String[] board) {
        /*
            . : 빈 공간
            R : 처음 위치
            D : 장애물 위치
            G : 목표 지점
            상,하,좌,우 방향 선정 후 map 의 끝 or 장애물을 만날때 까지 이동
            G 의 상,하,좌,우 중 하나라도 D or 맵의 끝 이어야 도달 가능
        */
        int answer = 0;
        int[][] map = new int[board.length][board[0].length()];
        
        int startX = 0;
        int startY = 0;
        int targetX = 0;
        int targetY = 0;
        
        for(int i = 0; i < board.length; i++){
            char[] arr = board[i].toCharArray();
            for(int j = 0; j < arr.length; j++){
                char c = arr[j];
                if(c == 'D') map[i][j] = -1;
                else if(c == '.') map[i][j] = 0;
                else if(c == 'G'){
                    map[i][j] = 1;
                    targetX = i;
                    targetY = j;
                }
                else {
                    startX = i;
                    startY = j;
                }
            }
        }
        for(int[] arr : map){
            System.out.println(Arrays.toString(arr));
        }        
        // 순서대로 상,하,좌,우
        int[] dx = new int[]{ -1,1,0,0 };
        int[] dy = new int[]{ 0,0,-1,1 };
        
        int count = 0;
        for(int i = 0; i < dx.length; i++){
            int mx = targetX + dx[i];
            int my = targetY + dy[i];
            // System.out.println("mx : " + mx + ", my : " + my);
            // 맵 범위 안에있으면서, 상,하,좌,우 가 벽 or -1(D) 가 아닌 경우
            if(mx >= 0 && mx < map.length && my >= 0 && my < map[0].length 
                       && map[mx][my] == 0) count++;
        }
        if(count == dx.length) return -1;

        
        Node root = new Node(startX,startY,0);
        Node target = new Node(targetX,targetY,0);
        answer = bfs(map,root,target,dx,dy);
        return answer;
    }
    
    int bfs(int[][] map, Node root, Node target, int[] dx, int[] dy){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        boolean[][] visited = new boolean[map.length][map[0].length];

        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(visited[current.x][current.y]) continue;
            visited[current.x][current.y] = true;
            if(current.x == target.x && current.y == target.y) return current.count;
            for(int i = 0; i < dx.length; i++){
                int mx = current.x + dx[i];
                int my = current.y + dy[i];
                // 맵 범위를 벗어나는 방향
                if(mx < 0 || mx == map.length || my < 0 || my == map[0].length) continue;
                // 장애물인 방향
                if(map[mx][my] == -1) continue;
                
                // 맵 범위 안에 있으면서, 장애물이 아니면 해당 방향으로 계속 이동함
                while ( mx >= 0 && mx < map.length && my >= 0 && my < map[0].length 
                       && map[mx][my] != -1) {
                    mx += dx[i];
                    my += dy[i];
                }
                mx -= dx[i];
                my -= dy[i];
                queue.offer(new Node(mx,my,current.count + 1));
            }
        }
        return -1;
    }
    
    class Node{
        int x;
        int y;
        int count;
        Node(int x, int y, int c){ this.x = x; this.y = y; count = c; }
        @Override
        public String toString(){
            return "Node{ x : " + x + ", y : " + y + ", count : " + count + " }";
        }
    }
}