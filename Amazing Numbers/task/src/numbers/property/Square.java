package numbers.property;

import java.math.BigInteger;
import java.util.function.Predicate;

import static java.math.BigInteger.ZERO;

public class Square implements Predicate<BigInteger> {
    @Override
    public boolean test(BigInteger bigInteger) {
        return bigInteger.sqrtAndRemainder()[1].equals(ZERO);
    }
}
