package pl.p.lodz.dmcs.ptoish;

import java.util.Set;
import java.util.TreeSet;

public class Exercise21 {

    public static void main(String[] args) {
        System.out.println("Exercise 2.1");
        System.out.println("Set");
        Set<Integer> set10 = createRandomSet(10);
        Set<Integer> set100 = createRandomSet(100);
        Set<Integer> set1000 = createRandomSet(1000);
        Set<Integer> set10000 = createRandomSet(10000);
        System.out.println("Adding");
        System.out.println("10");
        MyBenchmark.printTimeMultiple(() -> addElements(set10));
        System.out.println("100");
        MyBenchmark.printTimeMultiple(() -> addElements(set100));
        System.out.println("1000");
        MyBenchmark.printTimeMultiple(() -> addElements(set1000));
        System.out.println("10000");
        MyBenchmark.printTimeMultiple(() -> addElements(set10000));

        System.out.println("Removing");
        System.out.println("10");
        MyBenchmark.printTimeMultiple(() -> removeElements(set10));
        System.out.println("100");
        MyBenchmark.printTimeMultiple(() -> removeElements(set100));
        System.out.println("1000");
        MyBenchmark.printTimeMultiple(() -> removeElements(set1000));
        System.out.println("10000");
        MyBenchmark.printTimeMultiple(() -> removeElements(set10000));


        System.out.println("Browsing");
        System.out.println("10");
        MyBenchmark.printTimeMultiple(() -> browseElements(set10));
        System.out.println("100");
        MyBenchmark.printTimeMultiple(() -> browseElements(set100));
        System.out.println("1000");
        MyBenchmark.printTimeMultiple(() -> browseElements(set1000));
        System.out.println("10000");
        MyBenchmark.printTimeMultiple(() -> browseElements(set10000));


        System.out.println("Containing");
        System.out.println("10");
        MyBenchmark.printTimeMultiple(() -> containElements(set10));
        System.out.println("100");
        MyBenchmark.printTimeMultiple(() -> containElements(set100));
        System.out.println("1000");
        MyBenchmark.printTimeMultiple(() -> containElements(set1000));
        System.out.println("10000");
        MyBenchmark.printTimeMultiple(() -> containElements(set10000));
    }

    private static Set<Integer> createRandomSet(long size) {
        Set<Integer> set = new TreeSet<>();
        int i = 0;
        while (set.size() < size) {
            set.add(i++);
        }
        return set;
    }

    private static void addElements(Set<Integer> set) {
        set.add(42424242);
    }

    private static void removeElements(Set<Integer> set) {
        set.remove(42424242);
    }

    private static void containElements(Set<Integer> set) {
        set.contains(42424242);
    }

    private static void browseElements(Set<Integer> set) {
        Integer x = 0;
        for (Integer number : set) {
            x = number;
        }
    }
}
