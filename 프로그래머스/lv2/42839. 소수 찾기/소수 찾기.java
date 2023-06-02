import java.util.*;
class Solution {
    static Set<Integer> set;
    public int solution(String numbers) {
        int answer = 0;
        
        char[] arr = numbers.toCharArray();
        set = new HashSet<>();
        int[] intArray = new int[arr.length];
        
        for(int i = 0; i < arr.length; i++){
            intArray[i] = (arr[i] - '0');
        }
        
        for(int i = 1; i <= intArray.length; i++){
            int[] output = new int[intArray.length];
            boolean[] visited = new boolean[intArray.length];
            perm(intArray,output,visited,0,intArray.length,i);
        }
        
        Iterator<Integer> iterator = set.iterator();
    
        while(iterator.hasNext()){
            int num = iterator.next();
            if(isPrime(num)) answer++;
        }
        
        return answer;
    }

    static boolean isPrime(int num){
        int sqr = (int) Math.sqrt(num);
        if(num == 1 || num == 0) return false;
        
        for(int i = 2; i < sqr + 1; i++){
            if(num % i == 0) return false;
        }        
        return true;
    }
    
    static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < r; i++){
                sb.append(output[i]);
            }
            set.add(Integer.parseInt(sb.toString()));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }
    
}