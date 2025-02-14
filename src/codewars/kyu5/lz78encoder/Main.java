package codewars.kyu5.lz78encoder;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("0A0B0C0D4E0F0G1B3D0E4B2D10A1E4A10D9A2C - Output" );
        System.out.println(encoder(
                "ABCDDEFGABCDEDBBDEAAEDAEDCDABC"
        ));

        System.out.println("ABCDDEFGABCDEDBBDEAAEDAEDCDABC - Output");
        System.out.println(decoder(
                "0A0B0C0D4E0F0G1B3D0E4B2D10A1E4A10D9A2C"
        ));
    }

    public static String encoder(String data) {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "");
        StringBuilder result = new StringBuilder();
        StringBuilder aux = new StringBuilder();

        for (int i=0; i<data.length(); i++) {
            aux.append(data.charAt(i));
            int index = 0;

            while (map.containsValue(aux.toString())) {
                i += 1;
                index = getMapKeyByValue(map, aux.toString());
                if (i == data.length()) {
                    result.append(index);
                    break;
                }

                aux.append(data.charAt(i));
            }

            if (i != data.length()) {
                result.append(index).append(data.charAt(i));
                map.put(map.size(), aux.toString());
                aux.setLength(0);
            }
        }

        return result.toString();
    }

    private static int getMapKeyByValue(Map<Integer, String> map, String value) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }

        return -1;
    }

    public static String decoder(String data) {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "");
        StringBuilder result = new StringBuilder();

        int i = 0;
        while (i < data.length()) {
            int index = 0;
            while (i < data.length() && Character.isDigit(data.charAt(i))) {
                index = index * 10 + (data.charAt(i) - '0');
                i++;
            }

            if (i == data.length()) {
                result.append(map.get(index));
                break;
            }

            char nextChar = data.charAt(i);
            i++;

            result.append(map.get(index)).append(nextChar);
            map.put(map.size(), map.get(index) + nextChar);
        }

        return result.toString();
    }
}
