package com.byazt.rft;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVPH_PARAMS, 5})
public class q extends com.byazt.tbt.q {
    public ExecutorService n;
    public final Deque<n.C0324n> qg = new ArrayDeque();
    public final Deque<n.C0324n> s = new ArrayDeque();
    public final Deque<n> q = new ArrayDeque();
    public AtomicInteger l = new AtomicInteger(64);
    public int w = Integer.MAX_VALUE;

    @Override // com.byazt.tbt.q
    public void qg(int i) {
    }

    public q() {
        if (this.n == null) {
            this.n = new com.byazt.xis.q(0, Integer.MAX_VALUE, 20L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory() { // from class: com.byazt.rft.q.1
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    com.byazt.xis.s sVar = new com.byazt.xis.s(runnable, "systemHttp Dispatcher");
                    sVar.setDaemon(false);
                    sVar.setPriority(10);
                    return sVar;
                }
            });
        }
    }

    @Override // com.byazt.tbt.q
    public ExecutorService qg() {
        return this.n;
    }

    @Override // com.byazt.tbt.q
    public void n(int i) {
        this.l.set(i);
    }

    @Override // com.byazt.tbt.q
    public synchronized List<com.byazt.tbt.qg> s() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        try {
            for (n.C0324n c0324n : this.qg) {
                if (c0324n != null && c0324n.n() != null) {
                    arrayList.add(c0324n.n());
                }
            }
        } catch (Throwable unused) {
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // com.byazt.tbt.q
    public synchronized List<com.byazt.tbt.qg> q() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        try {
            arrayList.addAll(this.q);
            for (n.C0324n c0324n : this.s) {
                if (c0324n != null && c0324n.n() != null) {
                    arrayList.add(c0324n.n());
                }
            }
        } catch (Throwable unused) {
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // com.byazt.tbt.q
    public int n() {
        return this.l.get();
    }

    @Override // com.byazt.tbt.q
    public synchronized void s(int i) {
        if (i >= 0) {
            this.w = i;
        }
    }

    public void n(n.C0324n c0324n) {
        n.C0324n c0324nS;
        synchronized (this) {
            if (this.s.size() < n()) {
                this.s.add(c0324n);
                if (c0324n != null) {
                    c0324n.qg();
                }
                qg().submit(c0324n);
                return;
            }
            if (this.qg.size() >= this.w) {
                c0324nS = s(c0324n);
                if (c0324nS == null) {
                    throw new RejectedExecutionException("ready queue max count exceeded");
                }
                this.qg.remove(c0324nS);
            } else {
                c0324nS = null;
            }
            this.qg.add(c0324n);
            if (c0324nS != null) {
                c0324nS.s();
            }
        }
    }

    private n.C0324n s(n.C0324n c0324n) {
        String strQ = q(c0324n);
        if (strQ != null && !strQ.isEmpty()) {
            HashMap map = new HashMap();
            Iterator<n.C0324n> it = this.qg.iterator();
            while (true) {
                if (it.hasNext()) {
                    String strQ2 = q(it.next());
                    if (strQ.equals(strQ2)) {
                        return null;
                    }
                    if (strQ2 != null && !strQ2.isEmpty()) {
                        Integer num = (Integer) map.get(strQ2);
                        map.put(strQ2, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
                    }
                } else {
                    Iterator<n.C0324n> itDescendingIterator = this.qg.descendingIterator();
                    while (itDescendingIterator.hasNext()) {
                        n.C0324n next = itDescendingIterator.next();
                        Integer num2 = (Integer) map.get(q(next));
                        if (num2 != null && num2.intValue() > 1) {
                            return next;
                        }
                    }
                    break;
                }
            }
        }
        return null;
    }

    private String q(n.C0324n c0324n) {
        if (c0324n == null || c0324n.n() == null || c0324n.n().n() == null) {
            return null;
        }
        return c0324n.n().n().l();
    }

    public synchronized void n(n nVar) {
        this.q.add(nVar);
    }

    public void qg(n.C0324n c0324n) {
        n(this.s, c0324n, true);
    }

    public void qg(n nVar) {
        n(this.q, nVar, false);
    }

    private <T> void n(Deque<T> deque, T t, boolean z) {
        synchronized (this) {
            deque.remove(t);
            if (z) {
                l();
            }
        }
    }

    private void l() {
        if (this.s.size() < n() && !this.qg.isEmpty()) {
            Iterator<n.C0324n> it = this.qg.iterator();
            while (it.hasNext()) {
                n.C0324n next = it.next();
                it.remove();
                this.s.add(next);
                if (next != null) {
                    next.qg();
                }
                qg().submit(next);
                if (this.s.size() >= n()) {
                    return;
                }
            }
        }
    }
}
