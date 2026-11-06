package com.tapsdk.tapad;

/* JADX INFO: loaded from: classes2.dex */
public interface TapAppDownloadListener {
    void onDownloadComplete();

    void onDownloadError();

    default void onDownloadPause() {
    }

    void onDownloadStart();

    void onIdle();

    void onInstalled();

    void onUpdateDownloadProgress(int i);
}
