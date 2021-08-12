package numbers.property;

import java.math.BigInteger;
import java.util.function.Predicate;

public class Jumping implements Predicate<BigInteger> {
    @Override
    public boolean test(BigInteger bigInteger) {
        return false;
    }
}
