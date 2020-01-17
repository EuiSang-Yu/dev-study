import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;



//효주는 포도주 시식회에 갔다. 그 곳에 갔더니, 테이블 위에 다양한 포도주가 들어있는 포도주 잔이 일렬로 놓여 있었다. 효주는 포도주 시식을 하려고 하는데, 여기에는 다음과 같은 두 가지 규칙이 있다.
//
//포도주 잔을 선택하면 그 잔에 들어있는 포도주는 모두 마셔야 하고, 마신 후에는 원래 위치에 다시 놓아야 한다.
//연속으로 놓여 있는 3잔을 모두 마실 수는 없다.
//효주는 될 수 있는 대로 많은 양의 포도주를 맛보기 위해서 어떤 포도주 잔을 선택해야 할지 고민하고 있다. 1부터 n까지의 번호가 붙어 있는 n개의 포도주 잔이 순서대로 테이블 위에 놓여 있고, 각 포도주 잔에 들어있는 포도주의 양이 주어졌을 때, 효주를 도와 가장 많은 양의 포도주를 마실 수 있도록 하는 프로그램을 작성하시오. 
//
//예를 들어 6개의 포도주 잔이 있고, 각각의 잔에 순서대로 6, 10, 13, 9, 8, 1 만큼의 포도주가 들어 있을 때, 첫 번째, 두 번째, 네 번째, 다섯 번째 포도주 잔을 선택하면 총 포도주 양이 33으로 최대로 마실 수 있다.
//
//입력
//첫째 줄에 포도주 잔의 개수 n이 주어진다. (1≤n≤10,000) 둘째 줄부터 n+1번째 줄까지 포도주 잔에 들어있는 포도주의 양이 순서대로 주어진다. 
//포도주의 양은 1,000 이하의 음이 아닌 정수이다.
//
//출력
//첫째 줄에 최대로 마실 수 있는 포도주의 양을 출력한다.
//
//예제 입력 1 
//6
//6
//10
//13
//9
//8
//1
//예제 출력 1 
//33
//출처
//빠진 조건을 찾은 사람: keith
public class No2156 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		ver1();

	}

	static void ver1() throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(sc.readLine());

		String[] wines = new String[number];
		String[][] winesCalc = new String[4][number];
		//boolean[] wineStatus = new boolean[number] ;
		int maxTot = 0;
		int max[] = new int[4];
		int tmpCost0 = 0;
		int tmpCost1 = 0;
		int tmpCost2 = 0;
		
		
		// 입력을 받아 파싱하여 배열로 저장
		for (int i = 0;i<number;i++) {
			wines[i] = sc.readLine().toString();
		}                
		
		//Arrays.fill(wineStatus,true);
		// 초기 값 세팅
		//포도주의 양은 1,000 이하의 음이 아닌 정수이다.
		for(int i = 0;i < 4;i++) {
			max[i] = 0;
		
			winesCalc[i] = Arrays.copyOf(wines, wines.length);
		}
		




		// 첫번째값을 최대로 지정 max값은 무조건 한개의 원소값보다는 크다.
		
		if(number < 2) {
			for(int i=0;i<number;i++) { 
				maxTot = maxTot+ Integer.parseInt(winesCalc[0][i]);
			}
		}else {
	
			//00
			//max[0] += Integer.parseInt(winesCalc[0][0]);
			//max[0] += Integer.parseInt(winesCalc[0][1]);
			//winesCalc[0][0] = "-1";
			//winesCalc[0][1] = "-1";

			
			//01
			//max[1] += Integer.parseInt(winesCalc[1][0]);
			max[1] += Integer.parseInt(winesCalc[1][1]);
			//winesCalc[1][0] = "-1";
			winesCalc[1][1] = "-1";

			
			//10
			max[2] += Integer.parseInt(winesCalc[2][0]);
			//max[2] += Integer.parseInt(winesCalc[2][1]);
			winesCalc[2][0] = "-1";
			//winesCalc[2][1] = "-1";

			
			//11
			max[3] += Integer.parseInt(winesCalc[3][0]);
			max[3] += Integer.parseInt(winesCalc[3][1]);
			winesCalc[3][0] = "-1";
			winesCalc[3][1] = "-1";



				
				
	
			for(int h = 0;h < 4;h++) {
				System.out.println("\n"+h+"----------------------");
				tmpCost0 = 0;
				tmpCost1 = 0;
				tmpCost2 = 0;
				int i=2;
				while(i<number) { 
					//조건
					if( !(winesCalc[h][i] == "-1") && !(winesCalc[h][i-1] == "-1" && winesCalc[h][i-2] == "-1")) {
						tmpCost0 = max[h]+ Integer.parseInt(winesCalc[h][i]);						
						if(i+1<number) {
							tmpCost1 = max[h]+ Integer.parseInt(winesCalc[h][i+1]);
						}if(i+2<number) {
							tmpCost2 = max[h]+ Integer.parseInt(winesCalc[h][i+2]);
						}
						// 3개중에 가장 최댓값을 골라서 넣는다
						max[h] = Math.max(Math.max(tmpCost0, tmpCost1),tmpCost2);
						System.out.println(max[h]);
						// 어느 값을 넣었는지 확인하여 상태 표시 마셨다면 0;
						if(tmpCost0 == max[h]) {
							winesCalc[h][i] = "-1";							
						}else if(i+1<number && tmpCost1 == max[h]) {
							winesCalc[h][i+1] = "-1";
						}else if(i+2<number && tmpCost2 == max[h]) {
							winesCalc[h][i+2] = "-1";
						}
					}
						i++;

					

				}
				
			}
			

			
			
		}

		



		maxTot =Math.max(Math.max(max[0], max[1]),Math.max(max[2], max[3]));
		System.out.println("최댓값은 "+maxTot);
		System.out.println("\n\n"+0 +" : "+max[0]);
		for(String str : winesCalc[0]) {
			System.out.print(str + "  ");
		}
		System.out.println("\n\n"+1 +" : "+max[1]);
		for(String str : winesCalc[1]) {
			System.out.print(str + "  ");
		}
		System.out.println("\n\n"+2 +" : "+max[2]);
		for(String str : winesCalc[2]) {
			System.out.print(str + "  ");
		}
		System.out.println("\n\n"+3 +" : "+max[3]);
		for(String str : winesCalc[3]) {
			System.out.print(str + "  ");
		}
		
//		System.out.println(maxTot);

	}
	/*
	static void ver2() throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(sc.readLine());

		String[][] wines = new String[4][number];
		String[][] winesCalc = new String[4][number];
		//boolean[] wineStatus = new boolean[number] ;
		int max = 0;
		int tmpCost0 = 0,tmpCost1 = 0,tmpCost2 = 0;
		// 입력을 받아 파싱하여 배열로 저장
		for (int i = 0;i<number;i++) {
			wines[0][i] = sc.readLine().toString();
			wines[1][i] = sc.readLine().toString();
			wines[2][i] = sc.readLine().toString();
			wines[3][i] = sc.readLine().toString();
		}                
		winesCalc = Arrays.copyOf(wines, wines.length);
		//Arrays.fill(wineStatus,true);


		// 첫번째값을 최대로 지정 max값은 무조건 한개의 원소값보다는 크다.
		max = Integer.parseInt(wines[0]);
		winesCalc[0] ="0";
		
		if(number < 2) {
			for(int i=0;i<number;i++) { 
				max = max+ Integer.parseInt(winesCalc[i]);
			}
		}else {
			for(int i=0;i<2;i++) {

				
				tmpCost0 = max+ Integer.parseInt(winesCalc[i]);
				tmpCost1 = max+ Integer.parseInt(winesCalc[i+1]);
				tmpCost2 = max+ Integer.parseInt(winesCalc[i+2]);
				max = Math.max(Math.max(tmpCost0, tmpCost1),tmpCost2);
				
				if(tmpCost0 == max) {
					winesCalc[i] = "0";
				}else if(tmpCost1 == max) {
					winesCalc[i+1] = "0";
					i+=1;
				}else if(tmpCost2 == max) {
					winesCalc[i+2] = "0";
					i+=2;
				}
			}		

			for(int i=2;i<number;i++) { 
				if(!(winesCalc[i-1] == "0" && winesCalc[i-2] == "0") && winesCalc[i] != "0") {
					tmpCost0 = max+ Integer.parseInt(winesCalc[i]);
					if(i+1<number) {
						tmpCost1 = max+ Integer.parseInt(winesCalc[i+1]);
					}if(i+2<number) {
						tmpCost2 = max+ Integer.parseInt(winesCalc[i+2]);
					}
					
					

					max = Math.max(Math.max(tmpCost0, tmpCost1),tmpCost2);

					
					if(tmpCost0 == max) {
						winesCalc[i] = "0";
					}else if(tmpCost1 == max) {
						winesCalc[i+1] = "0";
						i+=1;
					}else if(tmpCost2 == max) {
						winesCalc[i+2] = "0";
						i+=2;
					}
				}				

			}

			
			
		}

		




		System.out.println(max);
		
		for(String str : winesCalc) {
			System.out.print(str + "  ");
		}

	}

*/
}
