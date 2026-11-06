package com.taptap.sdk.compilance;

import com.taptap.sdk.compilance.bean.IdentityVerifyState;
import kotlin.Metadata;

/* JADX INFO: compiled from: Callbacks.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/taptap/sdk/compilance/ComplianceAuthorizationCallback;", "", "goToRealNameManual", "", "isFallback", "", "goToUnderReview", "onCancel", "onCloseRealName", "onRealNameSuccess", "identifyState", "Lcom/taptap/sdk/compilance/bean/IdentityVerifyState;", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface ComplianceAuthorizationCallback {
    void goToRealNameManual(boolean isFallback);

    void goToUnderReview();

    void onCancel();

    void onCloseRealName();

    void onRealNameSuccess(IdentityVerifyState identifyState);
}
