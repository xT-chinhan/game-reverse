package com.byazt.hj;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 581, 8})
@Deprecated
public class s implements DownloadController {
    @Override // com.byazt.hj.DownloadController
    public boolean enableAH() {
        return true;
    }

    @Override // com.byazt.hj.DownloadController
    public boolean enableAM() {
        return true;
    }

    @Override // com.byazt.hj.DownloadController
    public boolean enableNewActivity() {
        return true;
    }

    @Override // com.byazt.hj.DownloadController
    public boolean enableShowComplianceDialog() {
        return true;
    }

    @Override // com.byazt.hj.DownloadController
    public int getDowloadChunkCount() {
        return 0;
    }

    @Override // com.byazt.hj.DownloadController
    public int getDownloadMode() {
        return 0;
    }

    @Override // com.byazt.hj.DownloadController
    public Object getExtraClickOperation() {
        return null;
    }

    @Override // com.byazt.hj.DownloadController
    public JSONObject getExtraJson() {
        return null;
    }

    @Override // com.byazt.hj.DownloadController
    public Object getExtraObject() {
        return null;
    }

    @Override // com.byazt.hj.DownloadController
    public int getInterceptFlag() {
        return 0;
    }

    @Override // com.byazt.hj.DownloadController
    public int getLinkMode() {
        return 0;
    }

    @Override // com.byazt.hj.DownloadController
    public boolean isAddToDownloadManage() {
        return false;
    }

    @Override // com.byazt.hj.DownloadController
    public boolean isAutoDownloadOnCardShow() {
        return false;
    }

    @Override // com.byazt.hj.DownloadController
    public boolean isEnableBackDialog() {
        return false;
    }

    @Override // com.byazt.hj.DownloadController
    public boolean isEnableMultipleDownload() {
        return false;
    }

    @Override // com.byazt.hj.DownloadController
    public void setDownloadMode(int i) {
    }

    @Override // com.byazt.hj.DownloadController
    public void setEnableNewActivity(boolean z) {
    }

    @Override // com.byazt.hj.DownloadController
    public void setEnableShowComplianceDialog(boolean z) {
    }

    @Override // com.byazt.hj.DownloadController
    public void setLinkMode(int i) {
    }

    @Override // com.byazt.hj.DownloadController
    public boolean shouldUseNewWebView() {
        return false;
    }
}
