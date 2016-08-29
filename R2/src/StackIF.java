
public interface StackIF {
	// add new item to top of stack
	public void push(Object item);
	
	// remove and return item from top of stack
	// throw Stack Exception when stack empty
	public Object pop() throws StackException;
	
	// return, but do not remove, item from top of stack
	// throw Stack Exception when stack empty
	public Object peek() throws StackException;	
	
	// return true if stack empty, false otherwise
	public boolean isEmpty();

}
