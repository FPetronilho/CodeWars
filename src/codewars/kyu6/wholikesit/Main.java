package codewars.kyu6.wholikesit;

public class Main {

    public static void main(String[] args) {

        System.out.println(whoLikesIt(
                "Alex", "Jacob", "Mark", "Max"
        ));

        System.out.println(whoLikesItOptimized(
                "Alex", "Jacob", "Mark", "Max"
        ));

        System.out.println(whoLikesItOptimized2(
                "Alex"
        ));
    }

    public static String whoLikesIt(String... names) {
        StringBuilder result = new StringBuilder();
        if (names.length == 0) {
            return "no one likes this";
        }

        if (names.length == 1) {
            result.append(names[0])
                    .append(" likes this");
            return result.toString();
        }

        if (names.length == 2) {
            result.append(names[0])
                    .append(" and ")
                    .append(names[1])
                    .append(" like this");
            return result.toString();
        }

        if (names.length == 3) {
            result.append(names[0])
                    .append(", ")
                    .append(names[1])
                    .append(" and ")
                    .append(names[2])
                    .append(" like this");
            return result.toString();
        }

        result.append(names[0])
                .append(", ")
                .append(names[1])
                .append(" and ")
                .append(String.valueOf(names.length - 2))
                .append(" others like this");
        return result.toString();
    }

    public static String whoLikesItOptimized(String... names) {
        final String template0 = "no one likes this";
        final String template1 = "%s likes this";
        final String template2 = "%s and %s like this";
        final String template3 = "%s, %s and %s like this";
        final String template4 = "%s, %s and %s others like this";

        return names.length == 0 ? template0 :
                names.length == 1 ? String.format(template1, names[0]) :
                        names.length == 2 ? String.format(template2, names[0], names[1]) :
                                names.length == 3 ? String.format(template3, names[0], names[1], names[2]) :
                                        String.format(template4, names[0], names[1], String.valueOf(names.length-2));
    }

    public static String whoLikesItOptimized2(String... names) {
        switch (names.length) {
            case 0: return "no one likes this";
            case 1: return String.format("%s likes this", names[0]);
            case 2: return String.format("%s and %s like this", names[0], names[1]);
            case 3: return String.format("%s, %s and %s like this", names[0], names[1], names[2]);
        }

         return String.format("%s, %s and %s others like this", names[0], names[1], String.valueOf(names.length-2));
    }
}
