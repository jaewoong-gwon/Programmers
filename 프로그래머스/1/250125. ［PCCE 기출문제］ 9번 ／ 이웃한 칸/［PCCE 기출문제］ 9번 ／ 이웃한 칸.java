import java.util.*;
class Solution {
    public int solution(String[][] board, int h, int w) {
        /*
            2차원 격자
            위, 아래, 왼, 오 중 같은 색으로 칠해진 칸의 개수
        */
        int answer = 0;
                
        // for(String[] arr : board) System.out.println(Arrays.toString(arr));
        
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        
        for(int i = 0; i < dx.length; i++){  
            int mx = h + dx[i];
            int my = w + dy[i];
            
            if(0 > mx || mx >= board.length || 0 > my || my >= board[0].length) continue;
            
            if(!board[mx][my].equals(board[h][w])) continue;
            
            answer++;
        }
        return answer;
    }
}