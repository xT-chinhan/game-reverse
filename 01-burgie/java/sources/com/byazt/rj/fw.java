package com.byazt.rj;

import com.byazt.xlm.aj;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1628, 62})
public final class fw extends Thread {
    public final Thread hn;
    public volatile boolean hw;
    public volatile Thread pr;

    public fw(Thread thread) {
        this.hn = thread;
    }

    @Override // java.lang.Thread
    public void interrupt() {
        if (this.pr != null) {
            this.pr.interrupt();
        }
    }

    @Override // java.lang.Thread
    public boolean isInterrupted() {
        if (this.pr != null) {
            return this.pr.isInterrupted();
        }
        return true;
    }

    @Override // java.lang.Thread
    public synchronized void start() {
        if (this.hw) {
            return;
        }
        this.hw = true;
        aj.hw.vk().execute(new com.byazt.mz.hn(new Runnable() { // from class: com.byazt.rj.fw.1
            @Override // java.lang.Runnable
            public void run() {
                if (aj.hw.ho()) {
                    fw.this.pr();
                } else {
                    fw.this.hw();
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr() {
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        try {
            hw hwVarHn = aj.hw.hn();
            String name2 = this.hn.getName();
            if (hwVarHn != null) {
                name2 = hwVarHn.pr(name2);
            }
            threadCurrentThread.setName(name2);
            this.pr = threadCurrentThread;
            threadCurrentThread.setPriority(this.hn.getPriority());
            this.hn.run();
        } finally {
            threadCurrentThread.setName(name);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw() {
        Thread threadCurrentThread = Thread.currentThread();
        this.pr = threadCurrentThread;
        threadCurrentThread.setPriority(this.hn.getPriority());
        this.hn.run();
    }
}
