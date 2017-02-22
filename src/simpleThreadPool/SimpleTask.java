package simpleThreadPool;

/**
 * @author Laurie Dugdale
 */
public class SimpleTask implements ISimpleTask {


    @Override
    /**
     * The task to run
     */
    public void run() {

        System.out.println(Thread.currentThread() + " is currently performing a task");

    }

    public static void main(String args[]) throws InterruptedException {
        // Initialize thread pool
        SimpleThreadPool pool = new SimpleThreadPool();
        pool.start();
        // Create 20 tasks
        for(int i = 1; i<=2000; i++){

            pool.addTask(new SimpleTask());
            //Thread.sleep(3000);
        }
        pool.stop();
    }

}
