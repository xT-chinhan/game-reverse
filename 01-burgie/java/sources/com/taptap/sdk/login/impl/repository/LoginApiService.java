package com.taptap.sdk.login.impl.repository;

import com.taptap.sdk.base.network.annotation.Module;
import com.taptap.sdk.kit.internal.p001const.SdkModules;
import com.taptap.sdk.login.PrivateTapSdkAccount;
import com.taptap.sdk.login.impl.data.request.LoginRequest;
import com.taptap.sdk.retrofit2.http.Body;
import com.taptap.sdk.retrofit2.http.POST;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: LoginApiService.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH§@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/taptap/sdk/login/impl/repository/LoginApiService;", "", "loginByCode", "Lcom/taptap/sdk/login/PrivateTapSdkAccount;", "body", "Lcom/taptap/sdk/login/impl/data/request/LoginRequest;", "(Lcom/taptap/sdk/login/impl/data/request/LoginRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginByToken", "", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Module(name = SdkModules.LOGIN, version = "4.10.9")
public interface LoginApiService {
    @POST("/auth/v1/login-by-authorization-code")
    Object loginByCode(@Body LoginRequest loginRequest, Continuation<? super PrivateTapSdkAccount> continuation);

    @POST("/auth/v1/login-by-token")
    Object loginByToken(@Body Map<String, String> map, Continuation<? super PrivateTapSdkAccount> continuation);
}
