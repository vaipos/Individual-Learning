
public class MergeSort {

	public static void main(String[] args) {
		int[] integers = {10,6,12, 4, 100, 2, 18,9};
		sort(integers, 0, integers.length-1);
		for(int i : integers){
			System.out.println(i);
		}
	}
	
	private static void sort(int[] array , int l, int r){
		if(l<r){
			int m = (l+r)/2;
			
			sort(array, l, m);
			sort(array, m+1, r);
			
			merge(array, l, r, m);
		}
	}
	
	private static void merge(int[] array , int l, int r, int m){
		int k = l;
		int n1 = m-l+1;
		int n2 = r-m;
		int[] larray = new int[n1];
		int[] rarray = new int[n2];
		for(int i=0 ; i<n1 ; ++i){
			larray[i] = array[l+i];
		}
		for(int i=0 ; i<n2 ; ++i){
			rarray[i] = array[m+i+1];
		}
		int i=0, j=0; 
		while(i<n1 && j<n2){
			if(larray[i] < rarray[j]){
				array[k++] = larray[i++];
			}else{
				array[k++] = rarray[j++];
			}
		}
		
		while(i<n1){
			array[k++] = larray[i++];
		}
		while(j<n2){
			array[k++] = rarray[j++];
		}
	}
}
