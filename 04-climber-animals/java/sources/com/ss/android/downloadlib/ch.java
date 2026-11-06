package com.ss.android.downloadlib;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.downloadlib.addownload.hi;
import com.ss.android.downloadlib.addownload.zb;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes3.dex */
public class ch {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile ch f4484ms;
    private final x ah;
    private long c;
    private final com.ss.android.downloadad.api.ms d;
    private com.ss.android.downloadad.api.xr ka;
    private final com.ss.android.download.api.ms xr;

    public static ch ms(final Context context) {
        if (f4484ms == null) {
            synchronized (ch.class) {
                if (f4484ms == null) {
                    com.ss.android.downloadlib.ka.xr.ms(new Runnable() { // from class: com.ss.android.downloadlib.ch.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ch unused = ch.f4484ms = new ch(context);
                        }
                    });
                }
            }
        }
        return f4484ms;
    }

    private ch(Context context) {
        this.ah = x.ms();
        this.xr = new c();
        this.c = System.currentTimeMillis();
        xr(context);
        this.d = ms.ms();
    }

    private void xr(Context context) {
        hi.ms(context);
        Downloader.getInstance(hi.getContext());
        com.ss.android.downloadlib.addownload.xr.c.ms().xr();
        com.ss.android.socialbase.appdownloader.d.ch().ms(hi.getContext(), "misc_config", new com.ss.android.downloadlib.ah.ab(), new com.ss.android.downloadlib.ah.c(context), new ah());
        com.ss.android.downloadlib.ah.d dVar = new com.ss.android.downloadlib.ah.d();
        com.ss.android.socialbase.appdownloader.d.ch().ms(dVar);
        Downloader.getInstance(context).registerDownloadCacheSyncListener(dVar);
        com.ss.android.socialbase.appdownloader.d.ch().ms(new zb());
        com.ss.android.socialbase.downloader.downloader.ah.ms(new com.ss.android.downloadlib.ah.ka());
        com.ss.android.socialbase.appdownloader.d.ch().ms(com.ss.android.downloadlib.c.ah.ms());
    }

    public com.ss.android.download.api.ms ms() {
        return this.xr;
    }

    public com.ss.android.download.api.ms ms(String str) {
        com.ss.android.download.api.config.c cVarXr = ab.ms().xr();
        if (cVarXr != null && cVarXr.ms(str)) {
            return cVarXr.xr(str);
        }
        return this.xr;
    }

    public long xr() {
        return this.c;
    }

    public void ah() {
        this.c = System.currentTimeMillis();
    }

    public com.ss.android.downloadad.api.ms d() {
        return this.d;
    }

    public com.ss.android.downloadad.api.xr ka() {
        if (this.ka == null) {
            this.ka = xr.ms();
        }
        return this.ka;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public x x() {
        return this.ah;
    }

    public void ms(final Context context, final int i, final DownloadStatusChangeListener downloadStatusChangeListener, final DownloadModel downloadModel) {
        com.ss.android.downloadlib.ka.xr.ms(new Runnable() { // from class: com.ss.android.downloadlib.ch.4
            @Override // java.lang.Runnable
            public void run() {
                ch.this.x().ms(context, i, downloadStatusChangeListener, downloadModel);
            }
        });
    }

    public void ms(final String str, final long j, final int i, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final OnItemClickListener onItemClickListener, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.ka.xr.ms(new Runnable() { // from class: com.ss.android.downloadlib.ch.5
            @Override // java.lang.Runnable
            public void run() {
                ch.this.x().ms(str, j, i, downloadEventConfig, downloadController, onItemClickListener, iDownloadButtonClickListener);
            }
        });
    }

    public void ms(final String str, final long j, final int i, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController) {
        com.ss.android.downloadlib.ka.xr.ms(new Runnable() { // from class: com.ss.android.downloadlib.ch.6
            @Override // java.lang.Runnable
            public void run() {
                ch.this.x().ms(str, j, i, downloadEventConfig, downloadController);
            }
        });
    }

    public void ms(final String str, final long j, final int i, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.ka.xr.ms(new Runnable() { // from class: com.ss.android.downloadlib.ch.7
            @Override // java.lang.Runnable
            public void run() {
                ch.this.x().ms(str, j, i, downloadEventConfig, downloadController, iDownloadButtonClickListener);
            }
        });
    }

    public void ms(final String str, final int i) {
        com.ss.android.downloadlib.ka.xr.ms(new Runnable() { // from class: com.ss.android.downloadlib.ch.2
            @Override // java.lang.Runnable
            public void run() {
                ch.this.x().ms(str, i);
            }
        });
    }

    public void ms(final String str, final boolean z) {
        com.ss.android.downloadlib.ka.xr.ms(new Runnable() { // from class: com.ss.android.downloadlib.ch.3
            @Override // java.lang.Runnable
            public void run() {
                ch.this.x().ms(str, z);
            }
        });
    }

    public void ms(com.ss.android.download.api.download.ms.ms msVar) {
        x().ms(msVar);
    }

    public String c() {
        return hi.u();
    }

    public void ab() {
        ka.ms().c();
    }

    public DownloadInfo xr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.ss.android.socialbase.appdownloader.d.ch().ms(hi.getContext(), str);
    }

    public DownloadInfo ms(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str2) && z) {
            return xr(str);
        }
        return Downloader.getInstance(hi.getContext()).getDownloadInfo(str, str2);
    }
}
