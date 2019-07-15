package com.lcclovehww.readwritelock;

/**
 * @author lcc
 * @date 2019/7/15 - 9:01
 */
public final class ReadWriteLock {

    private int readingReaders = 0; //实际正在读取中的线程个数
    private int waitingWriters = 0; //正在等待写入的线程个数
    private int writingWriters = 0; //
    private boolean preferWriter = true; //若写入优先， 则为true

    public synchronized void readLock() throws InterruptedException {
        while (writingWriters > 0 || (preferWriter && waitingWriters > 0)) {
//        while (writingWriters > 0 || (waitingWriters > 0)) {
            wait();
        }
        readingReaders++;
    }

    public synchronized void readUnlock() {
        readingReaders--;//实际正在写入中的线程个数
        preferWriter = true;
        notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        waitingWriters++;
        try {
            while (readingReaders > 0 || writingWriters > 0) {
                wait();
            }
        } finally {
            waitingWriters--;
        }
        writingWriters++;
    }

    public synchronized void writeUnlock() {
        writingWriters--;
        preferWriter = false;
        notifyAll();
    }


}
