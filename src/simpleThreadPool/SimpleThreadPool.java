package simpleThreadPool;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Laurie Dugdale
 */
public class SimpleThreadPool implements ISimpleThreadPool{

    private LinkedBlockingQueue<ISimpleTask> tasksQ = new LinkedBlockingQueue<>();
    private Thread[] threads = new Thread[6];



    public void start() {
        for (int i = 0; i < threads.length; i++) {
            //threads[i] = (new Thread(new SimplePoolThread(tasksQ)).start());
            this.threads[i] = (new Thread(new SimplePoolThread(this.tasksQ)));
            this.threads[i].start();
        }
    }

    public void stop() {
        for (int i = 0; i < threads.length; i++) {
            //Thread.currentThread().interrupt();
            this.threads[i].interrupt();
        }
    }

    public void addTask(ISimpleTask task) {

        try {
            this.tasksQ.put(task);
        } catch (InterruptedException e) {
            System.err.println("Task could not be added");
            e.printStackTrace();
        }

    }
}
