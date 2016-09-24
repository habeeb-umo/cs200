import java.util.ArrayList;
import java.util.Arrays;
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

	public boolean isInteger( String input ) {
		try {
			Integer.parseInt( input );
			return true;
		}
		catch( Exception e ) {
			return false;
		}
	}

	// Convert Infix to Postfix using expQueue and opStack
	// tokIt iteratively produces the tokens of the infix expression
	// return a String containing the Postfix expression
	public String convertIn2Post() throws StackException, QueueException{
		
		while(tokIt.hasNext()){
			nextToken = tokIt.next();
			if(isInteger(nextToken)){
				expQueue.enqueue(nextToken);
			}
			else if(nextToken.equals("(")){
				opStack.push(nextToken);
			}
			else if(nextToken.equals(")")){
				while(!(opStack.peek().equals("("))){
					expQueue.enqueue(opStack.pop());
				}
				opStack.pop();
			}
			else{
				if(opStack.isEmpty() || opStack.peek().equals("(")){
					opStack.push(nextToken);
				}
				else{
					while(isGreaterOrEqual(opStack.peek() , nextToken) && (!opStack.peek().equals("(") && !(opStack.isEmpty()))){
						expQueue.enqueue(opStack.pop());
					}
					opStack.push(nextToken);
				}
			}
		}
			while(!(opStack.isEmpty())){
				expQueue.enqueue(opStack.pop());
			}

			String s = "";
			while(expQueue.size() != 0){
				s += expQueue.dequeue();
				s += " ";
			}
			return s;
		
		
	}
		
		boolean isGreaterOrEqual(String fromStack, String nextToken){
			int from = 0;
			int next = 0;
			
			if(fromStack.equals("+") || fromStack.equals("-")){
				from = 0;
			}
			if(fromStack.equals("*") || fromStack.equals("/")){
				from = 1;
			}
			if(nextToken.equals("+") || nextToken.equals("-")){
				next = 0;
			}
			if(nextToken.equals("*") || nextToken.equals("/")){
				next = 1;
			}
			
			if(from >= next){
				return true;
			}
			else 
				return false;
			
		}

		public static void main(String[] args) throws StackException, QueueException{
			// exercise with increasingly complex expressions
			boolean db = false;
			In2Post ex1 = new In2Post("1", db);
			System.out.println(ex1.convertIn2Post());
			In2Post ex2 = new In2Post("1+2+3", db);
			System.out.println(ex2.convertIn2Post());

		}
	}
