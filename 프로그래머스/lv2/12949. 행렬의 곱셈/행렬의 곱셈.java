class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for(int r = 0; r < answer.length; r++) {
            for(int c = 0; c < answer[r].length; c++) {
                for(int l = 0; l < arr1[r].length; l++) {
                    answer[r][c] += arr1[r][l] * arr2[l][c];
                }
            }
        }
        return answer;
    }
}