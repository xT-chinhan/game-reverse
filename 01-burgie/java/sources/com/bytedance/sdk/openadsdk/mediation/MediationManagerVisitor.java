package com.bytedance.sdk.openadsdk.mediation;

import android.os.Bundle;
import com.byazt.ot.hw;
import com.byazt.vzx.pr;
import com.byazt.xjg.ho;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 78, 79, 80, 81, 1668})
public class MediationManagerVisitor {
    private static volatile Object hw;
    private static volatile MediationManagerVisitor pr;
    private hw hn;

    public static MediationManagerVisitor getInstance() {
        if (pr == null) {
            synchronized (MediationManagerVisitor.class) {
                if (pr == null) {
                    pr = new MediationManagerVisitor();
                }
            }
        }
        return pr;
    }

    private MediationManagerVisitor() {
    }

    public synchronized IMediationManager getMediationManager() {
        Bundle bundle = new Bundle();
        bundle.putString("mediation_manager", "mediation_manager");
        TTAdManager adManager = TTAdSdk.getAdManager();
        Object obj = hw;
        if (adManager != null) {
            hw = adManager.getExtra(null, bundle);
        }
        if (hw == null) {
            return null;
        }
        if (this.hn == null) {
            this.hn = new hw(ho.pr(hw));
        } else if (obj != hw) {
            this.hn.pr(ho.pr(hw));
        }
        return this.hn;
    }
}
