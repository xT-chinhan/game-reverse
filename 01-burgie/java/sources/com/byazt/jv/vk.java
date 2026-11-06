package com.byazt.jv;

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

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 50})
public final class vk {
    public static final /* synthetic */ boolean hn = true;
    public static final Executor x = new com.byazt.fr.x(0, Integer.MAX_VALUE, 20, TimeUnit.SECONDS, new SynchronousQueue(), com.byazt.xx.hn.pr("OkHttp ConnectionPool", true));
    public final Runnable aj;
    public int c;
    public List<String> fw;
    public boolean hw;
    public final com.byazt.iaw.x pr;
    public long uc;
    public final Deque<com.byazt.iaw.hn> vk;
    public long zo;

    public vk() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public vk(int i, long j, TimeUnit timeUnit) {
        this.aj = new Runnable() { // from class: com.byazt.jv.vk.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    long jPr = vk.this.pr(System.nanoTime());
                    if (jPr == -1) {
                        return;
                    }
                    if (jPr > 0) {
                        long j2 = jPr / C.MICROS_PER_SECOND;
                        long j3 = jPr - (C.MICROS_PER_SECOND * j2);
                        synchronized (vk.this) {
                            try {
                                vk.this.wait(j2, (int) j3);
                            } catch (InterruptedException e) {
                            }
                        }
                    }
                }
            }
        };
        this.vk = new ArrayDeque();
        this.pr = new com.byazt.iaw.x();
        this.c = i;
        this.uc = timeUnit.toNanos(j);
        if (j <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: ".concat(String.valueOf(j)));
        }
    }

    public void pr(Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.containsKey("max_idle_cnt")) {
                    int i = bundle.getInt("max_idle_cnt");
                    if (i <= 5) {
                        i = this.c;
                    }
                    this.c = i;
                }
                if (bundle.containsKey("max_idle_time")) {
                    long j = bundle.getLong("max_idle_time");
                    this.uc = j > 5 ? TimeUnit.MINUTES.toNanos(j) : this.uc;
                }
                if (bundle.containsKey("white_hosts") && bundle.containsKey("white_extra_idle_time")) {
                    this.fw = bundle.getStringArrayList("white_hosts");
                    long j2 = bundle.getLong("white_extra_idle_time");
                    this.zo = j2 > 0 ? TimeUnit.MINUTES.toNanos(j2) : 0L;
                }
            } catch (Throwable th) {
            }
        }
    }

    public com.byazt.iaw.hn pr(pr prVar, com.byazt.iaw.fw fwVar, y yVar) {
        if (!hn && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (com.byazt.iaw.hn hnVar : this.vk) {
            if (hnVar.pr(prVar, yVar)) {
                if (fwVar != null) {
                    fwVar.pr(hnVar, true);
                }
                return hnVar;
            }
        }
        return null;
    }

    public Socket pr(pr prVar, com.byazt.iaw.fw fwVar) {
        if (!hn && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (com.byazt.iaw.hn hnVar : this.vk) {
            if (hnVar.pr(prVar, null) && hnVar.c() && hnVar != fwVar.hw()) {
                return fwVar.pr(hnVar);
            }
        }
        return null;
    }

    public void pr(com.byazt.iaw.hn hnVar) {
        if (!hn && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.hw) {
            this.hw = true;
            x.execute(this.aj);
        }
        this.vk.add(hnVar);
    }

    public boolean hw(com.byazt.iaw.hn hnVar) {
        if (!hn && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (hnVar.pr || this.c == 0) {
            this.vk.remove(hnVar);
            return true;
        }
        notifyAll();
        return false;
    }

    public long pr(long j) {
        try {
            synchronized (this) {
                com.byazt.iaw.hn hnVar = null;
                long j2 = Long.MIN_VALUE;
                int i = 0;
                int i2 = 0;
                for (com.byazt.iaw.hn hnVar2 : this.vk) {
                    if (pr(hnVar2, j) > 0) {
                        i2++;
                    } else {
                        i++;
                        long j3 = j - hnVar2.c;
                        com.byazt.iaw.hn hnVar3 = hnVar;
                        if (this.zo > 0 && hn(hnVar2)) {
                            j3 -= this.zo;
                        }
                        if (j3 <= j2) {
                            hnVar = hnVar3;
                        } else {
                            hnVar = hnVar2;
                            j2 = j3;
                        }
                    }
                }
                com.byazt.iaw.hn hnVar4 = hnVar;
                long j4 = this.uc;
                if (j2 < j4 && i <= this.c) {
                    if (i > 0) {
                        return j4 - j2;
                    }
                    if (i2 > 0) {
                        return j4;
                    }
                    this.hw = false;
                    return -1L;
                }
                this.vk.remove(hnVar4);
                com.byazt.xx.hn.pr(hnVar4.hn());
                return 0L;
            }
        } catch (OutOfMemoryError e) {
            return this.uc;
        }
    }

    private int pr(com.byazt.iaw.hn hnVar, long j) {
        List<Reference<com.byazt.iaw.fw>> list = hnVar.x;
        int i = 0;
        while (i < list.size()) {
            Reference<com.byazt.iaw.fw> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                com.byazt.lp.c.hw().pr("A connection to " + hnVar.pr().pr().pr() + " was leaked. Did you forget to close a response body?", ((com.byazt.iaw.fw.pr) reference).pr);
                list.remove(i);
                hnVar.pr = true;
                if (list.isEmpty()) {
                    hnVar.c = j - this.uc;
                    return 0;
                }
            }
        }
        return list.size();
    }

    private boolean hn(com.byazt.iaw.hn hnVar) {
        try {
            List<String> list = this.fw;
            if (list != null && !list.isEmpty() && hnVar.pr() != null && hnVar.pr().pr() != null && hnVar.pr().pr().pr() != null && hnVar.pr().pr().pr().uc() != null) {
                String strUc = hnVar.pr().pr().pr().uc();
                if (!TextUtils.isEmpty(strUc) && this.fw.contains(strUc)) {
                    return true;
                }
            }
        } catch (Throwable th) {
        }
        return false;
    }
}
