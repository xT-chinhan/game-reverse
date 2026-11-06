package com.bytedance.sdk.openadsdk.core.nw;

/* JADX INFO: loaded from: classes2.dex */
public class s {
    private int ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f3093ms;
    private int xr;

    public int ms() {
        return this.f3093ms;
    }

    public void ms(int i) {
        if (i != 1 && i != 2) {
            i = 0;
        }
        this.f3093ms = i;
    }

    public int xr() {
        return this.xr;
    }

    public void xr(int i) {
        if (i <= 0 || i >= d()) {
            int i2 = this.f3093ms;
            if (i2 == 1) {
                this.xr = 90;
                return;
            } else {
                if (i2 == 2) {
                    this.xr = 150;
                    return;
                }
                return;
            }
        }
        this.xr = i;
    }

    public int ah() {
        return this.ah;
    }

    public void ah(int i) {
        if (i <= 0 || i >= d()) {
            int i2 = this.f3093ms;
            if (i2 == 1) {
                this.ah = 90;
                return;
            } else {
                if (i2 == 2) {
                    this.ah = 150;
                    return;
                }
                return;
            }
        }
        this.ah = i;
    }

    private int d() {
        return com.bytedance.sdk.openadsdk.core.jw.ul.d(com.bytedance.sdk.openadsdk.core.re.getContext(), com.bytedance.sdk.openadsdk.core.jw.ul.ka(com.bytedance.sdk.openadsdk.core.re.getContext()));
    }
}
