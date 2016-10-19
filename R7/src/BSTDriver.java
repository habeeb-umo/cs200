
public class BSTDriver {

	public static void main(String[] args) throws BSTException{
		BST st = new BST();
		IdVal m = new IdVal("moo",5);
		st.insertItem(m);
		IdVal h = new IdVal("hi",13);
		st.insertItem(h);
		IdVal r = new IdVal("rara",57);
		st.insertItem(r);
		IdVal a = new IdVal("aaarch",11);
		st.insertItem(a);
		IdVal c = new IdVal("caramba",-4);
		st.insertItem(c);
		
		st.preorderTraverse();
		
		IdVal av = st.retrieveItem("aaarch");
		System.out.println("retrieving item with key aaarch: " + av);
		
		IdVal mv = st.retrieveItem("moo");
		System.out.println("retrieving item with key moo: " + mv);		
	
		IdVal zv = st.retrieveItem("non existing item z");
		System.out.println("retrieving z: " + zv);
		
		// testing BST Exception
		IdVal m2 = new IdVal("moo", 17);
		st.insertItem(m2);
	}
}
