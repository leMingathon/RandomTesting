import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WhyItsNewsMathsProblem1 {
	public static void main(String[] args) throws IOException {
		// Sequence 1
		ArrayList<Integer> primes = new ArrayList<>();
		// Part of Sequence 2 (terms are removed from Sequence 2 as they're concatenated and added to Sequence 3,
		// because there's no point storing them)
		ArrayList<Character> primeDigits = new ArrayList<>();
		// Sequence 3
		ArrayList<Integer> primeDigitsConcat = new ArrayList<>();
		// The number we all want (initially something ridiculous).
		int firstSquare = -1;
		// We want this to be true!
		boolean squareNumberFound = false;

		// For printing output to a file.
		BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

		// Might as well add 2 to Sequences 1 and 2 to begin with, since we all know that 2 is the first prime.
		primes.add(2);
		primeDigits.add('2');

		// Start with the number 3, and keep looping until the first square number in Sequence 3 is found.
		for (int i = 3; ; i++) {
			writer.write("Testing the number " + i + "\n");
			// At first, assume that i is prime.
			boolean isPrime = true;

			// Use the Sieve of Eratosthenes to test if i actually is prime.
			for (int p : primes) {
				if (p * p <= i) {
					// Check for divisibility by all primes <= sqrt(i).
					if (i / p * p == i) {
						// then i is NOT prime because p is a factor.
						writer.write(i + " is divisible by " + p + "\n");
						isPrime = false;
						break;
					}
				} else {
					break;
				}
			}

			if (isPrime) {
				writer.write("Aha! " + i + " IS prime!" + "\n");
				// Add i to Sequence 1.
				primes.add(i);

				// Add the digits of i individually to Sequence 2.
				char[] iDigits = String.valueOf(i).toCharArray();
				for (char c : iDigits) {
					primeDigits.add(c);
				}
				writer.write("primeDigits: " + primeDigits + "\n");

				// Concatenate every 5 successive digits in the part of Sequence 2 stored in the primeDigits ArrayList
				// to form new terms of Sequence 3.
				if (primeDigits.size() >= 5) {
					for (int j = 0; j + 4 < primeDigits.size(); j++) {
						String primeDigitsConcatString = new String(new char[]{
								primeDigits.get(j),
								primeDigits.get(j + 1),
								primeDigits.get(j + 2),
								primeDigits.get(j + 3),
								primeDigits.get(j + 4)
						});
						writer.write("primeDigitsConcatString: " + primeDigitsConcatString + "\n");

						int newPrimeDigitsConcat = Integer.parseInt(primeDigitsConcatString);
						primeDigitsConcat.add(newPrimeDigitsConcat);
						writer.write("Number of terms in Sequence 3: " + primeDigitsConcat.size() + "\n");

						// ***Test if the new term added to Sequence 3 is a square number; if so, we've found it!***
						if (Math.sqrt((double) newPrimeDigitsConcat)
								== (int) Math.sqrt((double) newPrimeDigitsConcat)) {
							writer.write("YAY! " + newPrimeDigitsConcat + " IS A SQUARE NUMBER!!!" + "\n");
							firstSquare = newPrimeDigitsConcat;
							squareNumberFound = true;
						}
					}

					// Remove all the digits from Sequence 2 that will not be used again to form new terms in
					// Sequence 3, leaving only the ones that will still be part of the next few terms.
					primeDigits.subList(0, primeDigits.size() - 4).clear();
					writer.write("What's left of primeDigits: " + primeDigits + "\n");
				}

				if (squareNumberFound) {
					// then we're done!
					break;
				}
			}

			writer.newLine();
		}

		// Proudly display the result.
		writer.newLine();
		writer.write("DING DING DING!!! The first square number in Sequence 3 has been found!" + "\n");
		writer.write("It's " + firstSquare +
				", and it's the " + (primeDigitsConcat.indexOf(firstSquare) + 1) + "th number in the sequence." + "\n");
		writer.close();
	}
}
