package com.byazt.ncu;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_OUTLET_DROPCOUNT_ONCE, 19})
public final class n<T> implements BlockingQueue<T> {
    public final BlockingQueue<T> n;

    @Override // java.util.Collection
    public Object[] toArray() {
        return new Object[0];
    }

    public n(BlockingQueue blockingQueue) {
        if (blockingQueue == null) {
            this.n = new SynchronousQueue();
        } else {
            this.n = blockingQueue;
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public T take() throws InterruptedException {
        return this.n.take();
    }

    @Override // java.util.concurrent.BlockingQueue
    public T poll(long j, TimeUnit timeUnit) throws InterruptedException {
        try {
            return this.n.poll(j, timeUnit);
        } catch (IllegalMonitorStateException | LinkageError unused) {
            return null;
        }
    }

    public final String n() {
        return this.n.getClass().getName();
    }

    public final BlockingQueue qg() {
        return this.n;
    }

    public int s() {
        return this.n.size();
    }

    @Override // java.util.Collection
    public final int size() {
        return s();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Queue, java.util.Collection
    public boolean add(T t) {
        return this.n.add(t);
    }

    @Override // java.util.Collection
    public boolean addAll(Collection collection) {
        return this.n.addAll(collection);
    }

    @Override // java.util.Collection
    public void clear() {
        this.n.clear();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection
    public boolean contains(Object obj) {
        return this.n.contains(obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection collection) {
        return this.n.containsAll(collection);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection collection) {
        return this.n.drainTo(collection);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection collection, int i) {
        return this.n.drainTo(collection, i);
    }

    @Override // java.util.Queue
    public T element() {
        return this.n.element();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.n.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return this.n.iterator();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Queue
    public boolean offer(T t) {
        return this.n.offer(t);
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(T t, long j, TimeUnit timeUnit) throws InterruptedException {
        return this.n.offer(t, j, timeUnit);
    }

    @Override // java.util.Queue
    public T peek() {
        return this.n.peek();
    }

    @Override // java.util.Queue
    public T poll() {
        try {
            return this.n.poll();
        } catch (LinkageError unused) {
            return null;
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(T t) throws InterruptedException {
        this.n.put(t);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return this.n.remainingCapacity();
    }

    @Override // java.util.Queue
    public T remove() {
        return this.n.remove();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection
    public boolean remove(Object obj) {
        return this.n.remove(obj);
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection collection) {
        return this.n.removeAll(collection);
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection collection) {
        return this.n.retainAll(collection);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length > 0) {
            tArr[0] = null;
        }
        return tArr;
    }
}
