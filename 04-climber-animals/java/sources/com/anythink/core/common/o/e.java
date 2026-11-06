package com.anythink.core.common.o;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import com.anythink.core.common.d.t;
import com.anythink.core.common.d.u;
import com.anythink.core.common.v.af;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private static e d;
    long b;
    private Context f;
    private ActivityManager g;
    private d h;
    private boolean j;
    private volatile Integer k;
    private volatile Integer l;
    private volatile Long m;
    private boolean e = false;
    private final File i = Environment.getDataDirectory();
    final long a = 5000;
    AtomicInteger c = new AtomicInteger();

    public static e a() {
        if (d == null) {
            synchronized (e.class) {
                if (d == null) {
                    d = new e();
                }
            }
        }
        return d;
    }

    private e() {
        Context contextG = t.b().g();
        this.f = contextG;
        this.g = (ActivityManager) contextG.getSystemService(TTDownloadField.TT_ACTIVITY);
        this.h = new d();
    }

    public final void a(com.anythink.core.d.b bVar) {
        this.e = bVar.i();
        synchronized (this) {
            if (!this.j) {
                d dVar = this.h;
                Context context = this.f;
                ActivityManager activityManager = this.g;
                int memoryClass = activityManager.getMemoryClass();
                if ((context.getApplicationContext().getApplicationInfo().flags & 1048576) == 1048576) {
                    memoryClass = activityManager.getLargeMemoryClass();
                }
                dVar.d = memoryClass;
                if (!t.b().c("t_mem")) {
                    if (this.k == null) {
                        this.k = Integer.valueOf(af.b(this.f, u.b.a, u.a.g, -1));
                    }
                    if (this.k.intValue() <= 0) {
                        this.k = Integer.valueOf(b.a());
                        af.a(this.f, u.b.a, u.a.g, this.k.intValue());
                    }
                    this.h.a = this.k.intValue();
                }
                if (!t.b().c("c_num")) {
                    if (this.l == null) {
                        this.l = Integer.valueOf(af.b(this.f, u.b.a, u.a.h, -1));
                    }
                    if (this.l.intValue() <= 0) {
                        this.l = Integer.valueOf(Runtime.getRuntime().availableProcessors());
                        af.a(this.f, u.b.a, u.a.h, this.l.intValue());
                    }
                    this.h.e = this.l.intValue();
                }
                if (!t.b().c("t_store")) {
                    if (this.m == null) {
                        this.m = Long.valueOf(af.b(this.f, u.b.a, u.a.i, -1L));
                    }
                    if (this.m.longValue() <= 0) {
                        try {
                            StatFs statFs = new StatFs(this.i.getPath());
                            this.m = Long.valueOf((statFs.getBlockCountLong() * ((long) statFs.getBlockSize())) / BaseConstants.MB_VALUE);
                        } catch (Throwable unused) {
                        }
                        af.a(this.f, u.b.a, u.a.i, this.m.longValue());
                    }
                    this.h.f = this.m.longValue();
                }
                this.j = true;
            }
        }
    }

    public final d b() {
        if (!this.e) {
            return null;
        }
        if (SystemClock.elapsedRealtime() - this.b <= 5000) {
            return this.h;
        }
        this.b = SystemClock.elapsedRealtime();
        this.h.h = a.a();
        this.h.b = b.b();
        this.h.g = l();
        this.h.c = b.a(this.g);
        return this.h;
    }

    private void i() {
        d dVar = this.h;
        Context context = this.f;
        ActivityManager activityManager = this.g;
        int memoryClass = activityManager.getMemoryClass();
        if ((context.getApplicationContext().getApplicationInfo().flags & 1048576) == 1048576) {
            memoryClass = activityManager.getLargeMemoryClass();
        }
        dVar.d = memoryClass;
        if (t.b().c("t_mem")) {
            return;
        }
        if (this.k == null) {
            this.k = Integer.valueOf(af.b(this.f, u.b.a, u.a.g, -1));
        }
        if (this.k.intValue() <= 0) {
            this.k = Integer.valueOf(b.a());
            af.a(this.f, u.b.a, u.a.g, this.k.intValue());
        }
        this.h.a = this.k.intValue();
    }

    private void j() {
        if (t.b().c("c_num")) {
            return;
        }
        if (this.l == null) {
            this.l = Integer.valueOf(af.b(this.f, u.b.a, u.a.h, -1));
        }
        if (this.l.intValue() <= 0) {
            this.l = Integer.valueOf(Runtime.getRuntime().availableProcessors());
            af.a(this.f, u.b.a, u.a.h, this.l.intValue());
        }
        this.h.e = this.l.intValue();
    }

    private void k() {
        if (t.b().c("t_store")) {
            return;
        }
        if (this.m == null) {
            this.m = Long.valueOf(af.b(this.f, u.b.a, u.a.i, -1L));
        }
        if (this.m.longValue() <= 0) {
            try {
                StatFs statFs = new StatFs(this.i.getPath());
                this.m = Long.valueOf((statFs.getBlockCountLong() * ((long) statFs.getBlockSize())) / BaseConstants.MB_VALUE);
            } catch (Throwable unused) {
            }
            af.a(this.f, u.b.a, u.a.i, this.m.longValue());
        }
        this.h.f = this.m.longValue();
    }

    private long l() {
        try {
            StatFs statFs = new StatFs(this.i.getPath());
            return (statFs.getAvailableBlocksLong() * ((long) statFs.getBlockSize())) / BaseConstants.MB_VALUE;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public final synchronized void c() {
        this.c.incrementAndGet();
    }

    public final synchronized void d() {
        this.c.decrementAndGet();
    }

    public final synchronized int e() {
        return this.c.get();
    }

    public final int f() {
        if (t.b().c("t_mem")) {
            return 0;
        }
        if (this.k == null) {
            this.k = Integer.valueOf(af.b(this.f, u.b.a, u.a.g, -1));
        }
        if (this.k.intValue() > 0) {
            return this.k.intValue();
        }
        return 0;
    }

    public final int g() {
        if (t.b().c("c_num")) {
            return 0;
        }
        if (this.l == null) {
            this.l = Integer.valueOf(af.b(this.f, u.b.a, u.a.h, -1));
        }
        if (this.l.intValue() > 0) {
            return this.l.intValue();
        }
        return 0;
    }

    public final long h() {
        if (t.b().c("t_store")) {
            return 0L;
        }
        if (this.m == null) {
            this.m = Long.valueOf(af.b(this.f, u.b.a, u.a.i, -1L));
        }
        if (this.m.longValue() > 0) {
            return this.m.longValue();
        }
        return 0L;
    }
}
