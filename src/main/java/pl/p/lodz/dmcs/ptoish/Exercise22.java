package pl.p.lodz.dmcs.ptoish;

import java.time.Instant;
import java.util.*;

public class Exercise22 {
    private static Random random = new Random(Instant.now().getNano());

    public static void main(String[] args) {
        System.out.println("Exercise 2.2");
        List<Integer> list10 = createRandomList(10);
        List<Integer> list100 = createRandomList(100);
        List<Integer> list1000 = createRandomList(1000);
        List<Integer> list10000 = createRandomList(10000);

        System.out.println("List");
        System.out.println("Adding");
        System.out.println("10");
        testListAdding(list10);
        System.out.println("100");
        testListAdding(list100);
        System.out.println("1000");
        testListAdding(list1000);
        System.out.println("10000");
        testListAdding(list10000);

        System.out.println("Removing");
        System.out.println("10");
        testListRemoving(list10);
        System.out.println("100");
        testListRemoving(list100);
        System.out.println("1000");
        testListRemoving(list1000);
        System.out.println("10000");
        testListRemoving(list10000);

        System.out.println("Browsing");
        System.out.println("10");
        testListBrowsing(list10);
        System.out.println("100");
        testListBrowsing(list100);
        System.out.println("1000");
        testListBrowsing(list1000);
        System.out.println("10000");
        testListBrowsing(list10000);

        Deque<Integer> deque10 = createRandomDeque(10);
        Deque<Integer> deque100 = createRandomDeque(100);
        Deque<Integer> deque1000 = createRandomDeque(1000);
        Deque<Integer> deque10000 = createRandomDeque(10000);

        System.out.println("Queue");
        System.out.println("Adding");
        System.out.println("10");
        testDequeAdding(deque10);
        System.out.println("100");
        testDequeAdding(deque100);
        System.out.println("1000");
        testDequeAdding(deque1000);
        System.out.println("10000");
        testDequeAdding(deque10000);

        System.out.println("Removing");
        System.out.println("10");
        testDequeRemoving(deque10);
        System.out.println("100");
        testDequeRemoving(deque100);
        System.out.println("1000");
        testDequeRemoving(deque1000);
        System.out.println("10000");
        testDequeRemoving(deque10000);

        System.out.println("Browsing");
        System.out.println("10");
        System.out.println("Iterator");
        MyBenchmark.printTimeMultiple(() -> browseDequeElementsIterator(deque10));
        System.out.println("100");
        System.out.println("Iterator");
        MyBenchmark.printTimeMultiple(() -> browseDequeElementsIterator(deque100));
        System.out.println("1000");
        System.out.println("Iterator");
        MyBenchmark.printTimeMultiple(() -> browseDequeElementsIterator(deque1000));
        System.out.println("10000");
        System.out.println("Iterator");
        MyBenchmark.printTimeMultiple(() -> browseDequeElementsIterator(deque10000));
    }

    private static void testDequeAdding(Deque<Integer> deque) {
        System.out.println("Begin");
        MyBenchmark.printTimeMultiple(() -> addDequeElementsBegin(deque));
        System.out.println("End");
        MyBenchmark.printTimeMultiple(() -> addDequeElementsEnd(deque));
    }

    private static void testDequeRemoving(Deque<Integer> deque10) {
        System.out.println("Begin");
        MyBenchmark.printTimeMultiple(() -> removeDequeElementsBegin(deque10));
        System.out.println("End");
        MyBenchmark.printTimeMultiple(() -> removeDequeElementsEnd(deque10));
    }

    private static void testListBrowsing(List<Integer> list) {
        System.out.println("Index");
        MyBenchmark.printTimeMultiple(() -> browseListElementsIndex(list));
        System.out.println("Iterator");
        MyBenchmark.printTimeMultiple(() -> browseListElementsIterator(list));
    }

    private static void testListRemoving(List<Integer> list10) {
        System.out.println("Begin");
        MyBenchmark.printTimeMultiple(() -> removeListElementsBegin(list10));
        System.out.println("End");
        MyBenchmark.printTimeMultiple(() -> removeListElementsEnd(list10));
        System.out.println("Random");
        MyBenchmark.printTimeMultiple(() -> removeListElementsRandom(list10));
    }

    private static void testListAdding(List<Integer> list) {
        System.out.println("Begin");
        MyBenchmark.printTimeMultiple(() -> addListElementsBegin(list));
        System.out.println("End");
        MyBenchmark.printTimeMultiple(() -> addListElementsEnd(list));
        System.out.println("Random");
        MyBenchmark.printTimeMultiple(() -> addListElementsRandom(list));
    }

    private static List<Integer> createRandomList(long size) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (list.size() < size) {
            list.add(i++);
        }
        return list;
    }

    private static void addListElementsBegin(List<Integer> list) {
        list.add(0, 42424242);
    }

    private static void addListElementsEnd(List<Integer> list) {
        list.add(list.size() - 1, 42424242);
    }

    private static void addListElementsRandom(List<Integer> list) {
        list.add(Math.abs(random.nextInt() % list.size()), 42424242);
    }

    private static void removeListElementsBegin(List<Integer> list) {
        list.remove(0);
    }

    private static void removeListElementsEnd(List<Integer> list) {
        list.remove(list.size() - 1);
    }

    private static void removeListElementsRandom(List<Integer> list) {
        list.remove(Math.abs(random.nextInt() % list.size()));
    }

    private static void browseListElementsIterator(List<Integer> list) {
        Integer x = 0;
        for (Integer number : list) {
            x = number;
        }
    }

    private static void browseListElementsIndex(List<Integer> list) {
        Integer x = 0;
        for (int i = 0; i < list.size(); i++) {
            x = list.get(i);
        }
    }

    private static Deque<Integer> createRandomDeque(long size) {
        Deque<Integer> queue = new ArrayDeque<>();
        int i = 0;
        while (queue.size() < size) {
            queue.add(i++);
        }
        return queue;
    }

    private static void addDequeElementsBegin(Deque<Integer> queue) {
        queue.addFirst(42424242);
    }

    private static void addDequeElementsEnd(Deque<Integer> queue) {
        queue.addLast(42424242);
    }

    private static void removeDequeElementsBegin(Deque<Integer> queue) {
        queue.removeFirst();
    }

    private static void removeDequeElementsEnd(Deque<Integer> queue) {
        queue.removeLast();
    }

    private static void browseDequeElementsIterator(Deque<Integer> queue) {
        Integer x = 0;
        for (Integer number : queue) {
            x = number;
        }
    }
}
