package com.FateenJmartFH;

import java.util.Vector;
import java.util.function.Function;

/**
 * Object Pool Thread is a pool of thread that will be running
 * @param <T> generic of any class could be run as a thread
 */

public class ObjectPoolThread<T> extends Thread{
    private boolean exitSignal = false;
    private Vector<T> objectPool = new Vector<T>();
    private Function<T,Boolean> routine;

    /**
     * Creates Object Pool Thread.
     * @param name The thread's name.
     * @param routine The function to be applied.
     */
    public ObjectPoolThread(String name, Function<T,Boolean> routine){
        super(name);
        this.routine = routine;
    }

    /**
     * Creates Object Pool Thread.
     * @param routine The function to be applied.
     */
    public ObjectPoolThread(Function<T,Boolean> routine){
        this.routine = routine;
    }

    public synchronized void add (T object){
        objectPool.add(object);
    }

    public synchronized void exit (){
        this.exitSignal = true;
    }

    public void run (){
        exitSignal = false;
        boolean test;
        synchronized (this){
            for(T object : this.objectPool) {
                test = routine.apply(object);
                if (!test){
                    this.objectPool.add(object);
                }else{
                    this.objectPool.remove(object);
                }
                while(this.objectPool.size() == 0){
                    try {
                        routine.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(exitSignal){
                    break;
                }
            }
        }

    }

    public int size (){
        return objectPool.size();
    }
}
