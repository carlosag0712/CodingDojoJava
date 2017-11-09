package codingDojo.Puzzling;


public class PuzzleJavaTest {
    public static void main(String[] args) {

        PuzzleJava puja = new PuzzleJava();
        int [] arr1 = {3,5,1,2,7,9,8,13,25,32};

        puja.arraySum(arr1);
        System.out.println(puja.greaterThan10(arr1));

        String [] strArr = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
        puja.printStrArray(strArr);

        System.out.println(puja.greaterThan5(strArr));

        String [] strAlphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        puja.lastletter(strAlphabet);

        System.out.println(puja.get10NoOrder());
        System.out.println(puja.get10Sorted());

        System.out.println(puja.random5CharString(strAlphabet));

        System.out.println(puja.RandomString10(strAlphabet));


    }


}
