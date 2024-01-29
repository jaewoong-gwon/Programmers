class Solution {
    static String[] alpha;
    static int answer;
    static int count;
    public int solution(String word) {
        answer = 0;
        alpha = new String[]{"A","E","I","O","U"};
        String current = "";
        dfs(current,word);
        return answer;
    }
    static void dfs(String current,String target){
        if(current.equals(target)){
            answer = count;
            return;
        }
        
        if(current.length() >= 5) return;
        for(int i = 0; i < alpha.length; i++){
            count++;
            dfs(current + alpha[i],target);
        }

    }
}