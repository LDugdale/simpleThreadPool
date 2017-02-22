package simpleThreadPool;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Laurie Dugdale
 */
public class SimpleThreadPool implements ISimpleThreadPool{

    private LinkedBlockingQueue<ISimpleTask> taskQueue; // the task queue
    private Thread[] threads; // array of threads
    private int numOfThreads = 6; // set the number of threads

    /**
     * Constructor initializes the Queue and array
     */
    public SimpleThreadPool(){

        taskQueue = new LinkedBlockingQueue<>();
        threads = new Thread [numOfThreads];
    }

    @Override
    /**
     *  Starts some ISimplePoolThreads.
     */
    public void start() {

        for (int i = 0; i < numOfThreads; i++) {

            threads[i] = new Thread(new SimplePoolThread(taskQueue));
            threads[i].start();
        }
    }

    /**
     * Stops everything
     */
    public synchronized void stop(){

        try {

            // wait before stopping so threads run
            Thread.sleep(2000);

            for (int i = 0; i < numOfThreads; i++) {

                threads[i].interrupt();
            }

        } catch (InterruptedException e) {

            e.printStackTrace();
        }

    }

    @Override
    /**
     * Add a task to the taskQueue
     *
     * @param task The task to be added to the thread pool
     */
    public void addTask(ISimpleTask task) {

        try {

            this.taskQueue.put(task);
        } catch (InterruptedException e) {

            System.err.println("Tasks interrupted :" + e.getMessage());
        }
    }
}