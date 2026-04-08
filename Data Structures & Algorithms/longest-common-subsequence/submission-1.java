class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // Bottom up true dynamic programming approach
        // int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        // for(int i = text1.length() - 1; i>=0; i--) {
        //     for(int j = text2.length() - 1; j>=0; j--) {
        //         if (text1.charAt(i) == text2.charAt(j)) {
        //             dp[i][j] = 1+ dp[i+1][j+1];
        //         } else {
        //             dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
        //         }
        //     }
        // }
        // return dp[0][0];

        int N = text1.length(), M = text2.length();
        int[] dp = new int[M + 1];
        for(int i = 0; i< N; i++) {
            int[] currDp = new int[M + 1];
            for(int j = 0; j< M; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    currDp[j+1] = 1+ dp[j];
                } else {
                    currDp[j+1] = Math.max(currDp[j], dp[j+1]);
                }
            }
            dp = currDp;
        }
        return dp[M];
    }
}
