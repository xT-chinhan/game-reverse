package com.taptap.sdk.login.internal.net;

import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import kotlin.Metadata;

/* JADX INFO: compiled from: HttpCallback.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/login/internal/net/HttpCallback;", "RESULT", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "()V", "onCancel", "", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class HttpCallback<RESULT> implements TapTapCallback<RESULT> {
    @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
    public void onCancel() {
    }
}
