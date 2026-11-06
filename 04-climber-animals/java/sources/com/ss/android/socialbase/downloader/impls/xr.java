package com.ss.android.socialbase.downloader.impls;

/* JADX INFO: loaded from: classes3.dex */
public class xr implements com.ss.android.socialbase.downloader.downloader.ab {
    @Override // com.ss.android.socialbase.downloader.downloader.ab
    public int ms(int i, com.ss.android.socialbase.downloader.network.sl slVar) {
        if (slVar.ordinal() <= com.ss.android.socialbase.downloader.network.sl.MODERATE.ordinal()) {
            return 1;
        }
        return slVar == com.ss.android.socialbase.downloader.network.sl.GOOD ? i - 1 : i;
    }
}
