package com.bytedance.sdk.openadsdk.core.ub;

import android.text.TextUtils;
import com.bytedance.sdk.component.ch.ab;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.ny.xr;
import com.bytedance.sdk.component.ny.xr.ah;
import com.bytedance.sdk.component.ny.xr.d;
import com.bytedance.sdk.component.utils.ka;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.jw.g;
import com.bytedance.sdk.openadsdk.core.nw.jw;
import com.bytedance.sdk.openadsdk.core.re;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static String f3373ms = "";
    public static String xr = "";

    public static void ms(final RunnableC0311ms runnableC0311ms) {
        jw jwVarSa = re.xr().sa();
        final String strMs = jwVarSa == null ? null : jwVarSa.ms();
        if (TextUtils.isEmpty(strMs)) {
            return;
        }
        if (TextUtils.isEmpty(xr)) {
            xr = strMs;
        }
        ab.xr(new ny("loadPfJs") { // from class: com.bytedance.sdk.openadsdk.core.ub.ms.1
            @Override // java.lang.Runnable
            public void run() {
                RunnableC0311ms runnableC0311ms2;
                String str = strMs;
                if (str != null && str.equalsIgnoreCase(ms.xr)) {
                    if (TextUtils.isEmpty(ms.f3373ms)) {
                        ms.f3373ms = g.ms("js_pform").xr(ka.xr(strMs), "");
                    }
                    if (!TextUtils.isEmpty(ms.f3373ms) && (runnableC0311ms2 = runnableC0311ms) != null) {
                        runnableC0311ms2.run();
                        return;
                    }
                }
                ah ahVarAh = com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().ah();
                ahVarAh.ms(strMs);
                HashMap map = new HashMap();
                map.put("content-type", "application/json; charset=utf-8");
                ahVarAh.d(map);
                ahVarAh.ms(new com.bytedance.sdk.component.ny.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.ub.ms.1.1
                    @Override // com.bytedance.sdk.component.ny.ms.ms
                    public void ms(d dVar, IOException iOException) {
                    }

                    @Override // com.bytedance.sdk.component.ny.ms.ms
                    public void ms(d dVar, xr xrVar) {
                        try {
                            ms.f3373ms = xrVar.d();
                            ms.xr = strMs;
                            if (runnableC0311ms != null) {
                                runnableC0311ms.run();
                            }
                            g.ms("js_pform").ms();
                            g.ms("js_pform").ms(ka.xr(strMs), ms.f3373ms);
                        } catch (Throwable th) {
                            sl.ah("performanceH5", "TTWebViewClient : onPageFinished", th);
                        }
                    }
                });
            }
        });
    }

    public static void ms(StringBuilder sb, String str, String str2) {
        int iIndexOf;
        if (sb == null || TextUtils.isEmpty(str) || (iIndexOf = sb.indexOf(str)) <= 0) {
            return;
        }
        sb.replace(iIndexOf, str.length() + iIndexOf, str2);
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.ub.ms$ms, reason: collision with other inner class name */
    public static class RunnableC0311ms implements Runnable {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private WeakReference<Runnable> f3376ms;

        public RunnableC0311ms(Runnable runnable) {
            if (runnable != null) {
                this.f3376ms = new WeakReference<>(runnable);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            WeakReference<Runnable> weakReference = this.f3376ms;
            Runnable runnable = weakReference != null ? weakReference.get() : null;
            if (runnable != null) {
                runnable.run();
            }
        }
    }
}
