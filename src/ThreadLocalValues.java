public class ThreadLocalValues {

    public static void main(String[] args) {
        final ThreadLocal<String> myValue = new ThreadLocal<>();
//        myValue.set("MAIN");
        System.out.println("Thread " + Thread.currentThread().getName() + " = "+myValue.get());
//        myValue.remove();

        Thread thread1 = new Thread(()->{
//            myValue.set("FIRST");
            System.out.println("Thread " + Thread.currentThread().getName() + " = " + myValue.get());
        }, "FirstThread");

        Thread thread2 = new Thread(()->{
//            myValue.set("SECOND");
            System.out.println("Thread " + Thread.currentThread().getName() + " = " + myValue.get());
        }, "SecondThread");
        thread1.start();
        thread2.start();
        System.out.println("Thread " + Thread.currentThread().getName() + " = "+myValue.get() + " (second call)");
    }

}
