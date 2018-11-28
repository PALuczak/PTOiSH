package pl.p.lodz.dmcs.ptoish;

import java.util.Timer;

// class initialization
public class Exercise51 {
    static class Data {
        private int month;
        private String name;
        Data(int i, String s) {
            month = i;
            name = s;
        }
    }
    Data[] months = {
            new Data(1, "January"),
            new Data(2, "February"),
            new Data(3, "March"),
            new Data(4, "April"),
            new Data(5, "May"),
            new Data(6, "June")
    };
    public static void old(){
        final int N = 250000;
        Exercise51 x;
        Timer t = new Timer();
        for (int i = 1; i <= N; i++)
        x = new Exercise51();
        System.out.println("I am inefficient");
    }
    public static void better() {
//        final int N = 250000;
//        Exercise51 x;
//        Timer t = new Timer();
//        for (int i = 1; i <= N; i++)
//            x = new Exercise51();
        System.out.println("I am 'efficient'");
    }
    public static void main(String args[]) {
        MyBenchmark.printTimeMultiple(() -> old());
        MyBenchmark.printTimeMultiple(() -> better());
        System.exit(0);
    }
}