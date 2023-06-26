package tools;

public class AgeTools {

    public static Integer convertStrToInt(String str) {
        try {
            Integer ageInt = Integer.parseInt(str);
            if(ageInt < 0) {
                return null;
            }
            return ageInt;
        } catch(NumberFormatException ignore) {
            return null;
        }
    }
}


