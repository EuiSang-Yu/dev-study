import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class No1912 {
	//	문제
	//	n개의 정수로 이루어진 임의의 수열이 주어진다. 우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다. 단, 수는 한 개 이상 선택해야 한다.
	//
	//	예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자. 여기서 정답은 12+21인 33이 정답이 된다.
	//
	//	입력
	//	첫째 줄에 정수 n(1 ≤ n ≤ 100,000)이 주어지고 둘째 줄에는 n개의 정수로 이루어진 수열이 주어진다. 수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수이다.
	//
	//	출력
	//	첫째 줄에 답을 출력한다.
	//
	//	예제 입력 1 
	//	10
	//	10 -4 3 1 5 6 -35 12 21 -1
	//	예제 출력 1 
	//	33
	//	출처
	//	데이터를 추가한 사람: djm03178 dohyeokkim doju kimdr123
	//	빠진 조건을 찾은 사람: isac322 Qwaz
	//	문제의 오타를 찾은 사람: jh05013
	//	잘못된 데이터를 찾은 사람: tncks0121

	public static void main(String[] args) throws NumberFormatException, IOException {

		ver1();
	}



	static void ver1() throws NumberFormatException, IOException{




		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(sc.readLine());

		String inputs[] = new String[number];
		Long maxTmp = null;
		Long max = null;
		// 입력을 받아 파싱하여 배열로 저장
		inputs = sc.readLine().split(" ");



		for(int i=0;i<number-1;i++) {

			if(max == null) {
				max = Long.parseLong(inputs[i]);
			}
			maxTmp = 0l;
			for(int j = i+1 ;j < number; j++) {

				maxTmp += Long.parseLong(inputs[j]);
				max = Math.max(max, maxTmp);
			}        	


		}        
		System.out.println(max);	
	}

	static void ver2() throws NumberFormatException, IOException{
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(sc.readLine());

		String inputs[] = new String[number];
		int[] dp = new int[number];
		int max = 0;
		// 입력을 받아 파싱하여 배열로 저장
		inputs = sc.readLine().split(" ");


		// 동적 계획법을 하기위한 결과값 저장소
		dp[0] = Integer.parseInt(inputs[0]);
		max = Integer.parseInt(inputs[0]);

		for(int i=1;i<number;i++) {        	
			// 현재 값이 이전 값들의 합보다 크다면 그지점부터 더하기 다시 시작
			dp[i] += Math.max(dp[i-1] + Integer.parseInt(inputs[i]), Integer.parseInt(inputs[i]));
			// max 구하기
			max = Math.max(max, dp[i]);


		}        
		System.out.println(max);
	}
}

