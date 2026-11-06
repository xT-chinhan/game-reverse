package com.taptap.sdk.initializer.api;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import kotlin.Metadata;

/* JADX INFO: compiled from: TapInitCallback.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, d2 = {"Lcom/taptap/sdk/initializer/api/TapInitCallback;", "", "onInitFail", "", MediationConstant.KEY_ERROR_CODE, "", MediationConstant.KEY_ERROR_MSG, "", "onInitSuccess", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface TapInitCallback {
    void onInitFail(int errorCode, String errorMsg);

    void onInitSuccess();
}
