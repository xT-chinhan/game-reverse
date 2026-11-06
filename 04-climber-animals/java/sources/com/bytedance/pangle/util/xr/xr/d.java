package com.bytedance.pangle.util.xr.xr;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    private final File d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ms f706ms = new ms();
    private xr xr = new xr();
    private final com.bytedance.pangle.util.xr.ms.ah ah = new com.bytedance.pangle.util.xr.ms.ah();

    public d(String str) {
        this.d = new File(str);
    }

    public ms ms() {
        return this.f706ms;
    }

    public void ms(ms msVar) {
        this.f706ms = msVar;
    }

    public xr xr() {
        return this.xr;
    }

    public void ms(xr xrVar) {
        this.xr = xrVar;
    }

    public File ah() {
        return this.d;
    }

    public com.bytedance.pangle.util.xr.ms.ah d() {
        return this.ah;
    }
}
