package minCalc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //���۸����� br�� �Է¹���
    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split("\\-");
        //-�� �������� ���� �ɰ��� �迭�� ����

        int minResult = 0;
        //�ּڰ� �ʱ�ȭ

        for (int i = 0; i < input.length; i++) {
            int calcNum = calc(input[i].split("\\+"));
            //-�� �ɰ��� ������ �迭�� �ε����� ���� +�� �������� �ɰ��� calc�� ����
            if (i == 0) 
            	calcNum *= -1; //-3
            //��ȣ�� �����ͳ��� -������ �ؾ������� ù ������ +�� �����ϹǷ� -1�� ���� ������ �ٲ���
            minResult -= calcNum; 
            //�ּڰ� ������ ��갪�� ����ؼ� ����
        }

        System.out.println(minResult);
    }

    private static int calc(String[] subNums) {
        int result = 0;
        //��ȯ�� �ʱ�ȭ
        for (String item : subNums) {
        	//item�� �Ѿ�� +�� �ɰ� input[i]����
            result += Integer.parseInt(item);
            //�� ��갪�� ���� �����Ͽ� ��Ӵ���
        }
        return result;
        //result return
    }
}
