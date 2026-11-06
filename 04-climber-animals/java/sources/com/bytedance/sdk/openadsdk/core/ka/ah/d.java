package com.bytedance.sdk.openadsdk.core.ka.ah;

import android.text.TextUtils;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.x;
import com.bytedance.sdk.openadsdk.op.ab;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class d implements com.bytedance.sdk.openadsdk.core.ka.ah.ms {
    static ReferenceQueue<Object> xr = new ReferenceQueue<>();
    private int ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    Map<Object, ms> f2762ms = new ConcurrentHashMap();

    @Override // com.bytedance.sdk.openadsdk.core.ka.ah.ms
    public boolean ms(String str) {
        return true;
    }

    public d(int i) {
        this.ah = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ah.ms
    public void ms(final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final lm lmVar) {
        if (TextUtils.isEmpty(xrVar.nw())) {
            if (lmVar.no() <= 0) {
                lmVar.ka((System.currentTimeMillis() + 10500000) / 1000);
            }
            ab.d(new ny("PreloadStrategyRecovery-onNetworkResponse") { // from class: com.bytedance.sdk.openadsdk.core.ka.ah.d.1
                @Override // java.lang.Runnable
                public void run() {
                    System.currentTimeMillis();
                    com.bytedance.sdk.openadsdk.core.ka.d.d.ms(d.this.ah).ms(xrVar, lmVar, false);
                    System.currentTimeMillis();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ah.ms
    public void xr(final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final lm lmVar) {
        if (TextUtils.isEmpty(xrVar.nw())) {
            if (lmVar.no() <= 0) {
                lmVar.ka((System.currentTimeMillis() + 10500000) / 1000);
            }
            ab.d(new ny("PreloadStrategyRecovery-onNetworkResponse") { // from class: com.bytedance.sdk.openadsdk.core.ka.ah.d.2
                @Override // java.lang.Runnable
                public void run() {
                    System.currentTimeMillis();
                    x.ms msVarMs = com.bytedance.sdk.openadsdk.core.ka.ka.xr.ms(d.this.ah);
                    if (((msVarMs != null ? msVarMs.ny() : 0) & 1) == 1) {
                        com.bytedance.sdk.openadsdk.core.ka.d.d.ms(d.this.ah).ms(xrVar, lmVar, false);
                        System.currentTimeMillis();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ah.ms
    public void ah(final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final lm lmVar) {
        if (TextUtils.isEmpty(xrVar.nw())) {
            if (lmVar.no() <= 0) {
                lmVar.ka((System.currentTimeMillis() + 10500000) / 1000);
            }
            ab.d(new ny("PreloadStrategyRecovery-onNetworkResponse") { // from class: com.bytedance.sdk.openadsdk.core.ka.ah.d.3
                @Override // java.lang.Runnable
                public void run() {
                    System.currentTimeMillis();
                    com.bytedance.sdk.openadsdk.core.ka.d.d.ms(d.this.ah).ms(xrVar.d(), lmVar.wg(), false);
                    System.currentTimeMillis();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ah.ms
    public void xr(String str) {
        System.currentTimeMillis();
        for (Reference<? extends Object> referencePoll = xr.poll(); referencePoll != null; referencePoll = xr.poll()) {
            ms msVar = this.f2762ms.get(referencePoll);
            if (msVar != null) {
                com.bytedance.sdk.openadsdk.core.ka.d.d.ms(this.ah).ms(msVar.f2768ms, msVar.xr, false);
            }
        }
        com.bytedance.sdk.openadsdk.core.ka.d.d.ms(this.ah).xr(str);
        System.currentTimeMillis();
        com.bytedance.sdk.openadsdk.core.ka.d.d.ms(this.ah).ah(str);
        System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ah.ms
    public lm ms(String str, long j) {
        x.ms msVarMs = com.bytedance.sdk.openadsdk.core.ka.ka.xr.ms(this.ah);
        System.currentTimeMillis();
        lm lmVarMs = com.bytedance.sdk.openadsdk.core.ka.d.d.ms(this.ah).ms(str, true, j);
        if (lmVarMs != null && msVarMs != null) {
            try {
                if (msVarMs.ms(lmVarMs)) {
                    com.bytedance.sdk.openadsdk.core.ka.d.d.ms(this.ah).ms(str, lmVarMs.wg());
                }
            } catch (Exception unused) {
                sl.xr("PreloadStrategyRecovery", "deleteCacheMeta error");
            }
        }
        System.currentTimeMillis();
        return lmVarMs;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ah.ms
    public void ms(final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final lm lmVar, final Object obj, final boolean z) {
        final String strD = xrVar.d();
        ab.d(new ny("PreloadStrategyRecovery-onLoad") { // from class: com.bytedance.sdk.openadsdk.core.ka.ah.d.4
            @Override // java.lang.Runnable
            public void run() {
                x.ms msVarMs = com.bytedance.sdk.openadsdk.core.ka.ka.xr.ms(d.this.ah);
                if (msVarMs != null) {
                    try {
                        if (msVarMs.ms(lmVar)) {
                            return;
                        }
                    } catch (Exception unused) {
                        sl.xr("PreloadStrategyRecovery", "isDisableSdkBidding error");
                    }
                }
                System.currentTimeMillis();
                if (lmVar.bk() != 0) {
                    d.this.f2762ms.put(new PhantomReference(obj, d.xr), new ms(strD, lmVar.wg()));
                }
                if (z) {
                    return;
                }
                if (((msVarMs != null ? msVarMs.ny() : 0) & 2) == 2) {
                    com.bytedance.sdk.openadsdk.core.ka.d.d.ms(d.this.ah).ms(xrVar, lmVar, true);
                    System.currentTimeMillis();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ah.ms
    public void ms(final String str, final lm lmVar) {
        ab.d(new ny("PreloadStrategyRecovery-onShow") { // from class: com.bytedance.sdk.openadsdk.core.ka.ah.d.5
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                com.bytedance.sdk.openadsdk.core.ka.d.d.ms(d.this.ah).ms(str, lmVar.wg());
                System.currentTimeMillis();
            }
        });
        x.ms msVarMs = com.bytedance.sdk.openadsdk.core.ka.ka.xr.ms(this.ah);
        if (msVarMs != null) {
            com.bytedance.sdk.openadsdk.core.ka.xr.ms(str, msVarMs.hi()).xr(msVarMs.hi());
        }
    }

    private static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        String f2768ms;
        String xr;

        public ms(String str, String str2) {
            this.f2768ms = str;
            this.xr = str2;
        }
    }
}
