package com.bytedance.sdk.openadsdk.core.hi;

/* JADX INFO: loaded from: classes2.dex */
public class d implements com.bytedance.sdk.openadsdk.core.jw.ms.xr {
    @Override // com.bytedance.sdk.openadsdk.core.jw.ms.xr
    public void ms() {
    }

    private d() {
        com.bytedance.sdk.openadsdk.core.jw.ms msVarD = com.bytedance.sdk.openadsdk.core.ch.ub().d();
        if (msVarD != null) {
            msVarD.ms(this);
        }
    }

    private static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static d f2638ms = new d();
    }

    public static d ah() {
        return ms.f2638ms;
    }

    @Override // com.bytedance.sdk.openadsdk.core.jw.ms.xr
    public void xr() {
        com.bytedance.sdk.openadsdk.op.ab.ms(new com.bytedance.sdk.component.ch.ny("dl_work") { // from class: com.bytedance.sdk.openadsdk.core.hi.d.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.ch.ub().ms(ch.ms());
            }
        });
    }
}
