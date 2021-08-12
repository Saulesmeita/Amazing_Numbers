package numbers.property;

import java.math.BigInteger;
import java.util.function.Predicate;

import static java.math.BigInteger.ZERO;

public class Even implements Predicate<BigInteger> {
    @Override
    public boolean test(BigInteger number) {
        return number.mod(BigInteger.TWO).equals(ZERO);
    }
}
