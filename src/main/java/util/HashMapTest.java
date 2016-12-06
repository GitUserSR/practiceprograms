package util;

import java.util.HashMap;

public class HashMapTest {

	public static void main(String[] args) {
		HashMap<String, HashMap<String, Integer>> map = new HashMap<String, HashMap<String, Integer>>();
		HashMap<String, Integer> subMap = new HashMap<String, Integer>();
		subMap.put("subMapFirstKey", 1);
		map.put("mapFirstKey", subMap);
		System.out.println(subMap.values());
	}

}
