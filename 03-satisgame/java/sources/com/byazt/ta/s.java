package com.byazt.ta;

import android.util.SparseArray;
import com.byazt.je.AbsDownloadListener;
import com.byazt.je.IDownloadListener;
import com.byazt.je.um;
import com.byazt.qx.BaseException;
import com.byazt.wm.DownloadInfo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME, 8})
public class s {
    public static void n(int i, SparseArray<IDownloadListener> sparseArray, boolean z, DownloadInfo downloadInfo, BaseException baseException) {
        SparseArray<IDownloadListener> sparseArrayClone;
        if (!z || sparseArray == null) {
            return;
        }
        try {
            if (sparseArray.size() <= 0) {
                return;
            }
            synchronized (sparseArray) {
                sparseArrayClone = sparseArray.clone();
            }
            for (int i2 = 0; i2 < sparseArrayClone.size(); i2++) {
                IDownloadListener iDownloadListener = sparseArrayClone.get(sparseArrayClone.keyAt(i2));
                if (iDownloadListener != null) {
                    if (i == 1) {
                        iDownloadListener.onPrepare(downloadInfo);
                    } else if (i == 2) {
                        iDownloadListener.onStart(downloadInfo);
                    } else if (i == 4) {
                        iDownloadListener.onProgress(downloadInfo);
                    } else if (i == 5) {
                        iDownloadListener.onRetry(downloadInfo, baseException);
                    } else if (i == 6) {
                        iDownloadListener.onFirstStart(downloadInfo);
                    } else if (i == 7) {
                        iDownloadListener.onRetryDelay(downloadInfo, baseException);
                    } else if (i != 11) {
                        switch (i) {
                            case -7:
                                if (iDownloadListener instanceof AbsDownloadListener) {
                                    ((AbsDownloadListener) iDownloadListener).onIntercept(downloadInfo);
                                }
                                break;
                            case -6:
                                iDownloadListener.onFirstSuccess(downloadInfo);
                                break;
                            case -5:
                            case -2:
                                iDownloadListener.onPause(downloadInfo);
                                break;
                            case -4:
                                iDownloadListener.onCanceled(downloadInfo);
                                break;
                            case -3:
                                iDownloadListener.onSuccessed(downloadInfo);
                                break;
                            case -1:
                                iDownloadListener.onFailed(downloadInfo, baseException);
                                break;
                        }
                    } else if (iDownloadListener instanceof um) {
                        ((um) iDownloadListener).n(downloadInfo);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }
}
