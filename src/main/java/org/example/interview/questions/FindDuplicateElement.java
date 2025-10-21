package org.example.interview.questions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateElement {

	public static void main(String[] args) {
		String str = "ilovejavatechie";

		String[] strArray = str.split("");

		Map<String, Long> map = Arrays.stream(strArray)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map);

		List<String> collect = map.entrySet().stream().filter(a -> a.getValue() > 1).map( b -> b.getKey())
				.collect(Collectors.toList());
		System.out.println(collect);

		List<String> elementList =
				Arrays.asList("Ashu", "Bittoo", "Vritika", "Vartu", "Preeti", "Ashu", "Bittoo");

		List<String> duplicateElemnt = elementList.stream().distinct().collect(Collectors.toList());
		System.out.println("---------------");
		System.out.println("Duplicate Elemnt : "+ duplicateElemnt);


		// find unique char from a given string
		String inputData= "ilovemycountryindia";
		final List<Character> uniqueChar = inputData.chars().mapToObj(ch -> (char) ch).distinct().collect(Collectors.toList());
		System.out.println("All Unique Char/Element" + uniqueChar);

		// collect all dublicate element only
		Set set = new HashSet();
		inputData.chars().mapToObj(ch -> (char) ch).filter(obj -> ! set.add(obj)).forEach(System.out::print);
		System.out.print("\n------------\n");
		// colect all non- reapting chars
		final List<Map.Entry<Character, Long>> nonReaptingChar = inputData.chars().mapToObj(ch -> (char) ch)
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
				.entrySet().stream().filter(characterLongEntry -> characterLongEntry.getValue() == 1).collect(Collectors.toList());
		System.out.println(nonReaptingChar);

		// colect all reapting chars
		final List<Map.Entry<Character, Long>> reaptingChar = inputData.chars().mapToObj(ch -> (char) ch)
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
				.entrySet().stream().filter(characterLongEntry -> characterLongEntry.getValue() > 1).collect(Collectors.toList());
		System.out.println(reaptingChar);

		// collect first reating char
		Set myset = new HashSet();
		String st= "success";
		final Character c = st.chars().mapToObj(ch -> (char) ch).filter(ch -> !myset.add(ch)).findFirst().get();
		System.out.println(c);

		//collect first non- reapting char
		final Map.Entry<Character, Long> firstNonReaptingChar = st.chars().mapToObj(ch -> (char) ch)
				.collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
				.entrySet().stream().filter(characterLongEntry -> characterLongEntry.getValue() == 1).findFirst().get();
		System.out.println(firstNonReaptingChar);


	}

}
