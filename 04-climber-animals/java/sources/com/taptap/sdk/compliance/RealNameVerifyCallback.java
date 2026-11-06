package com.taptap.sdk.compliance;

import com.taptap.sdk.compliance.bean.IdentityVerifyState;
import kotlin.Metadata;

/* JADX INFO: compiled from: Callbacks.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/taptap/sdk/compliance/RealNameVerifyCallback;", "", "onCloseRealName", "", "onRealNameResult", "result", "Lcom/taptap/sdk/compliance/bean/IdentityVerifyState;", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface RealNameVerifyCallback {
    void onCloseRealName();

    void onRealNameResult(IdentityVerifyState result);
}
