
public class MinHopes {

	private static class Node{
		int val;
		Node child;
		public int getVal() {
			return val;
		}
		public void setVal(int val) {
			this.val = val;
		}
		public Node getParent() {
			return child;
		}
		public void setParent(Node parent) {
			this.child = parent;
		}
		
	}
	
	public static void main(String[] args) {
		int array[] =  {2, 3, 1 ,1 , 4};//{1, 3, 5, 2, 9, 2, 6, 7, 6, 8, 9};
		Node n = new Node();
		n.val=array[0];
		System.out.println(getMinHopes(0, array,n));
		System.out.println(n);
		while(true){
			System.out.print(n.val+" -->");
			if(n.child==null){
				break;
			}
			n = n.child;
		}
		System.out.println(practiceMinHopes( array,0));
		
	}

	private static int practiceMinHopes(int[] array, int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static int getMinHopes(int i, int[] array, Node parent) {
		System.out.println(array[i]);
		if(array.length==0){
			return -1;
		}
		if(i>array.length){
			return 0;
		}
		if(i+array[i]>=array.length-1){
			System.out.println("----"+array[i]);
			return 1;
		}
		int min = Integer.MAX_VALUE;
		int val=0;
		
		for(int j=1; j<=array[i]; j++){
			Node n = new Node();
			n.setVal( array[j]);
			int k = 1+getMinHopes(j+i, array,n);
			if(min>k){
				min = k;
				val= array[j];
				n.setVal( array[j+i]);
				parent.setParent(n);
			}
		}
		
		//System.out.println(val);
		return min;
	}
}
