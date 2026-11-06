package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.downloader.DownloadService;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public interface ub<T extends DownloadService> {
    void ah();

    void ah(DownloadTask downloadTask);

    void d();

    IBinder ms(Intent intent);

    void ms(int i);

    void ms(int i, Notification notification);

    void ms(Intent intent, int i, int i2);

    void ms(u uVar);

    void ms(WeakReference<T> weakReference);

    void ms(boolean z);

    boolean ms();

    void startService();

    void xr(DownloadTask downloadTask);

    boolean xr();
}
