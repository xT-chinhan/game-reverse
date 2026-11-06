package com.taptap.sdk.login.internal;

import com.taptap.sdk.login.TapTapLoginCallback;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TapLoginInternal.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/taptap/sdk/login/internal/TapLoginInternal;", "", "()V", "loginCallbacks", "", "Lcom/taptap/sdk/login/TapTapLoginCallback;", "notifyLoginStatusChange", "", "status", "", "registerLoginCallback", "callback", "unregisterLoginCallback", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapLoginInternal {
    public static final TapLoginInternal INSTANCE = new TapLoginInternal();
    private static final List<TapTapLoginCallback> loginCallbacks = new ArrayList();

    private TapLoginInternal() {
    }

    public final void registerLoginCallback(TapTapLoginCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        List<TapTapLoginCallback> list = loginCallbacks;
        if (list.contains(callback)) {
            return;
        }
        list.add(callback);
    }

    public final void unregisterLoginCallback(TapTapLoginCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        loginCallbacks.remove(callback);
    }

    public final void notifyLoginStatusChange(int status) {
        for (Object obj : loginCallbacks.toArray(new TapTapLoginCallback[0])) {
            ((TapTapLoginCallback) obj).onLoginStatusChange(status);
        }
    }
}
