import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCount {
	

	public static void main(String[] args) {
		String str ="Filtering is one of the common operation Java developers perform with large collections, and you will be surprise how much easy it is now to filter bulk data/large collection using lambda expression and stream API.  Stream provides a filter() method, which accepts a Predicate object, means you can pass lambda expression to this method as filtering logic. Following examples of filtering collection in Java with lambda expression will make it easy to understand.";
			//str ="is is is";
		
		StringTokenizer  stringTokenizer = new StringTokenizer(str, " ");
		Map<String, Integer> map = new HashMap<>();
		for (;stringTokenizer.hasMoreTokens();) {
			//Predicate<Map> pre = (map1)->map1.containsKey(string);
			String string = stringTokenizer.nextToken();
			//updateMap(map, string);
		}
		
		System.out.println(map);
		
		
		
		//using list and predicate
		
		List<String> tokens = Arrays.asList(str.split("\\s"));
		System.out.println(tokens.size());
		tokens.stream().forEach(st -> {
			checkAndUpdateMap(map,(map1)->map1.containsKey(st), st);
		});
		System.out.println(map);
		
		
		Stream<String> stream = Stream.of("A", "B");
		
		stream.map(e-> new SimpleEntry<String, Integer>(e, 1)).collect(Collectors.toMap(e->e.getKey(), e->e.getValue(), (v1,v2) -> v1+v2));
		
		//using map reduce
		List<String> tokensList = Arrays.asList(str.split("\\s"));
		System.out.println(tokensList.size());
		Map<String, Integer> resultMap=tokensList.stream().map((word) -> new SimpleEntry<String, Integer>(word,1)).
				collect(Collectors.toMap(e->e.getKey(), e->e.getValue(), (v1, v2)-> v1+v2));
		System.out.println(resultMap);
		
		//using grouping by
		Map<String, Long> groupByMap=tokensList.stream().map((word) -> new SimpleEntry<String, Integer>(word,1)).
				collect(Collectors.groupingBy(SimpleEntry::getKey,Collectors.counting()));
		System.out.println(groupByMap);
		
		Map<String, Integer> wordCountmap = new HashMap<>();
		
		tokensList.stream().peek( (word) -> wordCountmap.merge(word, 1, ((v1,v2)-> v1+v2))).close();;
		System.out.println(wordCountmap);
	}
	
	private static void checkAndUpdateMap(Map<String, Integer> map, Predicate<Map> predicate, String str){
		if(predicate.test(map)){
			map.put(str, map.get(str)+1);
		}else{
			map.put(str,1);
		}
	}
	
	private static void updateMap(Map<String, Integer> map, String str){
		Integer count = map.get(str);
		Integer updated=(count !=null) ? map.put(str,++count): map.put(str,1);
	}
	
	
	
}


