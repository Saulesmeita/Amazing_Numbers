package numbers.property;

import java.math.BigInteger;
import java.util.function.Predicate;

public class Sad implements Predicate<BigInteger> {
    private static final Predicate<BigInteger> HAPPY = new Happy();

    @Override
    public boolean test(BigInteger bigInteger) {
        return HAPPY.negate().test(bigInteger);
    }
}
