package com.byazt.fn;

import com.byazt.auw.DownloadInfo;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 157, 37})
public abstract class pr extends AbsDownloadListener implements qa {
    public static final String pr = pr.class.getSimpleName();

    public void pr(DownloadInfo downloadInfo) {
        if (com.byazt.p000do.pr.pr() && downloadInfo != null) {
            com.byazt.p000do.pr.hw(pr, " onWaitingDownloadCompleteHandler -- " + downloadInfo.getName());
        }
    }
}
