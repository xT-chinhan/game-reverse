package com.taptap.sdk.login.internal.service;

import com.google.android.gms.common.internal.ImagesContract;
import com.taptap.sdk.kit.internal.service.AuthService;
import com.taptap.sdk.login.api.LoginService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AuthServiceImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/taptap/sdk/login/internal/service/AuthServiceImpl;", "Lcom/taptap/sdk/kit/internal/service/AuthService;", "loginService", "Lcom/taptap/sdk/login/api/LoginService;", "(Lcom/taptap/sdk/login/api/LoginService;)V", "obtainAuthorization", "", ImagesContract.URL, "method", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AuthServiceImpl implements AuthService {
    private final LoginService loginService;

    public AuthServiceImpl(LoginService loginService) {
        Intrinsics.checkNotNullParameter(loginService, "loginService");
        this.loginService = loginService;
    }

    @Override // com.taptap.sdk.kit.internal.service.AuthService
    public String obtainAuthorization(String url, String method) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        return this.loginService.obtainAuthorization(url, method);
    }
}
