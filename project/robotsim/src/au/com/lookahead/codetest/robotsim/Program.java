package au.com.lookahead.codetest.robotsim;

import java.util.Scanner;

public class Program {	
	public static void main(String[] args) {
		Simulator simulator = new Simulator();
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()) {
			String command = scanner.nextLine();
			simulator.accept(command);
		}
		scanner.close();
	}
}