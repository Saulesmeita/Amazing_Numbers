package numbers.property;

import java.math.BigInteger;
import java.util.function.Predicate;

public class Palindromic implements Predicate<BigInteger> {
    @Override
    public boolean test(BigInteger number) {
        return new StringBuilder(number.toString())
                .reverse().toString().equals(number.toString());
    }
}
