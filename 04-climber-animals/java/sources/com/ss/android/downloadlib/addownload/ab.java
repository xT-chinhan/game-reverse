package com.ss.android.downloadlib.addownload;

import android.content.Context;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;

/* JADX INFO: loaded from: classes3.dex */
public interface ab {
    long d();

    ab ms(long j);

    ab ms(IDownloadButtonClickListener iDownloadButtonClickListener);

    ab ms(OnItemClickListener onItemClickListener);

    ab ms(String str);

    void ms();

    void ms(boolean z);

    boolean ms(int i);

    void x();

    ab xr(int i, DownloadStatusChangeListener downloadStatusChangeListener);

    ab xr(Context context);

    ab xr(DownloadController downloadController);

    ab xr(DownloadEventConfig downloadEventConfig);

    ab xr(DownloadModel downloadModel);

    void xr(int i);

    boolean xr();
}
