using System;

namespace IntegerTriangle
{
    class Program
    {
        static int[,] dp = new int[10001,10001];

        static void Main(string[] args)
        {

            int N = Convert.ToInt32(Console.ReadLine());
            int[,] triangle = new int[N,N];
            int maxValue = 0;
            
            for(int i = 0; i < N; i++)
            {
               string[] input = Console.ReadLine().Split();
                for (int j = 0; j < i+1; j++)
                {
                    triangle[i, j] = int.Parse(input[j]);
                }
            }
            dp[0, 0] = triangle[0, 0];

            for (int i = 1; i < N; i++)
            {
                for (int j = 0; j < i+1; j++)
                {
                    if (j == 0)
                        dp[i, j] = triangle[i, j] + dp[i - 1, j];
                    else if (j == i)
                        dp[i, j] = dp[i - 1, j - 1] + triangle[i, j];
                    else
                    {
                        dp[i, j] = Max((dp[i - 1, j - 1] + triangle[i, j]), dp[i - 1, j] + triangle[i, j]);
                    }
                    if (i == N - 1)
                        maxValue = Max(dp[i, j],maxValue);

                }
            }
            Console.WriteLine(maxValue);


        }
        private static int Max(int a, int b)
        {
            if (a < b)
                return b;
            else return a;
        }
    }
}
