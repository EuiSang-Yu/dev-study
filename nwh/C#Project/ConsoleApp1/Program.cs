using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    class Program
    {
        static int[] dp = new int[10001];
        static int[] podo = new int[10001];
        static void Main(string[] args)
        {
            int N = int.Parse(Console.ReadLine());
            for (int i = 1; i <= N; i++)
            {
                podo[i] = int.Parse(Console.ReadLine());
            }
            //if (N % 3 == 1)
            //    calc = (N + 2) / 3;
            //else if (N % 3 == 2)
            //    calc = (N + 1) / 3;
            //else if (N % 3 == 0)
            //    calc = N / 3;

            for (int i = 1; i<=N; i++)
            {
                if (i == 1)
                    dp[N] = podo[N];
                else if (i == 2)
                    dp[N] = podo[1] + podo[2];
                else
                {
                    dp[i] = Max(dp[i-3]+podo[i-1]+podo[i],Max(dp[i - 1], dp[i - 2] + podo[i]));
                }
            }
            Console.WriteLine(dp[N]);
        }
        private static int Max(int first, int second)
        {
            if (first > second)
                return first;
            else if(first==second)
                return first;
            else
                return second;
        }
    }
  }
