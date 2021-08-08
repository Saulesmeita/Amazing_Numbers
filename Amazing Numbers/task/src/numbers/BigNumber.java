package numbers;

import numbers.property.NumberProperty;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class BigNumber extends BigInteger {
    private static final Map<String, NumberProperty> properties = new HashMap<>();

    private static void addProperty(NumberProperty property) {
        properties.put(property.name(), property);
    }

    public static boolean isValidProperty(String name) {
        return properties.containsKey(name);
    }

    public BigNumber(String val) {
        super(val);
    }

    public boolean isNatural() {
        return this.compareTo(ZERO) > 0;
    }

    public boolean isEven() {
        return this.mod(TWO).equals(ZERO);
    }

}
