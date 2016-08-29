
public class Stack implements StackIF{
    //stackLL holds the stack elements 
	private LinkedList stackLL;
	
    //debug controls showing of progress
	private boolean debug;	
	
	//constructor: create empty Stack implemented with a linked list
	public Stack(boolean debug){
		stackLL = new LinkedList();
		this.debug = debug;
	}
	
	@Override
	// add new item to top of stack
	public void push(Object item) {
		// TODO Auto-generated method stub
		stackLL.add(0,item);
		if(debug)System.out.println("push: " + item);
	}

	@Override
	// remove and return item from top of stack
	// throw Stack Exception when stack empty
	public Object pop() throws StackException {
		Object item = null;
		if (stackLL.isEmpty()) throw new StackException("popping while stack empty!");
		else{
			item = stackLL.remove(0);
		}
		if(debug)System.out.println("pop: " + item);
		return item;
	}

	@Override
	// return, but do not remove, item from top of stack
	// throw Stack Exception when stack empty
	public Object peek() throws StackException {
		Object item = null;
		if (stackLL.isEmpty()) throw new StackException("peeking while stack empty!");
		else{
			item = stackLL.get(0);
		}
		if(debug)System.out.println("peek: " + item);
		return item;
	}

	@Override
	// return true if stack empty, false otherwise
	public boolean isEmpty() {
		return stackLL.isEmpty();
	}

	public static void main(String[] args) throws StackException{
		// use Stack to evaluate postfix expression "23 34 -"

		boolean	debug=false;
		
        if(args.length > 0)
             debug = true;
        
		Stack intStack = new Stack(debug);
		
		System.out.println("evaluate postfix expression:   23 34 10 - *");

        // encounter 23: push
		intStack.push(new Integer(23));	
        // encounter 34: push
		intStack.push(new Integer(34));
        // encounter 10: push
		intStack.push(new Integer(10));
		// encounter -: pop; pop; eval; push
		Integer right = 0;
		Integer left = 0;
		Object o;
		o = intStack.pop();
		if(o instanceof Integer)
			right = (Integer)o;
		o = intStack.pop();
		if(o instanceof Integer)
			left = (Integer)o;
		Integer res = left - right;
		intStack.push(res);		
	
		// encounter *: pop; pop; eval; push
		o = intStack.pop();
		if(o instanceof Integer)
    		right = (Integer)o;
		o = intStack.pop();
		if(o instanceof Integer)
    		left = (Integer)o;
		res = left * right;
		intStack.push(res);	
		
		System.out.println("result: " + intStack.pop());	
		System.out.println("intStack isEmpty: " + intStack.isEmpty());
		
		//wait for it...
		//System.out.println("pop...");
		//Integer kaboom = (Integer)intStack.pop();
	}

}
