package com.bytedance.sdk.component.ch.ms;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class ms<T> implements BlockingQueue<T> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final BlockingQueue<T> f1225ms;

    @Override // java.util.Collection
    public Object[] toArray() {
        return new Object[0];
    }

    public ms(BlockingQueue blockingQueue) {
        if (blockingQueue == null) {
            this.f1225ms = new SynchronousQueue();
        } else {
            this.f1225ms = blockingQueue;
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public T take() throws InterruptedException {
        return this.f1225ms.take();
    }

    @Override // java.util.concurrent.BlockingQueue
    public T poll(long j, TimeUnit timeUnit) throws InterruptedException {
        try {
            return this.f1225ms.poll(j, timeUnit);
        } catch (IllegalMonitorStateException unused) {
            return null;
        }
    }

    public final String ms() {
        return this.f1225ms.getClass().getName();
    }

    public final BlockingQueue xr() {
        return this.f1225ms;
    }

    public int ah() {
        return this.f1225ms.size();
    }

    @Override // java.util.Collection
    public final int size() {
        return ah();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Queue, java.util.Collection
    public boolean add(T t) {
        return this.f1225ms.add(t);
    }

    @Override // java.util.Collection
    public boolean addAll(Collection collection) {
        return this.f1225ms.addAll(collection);
    }

    @Override // java.util.Collection
    public void clear() {
        this.f1225ms.clear();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection
    public boolean contains(Object obj) {
        return this.f1225ms.contains(obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection collection) {
        return this.f1225ms.containsAll(collection);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection collection) {
        return this.f1225ms.drainTo(collection);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection collection, int i) {
        return this.f1225ms.drainTo(collection, i);
    }

    @Override // java.util.Queue
    public T element() {
        return this.f1225ms.element();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f1225ms.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return this.f1225ms.iterator();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Queue
    public boolean offer(T t) {
        return this.f1225ms.offer(t);
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(T t, long j, TimeUnit timeUnit) throws InterruptedException {
        return this.f1225ms.offer(t, j, timeUnit);
    }

    @Override // java.util.Queue
    public T peek() {
        return this.f1225ms.peek();
    }

    @Override // java.util.Queue
    public T poll() {
        return this.f1225ms.poll();
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(T t) throws InterruptedException {
        this.f1225ms.put(t);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return this.f1225ms.remainingCapacity();
    }

    @Override // java.util.Queue
    public T remove() {
        return this.f1225ms.remove();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection
    public boolean remove(Object obj) {
        return this.f1225ms.remove(obj);
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection collection) {
        return this.f1225ms.removeAll(collection);
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection collection) {
        return this.f1225ms.retainAll(collection);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length > 0) {
            tArr[0] = null;
        }
        return tArr;
    }
}
