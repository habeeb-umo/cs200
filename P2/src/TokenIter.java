
import java.util.Iterator;


public class TokenIter implements Iterator<String>{

	//input line to be tokenized
	private String line;

	// the next Token, null if no next Token
	private String nextToken;

	public TokenIter(String line){
		this.line = line;
	}


	@Override
	public void remove() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	
	public static void main(String[] args){
		String line;
		if(args.length>0)
			line = args[0];
		else
		    line = "   15*(26+37)-489/5*61-(723-8456789)  ";
		System.out.println("line: [" + line + "]");
		TokenIter tokIt = new TokenIter(line);
		while(tokIt.hasNext()){
			System.out.println("next token: [" + tokIt.next() + "]");
		}
	}

}
