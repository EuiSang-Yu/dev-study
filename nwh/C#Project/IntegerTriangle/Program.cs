using System;

namespace IntegerTriangle
{
    class Program
    {
        static int[] dp = new int[10001];

        static void Main(string[] args)
        {

            int N = Convert.ToInt32(Console.ReadLine());
            int[,] count = new int[N,N];
            int[] rowNum = new int[N];
            for(int i = 1; i <= N; i++)
            {
                for (int j = 1; j <= i; j++)
                {
                    count[i,j] = Convert.ToInt32(Console.ReadLine().Split(' '));
                }

            }


        }
    }
}
