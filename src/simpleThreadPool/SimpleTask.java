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

        System.out.println(Thread.currentThread() + "this is a simple task");

    }

}
