// Palindrome.java
// Class: cs200

public class Palindrome {
	
	Stack stack = new Stack();

//	private void generatePalindromeRecursive(String s,int index)
//	{
//		// first print the character, then recurse on the next character index
//		System.out.print(s.charAt(index));
//		if(index<s.length()-1)
//		{
//			// question: will index++ or ++index work on the method call below?
//			generatePalindromeRecursive(s,index+1);
//		}
//		System.out.print(s.charAt(index));
//		
//	}
	public Stack stringToStack(String s){
		for(int i = 0; i < s.length(); i++){
		stack.push(s.charAt(i));
		}
		return stack;
		
	}
	public void generatePalindrome(String s) {
		// generate palindrome by concatenating the reverse of s to s
		//generatePalindromeRecursive(s,0);
		stringToStack(s);
		String popString = "";
		while(!stack.isEmpty()){
			popString += stack.pop();
		}
		String f = s + popString;
		System.out.println(f);
	}
	
	public static void main(String[] args) {
	    Palindrome p = new Palindrome();
		p.generatePalindrome("ab");

	}

	

}
