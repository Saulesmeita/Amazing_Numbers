package numbers;

import numbers.property.Buzz;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
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
        final var buzzProperty = new Buzz();
        final var SEVEN = new BigNumber("7");
        final var isDivisibleBySeven = number.mod(SEVEN).equals(BigInteger.ZERO);
        final var isEndWithSeven = number.mod(BigInteger.TEN).equals(SEVEN);
        final var explanaton
                = isDivisibleBySeven && isEndWithSeven ? "is divisible by 7 and ends with 7"
                : isEndWithSeven ? "ends with 7"
                : isDivisibleBySeven ? "is divisible by 7"
                : "is neither divisible by 7 nor does it end with 7";
        //noinspection MalformedFormatString
        System.out
                .printf("This number is %s.%n", number.isEven() ? "Even" : "Odd")
                .printf("It is%s a %s number.%n", buzzProperty.hasProperty(number) ? "" : " not", buzzProperty.name())
                .printf("Explanation:%n")
                .printf("%,d %s%n", number, explanaton);
    }
}
