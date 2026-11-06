package com.bykv.vk.openvk.component.video.api.ah;

/* JADX INFO: loaded from: classes.dex */
public class xr {
    private String ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f18ms;
    private int xr;

    public xr(int i, int i2) {
        this.f18ms = i;
        this.xr = i2;
    }

    public xr(int i, int i2, String str) {
        this.f18ms = i;
        this.xr = i2;
        this.ah = str;
    }

    public int ms() {
        return this.f18ms;
    }

    public int xr() {
        return this.xr;
    }

    public String ah() {
        return this.ah;
    }

    public void ms(String str) {
        this.ah = str;
    }
}
