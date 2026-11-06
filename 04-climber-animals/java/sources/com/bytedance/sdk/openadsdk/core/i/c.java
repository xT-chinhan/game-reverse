package com.bytedance.sdk.openadsdk.core.i;

import com.bytedance.sdk.openadsdk.core.nw;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f2658ms = "c";
    private final Set<String> xr = new HashSet(1);

    public abstract void ms();

    public abstract void ms(String str);

    public synchronized boolean xr(String str) {
        return true;
    }

    protected final synchronized boolean ms(String str, int i) {
        try {
            if (i == 0) {
                return ms(str, d.GRANTED);
            }
            return ms(str, d.DENIED);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.i.c$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        static final /* synthetic */ int[] f2663ms;

        static {
            int[] iArr = new int[d.values().length];
            f2663ms = iArr;
            try {
                iArr[d.GRANTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2663ms[d.DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2663ms[d.NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    protected final synchronized boolean ms(final String str, d dVar) {
        this.xr.remove(str);
        int i = AnonymousClass5.f2663ms[dVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.ms(str);
                    }
                });
                return true;
            }
            if (i == 3) {
                if (xr(str)) {
                    if (this.xr.isEmpty()) {
                        nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.c.3
                            @Override // java.lang.Runnable
                            public void run() {
                                c.this.ms();
                            }
                        });
                        return true;
                    }
                } else {
                    nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.c.4
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.ms(str);
                        }
                    });
                    return true;
                }
            }
        } else if (this.xr.isEmpty()) {
            nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.ms();
                }
            });
            return true;
        }
        return false;
    }

    protected final synchronized void ms(String[] strArr) {
        Collections.addAll(this.xr, strArr);
    }
}
