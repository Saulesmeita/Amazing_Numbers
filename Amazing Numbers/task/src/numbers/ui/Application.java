package numbers.ui;

import numbers.Properties;

import java.math.BigInteger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;
import static java.util.Arrays.stream;
import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.joining;
import static numbers.Properties.isNotNatural;

public class Application extends LocalTextInterface implements Runnable {
    private static final Pattern DELIMITER = Pattern.compile("\\s");
    private final Properties properties;

    public Application(Properties properties) {
        this.properties = properties;
    }

    @Override
    public void run() {
        printf("welcome");
        printf("instructions");

        Stream.generate(this::getRequest)
                .takeWhile(not("0"::equals))
                .forEach(this::processRequest);
    }

    private String getRequest() {
        printf("prompt");
        return scanner.nextLine().toLowerCase();
    }

    private void processRequest(final String request) {
        if (request.isEmpty()) {
            printf("instructions");
            return;
        }
        var parameters = DELIMITER.split(request);
        if (isNotNatural(parameters[0])) {
            printf("error.first");
            return;
        }
        var number = new BigInteger(parameters[0]);
        if (parameters.length == 1) {
            printCard(new BigInteger(request));
            return;
        }
        if (isNotNatural(parameters[1])) {
            printf("error.second");
            return;
        }

        var params = stream(parameters, 2, parameters.length)
                .collect(Collectors.toUnmodifiableSet());

        var wrongProperties = params.stream()
                .filter(not(properties::hasProperty))
                .collect(Collectors.toUnmodifiableSet());

        if (!wrongProperties.isEmpty()) {
            var errorMessage = wrongProperties.size() == 1 ? "error.is" : "error.are";
            printf(errorMessage, wrongProperties);
            printf("available", properties);
            return;
        }

        var mutuallyExclusive = properties.getMutuallyExclusive(params);
        if (!mutuallyExclusive.isEmpty()) {
            printf("error.mutuallyExclusive", mutuallyExclusive);
            return;
        }

        var length = Long.parseLong(parameters[1]);

        Stream.iterate(number, ONE::add)
                .map(n -> properties.new Tester(n))
                .filter(tester -> tester.testAll(params))
                .limit(length)
                .forEach(this::printList);
    }

    private void printList(Properties.Tester tester) {
        var properties = this.properties.keySet()
                .stream()
                .filter(tester)
                .collect(joining(", "));
        printf("line.format", tester.getNumber(), properties);
    }

    private void printCard(BigInteger number) {
        printf("properties", number);
        var tester = properties.new Tester(number);
        properties.keySet().forEach(property -> printf("property", property, tester.test(property)));
    }
}
