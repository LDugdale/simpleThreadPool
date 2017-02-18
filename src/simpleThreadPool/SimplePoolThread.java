package simpleThreadPool;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Laurie Dugdale
 */
public class SimplePoolThread implements ISimplePoolThread {

    private LinkedBlockingQueue<ISimpleTask> tasksQ = new LinkedBlockingQueue<>();

    public SimplePoolThread(LinkedBlockingQueue<ISimpleTask> tasksQ) {
        this.tasksQ = tasksQ;
    }

    @Override
    public void run() {
        while (true) {
            try {
                tasksQ.take().run();
            } catch (InterruptedException e) {
                System.err.println("Tasks interrupted");
                e.printStackTrace();
                break;
            }
        }
    }
}
