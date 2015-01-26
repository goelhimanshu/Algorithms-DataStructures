import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class DashesCountInString {
	public static Map<Character, Integer> CharacterDashCount = new HashMap<Character, Integer>();
	
	static{
		CharacterDashCount.put('0', 6);
		CharacterDashCount.put('1', 2);
		CharacterDashCount.put('2', 5);
		CharacterDashCount.put('3', 5);
		CharacterDashCount.put('4', 4);
		CharacterDashCount.put('5', 5);
		CharacterDashCount.put('6', 6);
		CharacterDashCount.put('7', 3);
		CharacterDashCount.put('8', 7);
		CharacterDashCount.put('9', 6);
	}
	public static void main(String args[] ) throws Exception {
        
        Scanner br = new Scanner(System.in);
        
        while(br.hasNext()){
            System.out.println(getDashCount(br.nextLine()));
        }
    }
	
	public static int getDashCount(String str){
		int count =0;
		for(int i=0; i<str.length(); i++){
			count += CharacterDashCount.get(str.charAt(i));
		}
		return count ;
	}
}
