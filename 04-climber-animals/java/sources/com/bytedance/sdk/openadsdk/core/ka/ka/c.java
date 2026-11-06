package com.bytedance.sdk.openadsdk.core.ka.ka;

import com.bytedance.sdk.openadsdk.op.ab;

/* JADX INFO: loaded from: classes2.dex */
public class c implements ka {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ka f2786ms;

    public c(ka kaVar) {
        this.f2786ms = kaVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ka.ka
    public void ms(final Object obj) {
        ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ka.ka.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f2786ms != null) {
                    c.this.f2786ms.ms(obj);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ka.ka
    public void xr(final Object obj) {
        ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ka.ka.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f2786ms != null) {
                    c.this.f2786ms.xr(obj);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ka.ka
    public void ms(final int i, final String str) {
        ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ka.ka.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f2786ms != null) {
                    c.this.f2786ms.ms(i, str);
                }
            }
        });
    }
}
