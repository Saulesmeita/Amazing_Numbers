package numbers.property;

import java.math.BigInteger;
import java.util.function.Predicate;

public class Duck implements Predicate<BigInteger> {
    @Override
    public boolean test(BigInteger number) {
        return number.toString().indexOf('0') > -1;
    }
}
