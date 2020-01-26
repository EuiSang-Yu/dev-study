package podo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 static int numberindex =0;
	public static void main(String[] args) throws IOException {
		int number = Integer.parseInt(br.readLine());
		 if(number==0) {
				System.out.println(0);
				System.exit(0);
		 }
		int[] numberArray = new int[number];
		int[] maxArray = new int[number];
		int plusValue = 0;
		int maxValue = 0;
		int calcValue = 0;
		for(int i=0;i<number;i++) {		
			numberArray[i] = Integer.parseInt(br.readLine());
		}
		maxValue = numberArray[0];
		for(int i=0;i<number;i++) {
			plusValue=numberArray[i];
			for(int j=i;j<number-1;j++) {
				if(numberArray[j] > maxValue)
					maxValue = numberArray[j];
				plusValue=(plusValue+numberArray[j+1]);	
			}
			if(number==2) {
				maxValue=numberArray[0]+numberArray[1];
			}
			calcValue=plusValue;
			if((number-i)>=3) {
				for(int k=i+2;k<number;k=k+3) {
					calcValue= calcValue-numberArray[k];
				}
				maxArray[i] = calcValue;
		}
			if(number==3&&(maxArray[i]<numberArray[1]+numberArray[2])) {
				maxArray[i] = (numberArray[1]+numberArray[2]);		
			}
	}
		Arrays.sort(maxArray);
		if(number==1||number==2) 
			System.out.println(maxValue);
		else
		System.out.println(maxArray[number-1]);
	}
	}

