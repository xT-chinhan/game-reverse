package com.tapsdk.tapad.group.ads;

/* JADX INFO: loaded from: classes2.dex */
public interface DirichletAppDownloadListener {
    void onDownloadComplete();

    void onDownloadError();

    default void onDownloadPause() {
    }

    void onDownloadStart();

    void onIdle();

    void onInstalled();

    void onUpdateDownloadProgress(int i);
}
