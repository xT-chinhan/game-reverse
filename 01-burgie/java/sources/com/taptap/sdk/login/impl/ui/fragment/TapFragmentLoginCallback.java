package com.taptap.sdk.login.impl.ui.fragment;

import com.taptap.sdk.kit.internal.exception.TapTapException;
import com.taptap.sdk.login.impl.data.model.LoginRequest;
import com.taptap.sdk.login.impl.data.model.LoginResponse;
import com.taptap.sdk.login.impl.exception.CloudGameException;
import kotlin.Metadata;

/* JADX INFO: compiled from: TapFragmentLoginCallback.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\nH&J\u001c\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH&¨\u0006\u000e"}, d2 = {"Lcom/taptap/sdk/login/impl/ui/fragment/TapFragmentLoginCallback;", "", "executeFallbackStrategy", "", "request", "Lcom/taptap/sdk/login/impl/data/model/LoginRequest;", "error", "Lcom/taptap/sdk/login/impl/exception/CloudGameException;", "onCancel", "onFail", "Lcom/taptap/sdk/kit/internal/exception/TapTapException;", "onSuccess", "response", "Lcom/taptap/sdk/login/impl/data/model/LoginResponse;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface TapFragmentLoginCallback {
    void executeFallbackStrategy(LoginRequest request, CloudGameException error);

    void onCancel(LoginRequest request);

    void onFail(TapTapException error);

    void onSuccess(LoginRequest request, LoginResponse response);

    /* JADX INFO: compiled from: TapFragmentLoginCallback.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void executeFallbackStrategy$default(TapFragmentLoginCallback tapFragmentLoginCallback, LoginRequest loginRequest, CloudGameException cloudGameException, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: executeFallbackStrategy");
            }
            if ((i & 2) != 0) {
                cloudGameException = null;
            }
            tapFragmentLoginCallback.executeFallbackStrategy(loginRequest, cloudGameException);
        }
    }
}
