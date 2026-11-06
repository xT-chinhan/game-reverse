package com.byazt.pq;

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
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 109, 110})
public final class sz {
    public String l;
    public Runnable q;
    public ExecutorService w;
    public int n = 64;
    public int qg = 5;
    public int s = Integer.MAX_VALUE;
    public final Deque<hu.n> x = new ArrayDeque();
    public final Deque<hu.n> fs = new ArrayDeque();
    public final Deque<hu> rv = new ArrayDeque();

    public sz() {
    }

    public sz(String str) {
        this.l = str;
    }

    public synchronized ExecutorService n() {
        if (this.w == null) {
            String str = this.l;
            this.w = new com.byazt.xis.q(0, Integer.MAX_VALUE, 20L, TimeUnit.SECONDS, new SynchronousQueue(), com.byazt.zho.s.n((str == null || str.isEmpty()) ? "net" : this.l, false));
        }
        return this.w;
    }

    public synchronized void n(int i) {
        try {
            if (i <= 0) {
                throw new IllegalArgumentException("max < 1: ".concat(String.valueOf(i)));
            }
            this.n = i;
            l();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void qg(int i) {
        try {
            if (i <= 0) {
                throw new IllegalArgumentException("max < 1: ".concat(String.valueOf(i)));
            }
            this.qg = i;
            l();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void s(int i) {
        if (i >= 0) {
            this.s = i;
        }
    }

    public void n(hu.n nVar) {
        hu.n nVarS;
        synchronized (this) {
            if (this.fs.size() < this.n && l(nVar) < this.qg) {
                try {
                    this.fs.add(nVar);
                    if (nVar != null) {
                        nVar.q();
                    }
                    n().execute(nVar);
                } catch (Throwable unused) {
                }
                return;
            }
            if (this.x.size() >= this.s) {
                nVarS = s(nVar);
                if (nVarS == null) {
                    throw new RejectedExecutionException("ready queue max count exceeded");
                }
                this.x.remove(nVarS);
            } else {
                nVarS = null;
            }
            this.x.add(nVar);
            if (nVarS != null) {
                nVarS.l();
            }
        }
    }

    private hu.n s(hu.n nVar) {
        String strQ = q(nVar);
        if (strQ != null && !strQ.isEmpty()) {
            HashMap map = new HashMap();
            Iterator<hu.n> it = this.x.iterator();
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
                    Iterator<hu.n> itDescendingIterator = this.x.descendingIterator();
                    while (itDescendingIterator.hasNext()) {
                        hu.n next = itDescendingIterator.next();
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

    private String q(hu.n nVar) {
        if (nVar == null || nVar.qg() == null) {
            return null;
        }
        return nVar.qg().w();
    }

    private void l() {
        if (this.fs.size() < this.n && !this.x.isEmpty()) {
            Iterator<hu.n> it = this.x.iterator();
            while (it.hasNext()) {
                hu.n next = it.next();
                if (l(next) < this.qg) {
                    it.remove();
                    this.fs.add(next);
                    if (next != null) {
                        next.q();
                    }
                    n().execute(next);
                }
                if (this.fs.size() >= this.n) {
                    return;
                }
            }
        }
    }

    private int l(hu.n nVar) {
        Iterator<hu.n> it = this.fs.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().n().equals(nVar.n())) {
                i++;
            }
        }
        return i;
    }

    public synchronized void n(hu huVar) {
        this.rv.add(huVar);
    }

    public void qg(hu.n nVar) {
        n(this.fs, nVar, true);
    }

    public void qg(hu huVar) {
        n(this.rv, huVar, false);
    }

    private <T> void n(Deque<T> deque, T t, boolean z) {
        int iQ;
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            if (z) {
                l();
            }
            iQ = q();
            runnable = this.q;
        }
        if (iQ != 0 || runnable == null) {
            return;
        }
        runnable.run();
    }

    public synchronized List<l> qg() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<hu.n> it = this.x.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().s());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized List<l> s() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.rv);
        Iterator<hu.n> it = this.fs.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().s());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized int q() {
        return this.fs.size() + this.rv.size();
    }
}
