package com.taptap.sdk.compliance;

import com.taptap.sdk.compliance.bean.IdentityVerifyState;
import kotlin.Metadata;

/* JADX INFO: compiled from: Callbacks.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/taptap/sdk/compliance/TapAuthorizationCallback;", "", "goToRealNameManual", "", "goToUnderReview", "onCancel", "onFail", "e", "", "onSuccess", "identifyState", "Lcom/taptap/sdk/compliance/bean/IdentityVerifyState;", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface TapAuthorizationCallback {
    void goToRealNameManual();

    void goToUnderReview();

    void onCancel();

    void onFail(Throwable e);

    void onSuccess(IdentityVerifyState identifyState);
}
