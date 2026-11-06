package com.taptap.sdk.login.impl.repository;

import com.taptap.sdk.common.network.NetworkClientKt;
import com.taptap.sdk.kit.internal.TapSDKHost;
import com.taptap.sdk.retrofit2.Retrofit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoginApiServiceProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000¨\u0006\u0002"}, d2 = {"provideLoginApiService", "Lcom/taptap/sdk/login/impl/repository/LoginApiService;", "tap-login_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class LoginApiServiceProviderKt {
    public static final LoginApiService provideLoginApiService() {
        Retrofit retrofit = NetworkClientKt.provideRetrofit$default("https://" + TapSDKHost.INSTANCE.getApiHost(), null, 2, null);
        Object objCreate = retrofit.create(LoginApiService.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "retrofit.create(LoginApiService::class.java)");
        return (LoginApiService) objCreate;
    }
}
