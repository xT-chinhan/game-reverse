package com.byazt.eld;

import android.content.Context;
import com.byazt.bek.DownloadController;
import com.byazt.bek.DownloadEventConfig;
import com.byazt.bek.DownloadModel;
import com.byazt.bek.DownloadStatusChangeListener;
import com.byazt.zv.IDownloadButtonClickListener;
import com.byazt.zv.OnItemClickListener;

/* JADX INFO: loaded from: classes.dex */
public interface fw {
    fw hw(int i, DownloadStatusChangeListener downloadStatusChangeListener);

    fw hw(Context context);

    fw hw(DownloadController downloadController);

    fw hw(DownloadEventConfig downloadEventConfig);

    fw hw(DownloadModel downloadModel);

    void hw(int i);

    boolean hw();

    fw pr(long j);

    fw pr(IDownloadButtonClickListener iDownloadButtonClickListener);

    fw pr(OnItemClickListener onItemClickListener);

    fw pr(String str);

    void pr();

    void pr(boolean z);

    boolean pr(int i);

    long x();

    void zo();
}
