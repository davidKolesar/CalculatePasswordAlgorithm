package com.mycompany.passwordLogic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class PasswordLogic {

	/**
	 * Takes in String of potential passwords and enforces the following rules: it
	 * has to contain only alphanumeric characters (a−z, A−Z, 0−9); there should be
	 * an even number of letters; there should be an odd number of digits.
	 * 
	 * @param potentialPasswords
	 */
	public void passwordCalculator(String potentialPasswords) {
		String[] splitPasswords = potentialPasswords.split("\\s+");
		Stream<String> evaluatePotentialPasswords = Arrays.stream(splitPasswords);
		String longestValidPassword = evaluatePotentialPasswords
				// Filter out passwords that are not alphanumeric
				.filter(x -> x.matches("^[a-zA-Z0-9]*$"))
				// Filter out passwords with even number of digits
				.filter(x -> x.chars().filter(Character::isDigit).count() % 2 != 0)
				// Filter out password with odd string lengths
				.filter(x -> x.chars().filter(Character::isLetter).count() % 2 == 0)
				// Identify longest password
				.max(Comparator.comparingInt(String::length)).get();

		if (longestValidPassword == null || longestValidPassword.trim().isEmpty()) {
			longestValidPassword = "no acceptable passwords";
		}
		System.out.println(("Longest Valid password: " + longestValidPassword));
	}
}