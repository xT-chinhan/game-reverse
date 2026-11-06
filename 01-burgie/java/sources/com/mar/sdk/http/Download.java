package com.mar.sdk.http;

import android.util.Log;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class Download implements HttpDownload {
    private final String TAG = "Download";
    private DownloadListener listener;

    @Override // com.mar.sdk.http.HttpDownload
    public void setListener(DownloadListener listener) {
        this.listener = listener;
    }

    @Override // com.mar.sdk.http.HttpDownload
    public void execute(DownloadInfo downloadInfo) {
        if (downloadInfo.getRandomAccessFile() != null) {
            int st = downloadInfo.getStart();
            int ed = downloadInfo.getEnd();
            Log.d("Download", "execute: start download: start:" + st + ", end:" + ed);
            HttpConnect.download(downloadInfo, this.listener);
            return;
        }
        Log.d("Download", "execute: get file size");
        HttpConnect.getNetFileSize(downloadInfo.getUrl(), this.listener);
    }

    @Override // com.mar.sdk.http.HttpRequest
    public void url(String url) {
    }

    @Override // com.mar.sdk.http.HttpRequest
    public void header(String header) {
    }

    @Override // com.mar.sdk.http.HttpRequest
    public void params(Map<String, String> params) {
    }

    @Override // com.mar.sdk.http.HttpRequest
    public void params(String json) {
    }

    @Override // com.mar.sdk.http.HttpRequest
    public void setListener(HttpListener listener) {
    }

    @Override // com.mar.sdk.http.HttpRequest
    public void execute() {
    }

    @Override // com.mar.sdk.http.HttpRequest
    public String call() {
        return null;
    }
}
