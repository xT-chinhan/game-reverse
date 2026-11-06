package com.efs.sdk.base.http;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.efs.sdk.base.core.util.concurrent.b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsHttpListener implements b<HttpResponse> {
    public abstract void onError(@Nullable HttpResponse httpResponse);

    public abstract void onSuccess(@NonNull HttpResponse httpResponse);

    @Override // com.efs.sdk.base.core.util.concurrent.b
    public void result(@Nullable HttpResponse httpResponse) {
        if (httpResponse != null && httpResponse.succ) {
            onSuccess(httpResponse);
        } else {
            onError(httpResponse);
        }
    }
}
