import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        /*
            data[i][0] : code
            data[i][1] : date
            data[i][2] : maximum
            data[i][3] : remain
            
            data 에서
            ext < val_ext 로 필터
            sort_by 로 정렬
        */
        int[][] answer = {};
        
        List<Data> list = new ArrayList<>();
        for(int[] arr : data){
            list.add(new Data(arr[0], arr[1], arr[2], arr[3]));
        }
        
        return list.stream().filter(x -> x.getField(ext) < val_ext)
            .sorted((o1,o2)->{
                return o1.getField(sort_by) - o2.getField(sort_by);
            })
            .map(Data::toArray)
            .toArray(int[][]::new);
    }
    class Data {
        int code;
        int date;
        int maximum;
        int remain;
        
        Data(int c, int d, int m ,int r){
            code = c;
            date = d;
            maximum = m;
            remain = r;
        }
        
        int getField(String str){
            if(str.equals("code")) return code;
            else if(str.equals("date")) return date;
            else if(str.equals("maximum")) return maximum;
            else return remain;
        }
        
        int[] toArray(){
            return new int[]{code, date, maximum, remain};
        }
        
        @Override
        public String toString(){
            return "Data{ code : " + code + ", date : " + date +
                ", maximum : " + maximum + ", remain : " + remain + " }";
        }
    }
}