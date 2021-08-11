package numbers.ui;

import numbers.model.BigNumber;

import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;
import static numbers.model.BigNumber.isNotNatural;

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
        var parameters = DELIMITER.split(request);
        if (isNotNatural(parameters[0])) {
            printf("error.first");
            return;
        }
        var number = new BigNumber(parameters[0]);
        if (parameters.length == 1) {
            printCard(new BigNumber(request));
            return;
        }
        if (isNotNatural(parameters[1])) {
            printf("error.second");
            return;
        }
        var length = Long.parseLong(parameters[1]);
        Predicate<BigNumber> query = s -> true;
        for (int i = 2; i < parameters.length; i++) {
            if (BigNumber.isValidProperty(parameters[i])) {
                query = query.and(BigNumber.PROPERTIES.get(parameters[i]));
            } else {
                printf("error.property", parameters[i], BigNumber.PROPERTIES.keySet());
                return;
            }
        }
        Stream.iterate(number, BigNumber::nextNumber)
                .filter(query)
                .limit(length)
                .forEach(this::printList);
    }

    private void printList(BigNumber number) {
        var properties = BigNumber.PROPERTIES.keySet()
                .stream()
                .filter(number::hasProperty)
                .collect(Collectors.joining(", "));
        printf("line.format", number, properties);
    }

    private void printCard(BigNumber number) {
        printf("properties", number);
        BigNumber.PROPERTIES.keySet().forEach(property ->
                printf("property", property, number.hasProperty(property)));
    }
}
