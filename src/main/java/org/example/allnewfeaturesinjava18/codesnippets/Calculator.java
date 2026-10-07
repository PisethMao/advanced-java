package org.example.allnewfeaturesinjava18.codesnippets;
/**
 * Provides simple mathematical operations.
 *
 * <p>This class demonstrates JEP 413 Code Snippets
 * in Java API Documentation.</p>
 */
public class Calculator {
    /**
     * Adds two integers.
     *
     * <p>Example:</p>
     *
     * {@snippet :
     *     Calculator calculator = new Calculator();
     *     int result = calculator.add(10, 20); // @highlight substring="add" type="bold"
     *     IO.println(result);
     * }
     *
     * @param a first number
     * @param b second number
     * @return the sum of a and b
     */
    public int add(int a, int b) {
        return a + b;
    }
    /**
     * Multiplies two integers.
     *
     * <p>Example:</p>
     *
     * {@snippet :
     *     Calculator calculator = new Calculator();
     *     int result = calculator.multiply(5, 4);
     *     IO.println(result);
     * }
     *
     * @param a first number
     * @param b second number
     * @return the multiplication result
     */
    public int multiply(int a, int b) {
        return a * b;
    }
}
