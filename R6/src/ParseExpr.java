public class ParseExpr {

	private boolean debug;

	private String nextToken;	
	private TokenIter itTokens;

	public ParseExpr(TokenIter iter, boolean debug){
		itTokens = iter;
		this.debug = debug;
		nextTok("");
	}

	private void nextTok(String indent){
		if(itTokens.hasNext())
			nextToken = itTokens.next();
		else 
			nextToken = null;
		if(debug)
			System.out.println(indent+"next token: " + nextToken);
	}

	private void error(String errMess) throws ParseException{
		throw new ParseException(errMess);
	}

	// a line contains an expr or is empty
	
	public void line() throws ParseException{
		if(nextToken!=null)
     		expr("");
		if(nextToken!=null)
			error("end of line expected");
	}
	

	// expr = term ( "+"|"-" term )*
	// Notice that we only parse sums of numbers
	
	private void expr(String indent) throws ParseException{
		if(debug)
			System.out.println(indent+"expr");
		term(indent+" ");
		while(nextToken != null && (nextToken.equals("+") || nextToken.equals("-")) ){
				nextTok(indent+" ");
				term(indent+" ");	
		}
	}
	
	// term = factor ( "*"|"/" factor )*
	
	private void term(String indent) throws ParseException{
		if(debug)
			System.out.println(indent+"term");
		factor(indent+" ");
		while(nextToken != null && (nextToken.equals("*") || (nextToken.equals("/")))){
				nextTok(indent+" ");
				factor(indent+" ");	
		}
	}
	
	// factor = "-" factor | number | "(" expr ")"
	
	private void factor(String indent) throws ParseException{
		if(debug)
			System.out.println(indent + "factor");
		if(nextToken == null)
			error("factor expected");
		else if(nextToken.equals("-")){
			nextTok(indent+" ");
			factor(indent+" ");
		}
		else if(Character.isDigit(nextToken.charAt(0))){
			number(indent+" ");
		}
		else if(nextToken.contentEquals("(")){
			nextTok(indent+" ");
			expr(indent+" ");
			if(!nextToken.equals(")")){
				error(") expected");
			}
			else{
				nextTok(indent+" ");
			}
		}
		
		else 
			error("factor expected");	 
	}
	
	private void number(String indent) throws ParseException{
		if(debug)
			System.out.println(indent + "number");
		if(nextToken == null)
			error("number expected");
		else if(Character.isDigit(nextToken.charAt(0))){
			nextTok(indent);
		}
		else if(nextToken.equals("(")){
			nextTok(indent+" ");
			expr(indent+" ");
			if(nextToken.equals(")")){
				error(") expected");
			}
			else{
				nextTok(indent+" ");
			}
			
		}
		else 
			error("number expected");	 
	}
}
