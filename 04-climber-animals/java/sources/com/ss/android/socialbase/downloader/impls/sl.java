package com.ss.android.socialbase.downloader.impls;

/* JADX INFO: loaded from: classes3.dex */
public class sl {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile com.ss.android.socialbase.downloader.downloader.zb f4701ms;
    private static volatile com.ss.android.socialbase.downloader.downloader.zb xr;

    public static com.ss.android.socialbase.downloader.downloader.zb ms(boolean z) {
        if (z && com.ss.android.socialbase.downloader.downloader.ah.qf()) {
            if (xr == null) {
                synchronized (sl.class) {
                    if (xr == null) {
                        xr = com.ss.android.socialbase.downloader.downloader.ah.l().xr();
                    }
                }
            }
            return xr;
        }
        if (f4701ms == null) {
            synchronized (sl.class) {
                if (f4701ms == null) {
                    f4701ms = new ao();
                }
            }
        }
        return f4701ms;
    }
}
