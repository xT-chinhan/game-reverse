package com.byazt.xv;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import com.byazt.wm.DownloadTask;
import com.byazt.xv.CSJDownloadService;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public interface k<T extends CSJDownloadService> {
    IBinder n(Intent intent);

    void n(int i);

    void n(int i, Notification notification);

    void n(Intent intent, int i, int i2);

    void n(sz szVar);

    void n(WeakReference<T> weakReference);

    void n(boolean z);

    boolean n();

    void q();

    void qg(DownloadTask downloadTask);

    boolean qg();

    void s();

    void s(DownloadTask downloadTask);

    void startService();
}
