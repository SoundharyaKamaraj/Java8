/**
 * 
 */
package com.learn.java8.parallel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Soundharya
 *
 */
public class ParallelExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8 };
		List<Integer> listOfIntegers =
		    new ArrayList<>(Arrays.asList(intArray));
		Comparator<Integer> normal = Integer::compare;
		Comparator<Integer> reversed = normal.reversed();
		listOfIntegers.sort(reversed);
		
		//listOfIntegers.parallelStream().forEach( (e)-> System.out.println(" "+e));
		//listOfIntegers.parallelStream().forEach( (e)-> System.out.println(" "+e));
		listOfIntegers.parallelStream().forEachOrdered((e)-> System.out.println(" "+e));

	}

}
