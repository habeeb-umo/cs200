import java.util.ArrayList;

public class Stack implements StackIF{

	private ArrayList<Object> theStack;
	
	public Stack(){
		// initialize theStack
		theStack = new ArrayList<Object>();
	}
	
	@Override
	/*
	 * push op on Run Time Stack at end of theStack
	 */
	public void push(Object op) {
		// TODO Auto-generated method stub
		theStack.add(op);
		//System.out.println(theStack.toString());
	}

	@Override
	/*
	 * pop and return top Object from Run Time Stack
	 * If Stack empty, throw StackException("Popping from empty stack!");
	 */
	public Object pop() throws StackException {
		// TODO Auto-generated method stub
		Object popped = null;
		if(theStack.size() >= 1){
			// Get topmost object on stack
			popped = theStack.get(theStack.size()-1);
			// Remove topmost object on stack
			theStack.remove(theStack.size()-1);
		}
		return popped;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub\
		if(theStack.size() <= 0){
		return true;
		}
		else return false;
	}
	
	// return the String representation of theStack
	public String toString(){
		return theStack.toString();
	}
	
	public static void main(String[] args) throws StackException{
       Stack st = new Stack();
       st.push(new Frame(1,3,1,3));
       st.push(new Frame(0,2,1,2));
       System.out.println("st: " + st);
       st.pop();
       System.out.println("st: " + st);
       st.pop();
       System.out.println("st: " + st);
	}
       
}
