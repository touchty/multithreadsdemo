package touchty.lockdemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock
{
    // @Test
    public void test() throws Exception
    {
        final Lock lock = new ReentrantLock();
        lock.lock();


        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " interrupted.");
            }
        },"child thread -1");

        t1.start();
        Thread.sleep(1000);

        t1.interrupt();

        Thread.sleep(10000);
    }

    public static void main(String[] args) throws Exception
    {
        new TestLock().test();
    }
}