package tools;

public class WeightTools {
    public static Integer convertWeightToStr(String str) {
        try {
            Integer weightInt = Integer.parseInt(str);
            if (weightInt < 1) {
                return null;
            }
            return weightInt;
        } catch (NumberFormatException ignore) {
            return null;
        }
    }
}

