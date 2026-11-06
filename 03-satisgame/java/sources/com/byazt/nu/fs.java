package com.byazt.nu;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1243, 101})
public class fs {
    public float n;
    public int qg;

    public void n(float f) {
        float f2 = this.n + f;
        this.n = f2;
        int i = this.qg + 1;
        this.qg = i;
        if (i == Integer.MAX_VALUE) {
            this.n = f2 / 2.0f;
            this.qg = i / 2;
        }
    }
}
