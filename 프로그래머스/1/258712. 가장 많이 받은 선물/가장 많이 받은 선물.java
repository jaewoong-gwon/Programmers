import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String,Integer> map = new HashMap<>();
        Map<Integer,Integer> giftPoint = new HashMap<>();

        for(int i = 0; i < friends.length; i++){
            map.put(friends[i],i);
        }
            
        int[][] arr = new int[friends.length][friends.length];
        
        for(String gift : gifts){
            String[] tmp = gift.split(" ");
            int from = map.get(tmp[0]);
            int to = map.get(tmp[1]);
            giftPoint.put(from,giftPoint.getOrDefault(from,0) + 1);
            giftPoint.put(to,giftPoint.getOrDefault(to,0) - 1);
            arr[map.get(tmp[0])][map.get(tmp[1])]++;
        }
        
        // System.out.println(map);
        // System.out.println(giftPoint);
        
        Map<Integer,Integer> result = new HashMap<>();
        boolean[][] visited = new boolean[friends.length][friends.length];
        for(int i = 0; i < arr.length; i++){
            // System.out.println(Arrays.toString(arr[i]));
            for(int j = 0; j < arr[i].length; j++){
                if(i == j) continue;
                if(visited[i][j]) continue;
                
                if(arr[i][j] > arr[j][i]){ // 선물을 주고 받은 기록이 있고 더 많은 선물을 준 경우
                    result.put(i, result.getOrDefault(i,0) + 1);
                    visited[i][j] = true;
                    visited[j][i] = true;
                } else if(arr[i][j] < arr[j][i]){
                    result.put(j, result.getOrDefault(j,0) + 1);
                    visited[i][j] = true;
                    visited[j][i] = true;
                }
                else { // 선물을 주고 받은 적이 없거나 주고 받은 수가 같은 경우
                    int from = giftPoint.getOrDefault(i,0);
                    int to = giftPoint.getOrDefault(j,0);
                    if(from > to){ // A 가 받아야함
                        result.put(i,result.getOrDefault(i,0) + 1);
                        visited[i][j] = true;
                        visited[j][i] = true;
                    }
                    else if(from < to){ // B 가 받아야함
                        result.put(j, result.getOrDefault(j,0) + 1);
                        visited[i][j] = true;
                        visited[j][i] = true;
                    }
                }
            }
            // System.out.println(result);
        }
        
        List<Integer> list = new ArrayList<>(result.keySet());
        for(int i : list){
            int gift = result.get(i);
            if(answer < gift) answer = gift;
        }
        return answer;
    }
} 