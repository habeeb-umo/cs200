import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class ArrayHeapSort {

	private int[] A;

	public ArrayHeapSort(int[] A){
		this.A = A;
		buildHeap();
	}
	
	private int leftChild(int i){
		return 2*i+1;
		
	}
	
	private int rightChild(int i){
		return leftChild(i) + 1;
	}
	
	private int parent(int i){
		return (i - 1) / 2;
	}
	
	private static void swap(int[] A, int i, int j){
		int t = A[i];
		A[i] = A[j];
		A[j] = t;
	}
	private void heapify(int i, int size){
	// left and right subtrees are already heaps
	// need to bubble element i in place top down
		int l = leftChild(i);
		int r = rightChild(i);
		
		//max index has max child
		int max_index = i;
		
		if(l < size && A[max_index] < A[l]){
			max_index = l;
		}
		
		if(r < size && A[max_index] < A[r]){
			max_index = r;
		}
		
		//if one of the children is larger than parent, swap. otherwise, stop.
		if(max_index != i){
			swap(A, i, max_index);
			heapify(max_index, size);
		}
		
	}



	// implement the buildHeap algorithm described in the lecture notes 
	private void buildHeap(){
		for(int i = parent(A.length - 1); i >= 0; i--){
			heapify(i,A.length);
		}
	}

	// implement the in place heapSort algorithm described in the lecture notes
	public void heapSort(){
		for(int i = A.length - 1; i > 0; i--){
			swap(A, 0, i);
			//root is no longer heap, so heapify the root
			heapify(0, i);
		}
	}

	// return the heap content
	public String toString(){
		return Arrays.toString(A);
	}

	public static void main(String[] args) throws FileNotFoundException{
		// scanner for input file
		Scanner scan = new Scanner( new File (args[0]));
		// first int in input: number of ints to sort following 
		int n = Integer.parseInt(scan.next());
		int[] A = new int[n];
		for(int i = 0; i<n; i++)
			A[i] = Integer.parseInt(scan.next());
		System.out.println("    in: " + Arrays.toString(A));
		ArrayHeapSort ahs = new ArrayHeapSort(A);
		System.out.println("  heap: " + ahs);
		ahs.heapSort();
		System.out.println("sorted: " + ahs);

	}
}
