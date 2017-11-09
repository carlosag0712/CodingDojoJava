package codingDojo.StringManipulation;

/**
 * Created by carlosarosemena on 2017-10-31.
 */
public class StringManipulation {
    public String trimAndConcat(String str1, String str2){
        String trimmedconcated = "";
        trimmedconcated = str1.trim()+str2.trim();
        return trimmedconcated;
    }

    public Integer getIndexOrNull(String word, char letter){
        int index = word.indexOf(letter);

        if(index == -1){
            return null;
        }else{
            return  index;
        }

    }

    public Integer getIndexOrNull(String str1, String str2){
        int index = str1.indexOf(str2);

        if(index ==-1){
            return null;
        }else{
            return index;
        }
    }

    public String concatSubString(String str1, int int1, int int2, String str2){
        String  substring = str1.substring(int1,int2);
        return substring + str2;
    }
}
