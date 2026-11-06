package com.bytedance.sdk.openadsdk.api.ms;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class x extends com.bytedance.sdk.openadsdk.api.ka implements OnItemClickListener {
    public x(Function<SparseArray<Object>, Object> function) {
        this.f1777ms = function;
    }

    public x(EventListener eventListener) {
        this.xr = eventListener;
    }

    @Override // com.ss.android.download.api.config.OnItemClickListener
    public void onItemClick(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        ms(ValueSetConstants.VALUE_ON_ITEM_CLICK, ah() ? null : com.bykv.ms.ms.ms.ms.ms.ms().ms(com.bykv.ms.ms.ms.ms.xr.ms().ms(ValueSetConstants.VALUE_DOWNLOAD_MODEL, new ah(downloadModel)).ms(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG, new xr(downloadEventConfig)).ms(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER, new ms(downloadController)).xr()).xr());
    }
}
