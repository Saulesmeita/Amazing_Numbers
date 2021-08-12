package numbers.property;

import java.math.BigInteger;
import java.util.function.Predicate;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

public class Sunny implements Predicate<BigInteger> {
    @Override
    public boolean test(BigInteger bigInteger) {
        return bigInteger.add(ONE).sqrtAndRemainder()[1].equals(ZERO);
    }
}
