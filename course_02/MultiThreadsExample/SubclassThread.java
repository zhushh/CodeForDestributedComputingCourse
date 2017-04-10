public class SubclassThread extends Thread {
    public void run() {
        while (true) {
            try {
                sleep(5*1000);
                break;
            } catch (InterruptedException ex) {
                // nothing to do
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new SubclassThread();
        thread.start();
        System.out.println("MainFunc end here.");
    }
}
