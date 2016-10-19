
public class BST{
	// this Binary Search Tree is used for the implementation of the 
	// Symbol Table containing Symbols: (id,value) pairs
	// A Symbol is a Comparable object containing a String Identifier  
	// and a Boolean value 
	private BSTNode<IdVal> root;


	//empty tree
	public BST(){
		this.root = null;
	}

	public boolean isEmpty(){
		return root==null;
	}

	public void insertItem(IdVal item) throws BSTException{
		root = insertItem(root, item);
	}

	private BSTNode<IdVal> insertItem(BSTNode<IdVal> node, IdVal item) throws BSTException{
		BSTNode<IdVal> newSubTree;
		if(node==null){
			newSubTree = new BSTNode<IdVal>(item);
			return newSubTree;
		}
		
		IdVal tok = node.getItem();
		if(item.getKey().compareTo(tok.getKey())<0){
			newSubTree = insertItem(node.getLeft(), item);
			node.setLeft(newSubTree);
			return node;
		}
		if(item.getKey().compareTo(tok.getKey())>0){
			newSubTree = insertItem(node.getRight(), item);
			node.setRight(newSubTree);
			return node;
		}
		// ERROR: inserting existing item
		else 
			throw new BSTException("Inserting item with existing key!");
	}

	public IdVal retrieveItem(String key){
		return retrieveItem(root,key);
	}
	
	private IdVal retrieveItem(BSTNode<IdVal> node, String key){
		IdVal treeItem;
		
		if(node==null)
			treeItem = null;
		else{
			IdVal nodeItem = node.getItem();
			if(key.compareTo(nodeItem.getKey()) == 0)
				//found
				treeItem = nodeItem;
			else if(key.compareTo(nodeItem.getKey()) < 0)
				//search left
				treeItem = retrieveItem(node.getLeft(), key);
			else
				// search right
				treeItem = retrieveItem(node.getRight(), key);
		}
		return treeItem;

	}
	
	private BSTNode<IdVal> deleteNode(BSTNode<IdVal> node) throws BSTException{
		if(node.getLeft() == null){
			node = node.getRight();
		}
		else if(node.getRight() == null){
			node = node.getLeft();
		}
		else{
			BSTNode<IdVal> temp = node.getLeft();
			while(temp.getRight() != null){
				temp = temp.getRight();
			}
			node.setItem(temp.getItem());
			node.setLeft(deleteItem(node.getLeft(), temp.getItem()));
		}
		return node;
	}

	private BSTNode<IdVal> deleteItem(BSTNode<IdVal> node, IdVal item) throws BSTException {
		BSTNode<IdVal> newSubTree;
		if(node == null){
			throw new BSTException("No item to delete");
		}
		IdVal tok = node.getItem();
		int c = item.getKey().compareTo(tok.getKey());
		if(c == 0){
			return deleteNode(node);
		}
		if(c < 0){
			newSubTree = deleteItem(node.getLeft(), item);
			node.setLeft(newSubTree);
			return node;
		}
		if(c > 0){
			newSubTree = deleteItem(node.getRight(), item);
			node.setRight(newSubTree);
			return node;
		}
		else throw new BSTException("Inserting item with existing key");
	
		
	}
	
	
	
	

	public void preorderTraverse(){
		if (!isEmpty())
			preorderTraverse(root,"");
		else
			System.out.println("root is null");
	}

	public void preorderTraverse(BSTNode<IdVal> node, String indent){
		System.out.println(indent+node.getItem());		
		if(node.getLeft()!=null) {
			System.out.println(indent+"left");
			preorderTraverse(node.getLeft(),indent+" ");
		}

		if(node.getRight()!=null) {
			System.out.println(indent+"right");
			preorderTraverse(node.getRight(),indent+" ");
		}
	}

}
