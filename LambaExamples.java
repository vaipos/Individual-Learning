import java.util.function.Function;

public class LambaExamples {

	private  static Function<String, Boolean> func = new Function<String, Boolean>() {
		
		@Override
		public Boolean apply(String t) {
			// TODO Auto-generated method stub
			return t.contains("Apple");
		}
	};
	
	
	private static boolean testLamba(Function<String, Boolean> func, String s) {
		return func.apply(s);
	}
	
	public static void main(String[] args) {
		String str = "test";
		
		System.out.println(testLamba(func, str));
		
		System.out.println(testLamba(e-> e.contains("test"), str));
	}
	
	
}
