package com.bytedance.sdk.openadsdk.core.component.splash.ms;

import android.text.TextUtils;
import com.bytedance.sdk.component.ch.ab;
import com.bytedance.sdk.openadsdk.core.ah.ka;
import com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ny;
import com.bytedance.sdk.openadsdk.core.component.splash.c;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.g;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.tz;
import com.bytedance.sdk.openadsdk.core.op;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t.u;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d extends com.bytedance.sdk.openadsdk.core.component.splash.ms.ms {
    private xr c;
    private volatile com.bytedance.sdk.component.d.ms.xr ab = null;
    private com.bytedance.sdk.component.d.ms.xr x = g.ms("tt_materialMeta");

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.ms.ms
    public void ms(String str, String str2, boolean z, boolean z2, Object obj) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.ms.ms
    public void xr() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.ms.ms
    public void ms(tz tzVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, boolean z) {
        int iMs;
        if (tzVar != null && (iMs = c.ms(tzVar)) > 0) {
            ms(iMs, tzVar.ms().no());
            ms(tzVar);
        }
    }

    private void ms(tz tzVar) {
        xr xrVar = this.c;
        if (xrVar == null) {
            this.c = new xr(tzVar);
        } else {
            xrVar.ms(tzVar);
        }
        ab.ms(this.c, 10);
    }

    private com.bytedance.sdk.component.d.ms.xr ka() {
        if (this.ab == null) {
            this.ab = g.ms("tt_splash");
        }
        return this.ab;
    }

    private void ms(int i, long j) {
        com.bytedance.sdk.component.d.ms.xr xrVarKa = ka();
        xrVarKa.ms("expiration" + i, j);
        xrVarKa.ms("update" + i, System.currentTimeMillis() / 1000);
        xrVarKa.ms("has_ad_cache" + i, true);
    }

    private boolean ms(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ab abVar, String str) {
        if (ms(str)) {
            return true;
        }
        if (abVar != null) {
            abVar.d(0);
            abVar.xr(1);
            abVar.ms("no cache");
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003c  */
    /* JADX WARN: Code duplicated, block: B:20:0x003f A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:13:0x0020, B:15:0x0026, B:17:0x0030, B:20:0x003f, B:21:0x0042, B:24:0x004e), top: B:33:0x0020 }] */
    /* JADX WARN: Code duplicated, block: B:23:0x004d  */
    /* JADX WARN: Code duplicated, block: B:24:0x004e A[Catch: all -> 0x0052, TRY_LEAVE, TryCatch #0 {all -> 0x0052, blocks: (B:13:0x0020, B:15:0x0026, B:17:0x0030, B:20:0x003f, B:21:0x0042, B:24:0x004e), top: B:33:0x0020 }] */
    @Override // com.bytedance.sdk.openadsdk.core.component.splash.ms.ms
    public void ms(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ab abVar, String str, com.bytedance.sdk.openadsdk.core.component.splash.ms.ms.InterfaceC0286ms interfaceC0286ms) {
        lm lmVar;
        if (TextUtils.isEmpty(str) || interfaceC0286ms == null) {
            return;
        }
        if (!ms(abVar, str)) {
            interfaceC0286ms.ms();
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c cVar = null;
        try {
            com.bytedance.sdk.openadsdk.core.nw.ms msVarKa = ka(str);
            com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c cVar2 = new com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c(msVarKa, true);
            if (msVarKa != null) {
                try {
                    if (msVarKa.xr() == null || msVarKa.xr().isEmpty()) {
                        lmVar = null;
                    } else {
                        lmVar = msVarKa.xr().get(0);
                    }
                    if (lmVar != null) {
                        cVar2.ms(lmVar);
                    }
                    if (com.bytedance.sdk.openadsdk.core.live.xr.ms().ah(lmVar) != 3) {
                        cVar = cVar2;
                    } else {
                        cVar2.ms((lm) null);
                    }
                } catch (Throwable unused) {
                }
            } else {
                lmVar = null;
                if (lmVar != null) {
                    cVar2.ms(lmVar);
                }
                if (com.bytedance.sdk.openadsdk.core.live.xr.ms().ah(lmVar) != 3) {
                    cVar = cVar2;
                } else {
                    cVar2.ms((lm) null);
                }
            }
        } catch (Throwable unused2) {
        }
        interfaceC0286ms.ms(cVar);
        if (ka.ms().ch()) {
            return;
        }
        d(str);
    }

    public boolean ms(String str) {
        return (TextUtils.isEmpty(str) || !ka().xr(new StringBuilder("has_ad_cache").append(str).toString(), false) || ah(str)) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.ms.ms
    public void ms(com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.d<ny, com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ab> dVar, lm lmVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, boolean z) {
        if (lmVar == null) {
            return;
        }
        if (z) {
            this.x.ms("net_ad_already_shown", lmVar.eu());
        }
        if (this.ka.get()) {
            return;
        }
        String strXr = this.x.xr("net_ad_save_success" + f.ny(lmVar), "");
        if (TextUtils.isEmpty(strXr) || !strXr.equals(lmVar.eu())) {
            return;
        }
        this.ka.set(true);
        com.bytedance.sdk.openadsdk.core.ab.ms.ms("lqmt", "计划清除缓存 reqId:  " + strXr);
        d(xrVar != null ? xrVar.d() : null);
        if (dVar != null) {
            dVar.ms();
        }
    }

    private ms xr(String str) {
        ms msVar = new ms();
        if (TextUtils.isEmpty(str)) {
            return msVar;
        }
        com.bytedance.sdk.component.d.ms.xr xrVarKa = ka();
        long jXr = xrVarKa.xr("expiration" + str, 0L);
        long jXr2 = xrVarKa.xr("update" + str, 0L);
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        msVar.f2432ms = jCurrentTimeMillis < jXr2 || jCurrentTimeMillis >= jXr;
        msVar.xr = jXr2;
        msVar.ah = jXr;
        msVar.d = jCurrentTimeMillis;
        return msVar;
    }

    static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        boolean f2432ms = true;
        long xr = 0;
        long ah = 0;
        long d = 0;

        ms() {
        }
    }

    private boolean ah(final String str) {
        final ms msVarXr = xr(str);
        if (msVarXr.f2432ms) {
            u.ms().ab(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ms.d.1
                @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
                public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                    long j = msVarXr.d - msVarXr.xr;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("available_type", 0);
                    jSONObject.putOpt("creative_timeout_duration", Long.valueOf(j / 3600));
                    return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms(4).ah(str).xr(jSONObject.toString());
                }
            });
        }
        return msVarXr.f2432ms;
    }

    private void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.d.ms.xr xrVarKa = ka();
        this.x.ms("materialMeta" + str);
        if (xrVarKa != null) {
            xrVarKa.ms("has_ad_cache" + str);
            xrVarKa.ms("expiration" + str);
        }
        com.bytedance.sdk.openadsdk.core.ab.ms.ms("lqmt", "清除成功： rit: " + str);
    }

    private class xr extends com.bytedance.sdk.component.ch.ny {
        private tz xr;

        public xr(tz tzVar) {
            super("WriteCacheTask");
            this.xr = tzVar;
        }

        public void ms(tz tzVar) {
            this.xr = tzVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ah();
        }

        private void ah() {
            try {
                int iMs = c.ms(this.xr);
                if (iMs <= 0) {
                    return;
                }
                String strXr = d.this.x.xr("net_ad_already_shown", "");
                if (!TextUtils.isEmpty(strXr) && strXr.equals(this.xr.ms().eu())) {
                    com.bytedance.sdk.openadsdk.core.ab.ms.ms("lqmt", "该缓存已show-则不再save： rit: " + iMs + "   reqId: " + this.xr.ms().eu());
                    return;
                }
                JSONObject jSONObjectAh = this.xr.xr().ah();
                if (jSONObjectAh != null) {
                    d.this.x.ms("materialMeta".concat(String.valueOf(iMs)), jSONObjectAh.toString());
                }
                d.this.x.ms("net_ad_save_success".concat(String.valueOf(iMs)), this.xr.ms().eu());
                com.bytedance.sdk.openadsdk.core.ab.ms.ms("lqmt", "缓存成功： rit: " + iMs + "   reqId: " + this.xr.ms().eu());
            } catch (Throwable unused) {
            }
        }
    }

    private com.bytedance.sdk.openadsdk.core.nw.ms ka(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strXr = this.x.xr("materialMeta" + str, (String) null);
        if (!TextUtils.isEmpty(strXr)) {
            try {
                op.ms msVarMs = op.ms.ms(new JSONObject(strXr));
                if (msVarMs != null && msVarMs.x != null) {
                    return msVarMs.x;
                }
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public static void d() {
        re.xr().we();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.ms.ms
    public void ah() {
        try {
            g.ms("tt_materialMeta").ms();
            g.ms("tt_splash").ms();
        } catch (Throwable unused) {
        }
    }
}
