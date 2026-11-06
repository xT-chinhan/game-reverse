package com.byazt.pq;

import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 109, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public final class tj {
    public static final Executor q = new com.byazt.xis.q(0, Integer.MAX_VALUE, 20, TimeUnit.SECONDS, new SynchronousQueue(), com.byazt.zho.s.n("OkHttp ConnectionPool", true));
    public static final /* synthetic */ boolean s = true;
    public long fs;
    public int l;
    public final com.byazt.sqs.q n;
    public boolean qg;
    public final Runnable rv;
    public final Deque<com.byazt.sqs.s> tj;
    public long w;
    public List<String> x;

    public tj() {
        this(5, 300L, TimeUnit.SECONDS);
    }

    public tj(int i, long j, TimeUnit timeUnit) {
        this.rv = new Runnable() { // from class: com.byazt.pq.tj.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    long jN = tj.this.n(System.nanoTime());
                    if (jN == -1) {
                        return;
                    }
                    if (jN > 0) {
                        long j2 = jN / C.MICROS_PER_SECOND;
                        long j3 = jN - (C.MICROS_PER_SECOND * j2);
                        synchronized (tj.this) {
                            try {
                                tj.this.wait(j2, (int) j3);
                            } catch (InterruptedException unused) {
                            }
                        }
                    }
                }
            }
        };
        this.tj = new ArrayDeque();
        this.n = new com.byazt.sqs.q();
        this.l = i;
        this.w = timeUnit.toNanos(j);
        if (j <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: ".concat(String.valueOf(j)));
        }
    }

    public void n(Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.containsKey("max_idle_cnt")) {
                    int i = bundle.getInt("max_idle_cnt");
                    if (i < 0) {
                        i = this.l;
                    }
                    this.l = i;
                }
                if (bundle.containsKey("max_idle_time")) {
                    long j = bundle.getLong("max_idle_time");
                    this.w = j > 0 ? TimeUnit.SECONDS.toNanos(j) : this.w;
                }
                if (bundle.containsKey("white_hosts") && bundle.containsKey("white_extra_idle_time")) {
                    this.x = bundle.getStringArrayList("white_hosts");
                    long j2 = bundle.getLong("white_extra_idle_time");
                    this.fs = j2 > 0 ? TimeUnit.MINUTES.toNanos(j2) : 0L;
                }
            } catch (Throwable unused) {
            }
        }
    }

    public com.byazt.sqs.s n(n nVar, com.byazt.sqs.x xVar, lh lhVar) {
        if (!s && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (com.byazt.sqs.s sVar : this.tj) {
            if (sVar.n(nVar, lhVar)) {
                if (xVar != null) {
                    xVar.n(sVar, true);
                }
                return sVar;
            }
        }
        return null;
    }

    public Socket n(n nVar, com.byazt.sqs.x xVar) {
        if (!s && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (com.byazt.sqs.s sVar : this.tj) {
            if (sVar.n(nVar, null) && sVar.l() && sVar != xVar.qg()) {
                return xVar.n(sVar);
            }
        }
        return null;
    }

    public void n(com.byazt.sqs.s sVar) {
        if (!s && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.qg) {
            this.qg = true;
            q.execute(this.rv);
        }
        this.tj.add(sVar);
    }

    public boolean qg(com.byazt.sqs.s sVar) {
        if (!s && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (sVar.n || this.l == 0) {
            this.tj.remove(sVar);
            return true;
        }
        notifyAll();
        return false;
    }

    public long n(long j) {
        try {
            synchronized (this) {
                com.byazt.sqs.s sVar = null;
                long j2 = Long.MIN_VALUE;
                int i = 0;
                int i2 = 0;
                for (com.byazt.sqs.s sVar2 : this.tj) {
                    if (n(sVar2, j) > 0) {
                        i2++;
                    } else {
                        i++;
                        long j3 = j - sVar2.l;
                        com.byazt.sqs.s sVar3 = sVar;
                        if (this.fs > 0 && s(sVar2)) {
                            j3 -= this.fs;
                        }
                        if (j3 > j2) {
                            sVar = sVar2;
                            j2 = j3;
                        } else {
                            sVar = sVar3;
                        }
                    }
                }
                com.byazt.sqs.s sVar4 = sVar;
                long j4 = this.w;
                if (j2 < j4 && i <= this.l) {
                    if (i > 0) {
                        return j4 - j2;
                    }
                    if (i2 > 0) {
                        return j4;
                    }
                    this.qg = false;
                    return -1L;
                }
                this.tj.remove(sVar4);
                com.byazt.zho.s.n(sVar4.s());
                return 0L;
            }
        } catch (OutOfMemoryError unused) {
            return this.w;
        }
    }

    private int n(com.byazt.sqs.s sVar, long j) {
        List<Reference<com.byazt.sqs.x>> list = sVar.q;
        int i = 0;
        while (i < list.size()) {
            Reference<com.byazt.sqs.x> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                com.byazt.quz.l.qg().n("A connection to " + sVar.n().n().n() + " was leaked. Did you forget to close a response body?", ((com.byazt.sqs.x.n) reference).n);
                list.remove(i);
                sVar.n = true;
                if (list.isEmpty()) {
                    sVar.l = j - this.w;
                    return 0;
                }
            }
        }
        return list.size();
    }

    private boolean s(com.byazt.sqs.s sVar) {
        try {
            List<String> list = this.x;
            if (list != null && !list.isEmpty() && sVar.n() != null && sVar.n().n() != null && sVar.n().n().n() != null && sVar.n().n().n().w() != null) {
                String strW = sVar.n().n().n().w();
                if (!TextUtils.isEmpty(strW) && this.x.contains(strW)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
