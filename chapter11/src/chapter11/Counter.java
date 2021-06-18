package chapter11;

public class Counter {

    protected long count = 0;

    public void add(long value){
        long count = this.count;
        System.out.println("Start add, counter is " + count);
        this.count = this.count + value;
        System.out.println("Finish add, counter is " + this.count + " but should " + (count + value));
    }
    
    public static void main(String[] args) {
        Counter c = new Counter();
        new Thread(() -> {while(true) { c.add(10); }}).start();
        new Thread(() -> {while(true) { c.add(100); }}).start();
    }
 }