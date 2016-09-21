import java.util.ArrayList;

public class Stack implements StackIF {

	// Use opStack to push and pop operators
	private ArrayList<String> opStack;
	
	// debug controls debug reporting 
    private boolean debug;
    
    public Stack(boolean debug){
    }


    public static void main(String[] args) throws StackException{
    	Stack s = new Stack(false);
    	s.pop();
    }
}
