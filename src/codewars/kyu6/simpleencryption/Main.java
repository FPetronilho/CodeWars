package codewars.kyu6.simpleencryption;

public class Main {

    public static void main(String[] args) {

        System.out.println(encrypt("01234", 3));
        System.out.println(decrypt("20314", 3));
    }

    public static String encrypt(final String text, final int n) {
        if (text == null || n <= 0) {
            return text;
        }

        String[] textArray = text.split("");
        int count = 0;

        while (count < n) {
            String[] modified = new String[textArray.length];
            for (int i=0, oddIndex=0, evenIndex=modified.length/2; i<modified.length; i++) {
                if (i%2 != 0) {
                    modified[oddIndex++] = textArray[i];
                } else {
                    modified[evenIndex++] = textArray[i];
                }
            }

            count++;
            textArray = modified;
        }

        return String.join("", textArray);
    }

    public static String decrypt(final String encryptedText, final int n) {
        if (encryptedText == null || n <= 0) {
            return encryptedText;
        }

        String[] textArray = encryptedText.split("");
        int count = 0;

        while (count < n) {
            String[] modified = new String[textArray.length];
            for (int i=0, oddIndex=0, evenIndex=modified.length/2; i<modified.length; i++) {
                if (i%2 == 0) {
                    modified[i] = textArray[evenIndex++];
                } else {
                    modified[i] = textArray[oddIndex++];
                }
            }

            count++;
            textArray = modified;
        }

        return String.join("", textArray);
    }
}
