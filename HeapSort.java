
public class HeapSort {

	public static void main(String[] args) {
		int[] inarray = {2,5,1,6,3,11,56,92,24,19,38,52,78,84,27,96,65};
		int n = inarray.length;
		for(int i = n/2 -1 ; i>=0 ; i--){
			heapify(inarray, n, i);
		}
		for(int i : inarray){
			System.out.println(i);
		}
		System.out.println("---------------");
		for(int i = n -1 ; i>=0 ; i--){
			
			int temp = inarray[0];
			inarray[0] = inarray[i];
			inarray[i] = temp;
			heapify(inarray, i, 0);
		}
		
		for(int i : inarray){
			System.out.println(i);
		}
		
	}
	
	public static void heapify(int[] inarray, int n , int i){
		
		int largest = i;
		int l = 2*i+1;
		int r = 2*i+2;
		
		if(l<n && inarray[l]>inarray[largest]){
			largest = l;
		}
		
		if(r<n && inarray[r]>inarray[largest]){
			largest = r;
		}
		
		if(largest != i){
			int temp = inarray[i];
			inarray[i] = inarray[largest];
			inarray[largest] = temp;
			heapify(inarray, n, largest);
		}
	}
}
