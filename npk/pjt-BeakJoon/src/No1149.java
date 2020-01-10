import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//문제
//RGB거리에 사는 사람들은 집을 빨강, 초록, 파랑중에 하나로 칠하려고 한다. 또한, 그들은 모든 이웃은 같은 색으로 칠할 수 없다는 규칙도 정했다. 집 i의 이웃은 집 i-1과 집 i+1이고, 첫 집과 마지막 집은 이웃이 아니다.
//
//각 집을 빨강으로 칠할 때 드는 비용, 초록으로 칠할 때 드는 비용, 파랑으로 드는 비용이 주어질 때, 모든 집을 칠하는 비용의 최솟값을 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 집의 수 N이 주어진다. N은 1,000보다 작거나 같다. 둘째 줄부터 N개의 줄에 각 집을 빨강으로, 초록으로, 파랑으로 칠하는 비용이 주어진다. 비용은 1,000보다 작거나 같은 자연수이다.
//
//출력
//첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.
//
//예제 입력 1 
//3
//26 40 83
//49 60 57
//13 89 99
//예제 출력 1 
//96
//출처
//문제를 번역한 사람: baekjoon
//빠진 조건을 찾은 사람: djm03178
//데이터를 추가한 사람: rdd6584
//알고리즘 분류
//보기
//
//메모

public class No1149 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(sc.readLine());
        
        String[][] costs = new String[3][number];
        int[][] dp = new int[3][number];
        int max = 0;
        // 입력을 받아 파싱하여 배열로 저장
        for (int i = 0;i<number;i++) {
        	costs[i] = sc.readLine().split(" ");
        	
        }                
        // 동적 계획법을 하기위한 결과값 저장소
        
        //R 첫번째
        dp[0][0] = Integer.parseInt(costs[0][0]);
      //G 첫번째
        dp[1][0] = Integer.parseInt(costs[1][0]);
      //B 첫번째
        dp[2][0] = Integer.parseInt(costs[2][0]);
        		
        for(int i=1;i<number;i++) {        	
            //R 을 선택했을때
            dp[0][i] = Integer.parseInt(costs[0][i]) + Math.min(Integer.parseInt(costs[1][i-1]), Integer.parseInt(costs[2][i-1]));
          //G 첫번째
            dp[1][i] = Integer.parseInt(costs[1][i]) + Math.min(Integer.parseInt(costs[0][i-1]), Integer.parseInt(costs[2][i-1]));
          //B 첫번째
            dp[2][i] = Integer.parseInt(costs[2][i]) + Math.min(Integer.parseInt(costs[0][i-1]), Integer.parseInt(costs[1][i-1]));
        
        
        }
        
        max = Math.min(Math.min(dp[1][number-1], dp[2][number-1]), (dp[0][number-1]));
        System.out.println(max);	
	}
}
