package com.mycompany.passwordLogic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PasswordLogic {

	public int passwordCalculator(String potentialPasswords) {		
		String[] splitPasswords = potentialPasswords.split("\\s+");
		Stream<String> evaluatePotentialPasswords = Arrays.stream(splitPasswords);
		List<String> validPasswords = evaluatePotentialPasswords
				// filter out passwords that are not alphanumeric
				.filter(x -> x.matches("^[a-zA-Z0-9]*$"))
				// filter out passwords with even number of digits
				.filter(x -> x.chars().filter(Character::isDigit).count() % 2 != 0)
				// Filter out password with odd string lengths
				.filter(x -> x.chars().filter(Character::isLetter).count() % 2 == 0)
				// Collect the remaining results
				.collect(Collectors.toList());

		System.out.println(("Valid passwords:"));
		for(int i=0; i < validPasswords.size(); i++) {
			System.out.println(validPasswords.get(i));
		}
		
		if (validPasswords.size() == 0) {
			return -1;
		}

		return validPasswords.size();
	}
}