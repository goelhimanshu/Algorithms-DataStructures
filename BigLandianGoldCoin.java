import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class BigLandianGoldCoin {
	public static Map<Long, Long> valuesProcessed = new HashMap<Long, Long>();
	public static void main(String args[] ) throws Exception {
        
        Scanner br = new Scanner(System.in);
        
        while(br.hasNext()){
            System.out.println(getMaxConversion(br.nextInt()));
        }
    }
    
    public static long getMaxConversion(long n){
    	if(n<12){
    		return n;
    	}else{
    		long c1 ,c2 ,c3;
    		
    		if(valuesProcessed.containsKey(n/2)){
    			c1 = valuesProcessed.get(n/2);
    		}else{
    			c1 = getMaxConversion(n/2);
    		}
    		
    		if(valuesProcessed.containsKey(n/3)){
    			c2 = valuesProcessed.get(n/3);
    		}else{
    			c2 = getMaxConversion(n/3);
    		}
    		
    		if(valuesProcessed.containsKey(n/4)){
    			c3 = valuesProcessed.get(n/4);
    		}else{
    			c3 = getMaxConversion(n/4);
    		}
    		
    		long answer = c1+c2+c3>n?c1+c2+c3:n;
			valuesProcessed.put(n, answer);

			System.out.println(n+" -> "+c1+":"+c2+":"+c3+" = "+answer);
    		
    		return answer;
    	}
    }
}
