
public class QuickSort {
 public static void main(String[] args) {
		int[] integers = {10,6,12, 4, 100, 2, 18,9, 17, 5};
		quickSort(integers, 0, integers.length-1);
		
		//int rank = partition1(integers, 0, integers.length-1);
		//System.out.println(rank);
		for(int i : integers){
			System.out.println(i);
		}
}
 private static void quickSort(int[] array , int lo, int hi){
	 if(lo<hi){
		 int pi = partition(array, lo, hi);
		
		 quickSort(array, lo, pi-1);
		 quickSort(array, pi, hi);
	 }
 }
 
 
 private static int partition1(int[] array , int lo, int hi){
	int i = lo-1;
	int pivot = array[hi];
	/*
	 * j=0 10,6,12, 4, 100, 2, 18,9
	 * j=1 6,10,12,4,100,2,18,9 , i=0
	 * j=2 6,10,12,4,100,2,18,9
	 * j=3 6,4,12,10,100,2,18,9 , i=1
	 * j=4 6,4,12,10,100,2,18,9 
	 * j=5 6,4,2,10,100,12,18,9 , i=2
	 * j=6 6,4,2,10,100,12,18,9 , i=2
	 * j =7 will not come as j<hi which is j<7
	 * 
	 */
	for(int j=lo; j<hi ; j++){
		if(array[j]<=pivot){
			i++;
			//System.out.println(i+" = "+j);

			//swap(array, i , j);
		}
	}
	//System.out.println(i+" - "+hi);
	swap(array, i+1, hi);
	return i+1;
 }
 
 
 private static int partition(int[] array , int lo, int hi){
	int i = lo-1;
	int pivot = array[hi];
	/*
	 * j=0 10,6,12, 4, 100, 2, 18,9
	 * j=1 6,10,12,4,100,2,18,9 , i=0
	 * j=2 6,10,12,4,100,2,18,9
	 * j=3 6,4,12,10,100,2,18,9 , i=1
	 * j=4 6,4,12,10,100,2,18,9 
	 * j=5 6,4,2,10,100,12,18,9 , i=2
	 * j=6 6,4,2,10,100,12,18,9 , i=2
	 * j =7 will not come as j<hi which is j<7
	 * 
	 */
	
	
	for(int j=lo; j<hi ; j++){
		if(array[j]<=pivot){
			i++;
			//System.out.println(i+" = "+j);

			swap(array, i , j);
		}
	}
	//System.out.println(i+" - "+hi);
	swap(array, i+1, hi);
	return i+1;
 }
 
 private static void swap(int array[], int index1, int index2){
	 int t = array[index1];
	 array[index1] = array[index2] ;
	 array[index2] = t;
 }
 
}
