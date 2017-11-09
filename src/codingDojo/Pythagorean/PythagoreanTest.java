package codingDojo.Pythagorean;

/**
 * Created by carlosarosemena on 2017-10-31.
 */
public class PythagoreanTest {
    public static void main(String[] args) {
        PythagoreanTheorem pt = new PythagoreanTheorem();
        double hyp = pt.calculateHypotenuse(3,4);
        System.out.println(hyp);

    }
}
