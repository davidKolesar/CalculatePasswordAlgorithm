package com.mycompany.app;

import com.mycompany.passwordLogic.PasswordLogic;

public class App {

	public static void main(String[] args) {
		PasswordLogic passwordLogic = new PasswordLogic();
		passwordLogic.passwordCalculator("test 5 a0A pass007 ?xy1");
	}
}
