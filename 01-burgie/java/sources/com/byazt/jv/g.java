package com.byazt.jv;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
public final class g {
    public ExecutorService c;
    public Runnable hn;
    public String x;
    public int pr = 64;
    public int hw = 5;
    public final Deque<z.pr> uc = new ArrayDeque();
    public final Deque<z.pr> fw = new ArrayDeque();
    public final Deque<z> zo = new ArrayDeque();

    public g() {
    }

    public g(String str) {
        this.x = str;
    }

    public synchronized ExecutorService pr() {
        if (this.c == null) {
            String str = this.x;
            this.c = new com.byazt.fr.x(0, Integer.MAX_VALUE, 20L, TimeUnit.SECONDS, new SynchronousQueue(), com.byazt.xx.hn.pr((str == null || str.isEmpty()) ? "net" : this.x, false));
        }
        return this.c;
    }

    public synchronized void pr(int i) {
        try {
            if (i <= 0) {
                throw new IllegalArgumentException("max < 1: ".concat(String.valueOf(i)));
            }
            this.pr = i;
            c();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void hw(int i) {
        try {
            if (i <= 0) {
                throw new IllegalArgumentException("max < 1: ".concat(String.valueOf(i)));
            }
            this.hw = i;
            c();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void pr(z.pr prVar) {
        try {
            if (this.fw.size() < this.pr && hn(prVar) < this.hw) {
                this.fw.add(prVar);
                if (prVar != null) {
                    prVar.hn();
                }
                pr().execute(prVar);
                return;
            }
            this.uc.add(prVar);
        } catch (Throwable th) {
        }
    }

    private void c() {
        if (this.fw.size() < this.pr && !this.uc.isEmpty()) {
            Iterator<z.pr> it = this.uc.iterator();
            while (it.hasNext()) {
                z.pr next = it.next();
                if (hn(next) < this.hw) {
                    it.remove();
                    this.fw.add(next);
                    if (next != null) {
                        next.hn();
                    }
                    pr().execute(next);
                }
                if (this.fw.size() >= this.pr) {
                    return;
                }
            }
        }
    }

    private int hn(z.pr prVar) {
        Iterator<z.pr> it = this.fw.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().pr().equals(prVar.pr())) {
                i++;
            }
        }
        return i;
    }

    public synchronized void pr(z zVar) {
        this.zo.add(zVar);
    }

    public void hw(z.pr prVar) {
        pr(this.fw, prVar, true);
    }

    public void hw(z zVar) {
        pr(this.zo, zVar, false);
    }

    private <T> void pr(Deque<T> deque, T t, boolean z) {
        int iX;
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            if (z) {
                c();
            }
            iX = x();
            runnable = this.hn;
        }
        if (iX == 0 && runnable != null) {
            runnable.run();
        }
    }

    public synchronized List<c> hw() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<z.pr> it = this.uc.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().hw());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized List<c> hn() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.zo);
        Iterator<z.pr> it = this.fw.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().hw());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized int x() {
        return this.fw.size() + this.zo.size();
    }
}
