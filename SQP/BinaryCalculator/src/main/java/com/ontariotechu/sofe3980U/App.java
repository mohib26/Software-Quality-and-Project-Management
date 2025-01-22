package com.ontariotechu.sofe3980U;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
	/**
	 * Main program:  The entry point of the program. The local time will be printed first,
	 *      Then it will create two binary variables, perform operations (add, or, and, multiply) and print the results.
	 *
	 * @param args: not used
	 */
	public static void main( String[] args )
	{

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the first binary number:");
		String input1 = scanner.nextLine();
		Binary binary1 = new Binary(input1);
		System.out.println("First binary number is: " + binary1.getValue());

		System.out.println("Enter the second binary number:");
		String input2 = scanner.nextLine();
		Binary binary2 = new Binary(input2);
		System.out.println("Second binary number is: " + binary2.getValue());

		Binary sum = Binary.add(binary1, binary2);
		System.out.println("Their summation is: " + sum.getValue());

		Binary orResult = binary1.or(binary2);
		System.out.println("The result of OR operation is: " + orResult.getValue());

		Binary andResult = binary1.and(binary2);
		System.out.println("The result of AND operation is: " + andResult.getValue());

		Binary multiplyResult = binary1.multiply(binary2);
		System.out.println("The result of multiplication is: " + multiplyResult.getValue());

		scanner.close();
	}
}
