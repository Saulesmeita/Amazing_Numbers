package numbers;

import java.math.BigInteger;
import java.util.Scanner;

import static java.math.BigInteger.TEN;
import static java.math.BigInteger.ZERO;

public class Main {
    static {
        final var SEVEN = new BigNumber("7");
        BigNumber.addProperty("even", number -> number.mod(BigInteger.TWO).equals(BigInteger.ZERO));
        BigNumber.addProperty("odd", number -> number.mod(BigInteger.TWO).equals(BigInteger.ONE));
        BigNumber.addProperty("buzz", number -> number.mod(TEN).equals(SEVEN) || number.mod(SEVEN).equals(ZERO));
        BigNumber.addProperty("duck", number -> number.toString().indexOf('0') > -1);
    }

    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);

        System.out.println("Enter a natural number:");
        final var number = new BigNumber(scanner.nextLine());

        if (number.isNatural()) {
            printProperties(number);
        } else {
            System.out.println("This number is not natural!");
        }
    }

    private static void printProperties(BigNumber number) {
        //noinspection MalformedFormatString
        System.out.printf("Properties of %,d%n", number);
        BigNumber.numberProperties.keySet()
                .forEach(property -> System.out.printf("%12s: %s%n", property, number.hasProperty(property)));
    }

}
