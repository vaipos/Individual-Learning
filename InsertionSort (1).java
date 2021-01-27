
public class InsertionSort {

	public static void main(String[] args) {
		int[] inarray = {2,5,1,6,3,100,56,92,24,19,38,52,78,84,27,96,65};
//		for(int i=0; i<inarray.length-1; i++){
//			if(inarray[i+1]<inarray[i]){
//				
//				for(int j=0; j<=i; j++){
//					if(inarray[j]>inarray[i+1]){
//						swap(inarray, i+1, j);
//					}
//				}
//			}
//		}
//		
//		for(int i : inarray){
//			System.out.println(i);
//		}
//		
		
		sort(inarray, 0, inarray.length);
		
        
        for(int i : inarray){
			System.out.println(i);
		}
	}
	public static void sort(int[] inarray, int left, int right ) {
		for(int i =left+1 ; i<right; i++) {
			int valuetocompare = inarray[i];
			int j = i-1;// second index to iterate// previous value index
			while(j>=0 && inarray[j]>valuetocompare) {
				inarray[j+1] = inarray[j]; // assign the bigger value to next location
				j--;
			}
			inarray[j+1] = valuetocompare;
			
		}
	}
	private static void swap(int[] inarray, int i, int j){
		int t = inarray[j];
		inarray[j] = inarray[i];
		inarray[i] = t;
	}
}
