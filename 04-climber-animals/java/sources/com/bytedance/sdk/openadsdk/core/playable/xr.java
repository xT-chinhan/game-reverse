package com.bytedance.sdk.openadsdk.core.playable;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.sdk.component.ch.ab;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile xr f3286ms;
    private final long ah;
    private int d;
    private LruCache<String, com.bytedance.sdk.openadsdk.core.playable.ms.ms> xr;
    private CopyOnWriteArrayList<String> ka = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<String> c = new CopyOnWriteArrayList<>();
    private ConcurrentHashMap<String, WeakReference<com.bytedance.sdk.openadsdk.core.qv.ah>> ab = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Long> x = new ConcurrentHashMap<>();
    private final Object ny = new Object();

    static /* synthetic */ void ms(xr xrVar, String str) {
    }

    private xr() {
        int iWc = re.xr().wc();
        this.d = iWc;
        if (iWc > 30) {
            this.d = 30;
        } else if (iWc < 0) {
            this.d = 5;
        }
        this.ah = re.xr().qe() * 1000;
        this.xr = new LruCache<String, com.bytedance.sdk.openadsdk.core.playable.ms.ms>(this.d) { // from class: com.bytedance.sdk.openadsdk.core.playable.xr.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public int sizeOf(String str, com.bytedance.sdk.openadsdk.core.playable.ms.ms msVar) {
                return 1;
            }
        };
    }

    public static xr ms() {
        if (f3286ms == null) {
            synchronized (xr.class) {
                if (f3286ms == null) {
                    f3286ms = new xr();
                }
            }
        }
        return f3286ms;
    }

    public void ms(lm lmVar) {
        if (lmVar != null) {
            try {
                if (lmVar.rl() == 3) {
                    d(lmVar);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void d(final lm lmVar) {
        if (TextUtils.isEmpty(lmVar.hw())) {
            return;
        }
        final String strHw = lmVar.hw();
        if (this.ka.contains(strHw) || this.c.contains(strHw) || this.xr.get(strHw) != null) {
            return;
        }
        this.ka.add(strHw);
        this.x.put(strHw, Long.valueOf(System.currentTimeMillis()));
        ab.xr(new ny("playable_prefetch") { // from class: com.bytedance.sdk.openadsdk.core.playable.xr.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    xr.this.ms(lmVar, strHw);
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(lm lmVar, final String str) {
        com.bytedance.sdk.openadsdk.core.re.xr.ms(lmVar, lmVar == null ? null : lmVar.vt(), new com.bytedance.sdk.openadsdk.core.qv.ah() { // from class: com.bytedance.sdk.openadsdk.core.playable.xr.3
            @Override // com.bytedance.sdk.openadsdk.core.qv.ah
            public void ms(boolean z, List<lm> list, boolean z2) {
                try {
                    if (xr.this.c != null && xr.this.c.contains(str)) {
                        xr.ms(xr.this, "prefetchCache-onAdLoaded.. discardTask. key: " + str);
                        return;
                    }
                    xr.ms(xr.this, "prefetchCache-onAdLoaded.. success: ".concat(String.valueOf(z)));
                    synchronized (xr.this.ny) {
                        if (!z || list == null) {
                            xr.this.ka.remove(str);
                        } else {
                            if (list.size() > 0) {
                                com.bytedance.sdk.openadsdk.core.playable.ms.ms msVar = new com.bytedance.sdk.openadsdk.core.playable.ms.ms();
                                msVar.f3285ms = list;
                                msVar.xr = z;
                                msVar.ah = SystemClock.elapsedRealtime();
                                xr.this.xr.put(str, msVar);
                                xr.ms(xr.this, "prefetchCache-onAdLoaded.. 缓存save  key: " + str);
                            }
                            xr.this.ka.remove(str);
                        }
                        throw th;
                    }
                    WeakReference weakReference = (WeakReference) xr.this.ab.get(str);
                    com.bytedance.sdk.openadsdk.core.qv.ah ahVar = weakReference == null ? null : (com.bytedance.sdk.openadsdk.core.qv.ah) weakReference.get();
                    if (ahVar != null) {
                        ahVar.ms(z, list, true);
                        xr.this.ab.remove(str);
                        xr.ms(xr.this, "prefetchCache-onAdLoaded..callback invoke key: " + str);
                    }
                } catch (Exception unused) {
                }
            }
        }, (com.bytedance.sdk.openadsdk.ao.xr.ah.xr) null);
    }

    public void xr(lm lmVar) {
        if (lmVar != null) {
            try {
                if (TextUtils.isEmpty(lmVar.hw())) {
                    return;
                }
                String strHw = lmVar.hw();
                this.c.add(strHw);
                this.xr.remove(strHw);
                this.ka.remove(strHw);
                this.ab.remove(strHw);
                this.x.remove(strHw);
                this.xr.size();
                this.ka.size();
                this.c.size();
            } catch (Exception unused) {
            }
        }
    }

    public boolean ms(lm lmVar, com.bytedance.sdk.openadsdk.core.qv.ah ahVar) {
        if (lmVar != null && !TextUtils.isEmpty(lmVar.hw())) {
            String strHw = lmVar.hw();
            try {
                synchronized (this.ny) {
                    if (this.ka.contains(strHw)) {
                        this.ab.put(strHw, new WeakReference<>(ahVar));
                        return true;
                    }
                    com.bytedance.sdk.openadsdk.core.playable.ms.ms msVar = this.xr.get(strHw);
                    if (msVar == null) {
                        return false;
                    }
                    if (ms(msVar)) {
                        xr(lmVar);
                        return false;
                    }
                    if (ahVar != null) {
                        ahVar.ms(msVar.xr, msVar.f3285ms, true);
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private boolean ms(com.bytedance.sdk.openadsdk.core.playable.ms.ms msVar) {
        return this.ah > 0 && msVar != null && SystemClock.elapsedRealtime() - msVar.ah > this.ah;
    }

    public long ah(lm lmVar) {
        try {
            if (this.x == null || lmVar == null || TextUtils.isEmpty(lmVar.hw())) {
                return 0L;
            }
            return this.x.get(lmVar.hw()).longValue();
        } catch (Exception unused) {
            return 0L;
        }
    }
}
