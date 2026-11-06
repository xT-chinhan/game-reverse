package com.bytedance.sdk.component.adexpress.ms.xr;

import android.text.TextUtils;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.component.utils.sl;
import com.taptap.sdk.kit.internal.p000const.TrackAction;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class ka extends ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static File f898ms;
    private static volatile ka xr;
    private AtomicBoolean ah = new AtomicBoolean(true);
    private AtomicBoolean d = new AtomicBoolean(false);
    private boolean ka = false;
    private AtomicBoolean c = new AtomicBoolean(false);
    private AtomicInteger ab = new AtomicInteger(0);
    private AtomicLong x = new AtomicLong();

    public static ka xr() {
        if (xr == null) {
            synchronized (ka.class) {
                if (xr == null) {
                    xr = new ka();
                }
            }
        }
        return xr;
    }

    private ka() {
        x();
    }

    private void x() {
        com.bytedance.sdk.component.adexpress.d.ka.xr(new ny(TrackAction.INIT) { // from class: com.bytedance.sdk.component.adexpress.ms.xr.ka.1
            @Override // java.lang.Runnable
            public void run() {
                x.ms();
                ka.this.ah.set(false);
                ka.this.ah();
                ka.this.c();
                if (com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah() == null || !h.ms(com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah().getContext())) {
                    return;
                }
                com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah().xr().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.ms.xr.ka.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah() != null) {
                            com.bytedance.sdk.component.adexpress.ms.ms.ms.ms();
                        }
                    }
                });
            }
        }, 10);
    }

    public void ah() {
        com.bytedance.sdk.component.adexpress.ms.ah.ms msVarXr = x.xr();
        if (msVarXr == null || !msVarXr.c()) {
            return;
        }
        boolean zMs = ms(msVarXr);
        if (!zMs) {
            x.d();
        }
        this.ka = zMs;
    }

    public boolean ms(com.bytedance.sdk.component.adexpress.ms.ah.ms msVar) {
        if (msVar == null) {
            return false;
        }
        return ms(msVar.ms()) || ms(msVar.ka()) || ms(msVar.getResources());
    }

    public boolean d() {
        return this.ka;
    }

    public com.bytedance.sdk.component.adexpress.ms.ah.ms ka() {
        return x.xr();
    }

    @Override // com.bytedance.sdk.component.adexpress.ms.xr.ah
    public File ms() {
        return ab();
    }

    public void c() {
        ms(false);
    }

    public void ms(boolean z) {
        List<com.bytedance.sdk.component.adexpress.ms.ah.ms.C0231ms> listMs;
        boolean z2;
        if (this.ah.get()) {
            return;
        }
        try {
            if (this.d.get()) {
                if (z) {
                    this.ab.getAndIncrement();
                    return;
                }
                return;
            }
            boolean z3 = true;
            this.d.set(true);
            com.bytedance.sdk.component.adexpress.ms.ah.ms msVarAh = com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah().ah();
            com.bytedance.sdk.component.adexpress.ms.ah.ms msVarXr = x.xr();
            if (msVarAh != null && msVarAh.c()) {
                if (!x.xr(msVarAh)) {
                    this.d.set(false);
                    this.x.set(System.currentTimeMillis());
                    return;
                }
                if (com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah() != null) {
                    com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah().xr().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.ms.xr.ka.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.bytedance.sdk.component.adexpress.ka.ka.ms().xr();
                        }
                    });
                }
                x.ms(msVarAh);
                boolean zMs = (msVarAh.ka() == null || TextUtils.isEmpty(msVarAh.ka().ms())) ? false : ms(msVarAh.ka().ms());
                if (msVarAh.ms().size() != 0) {
                    listMs = ms(msVarAh, msVarXr);
                    z2 = listMs != null;
                } else {
                    listMs = null;
                    z2 = zMs;
                }
                if (!zMs) {
                    List<com.bytedance.sdk.component.adexpress.ms.ah.ms.C0231ms> listXr = xr(msVarAh, msVarXr);
                    if (listMs == null || listXr == null) {
                        listMs = listXr;
                    } else {
                        listMs.addAll(listXr);
                    }
                    if (listXr == null) {
                        z3 = false;
                    }
                    if (listXr == null) {
                        this.d.set(false);
                    }
                    z2 = z3;
                }
                if (z2 && ms(msVarAh)) {
                    x.ms(msVarAh);
                    x.ah();
                    xr(listMs);
                }
                ah();
                this.d.set(false);
                this.x.set(System.currentTimeMillis());
                ny();
                return;
            }
            this.d.set(false);
            ms(109);
        } catch (Throwable unused) {
        }
    }

    private void ny() {
        if (this.ab.getAndSet(0) <= 0 || System.currentTimeMillis() - this.x.get() <= 600000) {
            return;
        }
        c();
    }

    public static File ab() {
        if (f898ms == null) {
            try {
                File file = new File(new File(d.ms(), "tt_tmpl_pkg"), "template");
                file.mkdirs();
                f898ms = file;
            } catch (Throwable th) {
                sl.ah("TemplateManager", "getTemplateDir error", th);
            }
        }
        return f898ms;
    }
}
