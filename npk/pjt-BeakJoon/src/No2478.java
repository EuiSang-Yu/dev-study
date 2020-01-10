import java.util.Scanner;

public class No2478 {

	
	 public static void main(String[] args){
	        /* type algorithm code */
	        
	                Scanner sc = new Scanner(System.in);
	        int input = sc.nextInt();
	        
	        
	        // n <= 90
	    	
	    	long a = 0, b=1, c=1;
	    	

	    	long result = 0;
	        if(input == 0){
	            result = 0;
	        }else if(input == 1){
	            result = 1;
	        }else{
	        	for(int i =2 ;i < input; i++) {
	        		a = b;
	        		b = c;
	        		c = a+b;
	        	}
	        	result = c;
	        }
	    	
	    	 
	        
	        System.out.println(result);
	        
	    } 
	 
	 
	 public int fibo(int num){
	        if(num == 0){
	            return 0;
	        }else if(num == 1){
	            return 1;
	        }else{
	            return fibo(num-1) + fibo(num-2);
	        }
	    }
	    public int fiboFaster(int num){
	    	// n <= 90
	    	
	    	int[] arrFibo = new int[90];
	    	arrFibo[0] = 0;
	    	arrFibo[1] = 1;
	    	
	    	for(int i = 2;i<arrFibo.length;i++) {
	    		arrFibo[i] = arrFibo[i-1] + arrFibo[i-2];
	    	}
	    	
	    	
	    	
	        if(num == 0){
	            return 0;
	        }else if(num == 1){
	            return 1;
	        }else{
	        	return arrFibo[num];
	        }
	    	
	    	
	        
	    }

}
