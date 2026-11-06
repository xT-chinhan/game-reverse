package com.byazt.pp;

import android.os.Handler;
import android.os.Looper;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, 110})
public class sz<T> {
    public static Executor n = com.byazt.qit.qg.qg(new com.byazt.qit.fs("ie/LottieTask"));
    public volatile oa<T> l;
    public final Handler q;
    public final Set<tj<T>> qg;
    public final Set<tj<Throwable>> s;

    public sz(Callable<oa<T>> callable) {
        this(callable, false);
    }

    public sz(Callable<oa<T>> callable, boolean z) {
        this.qg = new LinkedHashSet(1);
        this.s = new LinkedHashSet(1);
        this.q = new Handler(Looper.getMainLooper());
        this.l = null;
        if (z) {
            try {
                setResult(callable.call());
                return;
            } catch (Throwable th) {
                setResult(new oa<>(th));
                return;
            }
        }
        n.execute(new n(callable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(oa<T> oaVar) {
        if (this.l != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.l = oaVar;
        n();
    }

    public synchronized sz<T> n(tj<T> tjVar) {
        oa<T> oaVar = this.l;
        if (oaVar != null && oaVar.n() != null) {
            tjVar.n(oaVar.n());
        }
        this.qg.add(tjVar);
        return this;
    }

    public synchronized sz<T> qg(tj<T> tjVar) {
        this.qg.remove(tjVar);
        return this;
    }

    public synchronized sz<T> s(tj<Throwable> tjVar) {
        oa<T> oaVar = this.l;
        if (oaVar != null && oaVar.qg() != null) {
            tjVar.n(oaVar.qg());
        }
        this.s.add(tjVar);
        return this;
    }

    public synchronized sz<T> q(tj<Throwable> tjVar) {
        this.s.remove(tjVar);
        return this;
    }

    private void n() {
        this.q.post(new Runnable() { // from class: com.byazt.pp.sz.1
            @Override // java.lang.Runnable
            public void run() {
                oa oaVar = sz.this.l;
                if (oaVar == null) {
                    return;
                }
                if (oaVar.n() != null) {
                    sz.this.n(oaVar.n());
                } else {
                    sz.this.n(oaVar.qg());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void n(T t) {
        Iterator it = new ArrayList(this.qg).iterator();
        while (it.hasNext()) {
            ((tj) it.next()).n(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void n(Throwable th) {
        ArrayList arrayList = new ArrayList(this.s);
        if (arrayList.isEmpty()) {
            com.byazt.nu.w.n("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((tj) it.next()).n(th);
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, 1222})
    private class n extends FutureTask<oa<T>> {
        public n(Callable<oa<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            if (isCancelled()) {
                return;
            }
            try {
                sz.this.setResult(get());
            } catch (InterruptedException | ExecutionException e) {
                sz.this.setResult(new oa(e));
            }
        }
    }
}
