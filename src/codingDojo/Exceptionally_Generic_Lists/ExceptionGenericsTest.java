package codingDojo.Exceptionally_Generic_Lists;

import java.util.ArrayList;

public class ExceptionGenericsTest {

    public static void main(String[] args) {
        ArrayList<Object> myList = new ArrayList();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye world");

        for(int i=0;i<myList.size();i++){
            try{
                Integer castedValue = (Integer)myList.get(i);
                myList.set(i,castedValue);
            } catch (ClassCastException e){
                System.out.println("ERROR IN INDEX #"+i);
                System.out.println("Value: "+myList.get(i));
                System.out.println("Error Message: "+ e.getMessage());
            }

        }




    }

}
