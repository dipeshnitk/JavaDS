package java8;

import java.util.Arrays;

/**
 * Created by Dipesh Gupta on 3/8/2016.
 */
public class SumReduceOperation {

    public static void main(String[] args) {
        int sum= Arrays.asList(1,2,3,4,5).stream().reduce(0,Integer::sum);
        System.out.println("Sum="+ sum);
    }
}
