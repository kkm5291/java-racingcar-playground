package calc;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    public static final String REGEX = "[,:]";
    public static final String CUSTOM_REGEX = "//(.)\n(.*)";
    public static final String NEGATIVE_NUMBER_EXCEPTION_MESSAGE = "양수만 가능합니다.";

    public static int splitAndSum(String rawString) {
        if (rawString == null || rawString.isEmpty()) {
            return 0;
        }
        List<Integer> integerNumbers = parseIntegerNumbers(split(rawString));
        return sum(integerNumbers);
    }

    private static List<Integer> parseIntegerNumbers(String[] numbers) {
        return Arrays.stream(numbers)
                .map(StringCalculator::parseAndValidateNumber)
                .collect(Collectors.toList());
    }

    private static int parseAndValidateNumber(String number) {
        int parsed = Integer.parseInt(number);
        validateNumber(Integer.parseInt(number));
        return parsed;
    }

    private static void validateNumber(Integer number) {
        if (number < 0) throw new RuntimeException(NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
    }

    private static Integer sum(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }

    private static String[] split(String rawString) {
        Matcher m = Pattern.compile(CUSTOM_REGEX).matcher(rawString);

        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return rawString.split(REGEX);
    }
}
