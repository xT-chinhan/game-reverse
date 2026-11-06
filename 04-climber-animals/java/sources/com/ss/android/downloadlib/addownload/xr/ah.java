package com.ss.android.downloadlib.addownload.xr;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ah {
    public static int ah = 2;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static int f4448ms = 0;
    public static int xr = 1;
    private int d = f4448ms;
    private long ka = 0;
    private JSONObject c = null;
    private int ab = 0;
    private String x = "";
    private String ny = "";

    public boolean ms() {
        return this.d == xr;
    }

    public int xr() {
        return this.ab;
    }

    public ah ms(int i) {
        this.d = i;
        return this;
    }

    public ah xr(int i) {
        this.ab = i;
        return this;
    }
}
