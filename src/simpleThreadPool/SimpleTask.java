package simpleThreadPool;

/**
 * @author Laurie Dugdale
 */
public class SimpleTask implements ISimpleTask {

    private int i;

    public SimpleTask(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " says: I wish I could sleep for " + i + " hour(s)");
    }

    public static void main(String args[]) {
        SimpleThreadPool pool = new SimpleThreadPool();
        pool.start();
        for (int i = 1; i <= 25; i++) {
            pool.addTask(new SimpleTask(i));
        }
    }
}
