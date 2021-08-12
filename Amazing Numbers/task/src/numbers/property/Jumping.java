package numbers.property;

import java.math.BigInteger;
import java.util.function.Predicate;

public class Jumping implements Predicate<BigInteger> {
    @Override
    public boolean test(BigInteger bigInteger) {
        var previous = bigInteger.mod(BigInteger.TEN);
        var rest = bigInteger.divide(BigInteger.TEN);
        while (rest.compareTo(BigInteger.ZERO) > 0) {
            var current = rest.mod(BigInteger.TEN);
            var difference = current.subtract(previous).abs();
            if (difference.compareTo(BigInteger.ONE) != 0) {
                return false;
            }
            previous = current;
            rest = rest.divide(BigInteger.TEN);
        }
        return true;
    }
}
