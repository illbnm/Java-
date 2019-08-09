package src.AQS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyLock implements Lock {

    private Helper helper = new Helper();

    private class Helper extends AbstractQueuedLongSynchronizer {
        //获取锁
        @Override
        protected boolean tryAcquire(long arg) {// arg 表示自己定义的增加量
            long state = getState();

            if (state == 0) {
                // 利用CAS原理修改state
                if (compareAndSetState(0, arg)) {
                    //设置当前线程占有资源
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
            } else if (getExclusiveOwnerThread() == Thread.currentThread()) {
                setState(getState() + arg);

            }


            return false;
        }

        // 释放锁

        @Override
        protected boolean tryRelease(long arg) {
            long state = getState() - arg;
            boolean flag = false;
            //判断释放后是否为 0
            if (state == 0) {
                setExclusiveOwnerThread(null);
                setState(state);
                return true;
            }

            setState(state); // 没有线程安全问题,重入性问题
            return false;
        }


        public Condition newConditionObject() {
            return new ConditionObject();
        }
    }

    @Override
    public void lock() {
        helper.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        helper.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {

        return helper.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return helper.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        helper.release(1);
    }

    @Override
    public Condition newCondition() { // 条件对象


        return helper.newConditionObject();
    }
}
