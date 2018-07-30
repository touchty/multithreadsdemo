package touchty.runnable;

public class MyRunnable implements Runnable  {
    @Override
    public void run() {

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Run inside MyRunnable!");
    }

    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new MyRunnable());
        t.start();
        //t.join();
        System.out.println("End of main");
    }
}
