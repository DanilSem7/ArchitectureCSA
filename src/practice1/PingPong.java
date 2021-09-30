package practice1;

class PingPongThread implements Runnable{
    private Object LOCK_OBJECT;
    private String name;
    boolean runner = true;
    public PingPongThread(Object LOCK_OBJECT, String name) {
        this.LOCK_OBJECT = LOCK_OBJECT;
        this.name = name;
    }
    @Override
    public void run() {

        while(runner){
            System.out.println(name);
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

public class PingPong {
    public static void main(String[] args) throws  InterruptedException {
        Object LOCK_OBJECT = new Object();

        PingPongThread ping = new PingPongThread(LOCK_OBJECT, "Ping");
        PingPongThread pong = new PingPongThread(LOCK_OBJECT, "Pong");

        Thread pinger = new Thread(ping);
        Thread ponger = new Thread(pong);

        pinger.start();
        ponger.start();

        ponger.sleep(1000);
        pong.runner =false;
        ponger.join();
        System.out.println("Поток 'Pong' остановлен");
    }
}