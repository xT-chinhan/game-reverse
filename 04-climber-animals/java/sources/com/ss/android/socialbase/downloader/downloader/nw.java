package com.ss.android.socialbase.downloader.downloader;

import com.ss.android.socialbase.downloader.network.IDownloadHttpService;

/* JADX INFO: loaded from: classes3.dex */
public interface nw {

    public static class ms implements nw {
        @Override // com.ss.android.socialbase.downloader.downloader.nw
        public com.ss.android.socialbase.downloader.network.x ah() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.nw
        public com.ss.android.socialbase.downloader.exception.ab ms(Throwable th, String str) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.nw
        public boolean ms() {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.nw
        public boolean ms(Throwable th) {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.nw
        public IDownloadHttpService xr() {
            return null;
        }
    }

    com.ss.android.socialbase.downloader.network.x ah();

    com.ss.android.socialbase.downloader.exception.ab ms(Throwable th, String str);

    boolean ms();

    boolean ms(Throwable th);

    IDownloadHttpService xr();
}
