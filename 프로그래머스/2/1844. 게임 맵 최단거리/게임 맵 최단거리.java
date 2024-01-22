import java.util.*;
class Solution {
    static int[] dx;
    static int[] dy;
    public int solution(int[][] maps) {
        /*
            동,서,남,북 으로의 움직임을 dx,dy 배열로 표현.
            최소값 -> BFS 사용
            1. 이동이 가능한지 확인
            2. 가능한 것만 queue 에 offer
            3. 맵을 움직일때마다 depth count
        */
        dx = new int[]{ 1, -1,0,0 };
        dy = new int[]{ 0, 0,1,-1 };
         
        return bfs(maps,new Coordinate(0,0,1));
    }
    static int bfs(int[][] maps,Coordinate c){
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(c);
        
        while(!queue.isEmpty()){
            Coordinate next = queue.poll();
            if(next.x == maps.length - 1 && next.y == maps[0].length - 1) return next.depth;
            
            for(int i = 0; i < dx.length; i++){
                int X = next.x + dx[i];
                int Y = next.y + dy[i];
                
                // 맵의 범위를 벗어나면 패스
                if(X < 0 || X >= maps.length ||
                    Y < 0 || Y >= maps[0].length ) continue;
                
                // 벽이 있는 자리면 패스
                if(maps[X][Y] == 0) continue;
                
                // 한번 왔던 길은 0 으로 만듬 -> 벽과 같은 값으로 -> 방문처리.
                maps[X][Y] = 0;
                queue.offer(new Coordinate(X,Y,next.depth + 1));
            }
        }
        return -1;
    }
    
    static class Coordinate {
        int x;
        int y;
        int depth;
        Coordinate(int x, int y, int d){ this.x = x; this.y = y; this.depth = d; }
    }
}