import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        Arrays.sort(files, (o1,o2) -> {
            String[] arr1 = process(o1);
            String[] arr2 = process(o2);
            
            int flag1 = arr1[0].compareToIgnoreCase(arr2[0]);
            int flag2 = Integer.parseInt(arr1[1]) - Integer.parseInt(arr2[1]);
            
            if(flag1 == 0){
                if(flag2 == 0) {
                    return 0;
                }
                return flag2;
            } 
            return flag1;
        });
        
        // for(String file : files){
        //     String[] tmp = process(file);
        //     System.out.println("head :" +tmp[0] + " number : " + tmp[1] + " tail : " + tmp[2]);
        // }
        return files;
    }
    
    static String[] process(String file){
        int idx = -1;
        char[] arr = file.toCharArray();
        String[] result = new String[3];
        
        for(int i = 0; i < arr.length; i++){
            if('0' <= arr[i] && arr[i] <= '9'){
                result[0] = file.substring(0,i);
                idx = i;
                break;
            }
        }
        
        for(int i = idx; i < arr.length; i++){
            if( !('0' <= arr[i] && arr[i] <= '9') ){
                if(Math.abs(i - idx) <= 5) {
                    result[1] = file.substring(idx,i);
                    result[2] = file.substring(i,arr.length);
                }
                else {
                    result[1] = file.substring(idx,idx + 5);
                    result[2] = file.substring(idx + 5, arr.length);
                }
                
                idx = i;
                break;
            }
        }
        
        if(result[1] == null){
            if(Math.abs(arr.length - idx) <= 5) result[1] = file.substring(idx, arr.length);
            else {
                result[1] = file.substring(idx,idx + 5);
                result[2] = file.substring(idx + 5, arr.length);
            }
        } 
        
        
        return result;
    }
}