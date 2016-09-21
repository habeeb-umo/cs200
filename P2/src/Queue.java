import java.util.ArrayList;


public class Queue implements QueueIF {

	// maintains expression
	private ArrayList<String> expQueue;
	
	// debug controls debug reporting
	private boolean debug;
	
	// constructor
	public Queue(boolean debug){
	}
	
    public static void main(String[] args) throws QueueException{
    	Queue q = new Queue(false);
    	q.dequeue();
    }
}
