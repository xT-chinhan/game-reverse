package com.byazt.j;

import android.content.Context;
import com.byazt.qx.BaseException;
import com.byazt.wm.DownloadInfo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_COUNT, 26})
public class qg extends com.byazt.je.q {
    public String l;
    public Context n;
    public String q;
    public int qg;
    public String s;
    public String w;
    public com.byazt.av.n x;

    public qg(Context context, int i, String str, String str2, String str3, String str4) {
        if (context != null) {
            this.n = context.getApplicationContext();
        } else {
            this.n = com.byazt.xv.s.u();
        }
        this.qg = i;
        this.s = str;
        this.q = str2;
        this.l = str3;
        this.w = str4;
    }

    public qg(com.byazt.av.n nVar) {
        this.n = com.byazt.xv.s.u();
        this.x = nVar;
    }

    @Override // com.byazt.je.q
    public com.byazt.av.n n() {
        com.byazt.av.n nVar = this.x;
        return (nVar != null || this.n == null) ? nVar : new n(this.n, this.qg, this.s, this.q, this.l, this.w);
    }

    @Override // com.byazt.je.q, com.byazt.je.AbsDownloadListener, com.byazt.je.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onPrepare(downloadInfo);
    }

    @Override // com.byazt.je.q, com.byazt.je.AbsDownloadListener, com.byazt.je.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onStart(downloadInfo);
    }

    @Override // com.byazt.je.q, com.byazt.je.AbsDownloadListener, com.byazt.je.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onPause(downloadInfo);
    }

    @Override // com.byazt.je.q, com.byazt.je.AbsDownloadListener, com.byazt.je.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onProgress(downloadInfo);
    }

    @Override // com.byazt.je.q, com.byazt.je.AbsDownloadListener, com.byazt.je.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        if (downloadInfo == null || this.n == null) {
            return;
        }
        if (downloadInfo.canShowNotification() && (!downloadInfo.isAutoInstallWithoutNotification() || !downloadInfo.isAutoInstall())) {
            super.onSuccessed(downloadInfo);
        }
        if (downloadInfo.isAutoInstall()) {
            com.byazt.bk.qg.n(downloadInfo);
        }
    }

    @Override // com.byazt.je.q, com.byazt.je.AbsDownloadListener, com.byazt.je.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo == null || this.n == null || !downloadInfo.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onFailed(downloadInfo, baseException);
    }
}
