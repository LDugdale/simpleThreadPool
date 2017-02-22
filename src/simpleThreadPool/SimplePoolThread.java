package simpleThreadPool;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Laurie Dugdale
 */
public class SimplePoolThread implements ISimplePoolThread {

    private LinkedBlockingQueue<ISimpleTask> taskQueue = new LinkedBlockingQueue<ISimpleTask>();


    /**
     * Constructor takes an ISimpleTask
     *
     * @param taskQueue
     */
    public SimplePoolThread(LinkedBlockingQueue<ISimpleTask> taskQueue) {

        this.taskQueue = taskQueue;
    }

    /**
     * Use an infinite loop to retrieve and perform tasks.
     */
    public void run(){

        // Loop isStopped boolean is false
        while(true){
            try {

                taskQueue.take().run();
            } catch (InterruptedException e) {

                System.out.println("Thread interrupted");
                break;
            }
        }
    }

}
