package touchty.synchronizeddemo;

public class TwoSums {

    private int sum1 = 0;
    private int sum2 = 0;

    public void add(int val1, int val2){
        synchronized(this){
            this.sum1 += val1;
            this.sum2 += val2;
        }
    }
    public int[] getSums() {
        int[] res = new int[]{sum1, sum2};
        return res;
    }

}