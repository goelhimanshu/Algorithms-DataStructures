import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class FiniteAutomataStringMatching {
	
	public List<HashMap<Character, Integer>> transitionFunction(String pattern, Set<Character> alphabets) {
		int m = pattern.length();
		List<HashMap<Character, Integer>> transFunc = new ArrayList<HashMap<Character,Integer>>();
		
		String processedPattern = "";
		
		for(int i=0; i<m+1; i++){
			HashMap<Character, Integer> transFuncValues = new HashMap<Character, Integer>();
			processedPattern = pattern.substring(0, i);

			for(Character alphabet : alphabets){
				String tmpPattern = processedPattern.concat(alphabet.toString());
				
				while(tmpPattern.length()>0 && !pattern.startsWith(tmpPattern)){
					tmpPattern = tmpPattern.substring(1);
				}
				
				if(pattern.startsWith(tmpPattern)){
					transFuncValues.put(alphabet, tmpPattern.length());
				}
			}
			
			transFunc.add(transFuncValues);
		}
		
		return transFunc;
	}
	
	public Set<Character> getAlphabets(String str){
		
		Set<Character> alphabets = new HashSet<Character>();
		for(Character c : str.toCharArray()){
			alphabets.add(c);
		}
		
		return alphabets;
	}
	
	public void stringMatch(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();
		Set<Character> alphabets = getAlphabets(text);
		
		List<HashMap<Character, Integer>> transFunc = transitionFunction(pattern, alphabets);
		
		int currentState = 0;
		
		for (int i = 0; i < n; i++) {
			Integer nextState = transFunc.get(currentState).get(text.charAt(i));

			if(nextState==m){
				System.out.println("Pattern Found at "+(i-m+1));
			}
			
			currentState=nextState;
		}
	}
	
	public static void main(String[] args) {
		String T = "HimanshuGoelIsWorkingInMinjarHimanshuGoelIsReadingAlgoDSUditBhatiaIsAccompanyingHim";
		String P = "HimanshuGoel";
		
		FiniteAutomataStringMatching obj = new FiniteAutomataStringMatching();
		obj.stringMatch(T, P);
	}

}
