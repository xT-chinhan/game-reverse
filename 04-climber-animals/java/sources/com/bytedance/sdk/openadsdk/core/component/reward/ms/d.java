package com.bytedance.sdk.openadsdk.core.component.reward.ms;

import com.bytedance.sdk.openadsdk.core.nw.x;
import com.bytedance.sdk.openadsdk.core.re;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final com.bytedance.sdk.openadsdk.core.ka.ah.ms f2223ms = new com.bytedance.sdk.openadsdk.core.ka.ah.xr(7);
    private static final com.bytedance.sdk.openadsdk.core.ka.ah.ms xr = new com.bytedance.sdk.openadsdk.core.ka.ah.xr(8);
    private static final com.bytedance.sdk.openadsdk.core.ka.ah.ms ah = new com.bytedance.sdk.openadsdk.core.ka.ah.ka(7);
    private static final com.bytedance.sdk.openadsdk.core.ka.ah.ms d = new com.bytedance.sdk.openadsdk.core.ka.ah.ka(8);
    private static final com.bytedance.sdk.openadsdk.core.ka.ah.ms ka = new com.bytedance.sdk.openadsdk.core.ka.ah.d(7);
    private static final com.bytedance.sdk.openadsdk.core.ka.ah.ms c = new com.bytedance.sdk.openadsdk.core.ka.ah.d(8);
    private static final com.bytedance.sdk.openadsdk.core.ka.ah.ms ab = new com.bytedance.sdk.openadsdk.core.ka.ah.ah(7);
    private static final com.bytedance.sdk.openadsdk.core.ka.ah.ms x = new com.bytedance.sdk.openadsdk.core.ka.ah.ah(8);

    public static int ms(boolean z) {
        x.ms msVarMs = z ? x.ms() : x.xr();
        if (!msVarMs.ab() || !re.xr().ci()) {
            return -1;
        }
        int iD = msVarMs.d();
        if (iD < 0 || iD == 2 || iD > 4) {
            return 1;
        }
        return iD;
    }

    public static com.bytedance.sdk.openadsdk.core.ka.ah.ms ms(boolean z, boolean z2) {
        if (z2) {
            return z ? ab : x;
        }
        int iMs = ms(z);
        if (iMs == -1) {
            return z ? ab : x;
        }
        if (iMs == 0) {
            return z ? f2223ms : xr;
        }
        if (iMs != 3) {
            return z ? ah : d;
        }
        return z ? ka : c;
    }
}
