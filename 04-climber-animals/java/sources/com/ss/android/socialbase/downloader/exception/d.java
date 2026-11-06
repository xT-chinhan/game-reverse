package com.ss.android.socialbase.downloader.exception;

/* JADX INFO: loaded from: classes3.dex */
public class d extends BaseException {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final long f4669ms;
    private final long xr;

    public d(long j, long j2) {
        super(1006, String.format("space is not enough required space is : %s but available space is :%s", String.valueOf(j2), String.valueOf(j)));
        this.f4669ms = j;
        this.xr = j2;
    }

    public long ms() {
        return this.f4669ms;
    }

    public long xr() {
        return this.xr;
    }
}
