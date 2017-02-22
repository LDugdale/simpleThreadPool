package simpleThreadPool;

/**
 * @author Laurie Dugdale
 */
public class SimpleTask implements ISimpleTask {


    @Override
    /**
     *
     */
    public void run() {

        System.out.println("this is a simple task from the thread called : " + Thread.currentThread());

    }

    public static void main(String args[]) throws InterruptedException {
        // Initialize thread pool
        SimpleThreadPool pool = new SimpleThreadPool();
        pool.start();
        // Create 20 tasks
        for(int i = 1; i<=4; i++){

            pool.addTask(new SimpleTask());
            Thread.sleep(3000);
        }
        pool.stop();
    }

}
