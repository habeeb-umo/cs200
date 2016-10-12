
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

	// expr = number ( "+" number )*
	// Notice that we only parse sums of terms, 
	// not differences
	private TreeNode expr(String indent) throws ParseException{
		if(debug)
			System.out.println(indent+"expr");

		TreeNode left = number(indent+" ");
		while(nextToken != null && nextToken.equals("+") ){
			String op = nextToken;
			nextTok(indent+" ");
			TreeNode right = number(indent+" ");
			left = new TreeNode(op,left, right);
		}
		return left;
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
