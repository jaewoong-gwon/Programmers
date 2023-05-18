class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1L)];
        
        int idx = 0;
        for(long i = left; i <= right; i++){
        	int x = (int)(i / n + 1);
            int y = (int)(i % n + 1);
            if(x > y) answer[idx++] = x;
            else if(x < y) answer[idx++] = y;
            else answer[idx++] = x;
        }
        
        return answer;
    }
}