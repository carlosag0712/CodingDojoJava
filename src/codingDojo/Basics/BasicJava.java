package codingDojo.Basics;

import java.util.ArrayList;

/**
 * Created by carlosarosemena on 2017-11-02.
 */


public class BasicJava {

    public void print1to255(){

        for(int i =1; i<=255;i++ ){
            System.out.println(i);
        }

    }

    public void print1To255Odds(){
        for(int i=1; i<=255;i++){
            if(i%2!=0){
                System.out.println(i);
            }
        }
    }

    public void printSum(){
        int sum =0;
        for(int i=0; i<=255;i++){
              sum += i;
            System.out.println("New number: "+i+" Sum: "+sum);
        }
    }

    public void iterateArray(int[] array){
        for(int i =0;i< array.length;i++){
            System.out.println(array[i]);

        }
    }

    public void findMax(int[] array){
        int max  = array[0];

        for(int i = 1; i < array.length; i++){
            if(array[i]>max){
                max = array[i];
            }
        }
        System.out.println(max);
    }

    public void getAverage(int[] array){
        int sum = 0;
        int lengtharr = array.length;

        for(int i = 0; i<lengtharr;i++){
            sum += array[i];

        }

        System.out.println(sum/lengtharr);
    }

    public void arrayOfOdds(){
        ArrayList<Integer> arrayOdds = new ArrayList<>();

        for (int i =1; i<=255; i++){
            if(i%2 != 0){
                arrayOdds.add(i);
            }
        }
        System.out.println(arrayOdds);
    }

    public void greaterThanY(int y, int[]array){
        int greaterThanY = 0;

        for (int i=0; i<array.length;i++){
            if(array[i]>y){
                greaterThanY += 1;
            }
        }

        System.out.println(greaterThanY+" numbers are greater than "+y);

    }

    public void squareTheValues(int[]array){
        for(int i =1; i<array.length;i++){
            array[i] *= array[i];
        }

        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);

        }
    }

    public void eliminateNegNum(int[]array){
        for(int i=0; i<array.length;i++){
            if(array[i]<0){
                array[i]=0;
            }
        }

        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);

        }
    }

    public void MinMaxAvg(int[]arr){
        int max = arr[0];
        int min = arr[0];
        int sum = 0;

        for(int i=0; i<arr.length;i++){
            sum += arr[i];
            if(arr[i]>max){
                max = arr[i];
            }
            if(arr[i]<min){
                min = arr[i];
            }
        }

        int avg = sum / arr.length;

        int [] minmaxavg = {max,min,avg};

        for(int i=0;i<minmaxavg.length;i++){
            System.out.println(minmaxavg[i]);
        }
    }

    public void arrayShift(int[] arr){

        for(int i =0;i<arr.length-1;i++){
            arr[i]=arr[i+1];
        }

        arr[arr.length-1] = 0;

        for(int i =0;i<arr.length;i++){
            System.out.println(arr[i]);
        }


    }




}
