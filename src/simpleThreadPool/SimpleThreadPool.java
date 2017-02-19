package simpleThreadPool;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Laurie Dugdale
 */
public class SimpleThreadPool implements ISimpleThreadPool{

    LinkedBlockingQueue<ISimpleTask> taskQueue;
//    Set<Thread> poolThreadSet;
    private Thread[] threads = new Thread[30];

//    SimpleThreadPool manages a queue of ISimpleTask(s) and a set of ISimplePoolThread(s). In start(),
//    your program is expected to start anumber of SimplePoolThread and initialize your task queue.
//    In addTask(), you put the task to your queue.

    public SimpleThreadPool(){
        taskQueue = new LinkedBlockingQueue<>();
//        threads = new HashSet<>();
    }


    /**
     *
     */
    public void start() {
        //poolThreadSet.forEach(t -> t.run());
        for(Thread thread : threads) {
            thread = new Thread(new SimplePoolThread(this.taskQueue));
            thread.start();
        }
    }

    /**
     *
     */
    public void stop() {

        for(Thread thread : threads) {
            thread.interrupt();
        }
    }

    /**
     *
     * @param task The task to be added to the queue
     */
    public void addTask(ISimpleTask task) {

        try {

            taskQueue.put(task);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

}
