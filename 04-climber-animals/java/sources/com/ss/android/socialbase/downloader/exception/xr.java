package com.ss.android.socialbase.downloader.exception;

/* JADX INFO: loaded from: classes3.dex */
public class xr extends BaseException {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final int f4673ms;

    public xr(int i, int i2, String str) {
        super(i, str);
        this.f4673ms = i2;
    }

    public int ms() {
        return this.f4673ms;
    }
}
