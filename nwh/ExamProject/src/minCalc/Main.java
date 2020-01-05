package minCalc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //버퍼리더로 br을 입력받음
    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split("\\-");
        //-를 기준으로 식을 쪼개어 배열에 저장

        int minResult = 0;
        //최솟값 초기화

        for (int i = 0; i < input.length; i++) {
            int calcNum = calc(input[i].split("\\+"));
            //-로 쪼개어 저장한 배열에 인덱스를 각각 +를 기준으로 쪼개어 calc로 보냄
            if (i == 0) 
            	calcNum *= -1; //-3
            //괄호로 묶은것끼리 -연산을 해야하지만 첫 묶음은 +로 시작하므로 -1을 곱해 음수로 바꿔줌
            minResult -= calcNum; 
            //최솟값 변수에 계산값을 계속해서 빼줌
        }

        System.out.println(minResult);
    }

    private static int calc(String[] subNums) {
        int result = 0;
        //반환값 초기화
        for (String item : subNums) {
        	//item에 넘어온 +로 쪼갠 input[i]넣음
            result += Integer.parseInt(item);
            //그 계산값을 따로 저장하여 계속더함
        }
        return result;
        //result return
    }
}
