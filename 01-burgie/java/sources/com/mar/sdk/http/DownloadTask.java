package com.mar.sdk.http;

import android.util.Log;
import java.util.concurrent.ArrayBlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadTask implements Runnable {
    private final int MAX_TASK = Runtime.getRuntime().availableProcessors() * 2;
    private final ArrayBlockingQueue<Download> downloadList = new ArrayBlockingQueue<>(this.MAX_TASK);
    private final ArrayBlockingQueue<DownloadInfo> downloadQueue = new ArrayBlockingQueue<>(this.MAX_TASK);
    private final String TAG = "DownloadTask";

    public DownloadTask(Download download, DownloadInfo downloadInfo, DownloadListener downloadListener) {
        download.setListener(downloadListener);
        this.downloadList.offer(download);
        this.downloadQueue.offer(downloadInfo);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.downloadList.size() <= 0) {
            Log.d("DownloadTask", "download task is null");
            return;
        }
        try {
            this.downloadList.take().execute(this.downloadQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
