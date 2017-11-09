package codingDojo.Puzzling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class PuzzleJava {

    public void arraySum(int arr[]){
        int sumOfArr = 0;
        for(int i=0; i<arr.length;i++){
            sumOfArr += arr[i];

        }
        System.out.println(sumOfArr);
    }

    public ArrayList<Integer> greaterThan10(int arr[]){
        ArrayList<Integer> greaterThan10Arr = new ArrayList<>();

        for(int i =0; i<arr.length;i++){
            if(arr[i]>10){
                greaterThan10Arr.add(arr[i]);

            }
        }

        return greaterThan10Arr;

    }

    public void printStrArray(String [] strArr){

        for(int i=0; i<strArr.length; i++){
            System.out.println(strArr[i]);
        }

    }

    public ArrayList<String> greaterThan5(String[] strArr){

        ArrayList<String> greaterThan5 = new ArrayList<>();

        for(int i=0;i<strArr.length;i++){
            if(strArr[i].length()>5){
                greaterThan5.add(strArr[i]);
            }
        }

        return greaterThan5;
    }

    public void lastletter(String []strArr){

        String vowels[]={"A","E","I","O","U"};
        String first = strArr[0];
        int count = 0;
        for(int i=0;i<strArr.length;i++){
            count++;

        }

        System.out.println("1st letter of the array is: "+first);

        if(Arrays.asList(vowels).contains(first)){
            System.out.println("first letter is a vowel");
        }else{
            System.out.println("not a vowel");
        }

        System.out.println("Total letters in the alphabet: "+count);
        System.out.println("last letter in the alphabet: "+strArr[strArr.length-1]);

    }

    public ArrayList<Integer> get10NoOrder(){
        ArrayList<Integer> get10 = new ArrayList<>();

        Random randomNum = new Random();

        for(int i =0;i<10;i++){
            get10.add(randomNum.nextInt(101-55)+55);
        }

        return get10;

    }

    public ArrayList<Integer> get10Sorted(){
        ArrayList<Integer> get10 = new ArrayList<>();

        Random randomNum = new Random();

        for(int i =0;i<10;i++){
            get10.add(randomNum.nextInt(101-55)+55);
        }

        Collections.sort(get10);
        int max = get10.get(0);
        int min = get10.get(0);

        for(int i=0;i<get10.size();i++){
            if(get10.get(i)>max){
                max = get10.get(i);
            }

            if(get10.get(i)<min){
                min = get10.get(i);
            }
        }

        System.out.println("Largest random number is: "+max);
        System.out.println("Smallest random number is: "+min);

        return get10;

    }

    public String random5CharString(String [] strArr){
        String randomWord = "";

        Random randomIndex = new Random();

        for(int i=0; i<5;i++){
            randomWord = randomWord.concat(strArr[randomIndex.nextInt(strArr.length)]);
        }

        return randomWord;
    }

    public ArrayList<String> RandomString10(String[]alphabet){
        ArrayList<String> RandomString10 = new ArrayList<>();

        for(int i=0;i<10;i++){
            RandomString10.add(random5CharString(alphabet));
        }

        return RandomString10;

    }


}
