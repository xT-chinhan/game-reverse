package com.bytedance.sdk.openadsdk.api.ms;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DownloadShortInfo;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class ka extends com.bytedance.sdk.openadsdk.api.ka implements DownloadStatusChangeListener {
    public ka(Function<SparseArray<Object>, Object> function) {
        this.f1777ms = function;
    }

    public ka(EventListener eventListener) {
        this.xr = eventListener;
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onIdle() {
        ms(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_IDLE);
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadStart(DownloadModel downloadModel, DownloadController downloadController) {
        ms(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_START, ah() ? null : com.bykv.ms.ms.ms.ms.ms.ms().ms(com.bykv.ms.ms.ms.ms.xr.ms().ms(ValueSetConstants.VALUE_DOWNLOAD_MODEL, new ah(downloadModel)).ms(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER, new ms(downloadController)).xr()).xr());
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadActive(DownloadShortInfo downloadShortInfo, int i) {
        ms(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE, ah() ? null : com.bykv.ms.ms.ms.ms.ms.ms().ms(com.bykv.ms.ms.ms.ms.xr.ms().ms(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_SHORT, new d(downloadShortInfo)).ms(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_PERCENT, i).xr()).xr());
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadPaused(DownloadShortInfo downloadShortInfo, int i) {
        ms(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_PAUSED, ah() ? null : com.bykv.ms.ms.ms.ms.ms.ms().ms(com.bykv.ms.ms.ms.ms.xr.ms().ms(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_SHORT, new d(downloadShortInfo)).ms(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_PERCENT, i).xr()).xr());
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadFailed(DownloadShortInfo downloadShortInfo) {
        ms(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_FAILED, ah() ? null : com.bykv.ms.ms.ms.ms.ms.ms().ms(com.bykv.ms.ms.ms.ms.xr.ms().ms(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_SHORT, new d(downloadShortInfo)).xr()).xr());
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onInstalled(DownloadShortInfo downloadShortInfo) {
        ms(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ON_INSTALLED, ah() ? null : com.bykv.ms.ms.ms.ms.ms.ms().ms(com.bykv.ms.ms.ms.ms.xr.ms().ms(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_SHORT, new d(downloadShortInfo)).xr()).xr());
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadFinished(DownloadShortInfo downloadShortInfo) {
        ms(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ON_FINISHED, ah() ? null : com.bykv.ms.ms.ms.ms.ms.ms().ms(com.bykv.ms.ms.ms.ms.xr.ms().ms(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_SHORT, new d(downloadShortInfo)).xr()).xr());
    }
}
