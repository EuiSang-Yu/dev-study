import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No1932 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		// 전체 층수를 입력 받음
		int floor = Integer.parseInt(sc.readLine());
		int max = -1;
		//DP의 모양은 tri와 같다
		ArrayList<ArrayList<Integer>> tri = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> dp = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> intLst_tmpTriEle;
		ArrayList<Integer> intLst_tmpDpEle;
		String[] strArr_tmpTriEle = new String[floor];

		// 입력을 받아 파싱하여 tri 리스트에 넣어줌
		for (int i = 0;i<floor;i++) {        

			intLst_tmpTriEle = new ArrayList<Integer>();
			strArr_tmpTriEle = sc.readLine().split(" ");

			for(int j = 0;j<=i;j++) {

				intLst_tmpTriEle.add(Integer.parseInt(strArr_tmpTriEle[j]));
			}
			tri.add(intLst_tmpTriEle);

		}                
		// 동적 계획법을 하기위한 결과값 저장소      
		// 가장 꼭대기의 DP 값은 정상의 값과 같다
		
		intLst_tmpDpEle = new ArrayList<Integer>();
		intLst_tmpDpEle.add(tri.get(0).get(0));
		
		dp.add(0, intLst_tmpDpEle);
		for(int i=1;i<floor;i++) {
			intLst_tmpDpEle = new ArrayList<Integer>();
			for(int j = 0;j<=i;j++) {
				//DP는 이전 합 tri는 현재 계산할 값
				if(j == 0) {
					//dp[i][j] = dp[i-1][0] + tri[i][j]
					intLst_tmpDpEle.add(dp.get(i-1).get(0) + tri.get(i).get(j));
					
				}else if(j == i) {
					//dp[i][j] = dp[i-1][i-1] + tri[i][j]
					intLst_tmpDpEle.add(dp.get(i-1).get(i-1) + tri.get(i).get(j));
					
				}else {
					//dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1]) + tri[i][j]
					intLst_tmpDpEle.add(Math.max(dp.get(i-1).get(j), dp.get(i-1).get(j-1)) + tri.get(i).get(j));
					
				}        	  
			}
			//dp 에 값들을 쌓음
			dp.add(i,intLst_tmpDpEle);
		}
		

		for(Integer tmpMax : intLst_tmpDpEle) {
			
			max = Math.max(max, tmpMax);
		}
		System.out.println(max);	
	}
}
