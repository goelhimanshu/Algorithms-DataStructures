import java.util.HashMap;
import java.util.Scanner;



public class RSum {

	private Long lowerLimit;
	
	private Long upperLimit;
	
	private static final HashMap<Long, Long> calculatedFactorialSum = new HashMap<Long, Long>();
	
	private static final HashMap<Long, Long> calculatedRSum = new HashMap<Long, Long>();

	public RSum(){}
	
	public RSum(Long lowerLimit, Long upperLimit){
		this();
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
	}
	
	public static void main(String[] args) {

		Scanner br = new Scanner(System.in);
		RSum obj = null;
		int testCasesCount = br.nextInt();
		
		while(testCasesCount>0){
			
			obj = new RSum(br.nextLong(), br.nextLong());
			System.out.println(obj.getSum());
			
			testCasesCount--;
		}
	}
	
	public Long getSum(){
		Long sum =0L;

		for(Long i=lowerLimit; i<=upperLimit; i++){
			Long factorialSum = getFactorialRsum(i);
			if(factorialSum == 9){
				sum += 9*(upperLimit - i +1);
				return sum;
			}
			sum +=  factorialSum;
		}
		
		return sum;
	}
	
	public Long getFactorialRsum(Long num){
		if(num == 0){
			return 0L;
		}else if(num == 1){
			return 1L;
		}
		
		if(calculatedFactorialSum.containsKey(num))
			return calculatedFactorialSum.get(num);
		
		Long result = getRSum(num*getFactorialRsum(num-1));
		calculatedFactorialSum.put(num, result);
		
		return result;
	}
	
	public Long getRSum(Long num){
		if(num<10)
			return num;
		
		if(calculatedRSum.containsKey(num))
			return calculatedRSum.get(num);
		
		Long result = getRSum(num%10 + num/10);
		calculatedRSum.put(num, result);
		
		return result;
	}
	
}
