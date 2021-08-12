package numbers.property;

import java.math.BigInteger;
import java.util.function.Predicate;

import static java.math.BigInteger.ZERO;

public class Gapful implements Predicate<BigInteger> {
    @Override
    public boolean test(BigInteger number) {
        var digits = number.toString();
        if (digits.length() < 3) {
            return false;
        }
        var divisor = new BigInteger(digits.charAt(0) + digits.substring(digits.length() - 1));
        return number.mod(divisor).equals(ZERO);
    }
}
