
public class ParseTreeExpr {

	private boolean debug;

	private String nextToken;	
	private TokenIter itTokens;

	public ParseTreeExpr(TokenIter iter, boolean debug){
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

	
	public Tree line() throws ParseException{
		TreeNode root;
		Tree tree = new Tree();
		if(nextToken!=null){
			root = expr("");
			tree = new Tree(root);
		}
		if(nextToken!=null)
			error("end of line expected");
		return tree;
	}

	// expr = term ( "+"|"-" term )*
	// Notice that we only parse sums of terms, 
	// not differences
	private TreeNode expr(String indent) throws ParseException{
		if(debug)
			System.out.println(indent+"expr");
		
		
		TreeNode left = term(indent+" ");
		while(nextToken != null && (nextToken.equals("+") || nextToken.equals("-")) ){
			String op = nextToken;
			nextTok(indent+" ");
			TreeNode right = term(indent+" ");
			left = new TreeNode(op,left, right);
		}
		return left;
	}
	
	// term = factor ( "*"|"/" factor )*
	
	private TreeNode term(String indent) throws ParseException{
		if(debug)
			System.out.println(indent+"term");
		TreeNode left = factor(indent+" ");
		while(nextToken != null && (nextToken.equals("*") || (nextToken.equals("/")))){
				String op = nextToken;
				nextTok(indent+" ");
				TreeNode right = factor(indent+" ");	
				left = new TreeNode(op, left, right);
		}
		return left;
	}
	
	private TreeNode factor(String indent) throws ParseException{
		if(debug)
			System.out.println(indent + "number");
		if(Character.isDigit(nextToken.charAt(0))){
			String num = nextToken;
			nextTok(indent);
			return new TreeNode(num);
		}
		else {
			error("number expected");
			return null; // for java type checker
		}
	}

	private TreeNode number(String indent) throws ParseException{
		if(debug)
			System.out.println(indent + "number");
		if(Character.isDigit(nextToken.charAt(0))){
			String num = nextToken;
			nextTok(indent);
			return new TreeNode(num);
		}
		else {
			error("number expected");
			return null; // for java type checker
		}
	}
}
