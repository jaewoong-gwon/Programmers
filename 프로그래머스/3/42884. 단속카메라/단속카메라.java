import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        /*
            진입시점이 빠른 순으로 정렬
            차량의 이동경로, 진입시점과 진출시점의 범위 안에 다른 차량의 이동경로가 포함되는지 확인
            -20 ~ -15 경로에 -18 ~ -13 포함 -> -18 ~ -15 가 포함됨
            -18 ~ -15 경로에 -14 ~ -5 미포함 -> -18 ~ -15 안 카메라 설치, 이동 경로 범위를 -14 ~ -5로 변경
            -14 ~ -5 경로에 -5 ~ -3 포함 -> -5 위치만 포함 -> 해당 위치에 설치
        */
        int answer = 0;
        Arrays.sort(routes,(o1,o2)->{
            return o1[0] - o2[0];
        });
        
        /* 
        for(int[] arr : routes){
            System.out.println(Arrays.toString(arr));
        }
        */
        
        int start = routes[0][0];
        int end = routes[0][1];
        
        // System.out.println("s : " + start + "\t e : " + end);
        for(int i = 1; i < routes.length; i++) {
            int[] route = routes[i];
            if(isInclude(route, start, end)) { // 범위 안에 있으면 겹치는 부분으로 범위를 조정
                int[] range = getRange(route, start, end);
                start = range[0];
                end = range[1];
            } else {
                answer++;
                start = route[0];
                end = route[1];
            }
        }
        return answer + 1;
    }
    
    boolean isInclude(int[] r, int s, int e) {
        // 체크 하려는 범위 s ~ e
        if(s <= r[0] && e >= r[0] ||
            s <= r[1] && e >= r[1]) return true;
        return false;
    }
    
    int[] getRange(int[] r, int s, int e) {
        int[] range = new int[2];
        if(s < r[0]) range[0] = r[0];
        else range[0] = s;
        
        if(e < r[1]) range[1] = e;
        else range[1] = r[1];
        
        return range;
    }
}