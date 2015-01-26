import java.math.BigInteger;
import java.util.Scanner;

class TestClass {
    
    public static BigInteger fact(int n){
    	if(n==0|| n==1){
    		return BigInteger.valueOf(1);
    	}else{
    		BigInteger num = new BigInteger(String.valueOf(n));
    		return num.multiply(fact(n-1));
    	}
    }
}

public class Factorial {

	public static void main(String args[] ) throws Exception {
        
        Scanner br = new Scanner(System.in);
        int testCasesCount = br.nextInt();

        for (int i = 0; i < testCasesCount; i++) {
            System.out.println(TestClass.fact(br.nextInt()));
        }
    }
}
