package simpleThreadPool;

/**
 * Created by laurie on 2/18/17.
 */
public class SimpleThreadPool implements ISimpleThreadPool{

    private boolean run;

    @Override
    public void start() {

    }

    @Override
    public void stop() {
        this.run = false;
    }

    @Override
    public void addTask(ISimpleTask task) {

        while(run){
            System.out.println("test");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
