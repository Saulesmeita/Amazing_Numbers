package numbers.property;

import java.math.BigInteger;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.math.BigInteger.*;
import static java.util.function.Predicate.not;

public class Happy implements Predicate<BigInteger> {
    private static final BigInteger SAD = BigInteger.valueOf(4);
    private static final Set<BigInteger> TERMINAL = Set.of(ONE, SAD);

    public static BigInteger numSquareSum(BigInteger bigInteger) {
        return Stream
                .iterate(bigInteger, not(ZERO::equals), i -> i.divide(TEN))
                .map(i -> i.mod(TEN))
                .map(i -> i.multiply(i))
                .reduce(ZERO, BigInteger::add);
    }

    @Override
    public boolean test(BigInteger bigInteger) {
        return Stream
                .iterate(bigInteger, Happy::numSquareSum)
                .filter(TERMINAL::contains)
                .findFirst()
                .orElseThrow()
                .equals(ONE);
    }

}
