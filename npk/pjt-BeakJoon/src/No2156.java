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
//첫째 줄에 포도주 잔의 개수 n이 주어진다. (1≤n≤10,000) 둘째 줄부터 n+1번째 줄까지 포도주 잔에 들어있는 포도주의 양이 순서대로 주어진다. 포도주의 양은 1,000 이하의 음이 아닌 정수이다.
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
		String[] winesCalc = new String[number];
		//boolean[] wineStatus = new boolean[number] ;
		int max = 0;
		int tmpCost = 0;
		// 입력을 받아 파싱하여 배열로 저장
		for (int i = 0;i<number;i++) {
			wines[i] = sc.readLine().toString();
		}                
		winesCalc = Arrays.copyOf(wines, wines.length);
		//Arrays.fill(wineStatus,true);


		// 첫번째값을 최대로 지정 max값은 무조건 한개의 원소값보다는 크다.
		max = Integer.parseInt(wines[0]);

		for(int head = 0;head < 4; head++) {

			switch(head) {
			case 0:
				//00
				//tmpCost += Integer.parseInt(winesCalc[0]);
				//winesCalc[0] = "0";

				//tmpCost += Integer.parseInt(winesCalc[1]);
				//winesCalc[1] = "0";


				break;
			case 1:
				//01
				//tmpCost += Integer.parseInt(winesCalc[0]);
				//winesCalc[0] = "0";

				tmpCost += Integer.parseInt(winesCalc[1]);
				winesCalc[1] = "0";
				break;
			case 2:
				//10
				tmpCost += Integer.parseInt(winesCalc[0]);
				winesCalc[0] = "0";

				//tmpCost += Integer.parseInt(winesCalc[1]);
				//winesCalc[1] = "0";
				break;
			case 3:
				//11
				tmpCost += Integer.parseInt(winesCalc[0]);
				winesCalc[0] = "0";

				tmpCost += Integer.parseInt(winesCalc[1]);
				winesCalc[1] = "0";
				break;
			}
			for(int i=2;i<number;i++) { 

				for(int j=i;j<number;j++) {
					//            		if(!(wineStatus[j-1] == false && wineStatus[j-2] == false) && cnt > 3) {
					//            			
					//            		}
					if(!(winesCalc[j-1] == "0" && winesCalc[j-2] == "0") && winesCalc[j] != "0") {
						tmpCost += Integer.parseInt(winesCalc[j]);
						winesCalc[j] = "0";
					}

				}

				max = Math.max(max, tmpCost);
				tmpCost = 0;
			}
			winesCalc = Arrays.copyOf(wines, wines.length);
		}



		System.out.println(max);	

	}


}
