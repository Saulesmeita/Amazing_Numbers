package numbers.property;

import numbers.BigNumber;

import static java.math.BigInteger.TEN;
import static java.math.BigInteger.ZERO;

public class Buzz implements NumberProperty {
    private static final BigNumber SEVEN = new BigNumber("7");

    @Override
    public boolean hasProperty(BigNumber number) {
        return number.mod(TEN).equals(SEVEN)
                || number.mod(SEVEN).equals(ZERO);
    }
}
