package com.byazt.ncu;

import com.byazt.qit.rv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_OUTLET_DROPCOUNT_ONCE, 21})
public final class x extends Thread {
    public volatile Thread n;
    public volatile boolean qg;
    public final Thread s;

    public x(Thread thread) {
        this.s = thread;
    }

    @Override // java.lang.Thread
    public void interrupt() {
        if (this.n != null) {
            this.n.interrupt();
        }
    }

    @Override // java.lang.Thread
    public boolean isInterrupted() {
        if (this.n != null) {
            return this.n.isInterrupted();
        }
        return true;
    }

    @Override // java.lang.Thread
    public synchronized void start() {
        if (this.qg) {
            return;
        }
        this.qg = true;
        rv.qg.tj().execute(new com.byazt.oo.s(new Runnable() { // from class: com.byazt.ncu.x.1
            @Override // java.lang.Runnable
            public void run() {
                if (rv.qg.cy()) {
                    x.this.n();
                } else {
                    x.this.qg();
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        try {
            qg qgVarS = rv.qg.s();
            String name2 = this.s.getName();
            if (qgVarS != null) {
                name2 = qgVarS.n(name2);
            }
            threadCurrentThread.setName(name2);
            this.n = threadCurrentThread;
            threadCurrentThread.setPriority(this.s.getPriority());
            this.s.run();
        } finally {
            threadCurrentThread.setName(name);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg() {
        Thread threadCurrentThread = Thread.currentThread();
        this.n = threadCurrentThread;
        threadCurrentThread.setPriority(this.s.getPriority());
        this.s.run();
    }
}
