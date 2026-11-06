package com.tapsdk.tapad;

/* JADX INFO: loaded from: classes3.dex */
public interface TapAppDownloadListener {
    void onDownloadComplete();

    void onDownloadError();

    void onDownloadStart();

    void onIdle();

    void onInstalled();

    void onUpdateDownloadProgress(int i);
}
