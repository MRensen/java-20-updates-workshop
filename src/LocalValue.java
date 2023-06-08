public class LocalValue{
    public static void alt(String[] args) {
        String myValue;
        myValue = "main";
        System.out.println("Main value ="+myValue);

        Thread thread1 = new Thread(()->{
            /*Dit geeft een compile error*/
//            myValue = "first";
            System.out.println("ThreadValue = "+myValue);
        },"thread");

        thread1.start();
    }

    public static void main(String[] args){
        MyString myValue;
        myValue = new MyString("main");
        System.out.println("Main value = "+myValue.getValue());

        Thread thread1 = new Thread(()->{
            /*Dit geeft geen compile error, maar is niet thread-safe*/
            myValue.setValue("Thread");
            System.out.println("ThreadValue = "+myValue.getValue());
        },"thread");

        System.out.println("Main value = "+myValue.getValue());
        thread1.start();
    }
    public static class MyString{
        String value;
        public MyString(String value){this.value=value;};

        public void setValue(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}