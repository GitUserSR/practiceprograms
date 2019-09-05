package util;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

	public static void main(String[] args) {
		HashMap<String, HashMap<String, Integer>> map = new HashMap<String, HashMap<String, Integer>>();
		HashMap<String, Integer> subMap = new HashMap<String, Integer>();
		subMap.put("subMapFirstKey", 1);
		map.put("mapFirstKey", subMap);
		System.out.println(subMap.values());

		Map<Integer, Employee> empMap = new HashMap<Integer, Employee>();
		empMap.put(1, new Employee(1, "Swathi"));
		empMap.put(2, new Employee(2, "Swathi"));
		System.out.println(empMap.get(1));
	}
}

class Employee {
	int id;
	String name;

	public Employee(Integer id, String string2) {
		this.id = id;
		this.name = name;
	}

	public int hashCode() {
		return id;
	}

	public boolean equals(Employee employee) {
		return (this.id == employee.id);
	}
}
