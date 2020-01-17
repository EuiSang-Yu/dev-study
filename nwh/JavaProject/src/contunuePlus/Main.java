package contunuePlus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	 static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 static int numberindex =0;
	public static void main(String[] args) throws IOException {
		int number = Integer.parseInt(br.readLine());
		int[] numberArray = new int[number];
		int plusValue = 0;
		int maxValue = 0;
		String[] input = br.readLine().split(" ");
		for(int i=0;i<number;i++) {		
			numberArray[i] = Integer.parseInt(input[i]);
		}
		maxValue = numberArray[0];
		for(int i=0;i<number;i++) {
			plusValue=numberArray[i];
			for(int j=i;j<number-1;j++) {
				if(numberArray[j] > maxValue)
					maxValue = numberArray[j];
				plusValue=(plusValue+numberArray[j+1]);
				if(plusValue>maxValue)
					maxValue=plusValue;			
			}
		}
		if(maxValue<numberArray[number-1])
			maxValue=numberArray[number-1];
		System.out.println(maxValue);
	}
}
