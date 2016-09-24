import java.util.ArrayList;

public class Stack implements StackIF {

	// Use opStack to push and pop operators
	private ArrayList<String> opStack;
	
	// debug controls debug reporting 
    private boolean debug;
    
    public Stack(boolean debug){
    	opStack = new ArrayList<String>();
    	this.debug = debug;
    }


    public static void main(String[] args) throws StackException{
    	Stack s = new Stack(false);
    	//s.pop();
    }


	@Override
	public void push(String op) {
		// TODO Auto-generated method stub
		opStack.add(op);
	}


	@Override
	public String pop() throws StackException {
		// TODO Auto-generated method stub
		
		if(opStack.isEmpty()){
			throw new StackException("Stack is empty");
		}
		String popped = null;
		if(opStack.size() >= 1){
			// Get topmost object on stack
			popped = opStack.get(opStack.size() - 1);
			// Remove topmost object on stack
			opStack.remove(opStack.size() - 1);
		}
		return popped;
	}


	@Override
	public String peek() throws StackException {
		// TODO Auto-generated method stub
		String s = "";
		if(opStack.isEmpty()){
		
		}
		else
			s = opStack.get(opStack.size() - 1);
		return s;
	}


	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(opStack.size() <= 0){
			return true;
		}
		return false;
	}
}
