import java.util.Scanner;


public class NumberPower {

	public int costOfConversion(long currentNumber, long postConversionNumber){
		int cost=0;
		while(currentNumber>0 && postConversionNumber>0){
			int unitDigitDifference = (int) (currentNumber%10 - postConversionNumber%10);
			if(unitDigitDifference<0){
				unitDigitDifference *= -1;
			}
			cost+=unitDigitDifference;
			currentNumber /= 10;
			postConversionNumber/= 10;
		}
		return cost;
	}
	
	public long getMinPossibleNumber(long currentNumber, int budget){
		long minPossibleNumber = currentNumber;
		
		int[] numberArray = numberToArray(currentNumber);
		int msbDigitIndex = numberArray.length-1;
		
		while(msbDigitIndex>=0 && budget>0){
			if(msbDigitIndex == numberArray.length-1){
				if(numberArray[msbDigitIndex]-1 > budget){
					numberArray[msbDigitIndex] = numberArray[msbDigitIndex]-budget; 
					budget=0;
				}else{
					budget -= (numberArray[msbDigitIndex]-1);
					numberArray[msbDigitIndex] = 1;
					
				}
			}else{
				if(numberArray[msbDigitIndex] > budget){
					numberArray[msbDigitIndex] = numberArray[msbDigitIndex]-budget; 
					budget=0;
				}else{
					budget -= numberArray[msbDigitIndex];
					numberArray[msbDigitIndex] = 0;
				}
			}
			msbDigitIndex--;
		}
		
		minPossibleNumber = arrayToNumber(numberArray);
		
		return minPossibleNumber;
	}
	
	public long getMaxPossibleNumber(long currentNumber, int budget){
		long maxPossibleNumber = currentNumber;
		
		int[] numberArray = numberToArray(currentNumber);
		int msbDigitIndex = numberArray.length-1;
		
		while(msbDigitIndex>=0 && budget>0){
			if( (9-numberArray[msbDigitIndex]) < budget){
				budget -= (9-numberArray[msbDigitIndex]);
				numberArray[msbDigitIndex] = 9; 
			}else{
				numberArray[msbDigitIndex] += budget;
				budget =0;
			}
			msbDigitIndex--;
		}
		
		maxPossibleNumber = arrayToNumber(numberArray);
		
		return maxPossibleNumber;
	}
	
	public long arrayToNumber(int[] numberArray){
		long number=0;
		
		for(int i=numberArray.length-1; i>=0; i--){
			number = number*10 +numberArray[i];
		}
		
		return number;
	}
	
	public boolean isMultipleOfThree(long number){
		return number%3==0?true:false;
	}
	
	public int getCountOfConversionsInBudget(long currentNumber, int budget){
		int conversionCount = 0;
		
		long minNumber = getMinPossibleNumber(currentNumber, budget);
		long maxNumber = getMaxPossibleNumber(currentNumber, budget);
		long iteratingNumber = minNumber;
		
		if(iteratingNumber%3!=0){
			iteratingNumber += 3- (iteratingNumber%3);
		}
		
		while(iteratingNumber<=maxNumber){
			if(costOfConversion(currentNumber, iteratingNumber) <= budget){
				conversionCount++;
				//System.out.println(iteratingNumber+" ");
			}
			iteratingNumber +=3;
		}
		
		return conversionCount;
	}
	
	public int[] numberToArray(long number){
		int[] numberArray = new int[18];
		int digitCount = 0;
		
		int i=0;
		while(number>0){
			numberArray[i]=(int) (number%10);
			i++;
			digitCount++;
			number /=10;
		}
		
		int[] finalArray = new int[digitCount];
		for(i=digitCount; i>0; i--){
			finalArray[i-1] = numberArray[i-1];
		}
		
		return finalArray;
	}
	
	public static void main(String[] args) {
		
        Scanner br = new Scanner(System.in);
        long currentNumber = br.nextLong();
        int budget = br.nextInt();

		NumberPower obj = new NumberPower();
		long startTime = System.currentTimeMillis();
		
		System.out.println("Possible Conversions"+obj.getCountOfConversionsInBudget(currentNumber,budget));
		System.out.println("Time Taken : "+(System.currentTimeMillis()-startTime));
	}
}
