import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TestMethodRefernces {

	/**
	 * Ways to add elements from one list to another
	 * @param args
	 */
	public static void main(String[] args) {
		
		// List based functions
		String str ="Filtering is one of the common operation Java developers perform with large collections, and you will be surprise how much easy it is now to filter bulk data/large collection using lambda expression and stream API.  Stream provides a filter() method, which accepts a Predicate object, means you can pass lambda expression to this method as filtering logic. Following examples of filtering collection in Java with lambda expression will make it easy to understand.";
		List<String> strList= Arrays.asList(str.split(" "));
		strList.forEach(x-> System.out.println(x));
		List<String> newList = new ArrayList<>();
		strList.forEach(x->newList.add(x));
		System.out.println(newList);
		List<String> newList1 = new ArrayList<>();
		//Method reference using instance
		strList.forEach(newList1::add);
		System.out.println(newList);
		
		List<String> list =strList.parallelStream().collect(Collectors.toCollection(ArrayList::new));
		System.out.println(list);
		
		 list =strList.parallelStream().collect(Collectors.toList());
		System.out.println(list);
		//wordcount to get map
		Map<String, Long> map =newList1.parallelStream().map(word -> new SimpleEntry<String, Integer>(word, 1)).collect(Collectors.groupingBy(SimpleEntry::getKey, Collectors.counting()));
		
		System.out.println(map);
		
		System.out.println(Math.pow(10, 2));
		
		
		((Double)Math.sqrt(10)).intValue();
		
	}
}
