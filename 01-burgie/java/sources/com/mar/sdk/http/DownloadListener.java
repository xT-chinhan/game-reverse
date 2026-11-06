package com.mar.sdk.http;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public interface DownloadListener {
    void onComplete(File file);

    void onFail();

    void onSuc(int i);
}
