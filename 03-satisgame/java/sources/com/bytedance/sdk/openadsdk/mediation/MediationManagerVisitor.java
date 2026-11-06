package com.bytedance.sdk.openadsdk.mediation;

import android.os.Bundle;
import com.byazt.cp.n;
import com.byazt.lt.qg;
import com.byazt.mo.k;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 55, 56, 57, 58, 1829})
public class MediationManagerVisitor {
    private static volatile MediationManagerVisitor n;
    private static volatile Object qg;
    private qg s;

    public static MediationManagerVisitor getInstance() {
        if (n == null) {
            synchronized (MediationManagerVisitor.class) {
                if (n == null) {
                    n = new MediationManagerVisitor();
                }
            }
        }
        return n;
    }

    private MediationManagerVisitor() {
    }

    public synchronized IMediationManager getMediationManager() {
        Bundle bundle = new Bundle();
        bundle.putString("mediation_manager", "mediation_manager");
        TTAdManager adManager = TTAdSdk.getAdManager();
        Object obj = qg;
        if (adManager != null) {
            qg = adManager.getExtra(null, bundle);
        }
        if (qg == null) {
            return null;
        }
        if (this.s == null) {
            this.s = new qg(k.n(qg));
        } else if (obj != qg) {
            this.s.n(k.n(qg));
        }
        return this.s;
    }
}
