package com.mar.sdk.http;

/* JADX INFO: loaded from: classes2.dex */
public interface HttpDownload extends HttpRequest {
    void execute(DownloadInfo downloadInfo);

    void setListener(DownloadListener downloadListener);
}
