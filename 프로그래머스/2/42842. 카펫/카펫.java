import java.util.List;
import java.util.ArrayList;
class Solution {
    public int[] solution(int brown, int yellow) {
        
        // brown + yellow = 전체 넓이
        int area = brown + yellow;
           
        List<Integer> nums = new ArrayList<>();
        
        // 한변의 길이로 가능한 경우 계산
        for(int i = 1; i <= area; i++) {
            if(area % i == 0) nums.add(i);
        }
        
        int width = 0;
        int height = 0;
        
        // System.out.println(nums);

        for(int i = 0; i < nums.size(); i++) {
            int w = nums.get(i);
            int h = area / w;
            
            
            // 노란색을 둘러싸려면 최소 가로 3, 세로 3
            if(w <= 2 || h <= 2) continue;
            
            // 가로 길이는 세로 길이와 같거나 김
            if(w < h) continue;
            
            // 노란색의 개수, width - 2 height - 2
            if(( w - 2 ) * ( h - 2 ) != yellow ) continue;
            
            width = w;
            height = h;
            
            // System.out.println("w : " + width + "\t h : " + height);
        }
        
        return new int[]{width, height};
    }
}