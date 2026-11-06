package com.byazt.ey;

import android.os.SystemClock;
import com.byazt.vlj.uc;
import com.byazt.vlj.zo;
import com.byazt.wf.g;
import com.byazt.wf.vk;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1650, 37})
public class pr implements Thread.UncaughtExceptionHandler {
    public static pr pr;
    public Thread.UncaughtExceptionHandler hw;
    public hw x;
    public HashSet<Thread.UncaughtExceptionHandler> hn = new HashSet<>();
    public long c = -1;
    public volatile boolean uc = true;

    private pr() {
        hn();
    }

    public static pr pr() {
        if (pr == null) {
            pr = new pr();
        }
        return pr;
    }

    public void pr(hw hwVar) {
        this.x = hwVar;
    }

    private void hn() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != this) {
            Thread.setDefaultUncaughtExceptionHandler(this);
            if (this.hw == null) {
                this.hw = defaultUncaughtExceptionHandler;
            } else {
                this.hn.add(defaultUncaughtExceptionHandler);
            }
        }
    }

    public static void hw() {
        try {
            pr prVar = pr;
            if (prVar != null) {
                prVar.uc = false;
                hw hnVar = pr.x;
                pr = new pr();
                if (hnVar == null) {
                    hnVar = new hn(zo.x());
                }
                pr.pr(hnVar);
                return;
            }
            vk.pr("CrashCatchDispatcher id not init.");
        } catch (Throwable th) {
            vk.pr("CrashCatchDispatcher reRegister", th);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        hw hwVar;
        if (SystemClock.uptimeMillis() - this.c < 20000) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            this.c = SystemClock.uptimeMillis();
            if (!this.uc) {
                vk.pr("This CrashCatchDispatcher is disable");
                hn(thread, th);
                return;
            }
            boolean zPr = pr(thread, th);
            if (!zPr) {
                hn(thread, th);
                return;
            }
            com.byazt.vlj.hn hnVar = com.byazt.vlj.hn.JAVA;
            hw(thread, th);
            if (zPr && (hwVar = this.x) != null && hwVar.pr(th)) {
                this.x.pr(jCurrentTimeMillis, thread, th);
            }
        } catch (Throwable th2) {
            try {
                vk.pr(th2);
            } finally {
                hn(thread, th);
            }
        }
    }

    private boolean pr(Thread thread, Throwable th) {
        uc ucVarX = zo.hw().x();
        if (ucVarX != null) {
            try {
                if (!ucVarX.pr(th, thread)) {
                    return false;
                }
            } catch (Throwable th2) {
                return true;
            }
        }
        return true;
    }

    private void hw(Thread thread, Throwable th) {
        List<Object> listHw = zo.hw().hw();
        com.byazt.vlj.hn hnVar = com.byazt.vlj.hn.JAVA;
        Iterator<Object> it = listHw.iterator();
        while (it.hasNext()) {
            it.next();
            try {
                g.pr(th);
            } catch (Throwable th2) {
                vk.hw(th2);
            }
        }
    }

    private void hn(Thread thread, Throwable th) {
        try {
            Iterator<Thread.UncaughtExceptionHandler> it = this.hn.iterator();
            while (it.hasNext()) {
                it.next().uncaughtException(thread, th);
            }
            this.hw.uncaughtException(thread, th);
        } catch (Throwable th2) {
        }
    }
}
