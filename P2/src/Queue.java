import java.util.ArrayList;


public class Queue implements QueueIF {

	// maintains expression
	private ArrayList<String> expQueue;
	
	// debug controls debug reporting
	private boolean debug;
	
	// constructor
	public Queue(boolean debug){
		expQueue = new ArrayList<String>();
		this.debug = debug;
	}
	
    public static void main(String[] args) throws QueueException{
    	Queue q = new Queue(false);
    	q.dequeue();
    }

	@Override
	public void enqueue(String token) {
		// TODO Auto-generated method stub
		expQueue.add(token);
	}

	@Override
	public String dequeue() throws QueueException {
		
		// TODO Auto-generated method stub
		if(expQueue.isEmpty()){
			throw new QueueException("Queue is empty");
		}
		String yank = expQueue.get(0);
		expQueue.remove(0);
		return yank;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return expQueue.size();
	}
}
