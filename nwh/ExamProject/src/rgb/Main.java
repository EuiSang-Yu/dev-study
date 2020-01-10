package rgb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	static int homeCount =0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] array = new int[homeCount];
    static int zeromin;
	public static void main(String[] args) throws IOException {
		homeCount = Integer.parseInt(br.readLine());
		if(homeCount<=0||homeCount>1000) {
			System.exit(0);
		}
		//집의 개수를 받을 객체  homeCount 생성	
		int[] red = new int[homeCount];
	    int[] green = new int[homeCount];
	    int[] blue = new int[homeCount];
	    int[] minArray = new int[homeCount];
	    int min = 0;
	   
		String lastColor = " ";
	    //객체 초기화	
					
			for(int i=0;i<homeCount;i++) {
				String[] input = br.readLine().split(" ");
				red[i] = Integer.parseInt(input[0]);
				green[i] = Integer.parseInt(input[1]);
				blue[i] = Integer.parseInt(input[2]);
				
			}//input에 각각 집에 색깔 비용 입력
			for(int i=0;i<homeCount-1;i++) {
					if(i==0) { // 0+1 Start
		
						if((red[i]+blue[i+1])<(red[i]+green[i+1])) {
						min = (red[i]+blue[i+1]);
						lastColor="b";
						}
						else {
							min=(red[i]+green[i+1]);
							lastColor="g";
						}
						if(min>(blue[i]+red[i+1])) {
							min=(blue[i]+red[i+1]);
							lastColor="r";
						}
						if(min>(blue[i]+green[i+1])) {
							min=(blue[i]+green[i+1]);
							lastColor="g";
						}
						if(min>(green[i]+red[i+1])) {
							min=(green[i]+red[i+1]);
							lastColor="r";
						}
						if(min>(green[i]+blue[i+1])) {
							min=(green[i]+blue[i+1]);
							lastColor="b";
						}
						minArray[i]=min;

					} // 0 + 1 END
					else {
						if(lastColor=="r") {
							if((minArray[i-1]+blue[i+1])<(minArray[i-1]+green[i+1])) {
								minArray[i] = (minArray[i-1]+blue[i+1]);
								lastColor="b";
							}
							else {
								minArray[i] = (minArray[i-1]+green[i+1]);
								lastColor="g";
							}
						}
						else if(lastColor=="g") {
							if((minArray[i-1]+blue[i+1])<(minArray[i-1]+red[i+1])) {
								minArray[i] = (minArray[i-1]+blue[i+1]);
							}
							else {
								minArray[i] = (minArray[i-1]+red[i+1]);
							}
						}
						else if(lastColor=="b") {
							if((minArray[i-1]+green[i+1])<(minArray[i-1]+red[i+1])) {
								minArray[i] = (minArray[i-1]+green[i+1]);
								lastColor="g";
							}
							else {
								minArray[i] = (minArray[i-1]+red[i+1]);
								lastColor="r";
							}
						}
					
					}// i =1 i++ END
					
					
				}
			if(homeCount == 1) {
				if(red[0]<green[0])
					zeromin = red[0];
				else zeromin = green[0];
				if(zeromin>blue[0])
					zeromin = blue[0];
				minArray[0]=min;
				System.out.println(zeromin);
			}
			else if((homeCount==2)) {
				System.out.println(minArray[0]);	
			}
			else
			System.out.println(minArray[homeCount-2]);		
	}
	//반례)같은거 처리 안함 미완코드

}
