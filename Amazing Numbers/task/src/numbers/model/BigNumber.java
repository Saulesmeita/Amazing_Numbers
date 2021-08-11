package numbers.model;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class BigNumber extends BigInteger {
    public static final Pattern NATURAL = Pattern.compile("[+]?\\d*\\d");
    public static final Map<String, Predicate<BigNumber>> PROPERTIES = new HashMap<>();

    private final Map<String, Boolean> attributes = new HashMap<>();

    public BigNumber(String val) {
        super(val);
    }

    public static void addProperty(String name, Predicate<BigNumber> property) {
        PROPERTIES.put(name.toLowerCase(), property);
    }

    public static boolean isNotNatural(final String value) {
        return !NATURAL.matcher(value).matches();
    }

    public static boolean isValidProperty(String name) {
        return PROPERTIES.containsKey(name.toLowerCase());
    }

    public boolean hasProperty(String name) {
        return attributes.computeIfAbsent(name, key -> PROPERTIES.get(key).test(this));
    }

    public BigNumber nextNumber() {
        return new BigNumber(this.add(ONE).toString());
    }

}
