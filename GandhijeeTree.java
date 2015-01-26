import java.util.Scanner;
import java.util.TreeMap;


public class GandhijeeTree {
	
	public static TreeMap<Character, Integer> personIds; 
	
	public static void main(String[] args){
		
		Scanner read = new Scanner(System.in);
		int testCasesCount = read.nextInt();
		
		for(int i =0; i< testCasesCount; i++){
			int desiredColumn = Integer.parseInt(read.next());
			String personDefination = read.next();
			
			Person person = new Person(personDefination);
			
			personIds = new TreeMap<Character, Integer>();
			getPersonAtColumn(person, 0, desiredColumn);
			
			if(personIds.size()>0){
				for(Character id : personIds.keySet()){
					for(int times=0; times<personIds.get(id); times++){
						System.out.print(id);
					}
				}
				System.out.println();
			}else{
				System.out.println("Common Gandhijee!");
			}
		}
	}
	
	public static void getPersonAtColumn(Person node, int currentColumnCount, int requiredColumnCount){
		if(node!=null){
			if(currentColumnCount==requiredColumnCount && node.personId!=null){
				if(personIds.containsKey(node.personId)){
					personIds.put(node.personId, personIds.get(node.personId)+1);
				}else{
					personIds.put(node.personId, 1);
				}
			}
			getPersonAtColumn(node.leftPerson, currentColumnCount-1, requiredColumnCount);
			getPersonAtColumn(node.rightPerson, currentColumnCount+1, requiredColumnCount);
		}
	}

}

class Person{
	public Character personId;
	public Person leftPerson;
	public Person rightPerson;
	
	Person(String personChainDefination){
		super();
		this.personId = null;
		this.leftPerson = null;
		this.rightPerson = null;
		
		if(personChainDefination==null || personChainDefination.length()<=0 || personChainDefination.equals(".")){
			//nothing to do here
		}else{
			this.personId = personChainDefination.charAt(0);
			
			if(personChainDefination.length()>1 && personChainDefination.charAt(1)=='('){
				int paranthesisStatus = 1;
				int startIndex = 2;
				int endIndex = 3;
				if(personChainDefination.charAt(startIndex)=='.'){
					endIndex--;
				}else{
					while(paranthesisStatus>0 && endIndex<personChainDefination.length()){
						endIndex++;
						if(personChainDefination.charAt(endIndex)=='('){
							paranthesisStatus++;
						}else if(personChainDefination.charAt(endIndex)==')'){
							paranthesisStatus--;
						}
					}
				}
				
				if(endIndex>=startIndex){
					this.leftPerson = new Person(personChainDefination.substring(startIndex, endIndex+1));
					this.rightPerson = new Person(personChainDefination.substring(endIndex+1, personChainDefination.length()-1));
				}
			}
		}
	}
}
