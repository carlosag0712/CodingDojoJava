package codingDojo.FizzBuzz;

/**
 * Created by carlosarosemena on 2017-10-31.
 */
public class FizzBuzz {
    public String fizzBuzz(int num){
        String message = "";

        if(num%3==0 && num%5==0){
            message = "Fizz";
        } else if(num%5==0){
            message = "Buzz";
        }else if(num%3==0){
            message = "FizzBuzz";
        }else{


            message = String.valueOf(num) ;
        }

        return message;
    }
}
