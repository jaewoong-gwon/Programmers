import java.util.*;
class Solution {
    static Set<String> used;
    public int solution(String begin, String target, String[] words) {
        /*
            바꿀수 있는 경우에만 탐색 진행
            한번 바꾼 단어 확인
            바꿀떄 마다 깊이 + 1 진행해서 target 과 같을때 해당 depth 리턴
        */
        used = new HashSet<>();
        return bfs(words,begin,target,0);
    }
    static int bfs(String[] words, String begin, String target,int depth){
        if(!List.of(words).contains(target)) return 0;
        Queue<Word> queue = new LinkedList<>();
        queue.offer(new Word(begin,depth));
        while(!queue.isEmpty()){
            Word now = queue.poll();
            if(now.word.equals(target)) return now.depth;
            for(String word : words){
                if(!used.contains(word)){
                    if(check(now.word,word)){
                        used.add(word);
                        queue.offer(new Word(word,now.depth + 1));
                    }
                }
            }
        }
        return 0;
    }
    
    static boolean check(String now, String target){
        int count = 0;
        for(int i = 0; i < now.length(); i++){
            if(now.charAt(i) != target.charAt(i)) count++;
        }
        return count == 1;
    }
    
    static class Word {
        String word;
        int depth;
        Word(String w, int d){ word = w; depth = d;}
    }
}