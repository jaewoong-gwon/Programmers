import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        Map<String,Integer> map = new HashMap<>();
        Map<String,Integer> count = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Music> queue = new PriorityQueue<>((o1,o2)->{
            int n1 = map.get(o1.genre);
            int n2 = map.get(o2.genre);
            if(n1 < n2) return 1;
            else if(n1 > n2) return -1;
            else {
                int p1 = o1.play;
                int p2 = o2.play;
                if(p1 < p2) return 1;
                else if(p1 > p2) return -1;
                else return o1.id - o2.id;
            }
        });
        
        for(int i = 0; i < genres.length; i++){
            String g = genres[i];
            int p = plays[i];
            map.put(g,map.getOrDefault(g,0) + p);
        }

        for(int i = 0; i < genres.length; i++){
            String g = genres[i];
            int p = plays[i];
            queue.offer(new Music(i,g,p));
            count.put(g,0);
        }
        
        
        
        while(!queue.isEmpty()){
            Music m = queue.poll();
            if(count.get(m.genre) < 2){
                list.add(m.id);
                count.replace(m.genre,count.get(m.genre) + 1);
            }
            
            // System.out.println("Music{ id : " + m.id + " genre : " + m.genre +
            //                     " play : " + m.play + " }");
        }
        
        //System.out.println(list);
        return list.stream().mapToInt(x->x).toArray();
    }
    
    static class Music{
        int id;
        String genre;
        int play;
        Music(int i, String g, int p) { id = i; genre = g; play = p;}
    }
}