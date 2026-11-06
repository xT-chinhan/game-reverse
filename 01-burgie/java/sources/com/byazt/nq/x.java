package com.byazt.nq;

import com.bytedance.sdk.openadsdk.TTAdLoadType;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1373, 121})
public class x {
    public static Boolean pr = null;

    private static boolean pr() {
        if (pr == null) {
            try {
                Class.forName("com.bytedance.sdk.openadsdk.TTAdLoadType");
                pr = Boolean.TRUE;
            } catch (Throwable th) {
                pr = Boolean.FALSE;
            }
        }
        return pr.booleanValue();
    }

    public static int pr(Object obj) {
        if (obj == null) {
            return -1;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (pr()) {
            try {
                if (TTAdLoadType.LOAD == obj) {
                    return 3;
                }
                if (TTAdLoadType.PRELOAD == obj) {
                    return 1;
                }
                TTAdLoadType tTAdLoadType = TTAdLoadType.UNKNOWN;
                return -1;
            } catch (Throwable th) {
            }
        }
        return -1;
    }
}
