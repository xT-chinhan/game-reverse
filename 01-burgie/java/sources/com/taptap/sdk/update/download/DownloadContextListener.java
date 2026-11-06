package com.taptap.sdk.update.download;

import com.taptap.sdk.update.download.core.cause.EndCause;

/* JADX INFO: loaded from: classes3.dex */
public interface DownloadContextListener {
    void queueEnd(DownloadContext downloadContext);

    void taskEnd(DownloadContext downloadContext, DownloadTask downloadTask, EndCause endCause, Exception exc, int i);
}
