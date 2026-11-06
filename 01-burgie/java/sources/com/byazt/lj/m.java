package com.byazt.lj;

import android.app.Notification;
import com.byazt.auw.DownloadInfo;
import com.byazt.auw.DownloadTask;
import com.byazt.fn.IDownloadFileUriProvider;
import com.byazt.fn.IDownloadListener;
import com.byazt.fn.b;
import com.byazt.fn.ls;
import com.byazt.fn.y;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface m {
    List<com.byazt.auw.hw> aj(int i);

    long c(int i);

    List<DownloadInfo> c(String str);

    boolean c();

    boolean fw();

    boolean fw(int i);

    boolean g(int i);

    List<DownloadInfo> hn(String str);

    void hn(int i);

    void hn(int i, boolean z);

    boolean hn();

    boolean hn(DownloadInfo downloadInfo);

    void ho(int i);

    DownloadInfo hw(String str, String str2);

    List<DownloadInfo> hw(String str);

    void hw(int i, int i2, IDownloadListener iDownloadListener, com.byazt.mrs.uc ucVar, boolean z);

    void hw(int i, List<com.byazt.auw.hw> list);

    void hw(int i, boolean z);

    void hw(DownloadInfo downloadInfo);

    void hw(DownloadTask downloadTask);

    void hw(List<String> list);

    boolean hw();

    boolean hw(int i);

    boolean k(int i);

    y lb(int i);

    int m(int i);

    boolean nt(int i);

    int pr(String str, String str2);

    List<DownloadInfo> pr(String str);

    void pr();

    void pr(int i);

    void pr(int i, int i2);

    void pr(int i, int i2, int i3, int i4);

    void pr(int i, int i2, int i3, long j);

    void pr(int i, int i2, long j);

    void pr(int i, int i2, IDownloadListener iDownloadListener, com.byazt.mrs.uc ucVar, boolean z);

    void pr(int i, int i2, IDownloadListener iDownloadListener, com.byazt.mrs.uc ucVar, boolean z, boolean z2);

    void pr(int i, long j);

    void pr(int i, Notification notification);

    void pr(int i, b bVar);

    void pr(int i, List<com.byazt.auw.hw> list);

    void pr(int i, boolean z);

    void pr(DownloadTask downloadTask);

    void pr(com.byazt.auw.hw hwVar);

    void pr(ls lsVar);

    void pr(List<String> list);

    void pr(boolean z, boolean z2);

    boolean pr(DownloadInfo downloadInfo);

    IDownloadFileUriProvider qa(int i);

    void startService();

    int uc(int i);

    void uc();

    void vk(int i);

    void w(int i);

    List<DownloadInfo> x();

    List<DownloadInfo> x(String str);

    void x(int i);

    b yb(int i);

    DownloadInfo zo(int i);
}
