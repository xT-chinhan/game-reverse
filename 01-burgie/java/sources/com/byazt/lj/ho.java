package com.byazt.lj;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import com.byazt.auw.DownloadTask;
import com.byazt.lj.CSJDownloadService;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public interface ho<T extends CSJDownloadService> {
    void hn();

    void hn(DownloadTask downloadTask);

    void hw(DownloadTask downloadTask);

    boolean hw();

    IBinder pr(Intent intent);

    void pr(int i);

    void pr(int i, Notification notification);

    void pr(Intent intent, int i, int i2);

    void pr(g gVar);

    void pr(WeakReference<T> weakReference);

    void pr(boolean z);

    boolean pr();

    void startService();

    void x();
}
