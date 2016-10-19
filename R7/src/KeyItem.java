// A generic class, with a Comparable parameter type 
public abstract class KeyItem<KT extends Comparable<KT>> {
	private KT key;
	
	public KeyItem(KT key){
		this.key = key;
	}

	public KT getKey(){
		return key;
	}
	
}
