package numbers;

import numbers.model.NumberProperties;
import numbers.ui.Application;

import java.math.BigInteger;
import java.util.Set;

import static java.math.BigInteger.*;

public class Main {
    private static final BigInteger SEVEN = new BigInteger("7");
    private static final NumberProperties NUMBER_PROPERTIES = new NumberProperties()
            .put("even", number -> number.mod(BigInteger.TWO).equals(BigInteger.ZERO))
            .put("odd", number -> number.mod(BigInteger.TWO).equals(ONE))
            .put("buzz", number -> number.mod(TEN).equals(SEVEN) || number.mod(SEVEN).equals(ZERO))
            .put("duck", number -> number.toString().indexOf('0') > -1)
            .put("palindromic", number ->
                    new StringBuilder(number.toString()).reverse().toString().equals(number.toString()))
            .put("gapful", number -> {
                var digits = number.toString();
                if (digits.length() < 3) {
                    return false;
                }
                var divisor = new BigInteger(digits.charAt(0) + digits.substring(digits.length() - 1));
                return number.mod(divisor).equals(ZERO);
            })
            .put("spy", number -> {
                var product = number.toString().chars().map(Character::getNumericValue)
                        .reduce(1, (a, b) -> a * b);
                return product > 0 && product == number.toString().chars().map(Character::getNumericValue).sum();
            })
            .put("square", number -> number.sqrtAndRemainder()[1].equals(ZERO))
            .put("sunny", number -> number.add(ONE).sqrtAndRemainder()[1].equals(ZERO))
            .add(Set.of("even", "odd"))
            .add(Set.of("sunny", "square"))
            .add(Set.of("spy", "duck"));

    public static void main(String[] args) {
        new Application(NUMBER_PROPERTIES).run();
    }

}
