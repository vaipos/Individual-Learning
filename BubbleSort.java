public class BubbleSort {
	
	public static void main(String[] args) {
		
		int[] integers = {10,6,12, 4, 100, 2, 18,9};
		for(int i=0; i< integers.length; i++) {
			for(int j=0; j<integers.length-i-1; j++) {
				int k = integers[j];
				if(k>integers[j+1]) {
					integers[j]= integers[j+1];
					integers[j+1] = k;
				}
			}
		}
		
		for(int i:integers) {
			System.out.println(i);
		}
	}

}
