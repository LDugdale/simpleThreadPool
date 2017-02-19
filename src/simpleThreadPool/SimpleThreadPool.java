package simpleThreadPool;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author Laurie Dugdale
 */
public class SimpleThreadPool implements ISimpleThreadPool{

    LinkedBlockingDeque<ISimpleTask> taskQueue;
    Set<ISimplePoolThread> poolThreadSet;

//    "SimpleThreadPool manages a queue of ISimpleTask(s) and a set of ISimplePoolThread(s). In start(), " +
//    "your program is expected to start anumber of SimplePoolThread and initialize your task queue. " +
//    "In addTask(), you put the task to your queue."

    public SimpleThreadPool(){
        taskQueue = new LinkedBlockingDeque<>();
        poolThreadSet = new HashSet<>();
    }


    /**
     *
     */
    public void start() {
        //poolThreadSet.forEach(t -> t.run());
        for(ISimplePoolThread thread : poolThreadSet){

            thread.run();
        }

    }

    /**
     *
     */
    public void stop() {
       // poolThreadSet.forEach(t -> t.wait());
    }

    /**
     *
     * @param task The task to be added to the queue
     */
    public void addTask(ISimpleTask task) {

        try {

            this.taskQueue.put(task);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }


    }
















//    private List<PoolThread> threads = new ArrayList<PoolThread>();
//    private boolean isStopped = false;
//
//    public ThreadPool(int noOfThreads, int maxNoOfTasks){
//        taskQueue = new BlockingQueue(maxNoOfTasks);
//
//        for(int i=0; i<noOfThreads; i++){
//            threads.add(new PoolThread(taskQueue));
//        }
//        for(PoolThread thread : threads){
//            thread.start();
//        }
//    }
//
//    public synchronized void  execute(Runnable task) throws Exception{
//        if(this.isStopped) throw
//                new IllegalStateException("ThreadPool is stopped");
//
//        this.taskQueue.enqueue(task);
//    }
//
//    public synchronized void stop(){
//        this.isStopped = true;
//        for(PoolThread thread : threads){
//            thread.doStop();
//        }
//    }










//    private Thread[] threads = new Thread[6];
//    /**
//     * #1. Initialize your queue (or do so in somewhere)
//     * #2. Starts some ISimplePoolThreads.
//     */
//    public void start() {
//        for (int i = 0; i < threads.length; i++) {
//            //threads[i] = (new Thread(new SimplePoolThread(tasksQ)).start());
//            this.threads[i] = (new Thread(new SimplePoolThread(this.tasksQ))); // init the threads
//            this.threads[i].start();         // start the workers
//        }
//    }
//
//    /**
//     * #1. Stops everything
//     */
//    public void stop() {
//        for (int i = 0; i < threads.length; i++) {
//            //Thread.currentThread().interrupt();
//            this.threads[i].interrupt(); // safely calls interrupt on the threads in order for them to stop
//        }
//    }
//
//    /**
//     * #1. Add a task to your queue.
//     */
//    public void addTask(ISimpleTask task) {
//        // add a task to be performed
//        try {
//            this.tasksQ.put(task);
//        } catch (InterruptedException e) {
//            System.err.println("Task could not be added");
//            e.printStackTrace();
//        }
//
//    }

}
