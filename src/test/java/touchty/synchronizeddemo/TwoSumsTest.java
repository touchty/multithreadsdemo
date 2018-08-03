package touchty.synchronizeddemo;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TwoSumsTest {
    private TwoSums twoSums = new TwoSums();

    @Test
    public void add() throws InterruptedException {
        Runnable task1 = () -> {
            twoSums.add(1, 1);
        };

        Runnable task2 = () -> {
            twoSums.add(2,2);
        };

        Runnable task3 = () -> {
            twoSums.add(3,3);
        };

        Thread t1 = new Thread(task1); t1.run();
        Thread t2 = new Thread(task2); t2.run();
        Thread t3 = new Thread(task3); t3.run();

        t1.join();
        t2.join();
        t3.join();

        int[] expected = new int[]{6, 6};
        int[] result = twoSums.getSums();

        Assert.assertArrayEquals(expected, result);

    }
}