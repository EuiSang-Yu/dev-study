package coin;

import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        //입력 받을 Scanner
        int N = sc.nextInt();
        int M = sc.nextInt();
        //N은 필요한 동전수 M은 동전으로 환산할 돈
        int count =0;
        
        int[] array=  new int[N];
        //동전의 개수인 N을 배열로 크기지정
        for(int i=0; i<N; i++){
        	array[i] = sc.nextInt();
            //N개 까지 입력받음
        }
        sc.close();
        
            for(int i = N-1; i>=0; i--){
                if(M>=array[i]){
                	//환산할 돈이 최대단위의 돈보다 크면
                    count += M/array[i];
                    //동전의 개수에는 나누기의 몫을
                    M = M%array[i];
                    //환산 할 돈은 나누기의 나머지를 넣어준다.
                }
                
            }
            
            System.out.println(count); 
    } 
}
