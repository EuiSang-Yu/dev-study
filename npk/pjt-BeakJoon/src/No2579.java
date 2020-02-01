import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//계단 오르기
//계단 오르는 데는 다음과 같은 규칙이 있다.
//
//계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
//연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
//마지막 도착 계단은 반드시 밟아야 한다.
//따라서 첫 번째 계단을 밟고 이어 두 번째 계단이나, 세 번째 계단으로 오를 수 있다. 하지만, 첫 번째 계단을 밟고 이어 네 번째 계단으로 올라가거나, 첫 번째, 두 번째, 세 번째 계단을 연속해서 모두 밟을 수는 없다.
//
//각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는 총 점수의 최댓값을 구하는 프로그램을 작성하시오.
public class No2579 {
	public static void main(String[] args) throws NumberFormatException, IOException{
		ver2();
	}

	static void ver1() throws NumberFormatException, IOException{



		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(sc.readLine());

		int inputs[] = new int[number];
		int dp[][] = new int[3][number];
		int max = 0;
		// 입력을 받아 파싱하여 배열로 거꾸로 저장 마지막은 항상 밟아야 하므로
		for(int i=0;i<number;i++) {
			inputs[(number-1)-i] = Integer.parseInt(sc.readLine());
		}
		// o x o
		dp[0][0] = inputs[0];
		dp[0][1] = dp[0][0];
		dp[0][2] = dp[0][1]+inputs[2];
		// o o x	
		dp[1][0] = inputs[0];
		dp[1][1] = inputs[0]+inputs[1];
		dp[1][2] = dp[1][1];
		// o x x
		dp[2][0] = inputs[0];
		dp[2][1] = dp[2][0];
		dp[2][2] = dp[2][1];
		for(int i=3;i<number;i++) {			 	
			//안오르거나 -
			//한번오르거나
			//두번 연속 오르거나
			dp[0][i] = Math.max(Math.max(dp[0][i-1],dp[0][i-2]+inputs[i]),dp[0][i-3]+inputs[i-1]+inputs[i]);
			dp[1][i] = Math.max(Math.max(dp[1][i-1],dp[1][i-2]+inputs[i]),dp[1][i-3]+inputs[i-1]+inputs[i]);
			dp[2][i] = Math.max(Math.max(dp[2][i-1],dp[2][i-2]+inputs[i]),dp[2][i-3]+inputs[i-1]+inputs[i]);
		} 
		
		max = Math.max(dp[0][number-1], Math.max(dp[1][number-1],dp[2][number-1]));
		System.out.println(max);	
	}
	
	static void ver2() throws NumberFormatException, IOException{



		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(sc.readLine());

		int inputs[] = new int[300];
		int dp[][] = new int[3][300];
		int max = 0;
		// 입력을 받아 파싱하여 배열로 거꾸로 저장 마지막은 항상 밟아야 하므로
		for(int i=0;i<number;i++) {
			inputs[(number-1)-i] = Integer.parseInt(sc.readLine());
		}
		// o x o
		dp[0][0] = inputs[0];
		dp[0][1] = dp[0][0];
		dp[0][2] = dp[0][1]+inputs[2];
		// o o x	
		dp[1][0] = inputs[0];
		dp[1][1] = inputs[0]+inputs[1];
		dp[1][2] = dp[1][1];
		// o x x
		dp[2][0] = inputs[0];
		dp[2][1] = dp[2][0];
		dp[2][2] = dp[2][1];
		for(int i=3;i<number;i++) {			 	
			
			//한번오르거나 
			//두번 연속 오르거나 dp[n] = dp[n-3] + inputs[n-1] + inputs[]
			dp[0][i] = Math.max(dp[0][i-2]+inputs[i],dp[0][i-3]+inputs[i-1]+inputs[i]);
			dp[1][i] = Math.max(dp[1][i-2]+inputs[i],dp[1][i-3]+inputs[i-1]+inputs[i]);
			dp[2][i] = Math.max(dp[2][i-2]+inputs[i],dp[2][i-3]+inputs[i-1]+inputs[i]);
		} 
		
		max = Math.max(dp[0][number-1], Math.max(dp[1][number-1],dp[2][number-1]));
		System.out.println(max);	
	}
}
