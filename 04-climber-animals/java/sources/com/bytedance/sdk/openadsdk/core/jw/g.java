package com.bytedance.sdk.openadsdk.core.jw;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile boolean f2702ms = false;

    static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        static final com.bytedance.sdk.component.ab.d.ms f2703ms = g.d();
    }

    public static int xr() {
        return 3;
    }

    private static String xr(String str) {
        return (f2702ms || com.bytedance.sdk.component.utils.h.ms(com.bytedance.sdk.openadsdk.core.re.getContext())) ? str : str + com.bytedance.sdk.component.utils.h.xr(com.bytedance.sdk.openadsdk.core.re.getContext());
    }

    public static com.bytedance.sdk.component.d.ms.xr ms(String str) {
        return ms.f2703ms.ms(xr(str)).ms();
    }

    public static void ms() {
        f2702ms = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.bytedance.sdk.component.ab.d.ms d() {
        com.bytedance.sdk.openadsdk.core.g.ch chVarXr = com.bytedance.sdk.openadsdk.core.re.xr();
        chVarXr.us();
        return new com.bytedance.sdk.component.ab.d.ms().ms(com.bytedance.sdk.openadsdk.core.re.getContext()).ms(1).xr(chVarXr.bk()).ms(f2702ms);
    }
}
