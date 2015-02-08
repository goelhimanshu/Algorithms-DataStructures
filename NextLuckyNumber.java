import java.util.Scanner;



public class NextLuckyNumber {

	public static String getLuckyNumber(String number){
		StringBuilder luckyNumber=new StringBuilder();
		int length = number.length();
		int index =0;
		
		Boolean is3 = false;
		while(index<number.length() && !is3){
			int digit = Integer.parseInt(String.valueOf(number.charAt(index)));
			if(index==0 && digit>5){
				luckyNumber.append(3);
				luckyNumber.append(3);
				is3 = true;
			}else if(digit<3){
				luckyNumber.append(3);
				is3 = true;
			}else if(digit>5){
				luckyNumber = trailing3(luckyNumber);
				luckyNumber.append(3);
				is3 = true;
			}else if(digit>3 && digit<5){
				luckyNumber.append(5);
				is3 = true;
			}else{
				luckyNumber.append(digit);
			}
			index++;
		}
		
		if(is3){
			for(int i=index; i<length; i++){
				luckyNumber.append(3);
			}
		}
		
		String luckyNum = luckyNumber.toString();
		if(number.equals(luckyNum)){
			luckyNumber = trailing3(luckyNumber);
		}
		
		return luckyNumber.toString();
	}
	
	public static StringBuilder trailing3(StringBuilder luckyNumber){
		
			String luckyNum = luckyNumber.toString();
			int length = luckyNumber.length();
			int lastDigit = Integer.parseInt(String.valueOf(luckyNum.charAt(length-1)));
			int firstOccuranceOf3FromRight = -1;
			
			int index = length-1;
			while(firstOccuranceOf3FromRight==-1 && index>=0){
				
				int digit = Integer.parseInt(String.valueOf(luckyNum.charAt(index)));
				if(digit==3)
					firstOccuranceOf3FromRight = index;
				
				index--;
			}
			
			
			if(firstOccuranceOf3FromRight==-1){

				luckyNumber = new StringBuilder();

				for(int i=0; i<=length; i++){
					luckyNumber.append(3);
				}
			}else{
				
				luckyNumber.delete(firstOccuranceOf3FromRight, length);
				luckyNumber.append(5);
				
				for(int i=firstOccuranceOf3FromRight+1; i<length; i++){
					luckyNumber.append(3);
				}
				
			}
		
		return luckyNumber;
	}

	public static void main(String[] args) {
		Scanner br = new Scanner(System.in);
		int testCasesCount = br.nextInt();
		
		while(testCasesCount>0){
			String number = br.next();
			System.out.println(getLuckyNumber(number));
			testCasesCount--;
		}
	}
	
}
