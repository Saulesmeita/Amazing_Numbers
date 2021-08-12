package numbers.property;

import java.math.BigInteger;
import java.util.function.Predicate;

public class Duck implements Predicate<BigInteger> {
    @Override
    public boolean test(BigInteger bigInteger) {
        return bigInteger.toString().indexOf('0') > -1;
    }
}
