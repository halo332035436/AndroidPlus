package com.halo332035436.jdk;

public class GCRootStaticVariable {

    private static int _10MB = 10 * 1024 * 1024;
    private byte[] memory;
    private static GCRootStaticVariable staticVariable;

    public GCRootStaticVariable(int size) {
        memory = new byte[size];
    }

    public static void main(String[] args) {
        System.out.println("start:");
        printMemory();
        GCRootStaticVariable g = new GCRootStaticVariable(4 * _10MB);
        g.staticVariable = new GCRootStaticVariable(8 * _10MB);
        // 将g置为null, 调用GC时可以回收此对象内存
        g = null;
        System.gc();
        System.out.println("GC完成");
        printMemory();
    }

    public static void printMemory() {
        System.out.print("free is " + Runtime.getRuntime().freeMemory() / 1024 / 1024 + " M, ");
        System.out.println("total is " + Runtime.getRuntime().totalMemory() / 1024 / 1024 + " M, ");
    }

}

