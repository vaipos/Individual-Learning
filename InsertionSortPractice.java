
public class InsertionSortPractice {
	
	public static void main(String[] args) {
		int[] integers = {10,6,12, 4, 100, 2, 18,9};
		//int[] integers = {10,6};

		sort(integers, 0, integers.length);
		for(int i : integers){
			System.out.println(i);
		}
	}
	
	private static void sort(int[] array, int l, int r) {
		for(int i = l+1; i<r ; i++) {
			int valToCompare = array[i];
			int j = i-1;// Just check if the prev Number is sorted in ascending or not
			while(j>=0 && array[j]>valToCompare) {
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = valToCompare;
		}
	}
	


}
