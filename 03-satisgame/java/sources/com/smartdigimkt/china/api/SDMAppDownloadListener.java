package com.smartdigimkt.china.api;

import com.smartdigimkt.sdk.api.SDMEventInterface;

/* JADX INFO: loaded from: classes3.dex */
public interface SDMAppDownloadListener extends SDMEventInterface {
    void onDownloadFail(long j, long j2, String str, String str2);

    void onDownloadFinish(long j, String str, String str2);

    void onDownloadPause(long j, long j2, String str, String str2);

    void onDownloadStart(long j, long j2, String str, String str2);

    void onDownloadUpdate(long j, long j2, String str, String str2);

    void onInstalled(String str, String str2);
}
