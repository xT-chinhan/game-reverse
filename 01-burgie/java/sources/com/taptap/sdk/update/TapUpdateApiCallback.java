package com.taptap.sdk.update;

import com.taptap.sdk.update.bean.UpdateResult;
import kotlin.Metadata;

/* JADX INFO: compiled from: Callbacks.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/taptap/sdk/update/TapUpdateApiCallback;", "", "onError", "", "throwable", "", "onSuccess", "updateInfo", "Lcom/taptap/sdk/update/bean/UpdateResult;", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface TapUpdateApiCallback {
    void onError(Throwable throwable);

    void onSuccess(UpdateResult updateInfo);
}
