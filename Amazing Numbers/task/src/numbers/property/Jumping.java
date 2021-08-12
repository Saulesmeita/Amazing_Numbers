package numbers.property;

import java.math.BigInteger;
import java.util.function.Predicate;

import static java.math.BigInteger.TEN;

public class Jumping implements Predicate<BigInteger> {
    @Override
    public boolean test(BigInteger bigInteger) {
        var previous = bigInteger.mod(TEN);
        var rest = bigInteger.divide(TEN);
        while (!rest.equals(BigInteger.ZERO)) {
            var current = rest.mod(TEN);
            var difference = current.subtract(previous).abs();
            if (!difference.equals(BigInteger.ONE)) {
                return false;
            }
            previous = current;
            rest = rest.divide(TEN);
        }
        return true;
    }
}
