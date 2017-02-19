package simpleThreadPool;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Laurie Dugdale
 */
public class SimpleThreadPool implements ISimpleThreadPool{

    private LinkedBlockingQueue<ISimpleTask> taskQueue;
    private Thread[] threads;
    private volatile boolean flag;

    /**
     * Empty constructor to initialize the field variables
     * Would prefer to pass an int that represented the requested size of the thread array
     */
    public SimpleThreadPool(){

        taskQueue = new LinkedBlockingQueue<>();
        this.threads = new Thread[4];
    }

    @Override
    /**
     *
     */
    public void start() {

        for (Thread thread : threads) {

            thread = new Thread(new SimplePoolThread(taskQueue));
            thread.start();
        }

    }

    @Override
    /**
     *
     */
    public void stop() {

        while (!taskQueue.isEmpty()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        flag = true;
        for (Thread thread: threads) {
            thread.interrupt();
        }
    }

    @Override
    /**
     *
     * @param task The task to be added to the queue
     */
    public void addTask(ISimpleTask task) {

        try {

            taskQueue.put(task);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted :" + e.getMessage());
        }
    }
}
