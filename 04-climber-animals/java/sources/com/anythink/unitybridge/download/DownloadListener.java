package com.anythink.unitybridge.download;

/* JADX INFO: loaded from: classes.dex */
public interface DownloadListener {
    void onDownloadFail(String str, String str2, long j, long j2, String str3, String str4);

    void onDownloadFinish(String str, String str2, long j, String str3, String str4);

    void onDownloadPause(String str, String str2, long j, long j2, String str3, String str4);

    void onDownloadStart(String str, String str2, long j, long j2, String str3, String str4);

    void onDownloadUpdate(String str, String str2, long j, long j2, String str3, String str4);

    void onInstalled(String str, String str2, String str3, String str4);
}
