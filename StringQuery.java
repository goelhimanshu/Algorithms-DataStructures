import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class StringQuery {
	
	public static Map<Character, ArrayList<Integer>> charOccurances;
	public static ArrayList<Character> strCharArray;
	static {
		strCharArray = new ArrayList<Character>();
		charOccurances = new HashMap<Character, ArrayList<Integer>>();
	}
	
	public static void main(String args[] ) throws Exception {
        
        Scanner br = new Scanner(System.in);
        
        String str = br.nextLine();
        processStringOccurances(str);
        
        int testQueryCount = br.nextInt();
        
        for(int i=0; i<testQueryCount; i++){
        	
        	int occurance = br.nextInt();
        	Character queryChar = br.next().charAt(0);
        	
        	removeChar(queryChar, occurance);
        }
        
        printArrayToString();
    }
	
	public static void processStringOccurances(String str){
		for(int i=0; i<str.length(); i++){
			Character strChar = str.charAt(i);
			if(charOccurances.containsKey(strChar)){
				charOccurances.get(strChar).add(i);
			}else{
				charOccurances.put(strChar, new ArrayList<Integer>());
				charOccurances.get(strChar).add(i);
			}
			strCharArray.add(strChar);
		}
	}
	
	public static void removeChar(Character queryChar, int occurance){
		ArrayList<Integer> charOccuranceList = charOccurances.get(queryChar);
		int occuranceIndex = charOccuranceList.get(occurance-1);
		charOccuranceList.remove(occurance-1);
		if(occuranceIndex<strCharArray.size()){
			strCharArray.set(occuranceIndex, '0');
		}
	}
	
	public static void printArrayToString(){
		StringBuilder result = new StringBuilder();
		for(int i=0; i<strCharArray.size(); i++){
			if(strCharArray.get(i)!='0'){
				result.append(strCharArray.get(i));
			}
		}
		System.out.println(result.toString());
	}
}
