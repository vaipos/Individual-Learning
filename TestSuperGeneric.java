import java.util.List;

public class TestSuperGeneric {

	/**
	 * Super generic in class level does not work 
	 * 
	 * @author kalyanpasumarthi
	 *
	 * @param <T>
	 */
private static class TestGenric<T extends Object /*, <V super TestSuperGeneric>*/>{
		
		private void testSuper(List<? super WordCount> t, T t1){
			
		}
	}
}
