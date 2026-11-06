package com.byazt.tuy;

import android.util.SparseArray;
import com.byazt.auw.DownloadInfo;
import com.byazt.fn.AbsDownloadListener;
import com.byazt.fn.IDownloadListener;
import com.byazt.fn.qa;
import com.byazt.lhc.BaseException;
import com.byazt.mrs.DownloadStatus;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_OUTFPS_LIST, 20})
public class hn {
    public static void pr(int i, SparseArray<IDownloadListener> sparseArray, boolean z, DownloadInfo downloadInfo, BaseException baseException) {
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
                    switch (i) {
                        case DownloadStatus.INTERCEPT /* -7 */:
                            if (iDownloadListener instanceof AbsDownloadListener) {
                                ((AbsDownloadListener) iDownloadListener).onIntercept(downloadInfo);
                            }
                            break;
                        case DownloadStatus.FIRST_SUCCESS /* -6 */:
                            iDownloadListener.onFirstSuccess(downloadInfo);
                            break;
                        case DownloadStatus.PAUSED_BY_DB_INIT /* -5 */:
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
                        case 1:
                            iDownloadListener.onPrepare(downloadInfo);
                            break;
                        case 2:
                            iDownloadListener.onStart(downloadInfo);
                            break;
                        case 4:
                            iDownloadListener.onProgress(downloadInfo);
                            break;
                        case 5:
                            iDownloadListener.onRetry(downloadInfo, baseException);
                            break;
                        case 6:
                            iDownloadListener.onFirstStart(downloadInfo);
                            break;
                        case 7:
                            iDownloadListener.onRetryDelay(downloadInfo, baseException);
                            break;
                        case 11:
                            if (iDownloadListener instanceof qa) {
                                ((qa) iDownloadListener).pr(downloadInfo);
                            }
                            break;
                    }
                }
            }
        } catch (Throwable th) {
        }
    }
}
