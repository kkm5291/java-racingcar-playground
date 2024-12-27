package racing;

public class ValidationUtils {

    public static final int NAME_LIMIT_LENGTH = 5;

    public static boolean nameValidation(String name) {
        if (name.length() > NAME_LIMIT_LENGTH) {
            throw new RuntimeException("이름은 5글자 이하만 가능합니다");
        }
        return true;
    }
}
