using System;

namespace upgyedan
{
    class Program
    {
        static int[] upstair = new int[301];
        static int[] dp = new int[10001];
        static void Main(string[] args)
        {
            int N = Convert.ToInt32(Console.ReadLine());
            if (N > 300)
                Environment.Exit(0);
            for(int i=0; i<N; i++)
            {
                upstair[i] = Convert.ToInt32(Console.ReadLine());
            }
            for(int i = 0; i < N; i++)
            {
                if (i == 0)
                    dp[i] = upstair[i];
                else if (i == 1)
                    dp[i] = dp[i - 1] + upstair[i];
                else if (i == 2)
                    dp[i] = Max(upstair[i-2] + upstair[i],upstair[1]+upstair[2]);
                else
                {

                        dp[i] =(Max((dp[i - 3] + upstair[i - 1] + upstair[i]), (dp[i - 2] + upstair[i])));
                    }
            }
            Console.WriteLine(dp[N-1]);

        }
        private static int Max(int a, int b)
        {
            if (a < b)
                return b;
            else
                return a;
        }
    }
}
