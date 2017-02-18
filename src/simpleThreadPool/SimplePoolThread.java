package simpleThreadPool;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Laurie Dugdale
 */
public class SimplePoolThread implements ISimplePoolThread {

    private LinkedBlockingQueue<ISimpleTask> queue = new LinkedBlockingQueue<>();

    public SimplePoolThread(LinkedBlockingQueue<ISimpleTask> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                queue.take().run();
            } catch (InterruptedException e) {
                System.err.println("Tasks interrupted");
                e.printStackTrace();
                break;
            }
        }
    }
}
