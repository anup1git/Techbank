package com.atos.fintect;

import java.util.ArrayList;
import java.util.List;

public class LambdaTesting {

	class Person {
		public Person(String string, int i) {
			this.name = string;
			this.age = i;
		}
		String name;
		Integer age;
	}
	
	
	public void mainInstance() {
		List<Person> peopleList = new ArrayList<>();
		peopleList.add(new Person("abc", 23));
		peopleList.add(new Person("xys", 13));
		peopleList.add(new Person("werwe", 35));
		peopleList.add(new Person("lpa", 3));
		
		peopleList.stream().forEach(personVar -> {System.out.println("hello " + personVar.name);});
		
		System.out.println("Count of ages  + " + peopleList.stream().filter((personVar) -> personVar.age > 10 ).count());
		System.out.println("Count of ages  + " + peopleList.stream().sorted().count());
	}
	
	public static void main(String[] args) {
		LambdaTesting lambdaTesting = new LambdaTesting();
		lambdaTesting.mainInstance();
	}
	
}

