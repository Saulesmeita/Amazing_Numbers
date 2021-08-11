package numbers.model;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;

public class BigNumber extends BigInteger {
    public static final Pattern NATURAL = Pattern.compile("[+]?\\d*[1-9]");
    public static final Map<String, Function<BigNumber, Boolean>> numberProperties = new HashMap<>();

    private final Map<String, Boolean> properties = new HashMap<>();

    public static void addProperty(String name, Function<BigNumber, Boolean> property) {
        numberProperties.put(name.toLowerCase(), property);
    }

    public static boolean isNatural(final String value) {
        return NATURAL.matcher(value).matches();
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
