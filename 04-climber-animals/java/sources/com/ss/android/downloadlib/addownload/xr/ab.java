package com.ss.android.downloadlib.addownload.xr;

/* JADX INFO: loaded from: classes3.dex */
public class ab {
    private String ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f4447ms;
    private int xr;

    public ab(int i) {
        this(i, 0, null);
    }

    public ab(int i, int i2) {
        this(i, i2, null);
    }

    public ab(int i, String str) {
        this(i, 0, str);
    }

    public ab(int i, int i2, String str) {
        this.f4447ms = i;
        this.xr = i2;
        this.ah = str;
    }

    public int getType() {
        return this.f4447ms;
    }

    public int ms() {
        return this.xr;
    }

    public String xr() {
        return this.ah;
    }
}
