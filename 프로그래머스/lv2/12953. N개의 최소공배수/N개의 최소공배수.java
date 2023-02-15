class Solution {
    
    static int[] count;
    
    public int solution(int[] arr) {
        int answer = 1;
        
        count = new int[101];
        
        for(int num : arr) {
            calculate(num);
        }
        
        for(int i = 2; i <= 100; i++) {
            if(count[i] != 0) {
                answer *= Math.pow(i, count[i]);
            }
        }
        return answer;
    }
    
    public void calculate(int num) {
        int idx = 2;
        int temp = 0;
        while(num > 0) {
            if(num % idx == 0) {
                temp++;
                num /= idx;
            } else {
                if(count[idx] < temp) {
                    count[idx] = temp;
                }
                
                if(num == 1) break;
                idx++;
                temp = 0;
            }
            
        }
    }
}