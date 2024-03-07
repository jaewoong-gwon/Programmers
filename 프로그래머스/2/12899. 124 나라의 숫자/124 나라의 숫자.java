class Solution {
    public String solution(int n) {
        String answer = "";
        /*
            3진수 : 0 1 2
            1 -> 0
            2 -> 1
            3 -> 2
            4 -> 3 
        */
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            int tmp = n % 3;
            if(tmp == 0) sb.append("4");
            else sb.append(tmp);
            n--;
            n /= 3; 
            // System.out.println(sb.toString());
        }
        
        
        // System.out.println("result : " + sb.reverse().toString());
        answer = sb.reverse().toString();
        return answer;
    }
}