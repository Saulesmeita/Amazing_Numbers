package numbers.property;

import java.math.BigInteger;
import java.util.function.Predicate;

import static java.math.BigInteger.TEN;
import static java.math.BigInteger.ZERO;

public class Buzz implements Predicate<BigInteger> {
    private static final BigInteger SEVEN = BigInteger.valueOf(7);

    @Override
    public boolean test(BigInteger bigInteger) {
        return bigInteger.mod(TEN).equals(SEVEN) || bigInteger.mod(SEVEN).equals(ZERO);
    }
}
