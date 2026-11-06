package com.bytedance.pangle.ab.ms;

/* JADX INFO: loaded from: classes2.dex */
public class ka {
    public com.bytedance.pangle.ah.ms ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public String f613ms;
    public int xr;

    public ka(String str, int i) {
        this.f613ms = str;
        this.xr = i;
    }

    public ka(com.bytedance.pangle.ah.ms msVar) {
        if (msVar != null) {
            this.f613ms = msVar.xr();
            this.xr = msVar.ah();
            this.ah = msVar;
        }
    }
}
