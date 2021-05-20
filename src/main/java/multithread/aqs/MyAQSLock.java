package multithread.aqs;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * @author admin
 * @date 2020/4/10 20:51
 */
public class MyAQSLock {

    private volatile int state = 0;
    private Thread lockHolder;
    private ConcurrentLinkedQueue<Thread> queue = new ConcurrentLinkedQueue<>();

    private static final Unsafe unsafe = reflectUnsafe();

    private static long startOffset;

    static {
        try {
            startOffset = unsafe.objectFieldOffset(MyAQSLock.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public boolean compareAndSwapState(int expect,int update){
        return unsafe.compareAndSwapInt(this,startOffset,expect,update);
    }

    public boolean tryAcquire(){
        Thread current = Thread.currentThread();
        int state = getState();
        if (state==0) {
            if((queue.size() == 0 || current == queue.peek()) && compareAndSwapState(0,1)){
                setLockHolder(current);
                return true;
            }
        }
        return false;
    }

    /**
     * 加锁
     */
    public void lock(){
        //获取锁
        if (tryAcquire()) {
            return;
        }
        Thread current = Thread.currentThread();
        queue.add(current);
        //停留在此方法
        for (;;){
            if (current == queue.peek() && tryAcquire()) {
                System.out.println("hold lock thread:"+current.getName());
                queue.poll();
                break;
            }

            LockSupport.park(current);
        }

    }

    /**
     * 释放锁
     */
    public void unlock(){
        Thread current = Thread.currentThread();
        if(current != lockHolder){
            throw new RuntimeException("你不是持有锁的线程，无法释放锁");
        }
        int state = getState();
        if (compareAndSwapState(state,0)) {
            System.out.println("线程"+current.getName()+"释放成功");
            setLockHolder(null);
            Thread first = queue.peek();
            if (first != null) {
                LockSupport.unpark(first);
            }

        }


    }


    public static Unsafe reflectUnsafe() {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            return (Unsafe)theUnsafe.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Thread getLockHolder() {
        return lockHolder;
    }

    public void setLockHolder(Thread lockHolder) {
        this.lockHolder = lockHolder;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


}
