
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;


public class TokenIter implements Iterator<String>{

	//input line to be tokenized
	private String line;

	// the next Token, null if no next Token
	private String nextToken;

	String[] tokens;
	int count = 0;
	
	public TokenIter(String line){
		this.line = line;
		//this.line = line;
		
	}


	@Override
	public void remove() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	
	
	
	public static void main(String[] args){
		String line;
		if(args.length>0){
			line = args[0];
		}
		else
		   line = "   15 *(26+37)-489/5*61-(723-8456789)  ";
		System.out.println("line: [" + line + "]");
		TokenIter tokIt = new TokenIter(line);
		while(tokIt.hasNext()){
			System.out.println("next token: [" + tokIt.next() + "]");
		}
	}

	
	
	@Override
	public boolean hasNext() {
	
		line = line.trim();
		line = line.replaceAll("\\s","");
		tokens = line.split("(?<=[-()+*/])|(?=[-()+*/])");
	
		if(count < tokens.length)
			return true;
		
		return false;
	}
		
	
	


	@Override
	public String next() {
		line = line.trim();
		line = line.replaceAll("\\s","");
		tokens = line.split("(?<=[-()+*/])|(?=[-()+*/])");
		if(count < tokens.length){
		this.nextToken = tokens[count];
		count = count + 1;
		}
		
		return nextToken;
	}

}
