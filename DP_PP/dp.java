import java.util.*;

public class dp {
    static Scanner scn = new Scanner(System.in);
    // int a = scn.nextInt();
    // int[] arr = new int[a];

    // Fibbonacci Series with 3 different methods============================================
    public static int fibbo_01(int n) {
        if (n <= 1) {
            return n;
        }
        int ans = fibbo_01(n - 1) + fibbo_01(n - 2);
        return ans;

    }
// Memo
    public static int fibbo_02(int n, int[] dp) {
        if (n <= 1) {
            dp[n] = n;
            return dp[n];
        }
      
        if (dp[n] != 0) {
            return dp[n];
        }
        int ans = fibbo_02(n - 1, dp) + fibbo_02(n - 2, dp);
        System.out.print(ans + " ");
        dp[n] = ans;
        return dp[n];

    }
// Tabulization
    public static int fibbo_03(int N, int[] dp) {
        for (int n = 1; n <= N; n++) {
            if (n <= 1) {
                dp[n] = n;
                continue;
            }

            int ans = dp[n - 1] + dp[n - 2];
            dp[n] = ans;

        }
        return dp[N];

    }
//    Leetcode 70=================================
    public static int Climbstairs(int n, int[] dp) {
        if (n <= 1) {
            dp[n] = 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int ans = Climbstairs((n - 1), dp) + Climbstairs((n - 2), dp);
        return dp[n] = ans;
    }
    
    public static int Climbstairs_Dp(int N, int[] dp) {
        for (int n = 0; n <= N; n++) {
            if (n <= 1) {
                dp[n] = 1;
                continue;
            }

            int ans = dp[n - 1] + dp[n - 2];
            dp[n] = ans;
        }
        return dp[N];
       
    }
    // leetcode 746
    public static int mincostCLimbStairs(int n, int[] dp, int[] cost) {
        if (n <= 1) {
            return dp[n] = cost[n];
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int ans = Math.min(mincostCLimbStairs(n - 1, dp, cost), mincostCLimbStairs(n - 2, dp, cost));
        if (n == cost.length) {
            // 4=4
            // dp[n] = ans;
            return ans;
        } else {
            dp[n] = ans + cost[n];
            return ans;
        }
    }
    


    public static void set1(){
   // int ans = fibbo_01(10);
        int[] cost = new int[4];
        for (int i = 0; i < cost.length; i++) {
            cost[i] = scn.nextInt();
        }
         int[] dp = new int[cost.length+1];
        // int ans = fibbo_02(10, dp);
        // int ans = fibbo_03(10, dp);
        // int[] dp = new int[6];
        // int ans = Climbstairs(2, dp);
         int ans = mincostCLimbStairs(4, dp, cost);
        System.out.println(ans);

    }

    public static void solve() {
     set1();
    }

    public static void main(String[] args) {
        solve();

    }

}

// compile: javac file name.java
// run java file name