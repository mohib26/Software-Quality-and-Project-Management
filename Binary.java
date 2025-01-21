package com.ontariotechu.sofe3980U;

import java.util.Scanner;

/**
 * Unsigned integer Binary variable
 */
public class Binary
{
	private String number="0";  // string containing the binary value '0' or '1'

	/**
	 * A constructor that generates a binary object.
	 *
	 * @param number a String of the binary values. It should contain only zeros or ones with any length and order. otherwise, the value of "0" will be stored. Trailing zeros will be excluded and empty string will be considered as zero.
	 */
	public Binary(String number) {
		if (number == null || number.isEmpty()) {
			this.number = "0"; // Default to "0" for null or empty input
			return;
		}

		// Validate the binary string (only '0' or '1' allowed)
		for (int i = 0; i < number.length(); i++) {
			char ch = number.charAt(i);
			if (ch != '0' && ch != '1') {
				this.number = "0"; // Default to "0" for invalid input
				return;
			}
		}

		// Remove leading zeros
		int beg;
		for (beg = 0; beg < number.length(); beg++) {
			if (number.charAt(beg) != '0') {
				break;
			}
		}

		// If all digits are '0', ensure number is "0"
		this.number = (beg == number.length()) ? "0" : number.substring(beg);

		// Ensure empty strings are replaced with "0"
		if (this.number.isEmpty()) {
			this.number = "0";
		}
	}
	/**
	 * Return the binary value of the variable
	 *
	 * @return the binary value in a string format.
	 */
	public String getValue()
	{
		return this.number;
	}
	/**
	 * Adding two binary variables.
	 *
	 * @param num1 The first addend object
	 * @param num2 The second addend object
	 * @return A binary variable with a value of <i>num1+num2</i>.
	 */
	public static Binary add(Binary num1, Binary num2) {
		int ind1 = num1.number.length() - 1;
		int ind2 = num2.number.length() - 1;
		int carry = 0;
		String num3 = "";
		while (ind1 >= 0 || ind2 >= 0 || carry != 0) {
			int sum = carry;
			if (ind1 >= 0) {
				sum += (num1.number.charAt(ind1) == '1') ? 1 : 0;
				ind1--;
			}
			if (ind2 >= 0) {
				sum += (num2.number.charAt(ind2) == '1') ? 1 : 0;
				ind2--;
			}
			carry = sum / 2;
			sum = sum % 2;
			num3 = ((sum == 0) ? "0" : "1") + num3;
		}
		return new Binary(num3);
	}

	/**
	 * Bitwise OR operation between two binary variables.
	 *
	 * @param other The other binary object to perform OR operation with.
	 * @return A binary variable with the result of the OR operation.
	 */
	public Binary or(Binary other) {
		int maxLength = Math.max(this.number.length(), other.number.length());
		String a = String.format("%" + maxLength + "s", this.number).replace(' ', '0');
		String b = String.format("%" + maxLength + "s", other.number).replace(' ', '0');

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < maxLength; i++) {
			result.append(a.charAt(i) == '1' || b.charAt(i) == '1' ? '1' : '0');
		}
		return new Binary(result.toString());
	}

	/**
	 * Bitwise AND operation between two binary variables.
	 *
	 * @param other The other binary object to perform AND operation with.
	 * @return A binary variable with the result of the AND operation.
	 */
	public Binary and(Binary other) {
		int maxLength = Math.max(this.number.length(), other.number.length());
		String a = String.format("%" + maxLength + "s", this.number).replace(' ', '0');
		String b = String.format("%" + maxLength + "s", other.number).replace(' ', '0');

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < maxLength; i++) {
			result.append(a.charAt(i) == '1' && b.charAt(i) == '1' ? '1' : '0');
		}
		return new Binary(result.toString());
	}

	/**
	 * Multiply two binary variables.
	 *
	 * @param other The other binary object to multiply with.
	 * @return A binary variable with the result of the multiplication.
	 */
	public Binary multiply(Binary other) {
		Binary result = new Binary("0");
		for (int i = other.number.length() - 1, shift = 0; i >= 0; i--, shift++) {
			if (other.number.charAt(i) == '1') {
				result = add(result, new Binary(this.number + "0".repeat(shift)));
			}
		}
		return result;
	}

	/**
	 * Test the OR operation.
	 */
	public static void testOr() {
		Binary a = new Binary("1010");
		Binary b = new Binary("1100");
		System.out.println("Test OR: ");
		System.out.println("Input: " + a.getValue() + " | " + b.getValue());
		System.out.println("Output: " + a.or(b).getValue()); // Expected: 1110
	}

	/**
	 * Test the AND operation.
	 */
	public static void testAnd() {
		Binary a = new Binary("1010");
		Binary b = new Binary("1100");
		System.out.println("Test AND: ");
		System.out.println("Input: " + a.getValue() + " & " + b.getValue());
		System.out.println("Output: " + a.and(b).getValue()); // Expected: 1000
	}

	/**
	 * Test the Multiply operation.
	 */
	public static void testMultiply() {
		Binary a = new Binary("101");
		Binary b = new Binary("11");
		System.out.println("Test Multiply: ");
		System.out.println("Input: " + a.getValue() + " * " + b.getValue());
		System.out.println("Output: " + a.multiply(b).getValue()); // Expected: 1111
	}
}



