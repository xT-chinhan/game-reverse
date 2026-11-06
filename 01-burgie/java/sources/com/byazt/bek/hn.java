package com.byazt.bek;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_POST_STALL_500, 20})
@Deprecated
public class hn implements DownloadController {
    @Override // com.byazt.bek.DownloadController
    public int getLinkMode() {
        return 0;
    }

    @Override // com.byazt.bek.DownloadController
    public int getDownloadMode() {
        return 0;
    }

    @Override // com.byazt.bek.DownloadController
    public boolean isEnableBackDialog() {
        return false;
    }

    @Override // com.byazt.bek.DownloadController
    public boolean isAddToDownloadManage() {
        return false;
    }

    @Override // com.byazt.bek.DownloadController
    public boolean isEnableMultipleDownload() {
        return false;
    }

    @Override // com.byazt.bek.DownloadController
    public int getDowloadChunkCount() {
        return 0;
    }

    @Override // com.byazt.bek.DownloadController
    public Object getExtraClickOperation() {
        return null;
    }

    @Override // com.byazt.bek.DownloadController
    public boolean shouldUseNewWebView() {
        return false;
    }

    @Override // com.byazt.bek.DownloadController
    public int getInterceptFlag() {
        return 0;
    }

    @Override // com.byazt.bek.DownloadController
    public JSONObject getExtraJson() {
        return null;
    }

    @Override // com.byazt.bek.DownloadController
    public Object getExtraObject() {
        return null;
    }

    @Override // com.byazt.bek.DownloadController
    public void setDownloadMode(int i) {
    }

    @Override // com.byazt.bek.DownloadController
    public void setLinkMode(int i) {
    }

    @Override // com.byazt.bek.DownloadController
    public void setEnableShowComplianceDialog(boolean z) {
    }

    @Override // com.byazt.bek.DownloadController
    public boolean enableShowComplianceDialog() {
        return true;
    }

    @Override // com.byazt.bek.DownloadController
    public boolean isAutoDownloadOnCardShow() {
        return false;
    }

    @Override // com.byazt.bek.DownloadController
    public boolean enableNewActivity() {
        return true;
    }

    @Override // com.byazt.bek.DownloadController
    public void setEnableNewActivity(boolean z) {
    }

    @Override // com.byazt.bek.DownloadController
    public boolean enableAH() {
        return true;
    }

    @Override // com.byazt.bek.DownloadController
    public boolean enableAM() {
        return true;
    }
}
