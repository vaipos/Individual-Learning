import java.util.function.Function;

public class TestCurryFunction {

	public static void main(String[] args) {
		Function<Integer, 
        Function<Integer, Integer> > 
   curryAdder = u -> v -> u + v; 
   
   
   
  
   System.out.println("Add 2, 3 :"
           + curryAdder 
                 .apply(2).apply(3) );
   
   Function<Integer, Integer> f1 =  curryAdder 
           .apply(6);
   
   System.out.println(" 6 + dynamic number : "+ f1.apply(10));
                
	}
}
