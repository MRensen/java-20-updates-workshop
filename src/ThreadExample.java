public class ThreadExample {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++){
            Thread thread = new Thread(()->{
                for (int j = 0; j < 5; j++){
                    String n = Thread.currentThread().getName();
                    System.out.println(n + " = " + j);
                }
            }, "Thread"+i);
            thread.start();
        }
    }
    public static void printTreadAndNumber(){

    }
}


