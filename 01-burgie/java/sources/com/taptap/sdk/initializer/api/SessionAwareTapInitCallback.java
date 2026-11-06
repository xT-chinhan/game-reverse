package com.taptap.sdk.initializer.api;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SessionAwareTapInitCallback.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Lcom/taptap/sdk/initializer/api/SessionAwareTapInitCallback;", "Lcom/taptap/sdk/initializer/api/TapInitCallback;", "onInitFail", "", MediationConstant.KEY_ERROR_CODE, "", MediationConstant.KEY_ERROR_MSG, "", d.aw, "", "onInitSuccess", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface SessionAwareTapInitCallback extends TapInitCallback {
    @Override // com.taptap.sdk.initializer.api.TapInitCallback
    void onInitFail(int errorCode, String errorMsg);

    void onInitFail(int errorCode, String errorMsg, long session);

    @Override // com.taptap.sdk.initializer.api.TapInitCallback
    void onInitSuccess();

    void onInitSuccess(long session);

    /* JADX INFO: compiled from: SessionAwareTapInitCallback.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class DefaultImpls {
        public static void onInitSuccess(SessionAwareTapInitCallback $this) {
        }

        public static void onInitFail(SessionAwareTapInitCallback $this, int errorCode, String errorMsg) {
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        }
    }
}
