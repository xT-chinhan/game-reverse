package com.bytedance.ms.xr.d;

import android.os.SystemClock;
import com.bytedance.ms.xr.c;
import com.bytedance.ms.xr.x;
import com.bytedance.ms.xr.x.ch;
import com.bytedance.ms.xr.x.u;
import com.bytedance.sdk.component.utils.sl;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static ms f564ms;
    private xr d;
    private Thread.UncaughtExceptionHandler xr;
    private HashSet<Thread.UncaughtExceptionHandler> ah = new HashSet<>();
    private long ka = -1;

    private ms() {
        xr();
    }

    public static ms ms() {
        if (f564ms == null) {
            f564ms = new ms();
        }
        return f564ms;
    }

    public void ms(xr xrVar) {
        this.d = xrVar;
    }

    private void xr() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != this) {
            Thread.setDefaultUncaughtExceptionHandler(this);
            if (this.xr == null) {
                this.xr = defaultUncaughtExceptionHandler;
            } else {
                this.ah.add(defaultUncaughtExceptionHandler);
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        xr xrVar;
        if (SystemClock.uptimeMillis() - this.ka < 20000) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            this.ka = SystemClock.uptimeMillis();
            boolean zMs = ms(thread, th);
            if (zMs) {
                com.bytedance.ms.xr.ah ahVar = com.bytedance.ms.xr.ah.JAVA;
                xr(thread, th);
                if (zMs && (xrVar = this.d) != null && xrVar.ms(th)) {
                    this.d.ms(jCurrentTimeMillis, thread, th);
                    sl.ms("crash_dispatcher", "end dispose ".concat(String.valueOf(th)));
                }
                ah(thread, th);
                return;
            }
            ah(thread, th);
        } catch (Throwable th2) {
            try {
                ch.ms(th2);
            } finally {
                ah(thread, th);
            }
        }
    }

    private boolean ms(Thread thread, Throwable th) {
        c cVarD = x.xr().d();
        if (cVarD != null) {
            try {
                if (!cVarD.ms(th, thread)) {
                    return false;
                }
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    private void xr(Thread thread, Throwable th) {
        List<Object> listXr = x.xr().xr();
        com.bytedance.ms.xr.ah ahVar = com.bytedance.ms.xr.ah.JAVA;
        Iterator<Object> it = listXr.iterator();
        while (it.hasNext()) {
            it.next();
            try {
                u.ms(th);
            } catch (Throwable th2) {
                ch.xr(th2);
            }
        }
    }

    private void ah(Thread thread, Throwable th) {
        try {
            Iterator<Thread.UncaughtExceptionHandler> it = this.ah.iterator();
            while (it.hasNext()) {
                try {
                    it.next().uncaughtException(thread, th);
                } catch (Throwable unused) {
                }
            }
            this.xr.uncaughtException(thread, th);
        } catch (Throwable unused2) {
        }
    }
}
