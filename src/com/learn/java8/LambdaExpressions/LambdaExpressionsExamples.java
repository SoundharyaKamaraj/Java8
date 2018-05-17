/**
 * 
 */
package com.learn.java8.LambdaExpressions;

import java.util.Arrays;
import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Soundharya
 *
 */
public class LambdaExpressionsExamples {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Iterating Over List
		//IterateOverList();
		
		//Using Lambda expression and Functional interface Predicate
		//FucntionInterfacePredicate();
		
		//How to combine Predicate in Lambda Expressions
		//FucntionInterfacePredicateWithLambda();
		
		//Map and Reduce example in Java 8 using lambda expressions
		//FunctionWithMapAndReduce();
		
		//Creating a List of String by filtering 
		//FunctionWithListFiltering();
		
		//Applying function on Each element of List
		//FunctionWithForEach();
		
		//Creating a Sub List by Copying distinct values 
		//FunctionWithDistinctValues();
		
		//Calculating Maximum, Minimum, Sum and Average of List elements
		FunctionWithSummaryStatics();
	}

	private static void FunctionWithSummaryStatics() {
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
		IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println("Highest prime number in List : " + stats.getMax());
		System.out.println("Lowest prime number in List : " + stats.getMin());
		System.out.println("Sum of all prime numbers : " + stats.getSum());
		System.out.println("Average of all prime numbers : " + stats.getAverage());

		
	}

	private static void FunctionWithDistinctValues() {
		// Create List of square of all distinct numbers
		List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
		List<Integer> distinct = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
		System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);
		
	}

	private static void FunctionWithForEach() {
		// Convert String to Uppercase and join them using coma
		List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
		String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining("/ "));
		System.out.println(G7Countries);		
	}

	private static void FunctionWithListFiltering() {
		List<String> strList =Arrays.asList("Soundharya","Saravanan","Devi");
		// Create a List with String more than 2 characters
		List<String> filtered = strList .stream().filter(x -> x.length()> 4).collect(Collectors.toList());
		System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);
		
	}

	private static void FunctionWithMapAndReduce() {
		// applying 12% VAT on each purchase
		// Without lambda expressions:
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		double total=0;
		/*for (Integer cost : costBeforeTax) {
		      double price = cost + .12*cost;
		      System.out.println(price);
		      total= total+price;
		}*/
	
		costBeforeTax.stream().map((cost)->cost+ .12*cost).forEach(System.out::println);
		//Map Reduce example using Lambda Expressions in Java 8
		double bill = costBeforeTax.stream().map((cost) -> cost + .12*cost).reduce((sum, cost) -> sum + cost).get();
		System.out.println("Total : " + bill);
	}

	private static void FucntionInterfacePredicateWithLambda() {
		List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		Predicate<String> startsWithJ = (n)->n.startsWith("J");
		Predicate<String> lengthCondition= (n)->n.length()>3;
		languages.stream().filter(startsWithJ.and(lengthCondition)).forEach(System.out::println);
		
		
	}

	private static void FucntionInterfacePredicate() {
		List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		
		  System.out.println("Languages which starts with J :");
		  filter(languages, (str)->true);
		  System.out.println("Languages which title more than 4 characters :");
		  filter(languages, (str)->str.toString().length() > 4);

		
	}

	private static void filter(List<String> languages, Predicate condition) {
		
		//before java8
		/*for(String name: names)  {
		       if(condition.test(name)) {
		          System.out.println(name + " ");
		       }
		    }*/
		
		languages.stream().filter((n)->(condition.test(n))).forEach(System.out::println);
		
	}

	private static void IterateOverList() {
		//Prior Java 8 :
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		for (String feature : features) {
		   System.out.println(feature);
		}
		
		//Using Lambda 
		features.forEach((n)-> System.out.println(n));
		
		// Even better use Method reference feature of Java 8
		// method reference is denoted by :: (double colon) operator
		// looks similar to score resolution operator of C++
		features.forEach(System.out::println);
		
	}

}
