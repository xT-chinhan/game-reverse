package com.bytedance.sdk.openadsdk.api.ms;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class c extends com.bytedance.sdk.openadsdk.api.ka implements IDownloadButtonClickListener {
    public c(Function<SparseArray<Object>, Object> function) {
        this.f1777ms = function;
    }

    public c(EventListener eventListener) {
        this.xr = eventListener;
    }

    @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
    public void handleComplianceDialog(boolean z) {
        ms(ValueSetConstants.VALUE_HANDLE_COMPLIANCE_DIALOG, ah() ? null : com.bykv.ms.ms.ms.ms.ms.ms().ms(com.bykv.ms.ms.ms.ms.xr.ms().ms(ValueSetConstants.VALUE_HANDLE_COMPLIANCE_DIALOG_SHOULD_SHOW, z).xr()).xr());
    }

    @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
    public void handleMarketFailedComplianceDialog() {
        ms(ValueSetConstants.VALUE_HANDLE_MARKET_FAILED_COMPLIANCE_DIALOG);
    }
}
