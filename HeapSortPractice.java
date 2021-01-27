
public class HeapSortPractice {

	public static void main(String[] args) {
		int[] integers = {10,6,12, 4, 100, 2, 18,9};
		sort(integers);
	}
	
	private static void sort(int array[]) {
		int n = array.length;
		// The following block will make each node in the tree has max value at root node compared to child
		for(int i = n/2-1; i>=0; i--) {
			heapify(array, n, i);
		}
		for(int i = n-1; i>=0; i--) {
			int t = array[i];
			array[i] = array[0];
			array[0] = t;
			heapify(array, i, 0);
		}
		
		for(int t : array) {
			System.out.println(t);
		}
	}
	
	private static void heapify(int array[], int n , int i) {
		int l =i;
		int n1 = 2*i+1;
		int n2 = 2*i+2;
		if(n1<n && array[n1]>array[l]) {
			l= n1;
		}
		if(n2<n && array[n2]>array[l]) {
			l = n2;
		}
		if(l!=i) {
			int t = array[l];
			 array[l] = array[i];
			 array[i] = t;
			 heapify(array, n, l);
		}
	}
}
