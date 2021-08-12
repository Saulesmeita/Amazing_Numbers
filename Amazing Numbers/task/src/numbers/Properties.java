package numbers;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Properties {
    public static final char CONTRARY = '-';
    public static final Pattern NATURAL = Pattern.compile("[+]?\\d*\\d");

    private final Map<String, Predicate<BigInteger>> allProperties;
    private final Set<Set<String>> mutuallyExclusiveSet;

    public Properties() {
        allProperties = new HashMap<>();
        mutuallyExclusiveSet = new HashSet<>();
    }

    public static boolean isNotNatural(final String value) {
        return !NATURAL.matcher(value).matches();
    }

    public Properties put(Predicate<BigInteger> predicate) {
        var name = predicate.getClass().getSimpleName().toLowerCase();
        allProperties.put(name, predicate);
        mutuallyExclusiveSet.add(Set.of(name, CONTRARY + name));
        return this;
    }

    public Properties add(String... mutuallyExclusive) {
        mutuallyExclusiveSet.add(Set.of(mutuallyExclusive));
        return this;
    }

    public boolean hasProperty(String name) {
        return isContraryProperty(name)
                ? allProperties.containsKey(name.substring(1))
                : allProperties.containsKey(name);
    }

    public boolean isContraryProperty(String name) {
        return name.length() > 0 && name.charAt(0) == CONTRARY;
    }

    public Set<Set<String>> getMutuallyExclusive(Set<String> properties) {
        return mutuallyExclusiveSet.stream()
                .filter(properties::containsAll)
                .collect(Collectors.toUnmodifiableSet());
    }

    public Set<String> keySet() {
        return allProperties.keySet();
    }

    @Override
    public String toString() {
        return allProperties.keySet().toString();
    }

    public class Tester implements Predicate<String> {
        private final BigInteger number;
        private final Map<String, Boolean> ownProperties;

        public Tester(BigInteger number) {
            this.number = number;
            ownProperties = new HashMap<>();
        }

        public BigInteger getNumber() {
            return number;
        }

        public boolean testAll(Set<String> properties) {
            return properties.stream().allMatch(this);
        }

        @Override
        public boolean test(String name) {
            var isContrary = isContraryProperty(name);
            var property = isContrary ? name.substring(1) : name;
            var isPresent = ownProperties.computeIfAbsent(property,
                    key -> Properties.this.allProperties.get(key).test(number));
            return isContrary != isPresent;
        }
    }
}
