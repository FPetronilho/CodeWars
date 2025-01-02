package codewars.kyu6.breakcamelcase;

public class Main {

    public static void main(String[] args) {

        System.out.println(camelCase("souToloManolo"));
        System.out.println(camelCaseOptimized("souToloManolo"));
    }


    public static String camelCase(String input) {
        StringBuilder result = new StringBuilder();

        for (int i=0; i<input.length(); i++) {
            char c = input.charAt(i);

            if (Character.isUpperCase(c)) {
                result.append(" ");
            }

            result.append(c);
        }

        return result.toString();
    }

    public static String camelCaseOptimized(String input) {
        return input.replaceAll("([A-Z])", " $1");
    }
}
