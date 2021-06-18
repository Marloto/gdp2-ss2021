import java.io.IOException;

public class StopExample implements Runnable {

    private boolean stopped;

    public void run() {
        while(!this.stopped) {
            System.out.println("Hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void setStop(boolean stopped) {
        this.stopped = stopped;
        
    }
    
    public static void main(String[] args) throws InterruptedException, IOException {
        StopExample target = new StopExample();
        Thread thread = new Thread(target);
        thread.setDaemon(true);
        thread.start();
        System.out.println("Started...");
        
//        System.in.read();
//        target.setStop(true);
        
        //thread.join(); // Blockierende Methode, wartet solange bis der Thread terminiert
        System.out.println("Finished...");
    }

}
