package numbers.ui;

import numbers.model.BigNumber;

import java.math.BigInteger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

public class Application extends LocalTextInterface implements Runnable {
    private static final Pattern DELIMITER = Pattern.compile("\\s");

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
        var numbers = DELIMITER.split(request);
        if (!BigNumber.isNatural(numbers[0])) {
            printf("error.first");
            return;
        }
        var number = new BigNumber(numbers[0]);
        if (numbers.length == 1) {
            printProperties(new BigNumber(request));
            return;
        }
        if (!BigNumber.isNatural(numbers[1])) {
            printf("error.second");
            return;
        }
        var length = Long.parseLong(numbers[1]);
        for (int i = Integer.parseInt(numbers[1]); i-- > 0; number = number.nextNumber()) {
            var properties = BigNumber.numberProperties.keySet()
                    .stream()
                    .filter(number::hasProperty)
                    .collect(Collectors.joining(", "));
            printf("line.format", number, properties);
        }
    }

    private void printProperties(BigNumber number) {
        printf("properties", number);
        BigNumber.numberProperties.keySet().forEach(property ->
                printf("property", property, number.hasProperty(property)));
    }
}
