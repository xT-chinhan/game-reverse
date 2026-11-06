package com.byazt.ug;

import android.content.Context;
import com.byazt.hj.DownloadController;
import com.byazt.hj.DownloadEventConfig;
import com.byazt.hj.DownloadModel;
import com.byazt.hj.DownloadStatusChangeListener;
import com.byazt.ky.IDownloadButtonClickListener;
import com.byazt.ky.OnItemClickListener;

/* JADX INFO: loaded from: classes2.dex */
public interface x {
    void fs();

    x n(long j);

    x n(IDownloadButtonClickListener iDownloadButtonClickListener);

    x n(OnItemClickListener onItemClickListener);

    x n(String str);

    void n();

    void n(boolean z);

    boolean n(int i);

    long q();

    x qg(int i, DownloadStatusChangeListener downloadStatusChangeListener);

    x qg(Context context);

    x qg(DownloadController downloadController);

    x qg(DownloadEventConfig downloadEventConfig);

    x qg(DownloadModel downloadModel);

    void qg(int i);

    boolean qg();
}
