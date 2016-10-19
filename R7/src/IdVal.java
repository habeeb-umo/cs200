// IdVal is a String KeyItem 
// Strings are Comparable
public class IdVal extends KeyItem<String> {
	
	private Integer val;
	
	public IdVal(String id, Integer val){
		super(id);
		this.val = val;
	}

	public String toString(){
		return "[" + getKey() + ": " + val+ "]"; 
	}
	
	public static void main(String[] args){
		IdVal iv1 = new IdVal("abc", 123);
		IdVal iv2 = new IdVal("bcd", 234);
		IdVal iv3 = new IdVal("cde", 345);	
		if(iv1.getKey().compareTo(iv2.getKey())<0)
			System.out.println(iv1 + " < " + iv2);
	}
}
