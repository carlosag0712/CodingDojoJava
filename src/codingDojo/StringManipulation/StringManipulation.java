package codingDojo.StringManipulation;

/**
 * Created by carlosarosemena on 2017-10-31.
 */
public class StringManipulation {
    public String trimAndConcat(String str1, String str2){
        String trimmedconcated = "";

        str1.trim();
        str2.trim();
        trimmedconcated = str1.concat(str2);
        return trimmedconcated;
    }
}
