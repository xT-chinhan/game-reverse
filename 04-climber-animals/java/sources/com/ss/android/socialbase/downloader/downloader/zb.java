package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.of;
import com.ss.android.socialbase.downloader.depend.ul;
import com.ss.android.socialbase.downloader.depend.yu;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface zb {
    boolean ab();

    boolean ab(int i);

    List<DownloadInfo> ah(String str);

    void ah(int i);

    void ah(int i, boolean z);

    boolean ah();

    boolean ah(DownloadInfo downloadInfo);

    boolean ao(int i);

    int c(int i);

    void c();

    void ch(int i);

    List<DownloadInfo> d();

    List<DownloadInfo> d(String str);

    void d(int i);

    yu h(int i);

    void hi(int i);

    long ka(int i);

    List<DownloadInfo> ka(String str);

    boolean ka();

    int ms(String str, String str2);

    List<DownloadInfo> ms(String str);

    void ms();

    void ms(int i);

    void ms(int i, int i2);

    void ms(int i, int i2, int i3, int i4);

    void ms(int i, int i2, int i3, long j);

    void ms(int i, int i2, long j);

    void ms(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.c cVar, boolean z);

    void ms(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.c cVar, boolean z, boolean z2);

    void ms(int i, long j);

    void ms(int i, Notification notification);

    void ms(int i, yu yuVar);

    void ms(int i, List<com.ss.android.socialbase.downloader.model.xr> list);

    void ms(int i, boolean z);

    void ms(ul ulVar);

    void ms(DownloadTask downloadTask);

    void ms(com.ss.android.socialbase.downloader.model.xr xrVar);

    void ms(List<String> list);

    void ms(boolean z, boolean z2);

    boolean ms(DownloadInfo downloadInfo);

    List<com.ss.android.socialbase.downloader.model.xr> ny(int i);

    of qv(int i);

    boolean sl(int i);

    void startService();

    boolean u(int i);

    void ub(int i);

    DownloadInfo x(int i);

    DownloadInfo xr(String str, String str2);

    List<DownloadInfo> xr(String str);

    void xr(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.c cVar, boolean z);

    void xr(int i, List<com.ss.android.socialbase.downloader.model.xr> list);

    void xr(int i, boolean z);

    void xr(DownloadInfo downloadInfo);

    void xr(DownloadTask downloadTask);

    void xr(List<String> list);

    boolean xr();

    boolean xr(int i);

    IDownloadFileUriProvider y(int i);

    int zb(int i);
}
