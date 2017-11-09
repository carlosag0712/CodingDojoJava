package codingDojo.Pythagorean;

import java.lang.Math;

/**
 * Created by carlosarosemena on 2017-10-31.
 */
public class PythagoreanTheorem {
    public double calculateHypotenuse(int legA, int legB){
        double a = legA * legB;
        double b = legB * legA;
        double c = Math.sqrt(a+b);

        return c;


    }
}
