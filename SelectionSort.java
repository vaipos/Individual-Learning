
public class SelectionSort {

	public static void main(String[] args) {
		int[] inarray = {2,5,1,6,3,100,56,92,24,19,38,52,78,84,27,96,65};
		for(int i =0; i< inarray.length; i++){
			int min = i;
			for(int j =i+1; j<inarray.length; j++){
				if(inarray[j]<inarray[min]){
					min =j;
				}
			}
			swap(inarray, i , min);
		}
		
		for(int i : inarray){
			System.out.println(i);
		}
		
	}
	
	private static void swap(int[] inarray, int i, int j){
		int t = inarray[j];
		inarray[j] = inarray[i];
		inarray[i] = t;
	}
}
