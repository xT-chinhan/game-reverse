package com.byazt.dx;

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

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 229, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
public class g<T> {
    public static Executor pr = com.byazt.xlm.hw.hw(new com.byazt.xlm.zo("ie/LottieTask"));
    public volatile m<T> c;
    public final Set<vk<Throwable>> hn;
    public final Set<vk<T>> hw;
    public final Handler x;

    public g(Callable<m<T>> callable) {
        this(callable, false);
    }

    public g(Callable<m<T>> callable, boolean z) {
        this.hw = new LinkedHashSet(1);
        this.hn = new LinkedHashSet(1);
        this.x = new Handler(Looper.getMainLooper());
        this.c = null;
        if (z) {
            try {
                setResult(callable.call());
                return;
            } catch (Throwable th) {
                setResult(new m<>(th));
                return;
            }
        }
        pr.execute(new pr(callable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(m<T> mVar) {
        if (this.c != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.c = mVar;
        pr();
    }

    public synchronized g<T> pr(vk<T> vkVar) {
        m<T> mVar = this.c;
        if (mVar != null && mVar.pr() != null) {
            vkVar.pr(mVar.pr());
        }
        this.hw.add(vkVar);
        return this;
    }

    public synchronized g<T> hw(vk<T> vkVar) {
        this.hw.remove(vkVar);
        return this;
    }

    public synchronized g<T> hn(vk<Throwable> vkVar) {
        m<T> mVar = this.c;
        if (mVar != null && mVar.hw() != null) {
            vkVar.pr(mVar.hw());
        }
        this.hn.add(vkVar);
        return this;
    }

    public synchronized g<T> x(vk<Throwable> vkVar) {
        this.hn.remove(vkVar);
        return this;
    }

    private void pr() {
        this.x.post(new Runnable() { // from class: com.byazt.dx.g.1
            @Override // java.lang.Runnable
            public void run() {
                m mVar = g.this.c;
                if (mVar == null) {
                    return;
                }
                if (mVar.pr() != null) {
                    g.this.pr(mVar.pr());
                } else {
                    g.this.pr(mVar.hw());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void pr(T t) {
        Iterator it = new ArrayList(this.hw).iterator();
        while (it.hasNext()) {
            ((vk) it.next()).pr(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void pr(Throwable th) {
        ArrayList arrayList = new ArrayList(this.hn);
        if (arrayList.isEmpty()) {
            com.byazt.ptr.uc.pr("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((vk) it.next()).pr(th);
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 229, MediaPlayer.MEDIA_PLAYER_OPTION_MOOV_POS})
    private class pr extends FutureTask<m<T>> {
        public pr(Callable<m<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            if (!isCancelled()) {
                try {
                    g.this.setResult(get());
                } catch (InterruptedException | ExecutionException e) {
                    g.this.setResult(new m(e));
                }
            }
        }
    }
}
