package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ms {
    private long ab;
    private long ah;
    private int c = 0;
    private long d;
    private String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected Notification f4742ms;
    private boolean ny;
    private int x;
    private int xr;

    public abstract void ms(BaseException baseException, boolean z);

    public ms(int i, String str) {
        this.xr = i;
        this.ka = str;
    }

    public void ms(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.xr = downloadInfo.getId();
        this.ka = downloadInfo.getTitle();
    }

    public int ms() {
        return this.xr;
    }

    public long xr() {
        return this.ah;
    }

    public void ms(long j) {
        this.ah = j;
    }

    public long ah() {
        return this.d;
    }

    public void xr(long j) {
        this.d = j;
    }

    public String d() {
        return this.ka;
    }

    public int ka() {
        return this.c;
    }

    public void ms(int i, BaseException baseException, boolean z) {
        ms(i, baseException, z, false);
    }

    public void ms(int i, BaseException baseException, boolean z, boolean z2) {
        if (z2 || this.c != i) {
            this.c = i;
            ms(baseException, z);
        }
    }

    public long c() {
        if (this.ab == 0) {
            this.ab = System.currentTimeMillis();
        }
        return this.ab;
    }

    public void ms(long j, long j2) {
        this.ah = j;
        this.d = j2;
        this.c = 4;
        ms((BaseException) null, false);
    }

    public void ms(Notification notification) {
        if (this.xr == 0 || notification == null) {
            return;
        }
        xr.ms().ms(this.xr, this.c, notification);
    }

    public synchronized void ab() {
        this.x++;
    }

    public boolean x() {
        return this.ny;
    }
}
