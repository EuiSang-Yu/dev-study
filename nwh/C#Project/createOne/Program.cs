using System;

namespace createOne
{
    class Program
    {
        static int[] dp = new int[1000001];
        static void Main(string[] args)
        {
            int N = Convert.ToInt32(Console.ReadLine());
            for(int i=1;i<=N;i++)
            {
                if (i == 1)
                    dp[i] = 0;
                else
                {
                    dp[i] = dp[i - 1] + 1;
                    if (i % 2 == 0)
                    {
                        dp[i]= minCalc((dp[i/2]+1),dp[i]);
                    }
                    if(i%3==0)
                    {
                        dp[i] = minCalc((dp[i / 3] + 1), dp[i]);
                    }
                }

            }
            Console.WriteLine(dp[N]);
        }
        private static int minCalc(int a,int b)
        {
            if (a < b)
                return a;
            else return b;
        }
    }
}
