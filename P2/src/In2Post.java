import java.util.ArrayList;
import java.util.Scanner;

public class In2Post {
	// Use expQueu to create the postfix expression
	// enqueue at the end of the queue
	// dequeue at the front of the queue
	private Queue expQueue;

	// opStack maintains operators
	private Stack opStack;

	// tokIt gets the input line in the constructor and scans it for tokens
	private TokenIter tokIt;
	
	// when scanning a next Token using tokIt, put it in nextToken
	private String nextToken;
	
	public In2Post(String line, boolean debug){
		tokIt = new TokenIter(line);
		opStack  = new Stack(debug);
		expQueue = new Queue(debug);
	}

	// Convert Infix to Postfix using expQueue and opStack
	// tokIt iteratively produces the tokens of the infix expression
	// return a String containing the Postfix expression
	public String convertIn2Post() throws StackException, QueueException{
		return "";
	}
	
	public static void main(String[] args) throws StackException, QueueException{
		// exercise with increasingly complex expressions
		boolean db = false;
		In2Post ex1 = new In2Post("1", db);
		System.out.println(ex1.convertIn2Post());
		In2Post ex2 = new In2Post("1+2", db);
		System.out.println(ex2.convertIn2Post());

	}
}
