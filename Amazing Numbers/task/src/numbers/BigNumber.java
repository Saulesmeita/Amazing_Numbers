package numbers;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class BigNumber extends BigInteger {
    public static final Map<String, Function<BigNumber, Boolean>> numberProperties = new HashMap<>();
    private final Map<String, Boolean> properties = new HashMap<>();

    public static void addProperty(String name, Function<BigNumber, Boolean> property) {
        numberProperties.put(name.toLowerCase(), property);
    }

    public static boolean isValidProperty(String name) {
        return numberProperties.containsKey(name.toLowerCase());
    }

    public BigNumber(String val) {
        super(val);
    }

    public boolean isNatural() {
        return this.compareTo(ZERO) > 0;
    }

    public boolean hasProperty(String name) {
        return properties.computeIfAbsent(name, key -> numberProperties.get(key).apply(this));
    }

}
