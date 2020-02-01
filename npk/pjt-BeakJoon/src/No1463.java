import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
//
//X가 3으로 나누어 떨어지면, 3으로 나눈다.
//X가 2로 나누어 떨어지면, 2로 나눈다.
//1을 뺀다.
//정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다.
//연산을 사용하는 횟수의 최솟값을 출력하시오.

public class No1463 {
	public static void main(String[] args) throws NumberFormatException, IOException{
		ver2();
	}

	static void ver1() throws NumberFormatException, IOException{


		// 오답
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));


		int input = Integer.parseInt(sc.readLine());
		int dp[] = new int[1000000];
		int min = 1000000;
		int cnt = 0;
		// 점화식
		// -1 -> /3
		// 
		while(true) {
			if(input == 1)break;
			if(input % 3 ==0) {
				input = input/3;
				cnt++;
				continue;
			}else if(input % 2 == 0) {

				if((input-1) % 3 == 0) {
					if(((input-1) % 3) < input % 2) {
						input = (input-1) % 3;
						cnt= cnt+2;
						continue;
					}else {
						input = input/2;
						cnt++;
						continue;
					}
				}else {
					input = input/2;
					cnt++;
					continue;
				}

			}else {
				if(input == 1)break;
				input = input-1;
				cnt++;
				continue;
			}





		}

		System.out.println(cnt);
	}

	static void ver2() throws NumberFormatException, IOException{


		// 정답
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));


		int number = Integer.parseInt(sc.readLine());
		int dp[] = new int[1000001];
		int min = 1000000;
		// 뒤집어서 생각한다.
		// 인텍스가 숫자 ex dp[1] 은 1을 만들수 있는 조합 -> 
		// dp[2] 2를 만드는 조합
		// 점화식
		// 1빼기  -> dp[n] = dp[n-1] +1
		// 3으로 나누어 떨어질때 dp[n] = dp[n/3] +1
		//2 으로 나누어 떠러질때  dp[n] = dp[n/2] +1
		dp[1] = 0;
		for(int i = 2;i<=number; i++) {
			dp[i] = dp[i-1]+1;
			if(i%2 ==0) {
				dp[i] = Math.min(dp[i], dp[i/2]+1);
			}
			if(i%3 ==0) {
				dp[i] = Math.min(dp[i], dp[i/3]+1);
			}
		}
		System.out.println(dp[number]);
	}
	static void ver3() throws NumberFormatException, IOException{


		// 정답
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));


		int number = Integer.parseInt(sc.readLine());
		int dp[] = new int[1000001];
		int min = 1000000;
		// 뒤집어서 생각한다.
		// 인텍스가 숫자 ex dp[1] 은 1을 만들수 있는 조합 -> 
		// dp[2] 2를 만드는 조합
		// 점화식
		// 1빼기  -> dp[n] = dp[n-1] +1
		// 3으로 나누어 떨어질때 dp[n] = dp[n/3] +1
		//2 으로 나누어 떠러질때  dp[n] = dp[n/2] +1
		dp[1] = 0;
		for(int i = 2;i<=number; i++) {
			dp[i] = dp[i-1]+1;
			if(i%2 ==0) {
				dp[i] = Math.min(dp[i], dp[i/2]+1);
			}
			if(i%3 ==0) {
				dp[i] = Math.min(dp[i], dp[i/3]+1);
			}
			System.out.println(i +":"+dp[i]);
		}
		
	}

}

