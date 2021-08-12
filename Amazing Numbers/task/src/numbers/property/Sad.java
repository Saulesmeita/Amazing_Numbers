package numbers.property;

import java.math.BigInteger;
import java.util.function.Predicate;

public class Sad implements Predicate<BigInteger> {
    @Override
    public boolean test(BigInteger bigInteger) {
        return false;
    }
}
