package codewars.humanreadabletime;

public class Main {

    public static void main(String[] args) {
        System.out.println(makeReadable(86399));
        System.out.println(makeReadableOptimized(86399));
    }

    public static String makeReadable(int seconds) {
        int hours = seconds/3600;
        int minutes = seconds/60 - hours*60;
        int sec = seconds - minutes*60 - hours*3600;

        StringBuilder result = new StringBuilder();
        if (hours > 9) {
            result.append(hours);
        } else {
            result.append("0" + hours);
        }

        result.append(":");
        if (minutes > 9) {
            result.append(minutes);
        } else {
            result.append("0" + minutes);
        }

        result.append(":");
        if (sec > 9) {
            result.append(sec);
        } else {
            result.append("0" + sec);
        }

        return result.toString();
    }

    public static String makeReadableOptimized(int seconds) {
        return String.format("%02d:%02d:%02d", seconds/3600, (seconds/60)%60, seconds%60);
    }
}
