package com.byazt.rj;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1628, 37})
public final class pr<T> implements BlockingQueue<T> {
    public final BlockingQueue<T> pr;

    public pr(BlockingQueue blockingQueue) {
        if (blockingQueue == null) {
            this.pr = new SynchronousQueue();
        } else {
            this.pr = blockingQueue;
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public T take() throws InterruptedException {
        return this.pr.take();
    }

    @Override // java.util.concurrent.BlockingQueue
    public T poll(long j, TimeUnit timeUnit) throws InterruptedException {
        try {
            return this.pr.poll(j, timeUnit);
        } catch (IllegalMonitorStateException e) {
            return null;
        }
    }

    public final String pr() {
        return this.pr.getClass().getName();
    }

    public final BlockingQueue hw() {
        return this.pr;
    }

    public int hn() {
        return this.pr.size();
    }

    @Override // java.util.Collection
    public final int size() {
        return hn();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Queue, java.util.Collection
    public boolean add(T t) {
        return this.pr.add(t);
    }

    @Override // java.util.Collection
    public boolean addAll(Collection collection) {
        return this.pr.addAll(collection);
    }

    @Override // java.util.Collection
    public void clear() {
        this.pr.clear();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection
    public boolean contains(Object obj) {
        return this.pr.contains(obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection collection) {
        return this.pr.containsAll(collection);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection collection) {
        return this.pr.drainTo(collection);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection collection, int i) {
        return this.pr.drainTo(collection, i);
    }

    @Override // java.util.Queue
    public T element() {
        return this.pr.element();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.pr.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return this.pr.iterator();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Queue
    public boolean offer(T t) {
        return this.pr.offer(t);
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(T t, long j, TimeUnit timeUnit) throws InterruptedException {
        return this.pr.offer(t, j, timeUnit);
    }

    @Override // java.util.Queue
    public T peek() {
        return this.pr.peek();
    }

    @Override // java.util.Queue
    public T poll() {
        return this.pr.poll();
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(T t) throws InterruptedException {
        this.pr.put(t);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return this.pr.remainingCapacity();
    }

    @Override // java.util.Queue
    public T remove() {
        return this.pr.remove();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection
    public boolean remove(Object obj) {
        return this.pr.remove(obj);
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection collection) {
        return this.pr.removeAll(collection);
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection collection) {
        return this.pr.retainAll(collection);
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return new Object[0];
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length > 0) {
            tArr[0] = null;
        }
        return tArr;
    }
}
