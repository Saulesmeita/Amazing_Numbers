package numbers.property;

import java.math.BigInteger;
import java.util.function.Predicate;

import static java.math.BigInteger.TEN;
import static java.math.BigInteger.ZERO;

public class Buzz implements Predicate<BigInteger> {
    private static final BigInteger SEVEN = new BigInteger("7");

    @Override
    public boolean test(BigInteger number) {
        return number.mod(TEN).equals(SEVEN) || number.mod(SEVEN).equals(ZERO);
    }
}
