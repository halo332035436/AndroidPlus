package com.halo332035436.jdk;

public class GCRootThread {

    private int _10MB = 10 * 1024 * 1024;
    private byte[] memory = new byte[8 * _10MB];

    public static void main(String[] args) throws Exception {
        System.out.println("start:");
        printMemory();
        AsyncTask at = new AsyncTask(new GCRootThread());
        Thread thread = new Thread(at);
        thread.start();
        System.gc();
        System.out.println("main方法执行完毕，完成GC");
        printMemory();
        thread.join();
        at = null;
        System.gc();
        System.out.println("线程代码执行完毕，完成GC");
        printMemory();
    }

    public static void printMemory() {
        System.out.print("free  is  " + Runtime.getRuntime().freeMemory() / 1024 / 1024 + "  M,  ");
        System.out.println("total  is  " + Runtime.getRuntime().totalMemory() / 1024 / 1024 + "  M,  ");
    }

    private static class AsyncTask implements Runnable {

        private GCRootThread gcRootThread;

        public AsyncTask(GCRootThread gcRootThread) {
            this.gcRootThread = gcRootThread;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }

    }

}

