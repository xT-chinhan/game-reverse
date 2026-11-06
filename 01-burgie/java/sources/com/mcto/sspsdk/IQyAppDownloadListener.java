package com.mcto.sspsdk;

/* JADX INFO: loaded from: classes2.dex */
public interface IQyAppDownloadListener {
    void onDownloadActive(float f, String str);

    void onDownloadFailed(String str);

    void onDownloadFinished(String str);

    void onDownloadPaused(float f, String str);

    void onIdle();

    void onInstalled(String str);
}
