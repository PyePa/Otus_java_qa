package tools;

public class WeightTools {
    public static Integer convertWeightToInt(String str) {
        try {
            Integer weightInt = Integer.parseInt(str);
            if (weightInt < 0) {
                return null;
            }
            return weightInt;
        } catch (NumberFormatException ignore) {
            return null;
        }
    }
}
