import java.util.Iterator;
import java.util.Scanner;
public class TokenIter implements Iterator<String>{
	Iterator<String> inner_iter;
	
	public TokenIter(String line){
		inner_iter = new Scanner(line.replaceAll("[+*-/()]"," $0 "));
	}
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return inner_iter.hasNext();
	}
	@Override
	public String next() {
		// TODO Auto-generated method stub
		return inner_iter.next();
	}

}
