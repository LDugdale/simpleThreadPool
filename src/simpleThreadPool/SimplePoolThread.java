package simpleThreadPool;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Laurie Dugdale
 */
public class SimplePoolThread implements ISimplePoolThread {

    private LinkedBlockingQueue<ISimpleTask> taskQueue = new LinkedBlockingQueue<>();

    /**
     *
     * @param taskQueue
     */
    public SimplePoolThread(LinkedBlockingQueue<ISimpleTask> taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    /**
     *
     */
    public void run() {

        while (true) {

            try {

                taskQueue.take().run();
            } catch (InterruptedException e) {

                System.err.println("Tasks interrupted :" + e.getMessage());
                break;
            }
        }
    }
}
