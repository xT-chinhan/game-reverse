package com.bytedance.sdk.openadsdk.core.nw;

/* JADX INFO: loaded from: classes2.dex */
public class vm {
    private int ah;
    private int d = 1;
    private int ka = 0;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f3107ms;
    private int xr;

    public int ms() {
        return this.f3107ms;
    }

    public void ms(int i) {
        if (i != 1 && i != 2 && i != 3 && i != 4) {
            this.f3107ms = 2;
        } else {
            this.f3107ms = i;
        }
    }

    public int xr() {
        return this.xr;
    }

    public void xr(int i) {
        if (i <= 0 || i >= ab()) {
            this.xr = 16;
        } else {
            this.xr = i;
        }
    }

    public int ah() {
        return this.ah;
    }

    public void ah(int i) {
        if (i <= 0 || i >= c()) {
            int i2 = this.f3107ms;
            if (i2 == 3 || i2 == 4) {
                this.ah = 30;
                return;
            } else {
                this.ah = 16;
                return;
            }
        }
        this.ah = i;
    }

    private int c() {
        return com.bytedance.sdk.openadsdk.core.jw.ul.d(com.bytedance.sdk.openadsdk.core.re.getContext(), com.bytedance.sdk.openadsdk.core.jw.ul.ka(com.bytedance.sdk.openadsdk.core.re.getContext()));
    }

    private int ab() {
        return com.bytedance.sdk.openadsdk.core.jw.ul.d(com.bytedance.sdk.openadsdk.core.re.getContext(), com.bytedance.sdk.openadsdk.core.jw.ul.d(com.bytedance.sdk.openadsdk.core.re.getContext()));
    }

    public int d() {
        return this.d == 2 ? 2 : 1;
    }

    public void d(int i) {
        this.d = i;
    }

    public int ka() {
        return this.ka;
    }

    public void ka(int i) {
        this.ka = i;
    }

    public static boolean ms(lm lmVar) {
        return (lmVar == null || lmVar.jf() == null || lmVar.jf().ka() != 1) ? false : true;
    }
}
