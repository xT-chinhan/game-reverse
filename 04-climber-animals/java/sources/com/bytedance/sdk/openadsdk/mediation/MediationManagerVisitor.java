package com.bytedance.sdk.openadsdk.mediation;

import android.os.Bundle;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.ao.ms.ms.ao;
import com.bytedance.sdk.openadsdk.mediation.xr.ms.ab;
import com.bytedance.sdk.openadsdk.mediation.xr.ms.ms.xr;

/* JADX INFO: loaded from: classes2.dex */
public class MediationManagerVisitor {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile MediationManagerVisitor f3945ms;
    private static volatile Object xr;
    private xr ah;

    public static MediationManagerVisitor getInstance() {
        if (f3945ms == null) {
            synchronized (MediationManagerVisitor.class) {
                if (f3945ms == null) {
                    f3945ms = new MediationManagerVisitor();
                }
            }
        }
        return f3945ms;
    }

    private MediationManagerVisitor() {
    }

    public synchronized IMediationManager getMediationManager() {
        Bundle bundle = new Bundle();
        bundle.putString("mediation_manager", "mediation_manager");
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager != null) {
            xr = adManager.getExtra(null, bundle);
        }
        if (xr == null) {
            return null;
        }
        if (this.ah == null) {
            this.ah = new ab(ao.ms(xr));
        }
        return this.ah;
    }
}
