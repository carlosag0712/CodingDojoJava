package codingDojo.StringManipulation;

/**
 * Created by carlosarosemena on 2017-10-31.
 */
public class StringManipulationTest {
    public static void main(String[] args) {
        StringManipulation smtc = new StringManipulation();
        String trimmedconcated = smtc.trimAndConcat("  Hell0   ", "   Carlos   ");
        System.out.println(trimmedconcated);

        StringManipulation gidx = new StringManipulation();
        Integer index = gidx.getIndexOrNull("Carlos", 'x');
        System.out.println(index);

        StringManipulation gidx2 = new StringManipulation();
        Integer index2 = gidx2.getIndexOrNull("Carlos", "losx");
        System.out.println(index2);

        StringManipulation consub = new StringManipulation();
        String newword = consub.concatSubString("Carlos",0,1,"Arosemena");
        System.out.println(newword);

    }

}
