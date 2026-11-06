package com.byazt.xv;

import android.app.Notification;
import com.byazt.je.IDownloadFileUriProvider;
import com.byazt.je.IDownloadListener;
import com.byazt.je.f;
import com.byazt.je.h;
import com.byazt.je.lh;
import com.byazt.wm.DownloadInfo;
import com.byazt.wm.DownloadTask;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface oa {
    lh cd(int i);

    void cp(int i);

    boolean cy(int i);

    boolean d(int i);

    DownloadInfo fs(int i);

    h hd(int i);

    void k(int i);

    long l(int i);

    List<DownloadInfo> l(String str);

    boolean l();

    int n(String str, String str2);

    List<DownloadInfo> n(String str);

    void n();

    void n(int i);

    void n(int i, int i2);

    void n(int i, int i2, int i3, int i4);

    void n(int i, int i2, int i3, long j);

    void n(int i, int i2, long j);

    void n(int i, int i2, IDownloadListener iDownloadListener, com.byazt.sk.w wVar, boolean z);

    void n(int i, int i2, IDownloadListener iDownloadListener, com.byazt.sk.w wVar, boolean z, boolean z2);

    void n(int i, long j);

    void n(int i, Notification notification);

    void n(int i, h hVar);

    void n(int i, List<com.byazt.wm.qg> list);

    void n(int i, boolean z);

    void n(f fVar);

    void n(DownloadTask downloadTask);

    void n(com.byazt.wm.qg qgVar);

    void n(List<String> list);

    void n(boolean z, boolean z2);

    boolean n(DownloadInfo downloadInfo);

    int oa(int i);

    List<DownloadInfo> q();

    List<DownloadInfo> q(String str);

    void q(int i);

    DownloadInfo qg(String str, String str2);

    List<DownloadInfo> qg(String str);

    void qg(int i, int i2, IDownloadListener iDownloadListener, com.byazt.sk.w wVar, boolean z);

    void qg(int i, List<com.byazt.wm.qg> list);

    void qg(int i, boolean z);

    void qg(DownloadInfo downloadInfo);

    void qg(DownloadTask downloadTask);

    void qg(List<String> list);

    boolean qg();

    boolean qg(int i);

    List<com.byazt.wm.qg> rv(int i);

    List<DownloadInfo> s(String str);

    void s(int i);

    void s(int i, boolean z);

    boolean s();

    boolean s(DownloadInfo downloadInfo);

    void startService();

    boolean sz(int i);

    void tj(int i);

    IDownloadFileUriProvider um(int i);

    int w(int i);

    void w();

    boolean x();

    boolean x(int i);
}
